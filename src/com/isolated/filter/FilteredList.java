package com.isolated.filter;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Map;
import java.util.TreeMap;

public class FilteredList {

	TreeMap<String, String> relatedList;
	TreeMap<String, String> isolatedList;
	
	ArrayList<String> predefined;
	LinkedList<String> modList;
	
	FileReader fr = null;
	BufferedReader br = null;
		
	public FilteredList() {
		relatedList = new TreeMap<>();
		isolatedList = new TreeMap<>();
		
		predefined = new ArrayList<>();
	}
	void addPre(){
		predefined.add("AdminHeaderPage.xsl");
		predefined.add("HeaderPage.xsl");
		predefined.add("PageStructure_Default.xsl");
		predefined.add("PageLayout.xsl");
		predefined.add("PageStructure.xsl");
		predefined.add("common-domain.js");
	}
	
		
	// Searching inside directory
	void searchDirectory(File file) throws FileNotFoundException{
		
		//FileReader fr = null;
		//BufferedReader br = null;
		
		if(file.isDirectory()){
			//System.out.println("Searching in directory... "+file.getAbsoluteFile());
			
				if(file.canRead()){
					for(File temp : file.listFiles()){
						
						if(temp.isDirectory()){
							
							String dName = temp.getName();
							//Condition for excluding the directories
							if(!dName.equals("schedule") && !dName.equals("report"))
								searchDirectory(temp);
						}
						else
						{	
							// open file and search inside it
													
							try
							{
								String filename = temp.getName();
								String fPath = temp.getAbsolutePath();
							
								//Scanner sc = new Scanner(new File(fPath));
																
								//System.out.println("filename : "+filename+" Path : "+temp.getAbsolutePath());
								
								boolean flag= true;
								boolean headFlag = false;
								
								if(filename.contains(".xsl"))
								{
									fr = new FileReader(new File(fPath));
									br = new BufferedReader(fr);
									String fromLine ="";
									while((fromLine = br.readLine())!=null){
																
										int len =predefined.size();
										
										//final String fromLine = sc.nextLine();
										
										if(fromLine.contains("<html>") || fromLine.contains("<HTML>"))
											headFlag=true;
										
										for(int i=0; i<len; i++){
											if(fromLine.contains(predefined.get(i))){
												relatedList.put(filename, fPath);
												flag=false;
												headFlag=false;
												break;
											}								
										}
										if(!flag)
											break;
									}
									if(flag && headFlag){
										//if(filename.contains(".xsl"))
											//isolatedList.put(filename, temp.getAbsolutePath().toString());
										isolatedList.put(filename, fPath);
									}						
							}
						}
						catch (IOException e) {
							e.printStackTrace();
						}
						finally{
							try {
								if(fr != null)
									fr.close();
								if(br != null)
									br.close();
								
							} catch (IOException e2) {
								e2.printStackTrace();
							}
						}
						
					}
				}
			}
		}
	}
	
	//Filtering Isolated list of files
	void Filter() throws FileNotFoundException{
		
		//Regular expression for extracting the tag <xsl:import href="filename"/>		
		//String regex = "^<\\s*xsl\\s*:\\s*import\\s*href.*/>$";
		String regex = "import";
		
		//Scanner scan; 
		String name;
		boolean flag=true;
		Iterator<String> set;		
		
		while(flag){
			
			flag=false;
			set = isolatedList.keySet().iterator();
			while(set.hasNext()){
				try
				{					
					String key = set.next();
					String path = isolatedList.get(key);
					
					//scan = new Scanner(new File(path));
					fr = new FileReader(new File(path));
					br = new BufferedReader(fr);
					String line = "";
					
					// Iterating inside the file and extracting the file name.
					while((line = br.readLine())!= null){
						//String line = scan.nextLine();
						if(line.contains(regex)){
							name = line.substring(line.indexOf('"')+1, line.lastIndexOf('"') );
							//checking name is present in relatedList or not
							if(relatedList.containsKey(name)){
								flag = true;
								break;
							}
						}
					}
					if(flag){
						relatedList.put(key, path);
						set.remove();
						break;
					}
				}
				catch(IOException ex){
					ex.printStackTrace();
				}
				finally{
					try {
						
						if(br != null)
							br.close();
						if(fr != null)
							fr.close();
						
					} 
					catch (IOException e)
					{
						e.printStackTrace();
					}
				}
			}
		}
	}
	
	/**
	 * Adding the common-domain.js to All the isolated xsl file with the following tag.
	 * 
	 */
	
