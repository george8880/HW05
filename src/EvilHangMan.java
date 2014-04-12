import java.util.*;
import java.io.*;


public class EvilHangMan extends HangmanGame {
	private String[] wordlist = new String[235000];// to store the dictionary
	private int numWords = 0;// count the number of possible secret words.

	public EvilHangMan(int stringLength, int numGuesses) {
		super("", numGuesses, "");	
		secretWordLength = stringLength; //override from super constructor
		numLettersRemaining = stringLength;
		guessResult = false;
		
		Scanner scanner = null;
		try {
			scanner = new Scanner(new File("dictionary.txt"));// read the dictionary
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
		int i = 0;
		while (scanner.hasNext()) {
			String temp = scanner.nextLine().toUpperCase();
			if (temp.length() == secretWordLength) {
				wordlist[i] = temp;
				i++;
				numWords++;
			}
		}

		for (i = 0; i < secretWordLength; i++) {
			currentState += "_ ";
		}
		scanner.close();

	}

	@Override
	public boolean makeGuess(char ch) {

		System.out.println("makeGuess: " + ch + "; numWords=" + numWords);
		guessResult = false;
		letterGuess = ch;
		if (Character.isLetter(ch) && !alreadyGuessed(ch)) {
			// adjust the Wordlist in order to avoid the word with the letter
			// user guessed
			int tempWordNum = 0;
			for (int i = 0; i < numWords; i++) {
				for (int j = 0; j < secretWordLength; j++) {
					if (wordlist[i].charAt(j) == ch) {
						break;
					} else {
						if (j == secretWordLength - 1) {
							if (wordlist[i].charAt(j) != ch) {
								tempWordNum++;
							}
						}
					}
				}
			}
			// we choose the words that don't contain the letter the user
			// guessed, and they will be the new possible secret words.
			String[] temp = new String[tempWordNum];
			int tempIndex = 0;
			for (int i = 0; i < numWords; i++) {
				for (int j = 0; j < secretWordLength; j++) {
					if (wordlist[i].charAt(j) == ch) {
						break;
					} else {
						if (j == secretWordLength - 1) {
							if (wordlist[i].charAt(j) != ch) {
								temp[tempIndex] = wordlist[i];
								tempIndex++;
							}
						}
					}
				}
			}
			if (tempWordNum == 0) {
				System.out.println("tempWordNum is zero!");

				secretWord = wordlist[0];
				guessResult = true;
			} else {
				secretWord = temp[0];
				numWords = tempWordNum;
				wordlist = temp;
				guessesRemaining--;
				guessResult = false;
			}
			if (!guessResult) {
				letterGuessHistory = letterGuessHistory + letterGuess;
			}

		} else return false;
		
		return guessResult;
	}
}