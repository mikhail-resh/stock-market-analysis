package com.example.appinfo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AppInfoController {
	
	@Autowired
	AppInfoService appInfoService;
	
	@RequestMapping("/about")
	public AppInfo getAppInfo() {
		return appInfoService.getAppInfo();
	}
	
	
}
