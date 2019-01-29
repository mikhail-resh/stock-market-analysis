package com.example.appinfo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AppInfoController {
	
	private final AppInfoService appInfoService;
	
	@Autowired
	public AppInfoController(AppInfoService appInfoService) {
		this.appInfoService = appInfoService;
	}
	
	@RequestMapping("/about")
	public AppInfo getAppInfo() {
		return appInfoService.getAppInfo();
	}
	
	
}
