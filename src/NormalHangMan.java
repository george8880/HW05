/**
 * <p>A class that keeps track of the current state of a game of hangman.</p>
 * <p> The class is constructed with a secret word and some number of guesses.</p>
 * <p>Every time a letter is guessed, the state of the game is updated appropriately
 * integrating the guessed letter into the word, updating the number of guesses
 * remaining, etc.</p>
 * 
 * <p>This class can then be used by a user interface to administer a regular game of Hangman.</p>
 */
import java.util.*;

public class NormalHangMan extends HangmanGame {

    /**
     * Constructor sets up the game to be played with a word and some number of
     * guesses.  The class should have private variables that keep track of:
     * <li>The original secret word
     * <li>The number of guesses remaining
     * <li>The number of letters that still need to be guessed
     * <li>The current state of word to be guessed (e.g. "L A B _ R A _ _ R Y")
     * @param secretWord the word that the player is trying to guess
     * @param numGuesses the number of guesses allowed
     */
    public NormalHangMan(String secretWord, int numGuesses, String letterHistory){
    	super(secretWord, numGuesses, letterHistory);
    	
        numLettersRemaining = secretWordLength;
        for(int i = 0; i < secretWordLength; i++)
        {
            currentState += "_ ";
            for(int j = i; j > 0; j--)
            {
                if(secretWord.charAt(i) == secretWord.charAt(j-1))
                {
                    numLettersRemaining--;//If the letter appears many times in the secret word, it will be counted just once.
                    break;
                }
            }
        }
    }   
    
    /**
     * Checks if the character has already been guessed. If not, add character to guess history and 
     * check if the character is in the secret word. If it is, update current state of guessing 
     * and decrease number of letters remaining. Otherwise, remove 1 from number of guesses remaining
     * 		@parameter: character guessed
     * 		@return: whether the character guessed is in the secret word
     * 		@modify: currentState      -- if character guessed IS in secret word
     * 			     history           -- character guessed added to history
     * 				 numLettersLeft    -- if character guessed IS in secret word
     * 				 guessesRemaining  -- if character guessed IS NOT in secret word				 
     */
    @Override
    public boolean makeGuess(char ch)
    {
    	if (Character.isLetter(ch) == false || alreadyGuessed(ch)) return false;
        
    	letterGuessHistory += ch;
    	
    	boolean letterIsInWord = updateState(ch);
    	
    	if (letterIsInWord)
    		numLettersRemaining--;
    	else
    		guessesRemaining--;
    	
    	return letterIsInWord;
    }
    
    /**
     * Updates current state of guessing if character is in secret word. Otherwise do nothing
     * 		@parameter: character guessed
     * 		@return: whether the character guessed is in the secret word
     * 		@modify: currentState -- if character guessed IS in the secret word
     */
    public boolean updateState(char ch) {
        for (int i = 0; i < secretWordLength; i++) {
            if (secretWord.charAt(i) == ch) {//if the user guess right, adjust the current state.
                String temp = "";
                for (int j = 0; j < secretWordLength; j++) {
                    if (secretWord.charAt(j) == ch)
                        temp = temp + ch + " ";
                    else
                        temp = temp + currentState.charAt(2*j) + currentState.charAt(2*j+1); 
                }
                
                currentState = temp;
                return true;
            }
        }
        
        return false;
    }
}
    
       