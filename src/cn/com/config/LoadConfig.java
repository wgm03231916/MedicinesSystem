package cn.com.config;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

public final class LoadConfig {
	private LoadConfig(){}
	
	public static Properties getConfig(){
		Properties pop = new Properties();
		try {
			pop.load(new FileReader(new File("./libs/config.properties")));
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return pop;
	}
	
}
