public class HangmanGame
{

	protected String secretWord = ""; //To store the secret word
	protected int secretWordLength; // the length of the secret string
	protected int guessesRemaining; //to store the number of guess for the user
	protected int numLettersRemaining; //to store the number of the letters in the secret word has not been guessed correctly
	protected char[] currentState; //store the current guessing situation
	protected String letterGuessHistory = ""; //store the letter user has tried
	protected char letterGuess; //the letter the user guess right now
	protected boolean guessResult;
	
	
	public HangmanGame(String secretWord, int stringLength, int numGuesses, String letterHistory) {
		this.secretWord = secretWord;
		secretWordLength = stringLength;
		guessesRemaining = numGuesses;
		letterGuessHistory = letterHistory;
		numLettersRemaining = stringLength;
		
		currentState = new char[stringLength];
		for (int i = 0; i < secretWordLength; i++)
			currentState[i] = '_';
	}
	
    /**
     * @return the original secret word.
     */
    public String getSecretWord() {
    	return secretWord;
    }
    
    /**
     * Simulates the player guessing a letter in the word and updates the state of game
     * accordingly -- number of guesses remaining, number of letters 
     * if the guessed letter is not in the word, and hasn't been guessed yet, numGuesses is decremented
     * if the guessed letter is in the word, and hasn't been guessed yet, then update the current state of
     * the guessed word to reveal the position(s) of the letter(s) that was just guessed, and update numLettersRemaining.
     * There should be no guess penalty for guessing a letter that has already been 
     * guessed, just return false.  
     * @param ch the char that is the next letter to be guessed on the word
     * @return true if the game isn't over and the guessed letter was in the word, false otherwise
     */
    public boolean makeGuess(char ch) { return false; }
     
    
    /**
     * @return true if there are no more letters to be guessed and there is still at least one guess remaining
     */
    public boolean isWin() {
    	return (guessesRemaining == 0) ? false : true;
    }
    
    /** 
     * @return true if either num guesses remaining is 0 or num letters remaining to be guessed is 0.
     */
    public boolean gameOver() {
    	return (guessesRemaining == 0 || numLettersRemaining == 0) ? true : false;
    }
    
    /**
     * @return the number of guesses the player has left
     */
    public int numGuessesRemaining() {
    	return guessesRemaining;
    }
    
    /**
     * The number of letters remaining to be guessed in the secret word - i.e.
     * the number of blank spaces the player sees, which may be different from
     * the actually number of letters it will take to fill those blanks.
     * @return the number of letters in the secret word that still have to be guessed
     */
    public int numLettersRemaining() {
    	return numLettersRemaining;
    }
    
    /**
     * Gives a display-ready String-ified version of the current state of the secret word, showing letters
     * that have been guessed and blank spaces for letters that still need to be guessed.
     * For example if the secrect word is "LABORATORY" and the player has guessed L, A, B, R, and Y
     * the method might return something like "L A B _ R A _ _ R Y"
     * @return a String of the current state of the secret word.
     */
    public String displayGameState() {
    	String result = "";
    	
    	for (char c : currentState)
    		result += c + " ";
    	
    	return result;
    }
    
    /**
     * A String representing the letters guessed so far in the order they were guessed.
     * Duplicates should not be added.
     * @return a String showing which letters have already been guessed.
     */
    public String lettersGuessed() {
    	return letterGuessHistory;
    }
    
    /**
     * Checks if character has already been guessed
     * @param c: character guessed
     * @return if character has already been guessed
     */
    public boolean alreadyGuessed(char c)
    {
    	for (int i = 0; i < letterGuessHistory.length(); i++) {
    		if (letterGuessHistory.charAt(i) == c) return true;
    	}
    	return false;
    }
}
