package com.isolated.filter;

import java.io.File;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

class Thread1 extends Thread{
	String fileName=null;
	String domain=null;
	String findDomain ="$APPLET_URL_DOMAIN$";
	List<String> addLines = null;
	
	Thread1(){}
	
	Thread1(String fileName, String domain)
	{
		this.fileName = fileName;
		this.domain = domain;
		addLines = new ArrayList<String>();
	}
	
	@Override
	public void run() {
		
		try
		{
			for(String line : Files.readAllLines(Paths.get(fileName), StandardCharsets.UTF_8))
			{
					if(line.contains(findDomain)){
						addLines.add(line.replace(findDomain, domain));
						addLines.add("\n");
					}
					else
					{
						addLines.add(line);
						addLines.add("\n");
					}
			}
			Files.write(Paths.get(fileName), addLines, StandardCharsets.UTF_8);
		} catch (IOException e) {
					e.printStackTrace();
		}
	}
}
public class TEST {

	public static void main(String[] args) {
		//String fileName1 = "C:\\Users\\1019270\\Desktop\\i2uitaglib.xsl";
		String fs = "C:"+File.separator+"Users"+File.separator+"1019270"+File.separator+"Desktop"+File.separator+"i2uitaglib.xsl";
		System.out.println("fs "+fs);
		String domain ="jda.corp.local";
		
		Thread1 thread1 = new Thread1(fs, domain);

		thread1.start();
		//thread2.start();
		try{
			thread1.join();
			//thread2.join();
		}
		catch(InterruptedException e){
			e.printStackTrace();
		}
		System.out.println("done");
	}

}
