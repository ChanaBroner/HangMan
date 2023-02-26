/* Chana Broner ID: 212368435 */

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class HangManVocabulary 
{
	private ArrayList<String> arrVocabulary;

	public HangManVocabulary() throws IOException
	{
		arrVocabulary = new ArrayList<String>();
		openFile();
	}

	public void openFile() throws IOException
	{
		arrVocabulary = new ArrayList<String>();
		try 
		{
			Scanner s = new Scanner(new File("HangMan.txt"));
			while(s.hasNext())
				arrVocabulary.add(s.next());     
			s.close();
		} 

		catch (IOException e1) 
		{
			System.out.println("Error: Cannot open file.");
		}
	}

	public String chooseWordToGuess()
	{
		return arrVocabulary.get((int) (Math.random() * arrVocabulary.size()));
	}
}
