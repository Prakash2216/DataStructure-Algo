package com.ds.algo.array;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;

class Interval implements Comparable<Interval>{
	
	int start;
	int end;
		
	public Interval(int start, int end) {
		this.start=start;
		this.end=end;
	}
@Override
	public int compareTo(Interval intv) {
		return this.end-intv.end;
	}
}

public class FindMutuallyExclusiveInterval {

	private static ArrayList<Interval> findMutuallyExclusive(ArrayList<Interval> list) {
		ArrayList<Interval> aux = new ArrayList<>();
		
		int j=0;
		int i;
		int len = list.size();
		for(i=1; i<len; i++) {
			
			if(list.get(i).start < list.get(i-1).end)
				continue;
			else {
				if(i-1 != j) {
					list.get(j).end = list.get(i-1).end;
					aux.add(list.get(j));
					j=i;
				}
				else {
					aux.add(list.get(j));
					j=i;
				}
			}			
		}
		if(j != i-1) {
			list.get(j).end = list.get(i-1).end;
			aux.add(list.get(j));
		}
		else
			aux.add(list.get(j));
		return aux;
	}
	private static void print(ArrayList<Interval> list) {
		Iterator< Interval> ite = list.iterator();
		while(ite.hasNext()) {
			Interval intv=ite.next();
			System.out.println("Interval ("+intv.start+", "+intv.end+")");
		}
	}
	public static void main(String[] args) {
		
		Interval i1 = new Interval(13, 14);
		Interval i2 = new Interval(3, 7);
		Interval i3 = new Interval(5, 12);
		Interval i4 = new Interval(3, 9);
		Interval i5 = new Interval(16, 20);
		Interval i6 = new Interval(15, 19);

		ArrayList<Interval> list = new ArrayList();
		list.add(i1);
		list.add(i2);
		list.add(i3);
		list.add(i4);
		list.add(i5);
		list.add(i6);
		
		Collections.sort(list);
		ArrayList<Interval> nList = findMutuallyExclusive(list);		
		print(nList);
	}
}
