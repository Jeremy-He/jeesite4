/**
 * Copyright (c) 2013-Now http://jeesite.com All rights reserved.
 */
package com.miaocup.modules.repair.web;

import com.jeesite.common.config.Global;
import com.jeesite.common.web.BaseController;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;

/**
 * 投诉建议Controller
 * @author yangkun
 * @version 2018-04-11
 */
@Controller
@RequestMapping(value = "${adminPath}/repair/backup")
public class BackupController extends BaseController {



	/**
	 * 查看编辑表单
	 */
	@RequiresPermissions("repair:opinion:view")
	@RequestMapping(value = {"list", ""})
	public String form( Model model) {
		return "modules/repair/backup";
	}

	/**
	 * 保存投诉建议
	 */
	@RequiresPermissions("repair:backup:edit")
	@GetMapping(value = "backup")
	@ResponseBody
	public String backup() {
		String savePath = "F:/backupDatabase";
		File saveFile = new File(savePath);
		if (!saveFile.exists()) {// 如果目录不存在
			saveFile.mkdirs();// 创建文件夹
		}

		if(!savePath.endsWith(File.separator)){
			savePath = savePath + File.separator;
		}
		PrintWriter printWriter = null;
		BufferedReader bufferedReader = null;
		String fileName = System.currentTimeMillis()+".sql";
		try {
			printWriter = new PrintWriter(new OutputStreamWriter(new FileOutputStream(savePath + fileName), "utf8"));
			Process process = Runtime.getRuntime().exec(" \\usr\\local\\mysql\\mysqldump -h 47.106.15.12 -u root -p root --set-charset=UTF8 miaocup");
			InputStreamReader inputStreamReader = new InputStreamReader(process.getInputStream(), "utf8");
			bufferedReader = new BufferedReader(inputStreamReader);
			String line;
			while((line = bufferedReader.readLine())!= null){
				printWriter.println(line);
			}
			printWriter.flush();
		}catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				if (bufferedReader != null) {
					bufferedReader.close();
				}
				if (printWriter != null) {
					printWriter.close();
				}
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		return renderResult(Global.TRUE, "数据备份成功！");
	}
}