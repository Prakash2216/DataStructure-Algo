package com.o9solution;

interface SupplyChain
{
	public void addSupply(int bucket, float delta);
	public void addDemand(int bucket, float delta);
	public float getInventry(int bucket);
}


class SupplyChainTree implements SupplyChain
{	
	float [] segmentInventory=null;
	float [] lazzyPropInventory=null;
	int buckets;
	
	public SupplyChainTree(int buckets) 
	{
		this.buckets = buckets;
		int size = nextPowerOf2(buckets);
		segmentInventory = new float[2*size-1];
		lazzyPropInventory = new float[2*size-1];
	}

	private int nextPowerOf2(int num) 
	{
		if(num == 0)
			return 1;
		
		if(num > 0 && (num&(num-1)) == 0)
			return num;
		
		while((num & (num-1)) > 0)
		{
			num = num&(num-1);
		}
		
		return num<<1;
	}
	
	public void updateInventory(int buckets, int start, int end, float data)
	{
		updateInventoryUtil(0, 0, buckets - 1, start, end, data);
	}
	
	private void updateInventoryUtil(int pos, int low, int high, int start, int end, float data) 
	{
		
		if (lazzyPropInventory[pos] != 0) 
		{ 
				 
			segmentInventory[pos] += lazzyPropInventory[pos];
			 
			if (low != high) 
			{ 
				//Postpone updating childrens 				 
				lazzyPropInventory[pos * 2 + 1] += lazzyPropInventory[pos]; 
				lazzyPropInventory[pos * 2 + 2] += lazzyPropInventory[pos]; 
			} 

			// Set the lazy value for current node as 0 as it is updated
			lazzyPropInventory[pos] = 0.0F; 
		} 

		// No overlap 
		if (low > high || low > end || high < start) 
			return; 

		// Full overlap 
		if (low >= start && high <= end) 
		{ 
			// Add the difference to current node 			
			segmentInventory[pos] +=  data;

			// Logic for checking leaf node or not 
			if (low != high) 
			{ 
				// This is place we store values in lazy nodes, 
				// instead of updating the segment tree. 
				// postponing the updates by storing values in lazy array 
				lazzyPropInventory[pos * 2 + 1] += data; 
				lazzyPropInventory[pos * 2 + 2] += data; 
			} 
			return; 
		} 

		// If partial overlap in range.		 
		int mid = (low + high) / 2; 
		updateInventoryUtil(pos * 2 + 1, low, mid, start, end, data); 
		updateInventoryUtil(pos * 2 + 2, mid + 1, high, start, end, data); 
	 
	} 

	

	@Override
	public void addSupply(int bucket, float data) 
	{
		updateInventory(buckets, bucket, buckets-1, data);		
	}

	@Override
	public void addDemand(int bucket, float data) 
	{
		updateInventory(buckets, bucket, buckets-1, -data);		
	}

	@Override
	public float getInventry(int bucket) {
		
		if (bucket < 0 || bucket > buckets - 1) 
		{ 
			System.out.println("Invalid Input"); 
			return -1.0F; 
		} 

		return getInventryUtil(0, buckets - 1, bucket, bucket, 0); 

	}
		
	private float getInventryUtil(int low, int high, int start, int end, int pos) 
	{
					
					if (lazzyPropInventory[pos] != 0) 
					{ 
						segmentInventory[pos] +=  lazzyPropInventory[pos];

						if (low != high) 
						{ 
							lazzyPropInventory[pos * 2 + 1] += lazzyPropInventory[pos]; 
							lazzyPropInventory[pos * 2 + 2] += lazzyPropInventory[pos]; 
						} 

						lazzyPropInventory[pos] = 0; 
					} 

					//No Overlap 
					if (low > high || low > end || high < start) 
						return 0.0F; 

					if (low >= start && high <= end) 
						return segmentInventory[pos]; 

					// Partial overlap 
					int mid = (low + high) / 2; 
					return getInventryUtil(low, mid, start, end, 2 * pos + 1) + getInventryUtil(mid + 1, high, start, end, 2 * pos + 2); 

	}
	
	

}
public class Driver {

	public static void main(String[] args)
	{
		SupplyChainTree tree = new SupplyChainTree(10);
		
		tree.addSupply(2, 50);
		
		System.out.println("Get the inventory after adding suppy 50 in bucket 2: "+tree.getInventry(3));
		
		tree.addDemand(3, 25);
		
		System.out.println("Get the inventory after adding demand 25 in bucket 3: "+tree.getInventry(3));
		
		tree.addDemand(2, 30);
		
		System.out.println("Get the inventory after adding demand 30 in bucket 2: "+tree.getInventry(3));

	}

}
