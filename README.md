**Hangman Game
This repository contains the implementation of a game of Hangman, 
a guessing game where one player selects a secret word and the other tries to guess the word by suggesting letters. 
For each incorrect guess, a part of a hangman is drawn. 
The game ends when the player guesses the word, or the hangman is completed. 
This implementation of the game uses JavaFX, a popular Java library for building graphical user interfaces.

Requirements
Java Development Kit (JDK) 8 or higher.
JavaFX 8 or higher.
Files
This repository contains three files:

HangMan.java: This file launches the JavaFX application and sets up the main window of the game. 
It loads the HangMan.fxml file using a FXMLLoader and displays it in the Stage.
HangManController.java: This file contains the game logic for the Hangman game. 
It initializes the HangManLogic class, which contains the underlying data and game mechanics. It also handles user input and updates the graphics of the game using the javafx.scene library.
HangManLogic.java: This file contains the core logic for the Hangman game. 
It reads a dictionary file containing a list of possible words and selects a word at random. It keeps track of the letters that have been guessed, the state of the hangman, and the current state of the guessed word.
Usage
When the game is launched, the player is presented with a blank word with dashes indicating the number of letters in the word, 
and a text field where they can enter a letter to guess. 
The player can enter one letter at a time and the game will respond by updating the word if the letter is correct or by drawing the next part of the hangman 
if the letter is incorrect. The game ends when the player correctly guesses the word, or the hangman is completed.
