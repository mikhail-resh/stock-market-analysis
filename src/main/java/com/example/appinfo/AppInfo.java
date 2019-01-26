package com.example.appinfo;


public class AppInfo {
	
	private String appName;
	private String version;

	private static AppInfo appInfo = null;
	public static AppInfo getAppInfo(String name, String version) {
		if (appInfo==null) {
			appInfo = new AppInfo(name,version);
		}
		return appInfo;
	}

	private AppInfo(String appName, String version) {
		super();
		this.appName = appName;
		this.version = version;
	}

	public String getAppName() {
		return appName;
	}

	public void setAppName(String appName) {
		this.appName = appName;
	}

	public String getVersion() {
		return version;
	}

	public void setVersion(String version) {
		this.version = version;
	}
	
	
}
