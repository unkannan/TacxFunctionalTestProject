package com.org.DriverFactory;

import java.io.File;

import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeDriverService;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.DesiredCapabilities;

public class ChromeDriverManager extends DriverManager{

	ChromeDriverService chromeService;
	
	@Override
	protected void startService() {
		if(chromeService==null) {
							try {				
				chromeService=new ChromeDriverService.Builder()
								.usingDriverExecutable(new File("src/test/resources/drivers/chromedriver.exe"))
								.usingAnyFreePort()
								.build();
				chromeService.start();
								}catch(Exception e) {
								e.printStackTrace();
								}
		}
		
	}

	@Override
	protected void stopService() {
		 if (chromeService != null && chromeService.isRunning())
			 chromeService.stop();
		
	}

	@Override
	protected void createDriver() {
		DesiredCapabilities cap=DesiredCapabilities.chrome();
		ChromeOptions options = new ChromeOptions();
		options.addArguments("test-type");
		cap.setCapability(ChromeOptions.CAPABILITY, options);
		 driver = new ChromeDriver(chromeService,cap);
		
	}

}
