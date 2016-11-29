package uk.ac.aston.cs1260;


public class PublicKey {
	public  int a;
    public  int n;
    public  int m;

    public static PublicKey create(int p, int q, int k) {
		PublicKey pk = new PublicKey();	
    	pk.n = p*q;
		pk.m = (p-1)*(q-1);
		pk.a = Euclidean.extendedAlgorithm(pk.m,k);
		return pk;
    }
  
    
}
