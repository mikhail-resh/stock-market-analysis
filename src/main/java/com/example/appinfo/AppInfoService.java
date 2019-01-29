package com.example.appinfo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.info.BuildProperties;
import org.springframework.stereotype.Service;

@Service
public class AppInfoService {
	
	private final BuildProperties buildProperties;
	
	@Autowired
	public AppInfoService(BuildProperties buildProperties) {
		this.buildProperties = buildProperties;
	}
		
	public AppInfo getAppInfo() {
		return AppInfo.getAppInfo(buildProperties.getName(), buildProperties.getVersion());
	}
}
