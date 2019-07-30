package com.ds.algo.interview.goldmaSach;

import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * @Date : 3/5/2019
 * @author Prakash Singh.
 * 
 * WAP to print all the anagrams together of a string from the given list.
 * 
 * Ex- 
 * Input : {"cat", "dog", "tac", "god"}
 * Output : {"cat", "tac", "dog", "god"}
 * 
 *
 * Approach 1 : 
 * 1. Iterate over the List of string, Now sort the string and use the sorted string as key and add original string to set.
 * 2. Now put in map.
 * 3. Iterate over the map and add all the sets from map to set of set and return set.
 * 
 * 
 * Aproach 2: 
 * 
 * 1. Iterate over the list of String, and sort the string.
 * 2. Now create the Trie of the sorted string.
 * 3. word string end at the leaf node contains the list of index of original string index.
 * 4. Now iterate over all the 26 length array for each node, once reach the last node print the head list of index. 
 */

interface AllAnagrams
{
	public Set<Set<String>> getAllanagrams(List<String> words); 
}

public class PrintAllAnagrams 
{
	/*
	 *  Implementation of approach 1.
	 */
	class AllAnagramsImp implements AllAnagrams
	{
		Map<String, Set<String>> lookup;
		public AllAnagramsImp()
		{
			 lookup = new LinkedHashMap<>();	
		}
	
		@Override
		public Set<Set<String>> getAllanagrams(List<String> words) 
		{
			Set<Set<String>> result = new LinkedHashSet<>();
			getAllAnagramsUtil(words);
			
			for(String word : words)
			{
				char [] arr = word.toCharArray();
				Arrays.sort(arr);
				result.add(lookup.get(String.valueOf(arr)));
			}
			return result;
		}
		
		public void getAllAnagramsUtil(List<String> words)
		{
			if(words == null || words.isEmpty())
				return;
			
			for(String word : words)
			{
				char [] cword = word.toCharArray();
				Arrays.sort(cword);
				
				String temp = String.valueOf(cword);
				Set<String> set = lookup.get(temp);
				
				if(set == null) {
					set = new LinkedHashSet<>();
					set.add(word);
					lookup.put(temp, set);
				}
				else {
					set.add(word);
					lookup.put(temp, set);
				}
			}
		}
		
		/**
		 * Implementation of approach 2.
		 * 
		 */
		final int NO_OF_CHARS = 26;
		String [] wArr;
		class TrieNode{
			
			TrieNode [] childs;
			List<Integer> head;
			boolean isEnd;
			
			public TrieNode()
			{
				childs = new TrieNode[NO_OF_CHARS];
				head = new LinkedList<>();
				isEnd=false;
			}
		}
		
		public void printAllAnagramsTogether(List<String> words)
		{
			if(words == null || words.isEmpty())
				return;
			
			wArr = words.toArray(new String[words.size()]);
			TrieNode root = null;
			
			for(int i=0; i<wArr.length; i++ ) {
				char [] carr = wArr[i].toCharArray();
				Arrays.sort(carr);
				root = insert(root, String.valueOf(carr), i, 0);
			}
			printAllAnagramsUtil(root);
		}

		private void printAllAnagramsUtil(TrieNode root) {
			
			if(root == null)
				return;
			
			if(root.isEnd)
				for(Integer i : root.head)
				{
					System.out.println(wArr[i]);
				}
			
			for(int i=0; i<NO_OF_CHARS; i++)
				printAllAnagramsUtil(root.childs[i]);
		}

		private TrieNode insert(TrieNode root, String word, int index, int i) {
			
			if(root == null)
				root = new TrieNode();
			if(i<word.length()) {
				int index1 = word.charAt(i) - 'a'; // getting the index for character to save in 26 size array
				root.childs[index1] = insert(root.childs[index1], word, index, i+1);
			}
			else
			{
				if(root.isEnd == true)
				{
					root.head.add(index);
				}
				else {
					root.isEnd = true;
					root.head.add(index);
				}
			}
			return root;
		}
		
	}
	public static void main(String[] args)
	{
		List<String> words = new LinkedList<String>();
		
		words.add("cat");
		words.add("dog");
		words.add("act");
		words.add("god");
		
	PrintAllAnagrams.AllAnagramsImp obj = new PrintAllAnagrams().new AllAnagramsImp();
		
		/*Set<Set<String>> result = obj.getAllanagrams(words);
		
		for(Set<String> set : result)
		{
			if(set != null)
				System.out.println(set);
		}
		*/
		obj.printAllAnagramsTogether(words);
		
	}

}
