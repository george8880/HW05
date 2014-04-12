import java.util.*;
import java.io.*;


public class EvilHangMan extends HangmanGame {
	private ArrayList<String> wordlist = new ArrayList<String>();// to store the dictionary

	public EvilHangMan(int stringLength, int numGuesses) {
		super("", stringLength, numGuesses, "");	
		
		Scanner scanner = null;
		try {
			scanner = new Scanner(new File("dictionary.txt"));// read the dictionary
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
		while (scanner.hasNext()) {
			String temp = scanner.nextLine().toUpperCase();
			if (temp.length() == secretWordLength)
				wordlist.add(temp);
		}
	
		scanner.close();

	}

	@Override
	public boolean makeGuess(char ch) {

		System.out.println("makeGuess: " + ch + "; numWords=" + wordlist.size());
		guessResult = false;
		letterGuess = ch;
		if (Character.isLetter(ch) && !alreadyGuessed(ch)) {
			//stores deleted words in case no more possible words
			ArrayList<String> deleted = new ArrayList<String>(); 
			
			for (int i = 0; i < wordlist.size(); i++)
				for (int j = 0; j < secretWordLength; j++) {
					String word = wordlist.get(i);
					if (word.charAt(j) == ch) {
						deleted.add(word);
						wordlist.remove(i);
						i--; //explore index again because of remove
						break;
					}
				}

			if (wordlist.size() == 0) {
				System.out.println("wordlist size is zero!");

				//doesn't matter for normal program run. Only for test case
				if (deleted.size() != 0) secretWord = deleted.get(0);
				
				guessResult = true;
			} else {
				secretWord = wordlist.get(0);
				guessesRemaining--;
				guessResult = false;
			}
			
			if (!guessResult)
				letterGuessHistory = letterGuessHistory + letterGuess;


		} else return false;
		
		return guessResult;
	}
}