package com.isolated.jspfilter;



import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.TreeMap;

public class JSPFilter {

	TreeMap<String, String> relatedList;
	TreeMap<String, String> isolatedList;
	
	ArrayList<String> predefined;
	
	
	FileReader fr = null;
	BufferedReader br = null;
		
	public JSPFilter() {
		relatedList = new TreeMap<>();
		isolatedList = new TreeMap<>();
		
		predefined = new ArrayList<>();
	}
	void addPre(){
		predefined.add("common-domain.js");
	}
	
		
	// Searching inside directory
	void searchDirectory(File file) throws FileNotFoundException{
				
		if(file.isDirectory())
		{
				if(file.canRead())
				{
					for(File temp : file.listFiles())
					{
						if(temp.isDirectory())
						{							
							String dName = temp.getName();
							//Condition for excluding the directories
							//if(!dName.equals("schedule") && !dName.equals("report"))
								searchDirectory(temp);
						}
						else
						{	
							// open file and search inside it									
							try
							{
								String filename = temp.getName();
								String fPath = temp.getAbsolutePath();
															
								
								boolean flag= true;
								boolean htmlFlag = false;
								
								if(filename.contains(".jsp"))
								{
									fr = new FileReader(new File(fPath));
									br = new BufferedReader(fr);
									String fromLine ="";
									while((fromLine = br.readLine())!=null)
									{																
										int len =predefined.size();
																			
										if(fromLine.contains("<html>") || fromLine.contains("<HTML>"))
											htmlFlag=true;
										
										for(int i=0; i<len; i++)
										{
											if(fromLine.contains(predefined.get(i)))
											{
												relatedList.put(filename, fPath);
												flag=false;
												htmlFlag=false;
												break;
											}								
										}
										if(!flag)
											break;
									}
									if(flag && htmlFlag)
									{
										isolatedList.put(filename, fPath);
									}						
							}
						}
						catch (IOException e) 
						{
							e.printStackTrace();
						}
						finally
						{
							try 
							{
								if(fr != null)
									fr.close();
								if(br != null)
									br.close();
								
							} 
							catch (IOException e2) 
							{
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
										
					fr = new FileReader(new File(path));
					br = new BufferedReader(fr);
					String line = "";
					
					// Iterating inside the file and extracting the file name.
					while((line = br.readLine())!= null)
					{
						if(line.contains(regex))
						{
							name = line.substring(line.indexOf('"')+1, line.lastIndexOf('"') );
							//checking name is present in relatedList or not
							if(relatedList.containsKey(name))
							{
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
	
	public static void main(String[] args) throws FileNotFoundException 
	{
		
		
		File file = null;
		FileWriter fw = null;
		BufferedWriter bw = null;
		
		long startTime = System.currentTimeMillis();
		
		JSPFilter fl = new JSPFilter();
		fl.addPre();
		int count =1;
		
		//Searching inside the Directories recursively
		fl.searchDirectory(new File("D:\\jda\\SRM2016-Setup\\SRM2017.1"));
		
		//fl.Filter();
		
		//Printing the list of related file which are in hierarchy of common domain
		try
		{
			file = new File("C:\\Users\\1019270\\Desktop\\JSPList_mod.txt");
			fw = new FileWriter(file);
			bw = new BufferedWriter(fw);
			
			String str ="List of Common-domain Related files\r\n";
			bw.write(str);
			bw.newLine();
			System.out.println(str);
			
			/*for(Map.Entry<String, String> entry : fl.relatedList.entrySet()){
				System.out.print(count+"  File name :: "+ entry.getKey());
				System.out.print("\t\t\t");
				System.out.println("Path :: "+entry.getValue());
				bw.write(count+" Path : "+entry.getValue());
				bw.newLine();
				bw.flush();
				count++;
			}*/
			
			Set<Entry<String, String>> set1 = fl.relatedList.entrySet();
			List<Entry<String, String>> list1 = new ArrayList<Entry<String, String>>(set1);
			Collections.sort(list1, new Comparator<Map.Entry<String, String>>() {

				@Override
				public int compare(Map.Entry<String, String> o1, Map.Entry<String, String> o2) {
					return ((o1.getValue()).compareTo(o2.getValue()));
				}
			});
			for(Map.Entry<String, String> entry : list1){
				//System.out.print(count+"  File name :: "+ entry.getKey());
				//System.out.print("\t\t\t");
				System.out.println(count+" Path : "+entry.getValue());
				bw.write(count+" Path : "+entry.getValue());
				bw.newLine();
				count++;
			}
			bw.write("No. of related files : "+fl.relatedList.size());
			bw.newLine();
			
			
			//Printing the list of isolated file.
			bw.write("\r\nList of Isolated files\r\n");
			bw.newLine();
			System.out.println("\nList of Isolated files");
			count=1;
			/*for(Map.Entry<String, String> entry : fl.isolatedList.entrySet()){
				System.out.print(count+"  File name :: "+ entry.getKey());
				System.out.print("\t\t\t");
				System.out.println("Path :: "+entry.getValue());
				bw.write(count+"  File : "+ entry.getKey()+"\t\t\t\t"+"Path : "+entry.getValue());
				bw.newLine();
				count++;
			}*/
			
			Set<Entry<String, String>> set = fl.isolatedList.entrySet();
			List<Entry<String, String>> list = new ArrayList<Entry<String, String>>(set);
			Collections.sort(list, new Comparator<Map.Entry<String, String>>() {

				@Override
				public int compare(Map.Entry<String, String> o1, Map.Entry<String, String> o2) {
					return ((o1.getValue()).compareTo(o2.getValue()));
				}
			});
			for(Map.Entry<String, String> entry : list){
				//System.out.print(count+"  File name :: "+ entry.getKey());
				//System.out.print("\t\t\t");
				System.out.println(count+" Path : "+entry.getValue());
				bw.write(count+" Path : "+entry.getValue());
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
	}
}
