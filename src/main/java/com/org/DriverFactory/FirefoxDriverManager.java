package com.org.DriverFactory;

import java.io.File;

import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.firefox.GeckoDriverService;
import org.openqa.selenium.remote.DesiredCapabilities;

 public class FirefoxDriverManager extends DriverManager {

	GeckoDriverService fs;
	
	@Override
	protected void startService() {
		if(fs==null) {
							try {				
		fs=new GeckoDriverService.Builder()
								.usingDriverExecutable(new File("src/main/java/resources/drivers/geckodriver.exe"))
								.usingAnyFreePort()
								.build();
		System.setProperty(GeckoDriverService.GECKO_DRIVER_EXE_PROPERTY, "drivers/geckodriver.exe");
		fs.start();
								}catch(Exception e) {
								e.printStackTrace();
								}
		}
		
	}

	@Override
	protected void stopService() {
		 if (fs != null && fs.isRunning())
			 fs.stop();
		
	}

	@Override
	protected void createDriver() {
		DesiredCapabilities cap=DesiredCapabilities.firefox();
		FirefoxOptions options = new FirefoxOptions();
		options.addArguments("test-type");
		options.addCapabilities(cap);
		//cap.setCapability(FirefoxOptions.CAPABILITY, options);
		 driver = new FirefoxDriver(options);
		
	}


}
