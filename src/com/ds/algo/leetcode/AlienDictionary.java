package com.ds.algo.leetcode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class AlienDictionary 
{
	Map<Character, List<Character>> graph= new HashMap<Character, List<Character>>(); 
	Map<Character, Integer> visited = new HashMap<>();
	StringBuffer sb = new StringBuffer();
	
	public String alienOrder(String [] words)
	{
		if(words == null || words.length == 0)
			return "";
		
		buildGraph(words);
		
		for(char c : graph.keySet())
		{
			if(visited.get(c) == 0)
			{
				topologicalSort(c);
			}
		}
		
		return sb.toString();
	}
	
	private void topologicalSort(char c) 
	{
		visited.put(c, 1);
		for(char edgeNode : graph.get(c))
		{
			if(visited.get(edgeNode) == 0)
			{
				topologicalSort(edgeNode);
			}
		}
		sb.insert(0, c);
	}

	private void buildGraph(String[] words) 
	{
		for(String word : words)
		{
			for(char c : word.toCharArray())
			{
				if(!graph.containsKey(c))
				{
					graph.put(c, new ArrayList<>());
					visited.put(c, 0);
				}
			}
		}
		
		// Build edges
		for(int i=0; i<words.length-1; i++)
		{
			int index=0;
			while(index < words[i].length() && index<words[i+1].length())
			{
				char c1 = words[i].charAt(index);
				char c2 = words[i+1].charAt(index);
				
				if(c1 != c2)
				{
					graph.get(c1).add(c2);
					break;
				}		
				index++;
			}
		}
	}
	
	public static void main(String[] args) 
	{
		String [] words = {"wrt", "wrf", "er", "etf", "rftt"};
		AlienDictionary obj = new AlienDictionary();
		String result = obj.alienOrder(words);
		
		System.out.println(result);
	}

}
