# RSA
First year mathematics project to implement a simple Java version of the RSA algorithm

The encryption function takes a string of ascii characters in input and convert each character to a number. Each number is then encrypted using the public key (which has been previously generated). Therefore given an input message, returned is a sequence of encrypted numbers corresponding to the encrypted characters of the string. The output of the encryption function is the string of such numbers, each separated by a space, e.g., "250 110 10 342 324".

The decryption function takes a string of numbers in input (e.g., "250 110 10 342 324"), and decrypts each number using the private key (which has been previously generated). The decrypted numbers are then converted back to the corresponding ascii characters. 
