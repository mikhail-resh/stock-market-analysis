package com.example.appinfo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.info.BuildProperties;
import org.springframework.stereotype.Service;

@Service
public class AppInfoService {

	@Autowired
	private BuildProperties buildProperties;
	
	public AppInfo getAppInfo() {
		return new AppInfo(buildProperties.getName(),buildProperties.getVersion());
	}

}
