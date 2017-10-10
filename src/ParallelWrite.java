import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

class myThread extends Thread{
	
	String fileName=null;
	String domain=null;
	String findDomain ="$APPLET_URL_DOMAIN$";
	StringBuffer addLines = null; 
	
	File file = null;
	FileReader reader = null;
	BufferedReader breader = null;
	FileWriter fwriter = null;
	BufferedWriter bwriter =null;
	
	myThread(String fileName, String domain){
		this.fileName = fileName;
		this.domain = domain;
		addLines = new StringBuffer();
	}
	
	@Override
	public void run() {
					
		file = new File(fileName);
		try {
			reader = new FileReader(file);
			breader = new BufferedReader(reader);
			String line ="";
			while((line = breader.readLine()) != null)
			{
				if(line.contains(findDomain))
				{
					line = line.replace(findDomain, domain);
					addLines.append(line+"\n");
					
				}
				else
					addLines.append(line+"\n");
			}
		} 
		catch (Exception e) {
			e.printStackTrace();
		}
		finally
		{
			try 
			{
				if(breader != null)
					breader.close();
				if(reader != null)
					reader.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
			
		}
		
		try 
		{
			fwriter = new FileWriter(file);
			bwriter = new BufferedWriter(fwriter);
			bwriter.write(addLines.toString());
			
		} catch (IOException e) {
			
			e.printStackTrace();
		}
		finally {
			try {
				if(bwriter != null)
					bwriter.close();
				if(fwriter != null)
					fwriter.close();
				
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
}

public class ParallelWrite {

	final String DOMAIN_VAR ="$APPLET_URL_DOMAIN$";

	StringBuffer addLines = new StringBuffer(); 

	File file = null;
	FileReader reader = null;
	BufferedReader breader = null;
	FileWriter fwriter = null;
	BufferedWriter bwriter =null;

	public void changeDomain(String fileName, String domain) throws IOException
	{		
		file = new File(fileName);
		try {
			reader = new FileReader(file);
			breader = new BufferedReader(reader);
			String line ="";
			while((line = breader.readLine()) != null)
			{
				if(line.contains(DOMAIN_VAR))
				{
					line = line.replace(DOMAIN_VAR, domain).toString();
					addLines.append(line+"\n");
					
				}
				else
					addLines.append(line+"\n");
			}
		}		
		finally
		{
				if(breader != null)
					breader.close();
				if(reader != null)
					reader.close();					
		}
		
		try 
		{
			fwriter = new FileWriter(file);
			bwriter = new BufferedWriter(fwriter);
			bwriter.write(addLines.toString());
			
		} 
		finally 
		{		
				if(bwriter != null)
					bwriter.close();
				if(fwriter != null)
					fwriter.close();	
		
		}
	}
	public static void main(String[] args) throws Exception {
		
		//String fileName1 = "C:\\Users\\1019270\\Desktop\\i2uitaglib.xsl";
		//String fileName2 = "C:\\Users\\1019270\\Desktop\\i2uitaglib1.xsl";
		
		String fileName1 = "C:"+File.separator+"Users"+File.separator+"1019270"+File.separator+"Desktop"+File.separator+"i2uitaglib.xsl";
		String fileName2 = "C:"+File.separator+"Users"+File.separator+"1019270"+File.separator+"Desktop"+File.separator+"i2uitaglib1.xsl";
		
		String domain ="jda.corp.local";
		
		System.out.println("fileName1 "+fileName1);
		System.out.println("fileName2 "+fileName2);
		
		//myThread thread1 = new myThread(fileName1, domain);
		//myThread thread2 = new myThread(fileName2, domain);
		
		//Starting threads
		/*thread1.start();
		thread2.start();
		try{
			thread1.join();
			thread2.join();
		}
		catch(InterruptedException e){
			e.printStackTrace();
		}*/
		ParallelWrite obj = new ParallelWrite();
		obj.changeDomain(fileName1, domain);
		obj.changeDomain(fileName2, domain);
		System.out.println("done");
	}

}
