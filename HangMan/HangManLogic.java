/* Chana Broner */

import java.io.IOException;

public class HangManLogic 
{
	private HangManVocabulary arrVocabulary;
	private String wordToGuess, bottomLine;

	public HangManLogic() throws IOException 
	{
		arrVocabulary = new HangManVocabulary();
		wordToGuess = arrVocabulary.chooseWordToGuess();
		bottomLine = new String(new char[wordToGuess.length()]).replace("\0", "_");
	}

	public void restart()
	{
		wordToGuess = arrVocabulary.chooseWordToGuess();
		bottomLine = new String(new char[wordToGuess.length()]).replace("\0", "_");
	}

	public String getWordToGuess()
	{
		return wordToGuess;
	}

	public String getBottomLine()
	{
		return bottomLine;
	}

	public String checkGuess(char ch)
	{
		String newBottomLine = "";

		for(int i = 0; i < wordToGuess.length(); i++)
		{
			if(ch == wordToGuess.charAt(i))
				newBottomLine += ch;
			else
				newBottomLine += bottomLine.charAt(i);
		}

		if(newBottomLine.equals(wordToGuess))
		{
			return "Won";	
		}
		else
		{
			if (bottomLine.equals(newBottomLine)) 
			{
				return "No change";
			}
			else 
			{
				bottomLine = newBottomLine;
				return "Change";
			}
		}
	}
}
