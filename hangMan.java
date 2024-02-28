/* This code is written for a Hangman game in Java.
 * 
 * It was authored by David Orhin.
 * 
 * 
 */




// Importing the Scanner class for user input
import java.util.Scanner;

public class hangMan{

    // Array of words for the game
    public static String wordlist[] = {"tree","rest","keep","umbrella","hello","rest","sleep","free","sheep","fell"
		 ,"apple", "banana", "orange", "grape", "kiwi", "pineapple", "strawberry", "blueberry", "watermelon", "peach", 
		 "mango", "pear", "apricot", "cherry", "plum", "melon", "papaya", "lemon", "lime", "coconut", "fig", "nectarine", 
		 "raspberry", "blackberry", "cantaloupe", "cranberry", "elderberry", "guava", "passionfruit"};
    // Scanner object for user input
    public static Scanner keyboard = new Scanner(System.in);

    public static void main(String args[]){

        // Select a random word from the word list
        String randomWord = Wordtaker(wordlist);	

        // Start the Hangman game with the selected word
        hangmanGame(randomWord); 
    }

    // Method to run the Hangman game
    public static void hangmanGame(String chosenKey){

        // Length of the chosen word
        int guessWord = chosenKey.length();

        // Counter for missed chances
        int missedChances = 0;

        // Array to store asterisks representing hidden letters of the word
        char[] asterix1 = asterixMaker(guessWord);

        // String to store the hidden word
        String hidden = "";

        // Flag to control the game loop
        boolean gameOver = false;

        // Game loop
        while(!gameOver){

            // Update the hidden word string
            hidden = new String(asterix1);

            // Display the current state of the hidden word
            System.out.println("(Guess) Enter a letter in word "+ hidden);

            // Get user input for a letter
            char input = keyboard.next().charAt(0);

            // Convert the input to a string
            String input1 = input + "";

            // Check if the chosen word contains the guessed letter
            if(chosenKey.contains(input1)){
                // Update the asterisk array with the correct guessed letter
                for(int j = 0; j < guessWord; j++){
                    char compareChar = chosenKey.charAt(j);
                    if(compareChar == input){
                        asterix1[j] = compareChar;
                        hidden = new String(asterix1);
                    }         
                }
            } else {
                // Increment missed chances if the guessed letter is not in the word
                System.out.println( input +" is not part of the word");
                missedChances += 1;
            }

            // Check if the player has guessed the entire word correctly
            if(chosenKey.equals(hidden)){
                //System.out.println("Game over has been set to true");
                gameOver = true;
            } else {
                gameOver = false;
            }
        }

        // Display game outcome
        if(gameOver){
            String hidden1 = new String(asterix1);
            if(chosenKey.equals(hidden1)){
                if(missedChances == 0 ) {
                    System.out.println(" Your word is: "+chosenKey +" You missed "+missedChances+" time" );
                } else {
                    System.out.println(" Your word is: "+chosenKey +" You missed "+missedChances+" times" );
                }
                // Ask if the player wants to play again
                System.out.println(" Would you like to play again ?" );
                char choice = keyboard.next().charAt(0);
                if(choice == 'y'){
                    // Restart the game with a new word
                    hangmanGame(Wordtaker(wordlist)); 
                } else {
                    // End the game
                    System.out.println("Game shall be closed");   
                }
            }
        }
    }

    // Method to select a random word from the word list
    public static String Wordtaker(String[] wordlist){
        int randomKey =  (int) (Math.random() * wordlist.length);
        String chosenKey = wordlist[randomKey]; 
        return chosenKey;
    }

    // Method to create an array of asterisks representing hidden letters of the word
    public static char[] asterixMaker(int guessWord){
        char[] astrix = new char[guessWord];
        for (int i = 0; i< guessWord ; i++){
            astrix[i] = '*';
        }
        return astrix;
    }
}