	void addDomainToIsolated(){
				
			FileReader fr=null;
			FileWriter fw=null;
			BufferedReader br=null;
			BufferedWriter bf=null;
			File fileIn=null;
			File fileOut=null;
			boolean isModified =false;
		    modList= new LinkedList<>();
			
			//</xsl:stylesheet>
			String regex =".*<\\s*/\\s*xsl\\s*:\\s*stylesheet\\s*>$";
			String headTag = "\r\n\t\t\t<script language=\"javascript\" type=\"text/javascript\" src=\"{$context}/javascript/common/common-domain.js\"/>\r\n";
			String tag = "\t<html>\r\n\t\t<head>\r\n\t\t\t<script language=\"javascript\" type=\"text/javascript\" src=\"{$context}/javascript/common/common-domain.js\"/>\r\n\t\t</head>\r\n\t</html>";
			String endTag = "</xsl:stylesheet>";
			tag = tag+"\r\n"+endTag;
			
			/*String path = "C:\\Users\\1019270\\Desktop\\temp.txt";
			String pathOut ="C:\\Users\\1019270\\Desktop\\temp1.txt";*/
			
			for(Map.Entry<String, String> entry : isolatedList.entrySet())
			{
				String fileName = entry.getKey();
				String path = entry.getValue();
				
				String pathOut = getPathOut(path);
				
				try{
					
					fileIn = new File(path);
					fr = new FileReader(fileIn);
					br = new BufferedReader(fr);
					
					fileOut = new File(pathOut);
					fw = new FileWriter(fileOut);
					bf = new BufferedWriter(fw);
					String line="";
					
					while((line = br.readLine()) != null){
						if(line.contains("<head>")){
							bf.write(line);
							bf.write(headTag);
							isModified =true;
						}
						/*else if(line.matches(regex) && !isModified){
							int index = line.lastIndexOf('<');
							//System.out.println(index);
							bf.write(line.substring(0, index)+"\r\n");
													
							//bf.newLine();
							bf.write(tag);
							//bf.newLine();
							isModified =true;
						}*/
						else{
							bf.write(line);
							bf.newLine();
						}
					}			
				
				}catch(IOException ex){
					ex.printStackTrace();
				}
				finally{
					try {
						if(bf != null)
							bf.close();
						
						if(fw != null)
							fw.close();						
													
						if(br != null)
							br.close();
						if(fr != null)
							fr.close();
					} catch (IOException e) {
						
						e.printStackTrace();
					}
				}
				if(isModified){
					String filepath = fileIn.getPath();
					modList.add(filepath);
					//fileIn.delete();
					System.out.println(fileIn.delete());
					System.out.println(filepath);
					boolean flag = fileOut.renameTo(new File(filepath));
					isModified=false;
					if(flag){
						System.out.println(flag);
					}
					else
						System.out.println(flag);	
				}
		}
	}
	
	private String getPathOut(String path) {
		return path.replace(".", "_bkp.");
	}
	
	public static void main(String[] args) throws FileNotFoundException {
		
		
		File file = null;
		FileWriter fw = null;
		BufferedWriter bw = null;
		
		long startTime = System.currentTimeMillis();
		
		FilteredList fl = new FilteredList();
		fl.addPre();
		int count =1;
		
		//Searching inside the Directories recursively
		fl.searchDirectory(new File("D:\\FilterView\\SRM_1019270_main_latest_view"));
		
		fl.Filter();
		
		//Printing the list of related file which are in hierarchy of common domain
		try
		{
			file = new File("C:\\Users\\1019270\\Desktop\\FilesList.txt");
			fw = new FileWriter(file);
			bw = new BufferedWriter(fw);
			
			String str ="List of Common-domain Related files\r\n";
			bw.write(str);
			bw.newLine();
			System.out.println(str);
			
			for(Map.Entry<String, String> entry : fl.relatedList.entrySet()){
				System.out.print(count+"  File name :: "+ entry.getKey());
				System.out.print("\t\t\t");
				System.out.println("Path :: "+entry.getValue());
				bw.write(count+"  File : "+ entry.getKey()+"\t\t\t\t"+"Path : "+entry.getValue());
				bw.newLine();
				bw.flush();
				count++;
			}
			bw.write("No. of related files : "+fl.relatedList.size());
			bw.newLine();
			
			
			//Printing the list of isolated file.
			bw.write("\r\nList of Isolated files\r\n");
			bw.newLine();
			System.out.println("\nList of Isolated files");
			count=1;
			for(Map.Entry<String, String> entry : fl.isolatedList.entrySet()){
				System.out.print(count+"  File name :: "+ entry.getKey());
				System.out.print("\t\t\t");
				System.out.println("Path :: "+entry.getValue());
				bw.write(count+"  File : "+ entry.getKey()+"\t\t\t\t"+"Path : "+entry.getValue());
				bw.newLine();
				count++;
			}
			bw.write("\r\nNo. of isolated files : "+fl.isolatedList.size());
			
			System.out.println("Number of Files isolated : "+fl.isolatedList.size());
			
			long endTime = System.currentTimeMillis();
			System.out.println("Performance :: "+ (endTime-startTime)+" miliseconds");
		}
		catch (IOException e) {
			e.printStackTrace();
		}
		finally
		{
			
				try 
				{
					if(bw != null)
					 bw.close();
					
					if(fw != null)
						fw.close();
					
				} 
				catch (IOException e) {
					
					e.printStackTrace();
				}
			
		}
		
		System.exit(0);
				
		//This Code is used for adding domain name to isolated xsl files.
		//fl.addDomainToIsolated();
		/*int modCount=1;
		System.out.println("List of Modified files");
		for(String l : fl. modList){
			System.out.println(modCount+" : "+l);
			modCount++;
		}*/
	}

}
