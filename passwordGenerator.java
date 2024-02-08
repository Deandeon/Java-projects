/*
 * Code Written by 
 * @David Kweku Amissah Orhin 
 * Student ID 20522026
 * 
 *  This is a program that generates random passwords
 */
// Importing the random library 
import java.util.Random;
import java.util.Scanner;

// Main class for generating passwords
public class passwordGenerator{

   // Main method to execute the program
   public static void main(String args[]){

        // Initializing scanner object 
        Scanner input = new Scanner(System.in);
        
        // Prompting user for input
        System.out.println("Enter allowed Special characters: ");
        String allowedSpecials = input.nextLine();
        System.out.println("Enter minimum password length: ");
        int minPasslength = input.nextInt();
        System.out.println("Enter minimum number Uppercase Characters: ");
        int minUppercase = input.nextInt();
        System.out.println("Enter minimum number of digit characters: ");
        int minNumOfDigits = input.nextInt();
        System.out.println("Enter minimum number of specials : ");
        int minNumOfSpecials = input.nextInt();
        
        // Generating random password
        String randomPassword = generatePassword(
        		minPasslength,
        		minUppercase,
        		minNumOfDigits,
        		minNumOfSpecials,
        		allowedSpecials  
        		);
        
        // Checking if generated password meets requirements
        Boolean passTest = checkPassword(randomPassword,
        		minPasslength,
        		minUppercase,
        		minNumOfDigits,
        		minNumOfSpecials,
        		allowedSpecials);
        
        // Displaying generated password
        if (passTest == true) {
       
        System.out.println("Here is your randomly generated password");
        System.out.println(randomPassword);
        }
        
        else {
        	System.out.println("The produced password does not meet the required conditions please try again");
        	}
        }
        
// Method to generate a random password
public static String generatePassword(
int minPassLength, 
 int minUppercase,
 int minNumOfDigits,
 int minNumOfSpecials,
 String allowedSpecials ){

// Getting length of special characters
int specialLength = allowedSpecials.length();	
Random  random = new Random();
	
// Creating character array for password
char[] randomPass = new char[minPassLength];

// Generating uppercase characters
for (int i = 0; i < minUppercase; i++) {
    randomPass[i] = randomGenUppercaseChar();
}

// Generating digit characters
for (int i = minUppercase; i < minUppercase + minNumOfDigits; i++) {
    randomPass[i] =  randomNumGen();
}

// Generating special characters
for (int i = minUppercase + minNumOfDigits; i < minUppercase + minNumOfDigits + minNumOfSpecials; i++) {
    int randIndex = (int) (Math.random() * specialLength);
    randomPass[i] = allowedSpecials.charAt(randIndex);
}

// Generating remaining lowercase characters
for (int i = minUppercase + minNumOfDigits + minNumOfSpecials; i < minPassLength; i++) {
    
       randomPass[i] = randomGenLetterChar('a','z');
}

// Shuffling the password
for (int i = minPassLength - 1; i > 0; i--) {
    int index = random.nextInt(i+1);
    char temp = randomPass[index];
    randomPass[index] = randomPass[i];
    randomPass[i] = temp;
}

// Converting character array to string and returning
return new String(randomPass);
}

// Method to check if password meets requirements
public static Boolean checkPassword(String i,
		int minPasslength, 
		int minUppercase, 
		int minNumOfDigits, 
		int minNumOfSpecials, 
		String allowedSpecials) {
	
	Boolean fufilledLength = null,caseCheck = null , digitsCheck = null,specialCheck = null, allRight = null;
	
	if(i.length() <= minPasslength ) {
		fufilledLength = true;
	}
	
	 if(i.length() > minUppercase) {
		caseCheck = true;
	}
	 if(i.length() > minNumOfDigits + minUppercase) {
		digitsCheck = true;
	}
	if(i.length() > minNumOfSpecials + minUppercase + minNumOfDigits) {
		specialCheck =true;
	}
	
	if(fufilledLength && caseCheck && digitsCheck && specialCheck == true) {
		allRight = true;
	
	}
	else{
	allRight = false;		
		
}
	return allRight;
}

// Method to generate a random lowercase character
public static char randomGenLetterChar( int i, int j){
return  (char)(i + Math.random() * (j - i + 1));
 }

// Method to generate a random uppercase character
 public static char randomGenUppercaseChar(){
   char upperRandom = randomGenLetterChar('A','Z');
   return upperRandom;

 }

// Method to generate a random digit character
 public static char randomNumGen(){
    return (char) ('0' + (int) (

Math.random() * 10));
 }

// Method to return allowed special characters
 public static String randomSpecialchar(String allowedSpecials){
    return allowedSpecials;
 }
 }

