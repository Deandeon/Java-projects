
    

/* This code is written for a Connect4 game in Java.
 * 
 * It was authored by David Orhin.
 * 
 * Some algorithms for methods were referenced from Stack Overflow and Educately.
 */

 import java.util.Scanner;

 public class connect4App{
 
 //Some instance variables
     
     //The first player or player red
     public static char redPlayer = 'R';
     
     // The second player or player Yellow
     public static char YellowPlayer = 'Y';
     
     //Public scanner for ease
     public static Scanner Keyboard = new Scanner(System.in);
    
   
     // main Method to call the main game method with is the connect4game
     public static void main(String[] args){
 
 // This calls the connect4 game in the main
 connect4game();
 
     }
 
     /* The connect4game method initializes the gameas well as handles the game loop,
      * and controls player turns and input.
      */
 public static void connect4game(){
     
     //Produces a new array that would wipe when ever the while loop is exited or the game has ended
     char[][] arrayGrid = getNewArray();
 
     //Bool for the end game condition
     boolean gameOver = false;
 
     // First player is red
     char playerTurn = redPlayer;
 
     
     while(gameOver == false ){
         
         
         connect4Interface(arrayGrid);
         
         System.out.println("player " + playerTurn + " Drop a  disk at column 0 - 6 " );
         
         int input = Keyboard.nextInt();
 
         //  This is to check if the input is outside the range of valid numbers (0 - 6).
         
          
         if(input > 6 || input < 0 ){
             
             System.out.println("The value entered is outside the expected range, please try again");
             
             input = Keyboard.nextInt();
         }
         
         // This is to check if the input is not a valid number.
          
          
         boolean isNum = (input >= 0 && input <= 6);
         if(!isNum) {
             
             System.out.println("The value entered is not valid, please try again");
             
             input = Keyboard.nextInt();
         }
         
         connect4GameMechanic(playerTurn,  arrayGrid, input);
         
             
         if (winCondition(arrayGrid, playerTurn)) {
             
             connect4Interface(arrayGrid);
             
             System.out.println(playerTurn + " Wins the game! Congratulations!");
             
             gameOver = true;
             
         } else if (drawCheck(arrayGrid)) {
             
             connect4Interface(arrayGrid);
             
             System.out.println("The game is a draw! No one wins.");
             
             gameOver = true;
             
         } else {
             // Switch to the next player
             playerTurn = playerSwapper(playerTurn);
 
         }
         
     }
 }
 
 
 
 /* The winCondition method checks the game board for winning combinations.
  * It checks horizontally, vertically, and diagonally for four piece placements.
  * This algorithm works by always assuing and looking for the 4 consecutive placements
  */
 public static boolean winCondition(char[][] arrayGrid, char playerTurn) {
     
     // Checks horizontally
     for (int i = 0; i < arrayGrid.length; i++) {
         //Subtracts 4 to always ensure that the index for the consecutive wins are not past 4
         for (int j = 0; j <= arrayGrid[i].length - 4; j++) {
             
             // condition for verticals based on place ments
             if (arrayGrid[i][j] == playerTurn && arrayGrid[i][j + 1] == playerTurn &&
                 arrayGrid[i][j + 2] == playerTurn && arrayGrid[i][j + 3] == playerTurn) {
                 return true;
             }
         }
     }
     
     // Checks diagonally form the top left
     for (int i = 0; i <= arrayGrid.length - 4; i++) {
         for (int j = 0; j <= arrayGrid[i].length - 4; j++) {
             if (arrayGrid[i][j] == playerTurn && arrayGrid[i + 1][j + 1] == playerTurn &&
                 arrayGrid[i + 2][j + 2] == playerTurn && arrayGrid[i + 3][j + 3] == playerTurn) {
                 return true;
             }
         }
     }
     
     // Check diagonally from the top right
     for (int i = 0; i <= arrayGrid.length - 4; i++) {
         for (int j = 3; j < arrayGrid[i].length; j++) {
             if (arrayGrid[i][j] == playerTurn &&
                 arrayGrid[i + 1][j - 1] == playerTurn &&
                 arrayGrid[i + 2][j - 2] == playerTurn &&
                 arrayGrid[i + 3][j - 3] == playerTurn) {
                 return true;
             }
         }
     }
     
     // If no win condition is met return false to continue the game
     return false;
 }
 
 
 /* The drawCheck method checks if the game board is full and no player has won
  *
  */
 public static boolean drawCheck(char[][] arrayGrid) {
     
     int spaceCounter = 0;
     
     for (int i = 0; i < arrayGrid.length; i++) {
         for (int j = 0; j < arrayGrid[i].length; j++) {
             if (arrayGrid[i][j] != ' ') {
                 spaceCounter += 1;
             }
             
             // If the number of non-empty cells equals the total number of cells, it's a draw
             if (spaceCounter == 42) {
                 return true;
             }
         }
     }
     
     return false; 
 }
 
 
 /* The connect4GameMechanic method handles the logic for dropping a token into a column.
  * It places the token at the lowest empty row in the specified column.
  */
 public static void connect4GameMechanic(char playerTurn, char[][] arrayGrid, int input) {
     
     int colNum = input;
     
     for (int i = arrayGrid.length - 1; i >= 0; i--) {
         
         if (arrayGrid[i][colNum] == ' ') {
             arrayGrid[i][colNum] = playerTurn;
             break;
         }
     }
 }
 
 
 // The connect4Interface method displays the current state of the game board visually.
 
 public static void connect4Interface(char[][] arrayGrid) {
     
     for (int i = 0; i < arrayGrid.length; i++) {
         for (int j = 0; j < arrayGrid[i].length; j++) {
             System.out.print("| " + arrayGrid[i][j]);
         }
         System.out.println("|");
     }
     System.out.println("---------------"); 
 
 }
 
 
 // The getNewArray method initializes a new game board with empty spaces and assigns it to arrayGrid in the connect4game method
  
 public static char[][] getNewArray() {
     
     char[][] arrayGrid = new char[6][7];
     
     for (int i = 0; i < arrayGrid.length; i++) {
         for (int j = 0; j < arrayGrid[i].length; j++) {
             arrayGrid[i][j] = ' ';
         }
     }
     
     return arrayGrid;
 }
 
 
 // The playerSwapper method alternates between players for each turn.
  
 public static char playerSwapper(char playerTurn){
     
     if (playerTurn == redPlayer) {
         return YellowPlayer;
     } else {
         return redPlayer;
     }
 }
 
 }
 