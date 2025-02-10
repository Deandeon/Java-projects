/*
 * Code Written by 
 * @David Kweku Amissah Orhin 
 * 
 * 
 *  A Receipt printing program that shows a user how much change they are due to take.
 */

//Importing the scanner Class
import java.util.Scanner;
public class  EssentialStore1{
    
// Unicode character for Ghanaian Cedi
char cediSign = '\u20B5';

public static void main(String[] args){
// Create a Scanner object to read user input
Scanner moneyInput = new Scanner(System.in);

// Prompt the user to enter the total cost of the item
System.out.println("Please Enter the total Cost of the item");
double totalCost = moneyInput.nextDouble();

// Prompt for the user to enter the amount they paid
System.out.println("Please Enter the amount you paid");
double amountPaid = moneyInput.nextDouble();

// A check to ensure that the amount paid is higher than the cost 
if(totalCost > amountPaid){
    System.out.println("You still owe some fees, there will be no change");
}
// Check if the amount paid is less than the total cost
else if(totalCost == amountPaid){
    System.out.println("There will be no change");
}
// Calculate and display the change breakdown
else{
computeChangeBreakdown(totalCost, amountPaid);
}


}

// Method to compute and display the change breakdown
public static void computeChangeBreakdown( double totalCost, double amountPaid){
// Initialized variables to count the number of different denominations
int fiftyCediNotes =0, twentyCediNotes =0, tenCediNotes = 0, fiveCedisNotes= 0, twoCedisCoin = 0, OneCediCoin = 0;

double  fiftyPeaCoin = 0,twentyPeaCoin = 0, tenPeaCoin = 0, fivePeaCoin = 0, onePeaCoin = 0;
// Calculate the change to be given and rounds it to 2 decimal places
double changeGiven = Math.round((amountPaid - totalCost) * 100.0) / 100.0;

// variable that makes change only an integer
int change = (int) changeGiven;

// variable that isolates the coins/ decimals in the change and rounds then to 2 decimal places
double changeForCoins = Math.round((changeGiven - change ) * 100.0) / 100.0;;

//Unicode for cedi
char cediSign ='\u20B5';

// Passing the change through if else statements to determine the number of bills needed
if(change >= 50 ){
fiftyCediNotes = change / 50;
change = change % 50;

}

 if(change >= 20){
twentyCediNotes = change / 20;
change = change % 20;

}

 if( change >= 10){
    tenCediNotes = change / 10;
    change = change % 10;
   

}

 if ( change >= 5){
    fiveCedisNotes = change / 5;
    change = change % 5;
       
}

 if (change >= 2){
    twoCedisCoin = change /2;
    change = change % 2;
  
    
}

 if ( change >= 1){
    OneCediCoin = change / 1;
    
}

 if (changeForCoins >= 0.5){
    fiftyPeaCoin = changeForCoins / 0.5;
    changeForCoins = changeForCoins % 0.5;
    

}
 if (changeForCoins >= 0.2){
    twentyPeaCoin = changeForCoins / 0.2;
    changeForCoins = changeForCoins % 0.2;
  
}

 if (changeForCoins >= 0.1){
    tenPeaCoin = changeForCoins / 0.1;
    changeForCoins = changeForCoins % 0.1;
    
}
 if (changeForCoins >= 0.05){
        fivePeaCoin = changeForCoins / 0.05;
        changeForCoins = changeForCoins % 0.05;
       
}
 if (changeForCoins >= 0.01){
    onePeaCoin = changeForCoins / 0.01;
    changeForCoins = changeForCoins % 0.01;
 
}
 
 // casting the values of the coins to int to allow thier numbers to be acquired
int fiftyPeaCoinint = (int)fiftyPeaCoin;
int twentyPeaCoinint = (int)twentyPeaCoin;
int tenPeaCoinint = (int)tenPeaCoin;
int fivePeaCoinint = (int)fivePeaCoin;
int onePeaCoinint = (int)onePeaCoin;


 // Display total change
System.out.printf("Your reminder is : %c %.2f", cediSign, changeGiven);
// empty line for better readability
System.out.println("");

// Checks to ensure that there is no repetition of bills if they are not needed ( They have a value of 0)
if(fiftyCediNotes > 0) {
System.out.println( fiftyCediNotes + " "+ cediSign +" 50 Cedi Notes" );
}
if(twentyCediNotes > 0) {
System.out.println( twentyCediNotes +" "+ cediSign +" 20 Cedi Notes" );
}
if(tenCediNotes > 0) {
System.out.println( tenCediNotes +" "+ cediSign +" 10 Cedi Notes" );
}
if(fiveCedisNotes > 0) {
System.out.println( fiveCedisNotes +" "+ cediSign +" 5 Cedi Notes" );
}
if(twoCedisCoin > 0) {
System.out.println( twoCedisCoin + " "+ cediSign +" 2 Cedi coin" );
}
if( OneCediCoin> 0) {
System.out.println( OneCediCoin + " "+ cediSign + " 1 Cedi Notes" );
}
if(fiftyPeaCoinint > 0) {
System.out.println(fiftyPeaCoinint +" 50p coin");
}
if(twentyPeaCoinint> 0) {
System.out.println(twentyPeaCoinint +" 20p coin");
}
if(tenPeaCoinint > 0) {
System.out.println(tenPeaCoinint +" 10p coin");
}
if(fivePeaCoinint > 0) {
System.out.println(fivePeaCoinint +" 5p coin");
}
if(onePeaCoinint > 0) {
System.out.println(onePeaCoinint +" 1p coin");
}




}
}
// Planning/List to take note of :

// It should have the ability to work with both notes and coins in the Ghanaian currency.

// 	it should format its output neatly so that it will look presentable when printed on the receipt slip.

// It must display the appropriate currency symbol of the Ghana Cedi (₵) notes and coins. 

// 	Your software should have the ability to display currency figures to two decimal places exactly.  

// Note that, in your program, you should only print a particular denomination if the required.






