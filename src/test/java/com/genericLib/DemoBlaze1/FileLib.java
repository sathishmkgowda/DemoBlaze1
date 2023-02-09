package com.genericLib.DemoBlaze1;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class FileLib 
{
	public String getDataFromProperties(String path,String key) throws IOException
	{
		FileInputStream fis=new FileInputStream(path);
		Properties prop=new Properties();
		prop.load(fis);
		String data= prop.getProperty(key);
		return data;
	}

}
