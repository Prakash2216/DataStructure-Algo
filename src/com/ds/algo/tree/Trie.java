package com.ds.algo.tree;

import java.util.HashMap;
import java.util.Map;

class TrieNode{
	Map<Character, TrieNode> children;
	boolean endOfWord;
	
	public TrieNode(){
		children = new HashMap<Character, TrieNode>();
		endOfWord = false;
	}
}

public class Trie {

	// Method to create the Trie 
	public static void createTrieUtil(String name, TrieNode root){
		if(name == null)
			return;
		TrieNode current = root;
		for(int i=0; i<name.length(); i++){
			Character ch = name.charAt(i);
			TrieNode node = current.children.get(ch);
			if(node == null){
				node = new TrieNode();
				current.children.put(ch, node);
			}
			current = node;
		}
		current.endOfWord = true;
	}
	//Method to create Trie Recursively
	public static void createTrieUtilRecursive(String name, TrieNode current, int index){
		
		if(index == name.length())
			return;
		
		Character ch = name.charAt(index);
		TrieNode node = current.children.get(ch);
		if(node == null){
			node = new TrieNode();
			current.children.put(ch, node);
			if(index == name.length()-1)
				current.endOfWord = true;
		}			
		
		createTrieUtilRecursive(name, node, index+1);
	}
	public static void createTrie(String [] names, TrieNode root){
		/*
		for(int i=0; i<names.length; i++){
			createTrieUtil(names[i], root);
		}
		*/
		
		for(int i=0; i<names.length; i++){
			createTrieUtilRecursive(names[i], root, 0);
		}
	}
	
	// Method for searching a word in Trie 
	public static boolean searchWord(String name, TrieNode root){
		if(name == null || root == null)
			return false;
		TrieNode current = root;
		for(int i=0; i<name.length(); i++){
			Character ch = name.charAt(i);
			TrieNode node = current.children.get(ch);
			if(node == null)
				break;
			current = node;
		}
		return current.endOfWord;
	}
	
	// Method for deleting a word from the Trie
	public static void delete(String name, TrieNode root){
		_delete(name, root, 0); 
	}
	
	public static boolean _delete(String name, TrieNode current, int index){
		
		if(index == name.length()){
			if(!current.endOfWord){
				return false;
			}
			current.endOfWord = false;
			return current.children.size() == 0;
		}
		
		Character ch = name.charAt(index);
		TrieNode node = current.children.get(ch);
		if(node == null){
			return false;
		}
		
		boolean shouldDelete = _delete(name, node, index+1);
		if(shouldDelete){
			current.children.remove(ch);
			return current.children.size() == 0;
		}
		return false;
	}
	
	public static void main(String[] args) {
		
		TrieNode root = new TrieNode();
		String [] names = {"abc", "abgl", "cdf", "abcd", "lmn"};
		createTrie(names, root);
		
		String word ="abc";
		boolean status = searchWord(word, root);
		if(status)
			System.out.println("Word "+word+" exist");
		else
			System.out.println("Word "+word+" not found");
	}

}
