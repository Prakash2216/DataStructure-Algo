package com.ds.algo.mathematical;

public class SelectRandomNoFromStream {
	public static int count=0;
	public static int res=0;
	public static void main(String[] args) {
		int [] stream = {1,2,3,4};
		SelectRandomNoFromStream obj = new SelectRandomNoFromStream();
		obj.SelectRandom(stream);
	}

	private void SelectRandom(int[] stream) {
		for(int i=0; i<stream.length; i++) {
			System.out.println("Random number from first"+(i+1)+" numbers is "
					+ " "+selectRandomUtil(stream[i]));
		}		
	}

	private int selectRandomUtil(int x) {
		count++;
		if(count == 1)
			res=x;
		else {
			int j = (int)Math.random()%count;
			if(j == count-1)
				res=x;
		}		
		return res;
	}
}
