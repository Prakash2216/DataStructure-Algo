package com.ds.algo.interview.Adobe;
/**
 * Problem: Given N petrol pumps, which having some amount of petrol and there is some distance between the next petrol pump, where only
 * one can fill the petrol.
 * 
 * find the starting point from where one can complete the circular tour by visiting all the petrol pumps.
 * @author Prakash
 *
 */
public class CircularlyArrangedNPetrolPumpTour {

	// tuple class contains the petrol at the current petrol pump and distance to next petrol pump.
	static class Petrol
	{
		int petrol;
		int distance;
		
		public Petrol(int petrol, int distance) 
		{
			this.petrol = petrol;
			this.distance = distance;
		}
	}
	
	/**
	 * we choose first petrol pump at index 0 as the start point and end at index 1.
	 * and keep traversing te petrol pump at all the index if end reaches to start that means we cover all the petrol pump.  
	 * @param petArr 
	 * @param length
	 * @return
	 */
	private static int findStartNode(Petrol[] petArr, int length) {
		int start = 0;
		int end = 1;
		int currPetrol = petArr[start].petrol - petArr[start].distance;
		
		while(start != end || currPetrol < 0)
		{
			while(currPetrol < 0 && start != end)
			{
				currPetrol -= petArr[start].petrol - petArr[start].distance;
				start = (start+1)%length;
				
				if(start == 0)
					return -1;
			}
			currPetrol += petArr[end].petrol - petArr[end].distance;
			end = (end+1)%length;
		}
		return start;
	}
	
	public static void main(String[] args) 
	{
		
		Petrol [] petArr = {new Petrol(9, 2), new Petrol(5, 6), new Petrol(3, 10), new Petrol(6, 5)};
		
		int start = findStartNode(petArr, petArr.length);	
		
		System.out.println(start == -1? "No solution" : "start = "+start);
	}	

}
