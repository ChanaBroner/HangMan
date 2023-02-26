/* Chana Broner */

import javafx.fxml.FXML;
import java.util.ArrayList;
import java.io.IOException;
import javafx.scene.shape.Line;
import javafx.scene.shape.Shape;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;
import javafx.scene.shape.Ellipse;
import javafx.scene.control.Button;

public class HangManController 
{

	@FXML
	private Line WrongGuess1, WrongGuess2, WrongGuess3, WrongGuess4;

	@FXML
	private Line WrongGuess6, WrongGuess7, WrongGuess8, WrongGuess9, WrongGuess10;

	@FXML
	private Ellipse WrongGuess5;

	@FXML
	private Label labelWord, labelChars, message;

	@FXML
	private GridPane grid;

	@FXML
	private Button end, playAgain;

	final int ROWS = 7, COLS = 4;
	HangManLogic hangMan;
	private Button[][] letterSelection;
	private ArrayList<Shape> hangManArray;
	private String charUsed;
	private int numGuess;

	public void initialize() throws IOException 
	{
		hangMan = new HangManLogic();
		numGuess = 0;
		labelWord.setText(hangMan.getBottomLine());
		charUsed = "Characters you used:\n";
		labelChars.setText(charUsed);

		hangManArray = new ArrayList<Shape>();
		hangManArray.add(WrongGuess1);
		hangManArray.add(WrongGuess2);
		hangManArray.add(WrongGuess3);
		hangManArray.add(WrongGuess4);
		hangManArray.add(WrongGuess5);
		hangManArray.add(WrongGuess6);
		hangManArray.add(WrongGuess7);
		hangManArray.add(WrongGuess8);
		hangManArray.add(WrongGuess9);
		hangManArray.add(WrongGuess10);

		letterSelection = new Button[ROWS][COLS];
		char ch = 'a';
		for(int i = 0; i < ROWS && ch <= 'z'; i++)
		{
			for(int j = 0; j < COLS && ch <= 'z'; j++)
			{
				letterSelection[i][j] = new Button(""+(ch));
				ch++;
				letterSelection[i][j].setPrefSize(grid.getPrefWidth() / COLS, grid.getPrefHeight() / ROWS);
				letterSelection[i][j].setOnAction(new EventHandler<ActionEvent>()
				{
					public void handle(ActionEvent event) 
					{
						handleButton(event);
					}
				});

				grid.add(letterSelection[i][j], j, i);
			}
		}
	}

	private void handleButton(ActionEvent event)
	{
		Button button = ((Button)event.getSource());
		char ch = button.getText().charAt(0);
		button.setDisable(true);
		String feedback = hangMan.checkGuess(ch);
		hangmanDraw(feedback, ch);
	}

	private void hangmanDraw(String feedback, char ch)
	{
		if (numGuess < hangManArray.size()) 
		{
			charUsed += ch + " ";
			labelChars.setText(charUsed);
			if(feedback.equals("Won"))
			{
				labelWord.setText(hangMan.getWordToGuess());
				playAgain(true);	
			}
			else
			{
				if (feedback.equals("No change")) 
				{
					hangManArray.get(numGuess).setVisible(true);
					numGuess++;
				}
				labelWord.setText(hangMan.getBottomLine());
			}
		}
		else
		{
			playAgain(false);
		}

	}

	private void playAgain(boolean found)
	{
		message.setVisible(true);
		end.setVisible(true);
		playAgain.setVisible(true);
		char ch = 'a';
		for(int i = 0; i < ROWS && ch <= 'z'; i++)
		{
			for(int j = 0; j < COLS && ch <= 'z'; j++)
			{
				letterSelection[i][j].setVisible(false);
				ch++;
			}
		}
		labelChars.setVisible(false);
		labelWord.setVisible(false);
		for (int i = 0; i < 10; i ++)
			hangManArray.get(i).setVisible(false);
		if(found)
			message.setText("You guessed right ! \nDo you want to play again ?");
		else
			message.setText("Game over :(\nDo you want to play again ?");
	}

	@FXML
	void newGame(ActionEvent event) 
	{
		if(event.getSource().equals(end))
		{
			end.setVisible(false);
			playAgain.setVisible(false);
			message.setText("Thanks for playing :)");
			/* Another option: exit(); */
		}
		else
		{
			message.setVisible(false);
			end.setVisible(false);
			playAgain.setVisible(false);

			char ch = 'a';
			for(int i = 0; i < ROWS && ch <= 'z'; i++)
			{
				for(int j = 0; j < COLS && ch <= 'z'; j++)
				{
					letterSelection[i][j].setVisible(true);
					letterSelection[i][j].setDisable(false);
					ch++;
				}
			}

			numGuess = 0;
			hangMan.restart();
			labelWord.setVisible(true);
			labelWord.setText(hangMan.getBottomLine());
			charUsed = "chars you use: ";
			labelChars.setVisible(true);
			labelChars.setText(charUsed);
		}
	}
}