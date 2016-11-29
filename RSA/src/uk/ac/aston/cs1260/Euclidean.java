package uk.ac.aston.cs1260;


/**
 * Extended euclidean algorithm
 * 
 * @author Clare Buckley
 * @version 24/04/2016
 */
public class Euclidean {
	private static int a;
	private static int b;

/*	//http://www.mast.queensu.ca/~math418/m418oh/m418oh04.pdf
	public static int normalAlgorithm(int a, int b) {
		Euclidean.a = a;		--> don't need to assign these
		Euclidean.b = b;

		while (b!=0) 
		{
			temp = a % b;
			a = b;		
			b = temp;		
		}
		return a; 			// a is gcd
	}
*/

	public static int extendedAlgorithm(int a, int b) 
	{ 
		//a0 b0 correspond to a and b in ax + by = gcd(a, b)
		//want to get a for publicKey --> need a such that gcd(a,n)=1;  
		
		int x = 0; 
		int prevY = 0;
		int prevX = 1;
		int y = 1;
		int toStore;


		while (b != 0) {
			//set the values to use
			int p = a/b;
			int q = a%b;
			a = b;
			b = q;
			
			//swapping
			toStore = x;
			x = prevX - p*x;
			prevX = toStore;	
			toStore = y;
			y = prevY - p*y;
			prevY = toStore;
		}
		if(prevX>prevY){
			return prevX;
		}
		else {
			return prevY;
		}

	}

}
