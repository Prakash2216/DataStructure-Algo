package com.ds.algo.DP;

import java.util.Collections;

class Animal
{
	static int life;
	
}

class Cow extends Animal
{
	static int life;
	public Cow()
	{
		life++;
	}
}

class Dog extends Animal
{
	static int life;
	public Dog()
	{
		life++;
	}
}

public class PrintLongestIncreasingSubSequence {

	public static void main(String[] args) 
	{
		Cow cow=new Cow();
		Dog dog= new Dog();
		
		int a =10;
		int b = a/0;
		System.out.println();
				  
 		
		System.out.println(Dog.life);

	}

}
