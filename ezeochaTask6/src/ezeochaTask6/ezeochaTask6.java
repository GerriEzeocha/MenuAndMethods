/**I declare that all material in this assessment task is my own work except where there is clear acknowledgement or reference to the work of others. I further declare that I have complied with, and agree to
abide by, the UIS Academic Integrity Policy at the University website. http://www.uis.edu/academicintegrity
Author’s Name: Gerri Ezeocha  Date: 03/29/2019*/
package ezeochaTask6;
/**
 * Goal of Task: To write a menu driven program that prompts user to choose a method to test:
 * methods include Decimal to Hex, Binary to Decimal, Hex to Decimal and String Permutations
 * 
 */
import java.util.*;
public class ezeochaTask6 {
	public static void main (String[] args) {
		
        Scanner input = new Scanner(System.in);
        String tryagain; //variable to hold user decision on trying another method
        
        //prompt warning user about user input size and potential time delay
        System.out.println("Choose an option below. Keep note of input size.\nTime delay will"
        		+ "occur in case of large inputs");	
        System.out.println();
        
        do {
        	//Menu of Methods, for user to choose from.
        System.out.print("Enter 1 to convert a Decimal to a Hexadecimal.\n");
        System.out.print("Enter 2 to convert a Binary number to a Decimal.\n");
        System.out.print("Enter 3 to convert a Hexadecimal to a Decimal.\n");
        System.out.println("Enter 4 to view the permutation of a String ");
        
        int choice = input.nextInt(); //hold user's choice from menu
        
        //taking user choice and passing to correct/indicated method
         if(choice ==1){
        	 System.out.print("Please enter a Decimal Number: ");
        	 int numValue = input.nextInt();
             String result = dec2Hex(numValue);
     		 System.out.println("The Hexadecimal equivalent of "+ numValue + " is "+ result);
         }
         else if (choice == 2){
        	 System.out.print("Please enter a Binary Number: ");
        	 String binaryString = input.next();
        	 int decimal = bin2Dec(binaryString);
     		 System.out.println("The Decimal equivalent of "+ binaryString + " is "+ decimal);
         }
         else if (choice == 3){
        	 System.out.print("Please enter a Hexadecimal Number: ");
        	 String hexString = input.next();
        	 int decimalHex = hex2Dec(hexString);
     		 System.out.println("The Decimal equivalent of "+ hexString + " is " + decimalHex);
         }
         else if (choice == 4){
        	 System.out.print("Please enter a String: ");
        	 String s = input.next();
        	 System.out.print("Permutations of " + s + " are: \n");
             displayPermutation(s);
         }
         else if (choice < 1 || choice > 4){
        	 System.out.print("Invalid input: Try again: ");
         }
         //asking user wants to keep testing methods.
         System.out.println();
 		 System.out.print("Test another method? Enter Y or N:  "); 
 		 tryagain = input.next().toUpperCase();
 		 System.out.println();
        } while (tryagain.charAt(0) == 'Y');
        
        	if(tryagain.charAt(0) == 'N') {
        		input.close();
        		System.out.println();
        		System.out.println("Thank you! Goodbye.");
        	}
	}
	//Method to convert decimal to hexadecimal
	public static String dec2Hex(int numValue) {
		String numResult = "";
		String code = "0123456789ABCDEF";
		if (numValue > 0) {
			numResult = dec2Hex(numValue/16); // Here the recursive function is called
			int remainder = numValue % 16;
			numResult += code.charAt(remainder);
		}
		return numResult;
	}

	//Method to convert binary number to decimal
	public static int bin2Dec(String binaryString) {
		int size = binaryString.length();
		int numResult = 0;
		if (size > 0) {
			int digit = Character.getNumericValue(binaryString.charAt(0));
			numResult = digit * (int) Math.pow(2, size - 1) + bin2Dec(binaryString.substring(1)); // Here the recursive function is called
		}
		return numResult;
	}

	//Method to convert hexadecimal number to Decimal
	public static int hex2Dec(String hexString) {
		String hexCapz = hexString.toUpperCase();
		int numResult = 0;
		String code = "0123456789ABCDEF";
		int size = hexString.length();
		if(size > 0) {
			char num = hexCapz.charAt(0);
			int dec = code.indexOf(num);
			numResult = dec * (int) Math.pow(16, size - 1) + hex2Dec(hexString.substring(1));// Here the recursive function is called
		}
		return numResult;
	}

	//Method to perform String permutation
	public static void displayPermutation(String s) {
		displayPermutation("", s);
	}
	//Helper-method for string permutation
	public static void displayPermutation(String s1, String s2) {
		int n = s2.length();
        if(s2.isEmpty()){
            System.out.println(s1);
        }
        else{
            for(int i = 0; i < n; i++){
                displayPermutation(s1 + s2.charAt(i), s2.substring(0, i) // Here the recursive function is called
                + s2.substring(i + 1, s2.length()));
            }
        }
	}

}
