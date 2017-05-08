package com.ds.algo.interview.amzn.set332;

public class FindSquareRoot {
	public static double sqrtMethod3(double a)
    {
        //firstly check if a is non-negative value
    if(a<0)
        return -1;
    
    //also check if a==0 or a==1 because in these two cases sqrt(a) = a
    if(a==0 || a==1) return a;

    //now start the core part of the code
    double precision = 0.000001;//define the precision, so we stop when precision is achieved
    
    double start = 0;
    double end = a;
    
    //we define these two start/end values because usually 0<sqrt(a)<a
    //however, if a<1; then 0<a<sqrt(a)
    if(a<1)
        end = 1;
    double ans=0;
    //define a loop to continue if the precision is not yet achieved
    while(end-start>precision)
    {
       // System.out.println("end-start = "+(end-start));
      //  System.out.println("precision = "+precision);

    double mid = (start+end)/2;
    double midSqr = mid*mid;
    
    if(midSqr==a)
        return mid;//we find the exact sqrt value!
    else if(midSqr<a) {
        start = mid;//we shift our focus to bigger half
      }
    else 
        end = mid;//shift focus to smaller half
    }

    
    //if we did not find exact sqrt value, we return the approxiated value with the defined precision
    return (start+end)/2;
    
  }

//Following method is used to find the perfect square of the given number in O(log n)

public static int findPerfectSquare(int a) {
	if(a<0)
		return -1;
	if(a == 0 || a == 1) {
		return a;
	}
	
	int start = 1;
	int end = a;
	int ans =0;
	while(start <=end) {
		int mid = (start+end)/2;
		
		if(mid*mid == a)
			return mid;
		else if(mid*mid < a) {
			start = mid+1;
			ans = mid;
		}
		else
			end = mid-1;
	}
	return ans;
}
  public static void main(String[] args) {
		int x=11;
		System.out.println("Square Root of "+x+" "+sqrtMethod3(x));
		
		System.out.println("Perfect square root of "+x+" "+findPerfectSquare(x));
	}

}
