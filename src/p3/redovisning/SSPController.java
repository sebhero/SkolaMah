package p3.redovisning;

public class SSPController {

	private SSPViewer viewer;
	private SSPPlayer computerPlayer;

	private int humanScore, computerScore;
	private boolean gameOver = false;

	public SSPController(SSPPlayer player, SSPViewer viewer) {
		this.computerPlayer = player;
		this.viewer = viewer;

		humanScore = computerScore = 0;
	}

	// Checks if the game has ended and declares the winner is it has
	public void checkGameState() {
		String winner = "Först till 3 vinner!";
		if (humanScore == 3) {
			winner = "Du har vunnit!";
			gameOver = true;
		} else if (computerScore == 3) {
			winner = "Du har förlorat.";
			gameOver = true;
		}
		viewer.Winner(winner);

	}

	public void humanChoice(int humanChoice) {
		if (!gameOver) {
			int computerChoice = computerPlayer.newChoice();
			// Check if it is a draw
			if (humanChoice == computerChoice) {
				// Nothing happens if both players choose the same
			}
			// Checking in a private method if who is the winner of the round
			else {
				boolean humanWins = isHumanVictorious(humanChoice, computerChoice);
				boolean computerWins = false;
				// if human has not won; updateing coputer or human scoring
				if (!humanWins) {
					computerWins = true;
					computerScore++;
				} else
					humanScore++;
				// Calls viewer object method to graphically update the scoring
				viewer.updateScores(humanScore, computerScore);
			}
			// Updates the choice of the players by using the object class for viewer
			viewer.updateChoice(getChoice(computerChoice), getChoice(humanChoice));
			checkGameState();
		}
	}

	// Checks if human player has won returns BOOLEAN
	private boolean isHumanVictorious(int humanChoice, int computerChoice) {
		if ((humanChoice == 0 && computerChoice == 1) || (humanChoice == 1 && computerChoice == 2)
				|| (humanChoice == 2 && computerChoice == 0))
			return true;
		else
			return false;
	}

	// Starts a new game instance
	public void newGame() {
		gameOver = false;
		viewer.reset();
		humanScore = computerScore = 0;
	}

	// GET: returns the corresponding choice as a word as a STRING; Sten, Sax or Påse
	public String getChoice(int choice) {
		String str = "";
		if (choice == 0)
			str = "Sten";
		else if (choice == 1)
			str = "Sax";
		else
			str = "Påse";
		return str;
	}

}