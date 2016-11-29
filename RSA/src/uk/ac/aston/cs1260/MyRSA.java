package uk.ac.aston.cs1260;
/**
	Please note that no exceptions should be thrown, rather a null must be returned on error.
 **/

public class MyRSA {
	@SuppressWarnings("unused")
	private static int m;
	private static int n;
	private static int a;
	private static PublicKey pk;
	private static String asciiString;
	private static String numbers;

	/**
	 * Computes the public key (a,n) using p and q, and uses this to encrypt the message
	 * @param p a prime number
	 * @param q a prime number
	 * @param privateKey
	 * @param message string of ascii characters, each character will be converted to a number
	 * @return a string of encrypted numbers correlating to each character in the message
	 */
	public static String encrypt(int p, int q, int privateKey, String message) {

		//Convert to ASCII 8 bit number
		StringBuilder strb = new StringBuilder();
		for (int i = 0; i < message.length(); i++) {
			char character = message.charAt(i);
			int ascii = (int) character;
			strb.append(ascii + " ");
		}

		asciiString = strb.toString();	
	//	System.out.println("Message in ascii: " + asciiString);			

		//Encrypt using a public key
		pk = PublicKey.create(p, q, privateKey);
		a = pk.a;
		n = pk.n;
		m = pk.m;
		numbers = asciiString;
		String encrypted = fastModExponentiation();
	//	System.out.println("Public key a: " + pk.a + " n: " + pk.n + " m: "+ pk.m);

		return encrypted;
	}

	/**
	 * Takes a string of numbers and decrypts each number using the private key (which has been previously generated). 
	 * The decrypted numbers are then converted back to the corresponding ascii characters. 
	 * @param privateKey
	 * @param encryptedString  a string of numbers (e.g., "250 110 10 342 324")
	 * @param p a prime number
	 * @param q a prime number
	 * @return a string of the decrypted message
	 */
	public static String decrypt(int privateKey, String encryptedString, int p, int q) {
		a = privateKey;
		n = pk.n;
		m = pk.m;
		numbers = encryptedString;
		String decrypted = fastModExponentiation();
		String[] letterArray = decrypted.split(" ");
		StringBuilder sb = new StringBuilder();
		for(int i = 0; i<letterArray.length; i++) {
			int numToConvert = Integer.parseInt(letterArray[i]);
			char text = (char) numToConvert;
			sb.append(text);
		}
		return sb.toString();
	}

	public static String fastModExponentiation() {
		StringBuilder exponentiation = new StringBuilder();
		//Get each binary representation of exponent
		String binaryStr = Integer.toBinaryString(a);
		char[] binaryArr = binaryStr.toCharArray();

		//Get ascii array of characters in the message
		String[] numberArray = numbers.split(" ");	//converted to int later

		//Fast modular exponentiation
		for (int numCount = 0; numCount < numberArray.length; numCount++) {
			int asciiNum = Integer.parseInt(numberArray[numCount]);
			
			//iterate backwards through binary number
			long l = 1;					
			long M = asciiNum%n;
			
			for(int i = binaryArr.length - 1; i >= 0; i--){
				if(binaryArr[i]=='1') {
					l = l*M%n;
				}
				M = M*M%n;			
			}
			exponentiation.append(l + " ");	
		}
		return exponentiation.toString();
	}
}

