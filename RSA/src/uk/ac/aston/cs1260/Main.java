package uk.ac.aston.cs1260;
public class Main {
/**
	Sample Main code. You can use this to run some tests on your code and
	check that it compiles and executes without errors.
**/

    public static void main(String[] args) {
    	int p = 53;
        int q = 61;
        int k = 1013;
        String message = "Hello world";
        System.out.println("Message to encrypt: " + message);
        String encryptedString = MyRSA.encrypt(p, q, k, message);
        System.out.println("Encrypted string: " + encryptedString);
        String checkValue = MyRSA.decrypt(k, encryptedString, p, q);
        System.out.println("Value after decrypting: " + checkValue);
    }
    
}
