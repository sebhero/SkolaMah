package DA339A_programmering1.Patterns.p3.redovisning;

import java.awt.Dimension;
import java.awt.GridLayout;

import javax.swing.BoxLayout;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class SSPViewer extends JPanel {

	// Private instance variables
	private JLabel title, human, computer, human_score, computer_score, humanChoice, computerChoice;

	private JPanel mainPanel = new JPanel();
	private JPanel pnlHuman = new JPanel(new GridLayout(3, 1));
	private JPanel pnlComputer = new JPanel(new GridLayout(3, 1));
	private JPanel pnlHumanAndComputer = new JPanel();
	private JPanel dummyPanel = new JPanel();

	private int sizeX = 250, sizeY = 150;

	public SSPViewer() {
		mainPanel.setLayout(new BoxLayout(mainPanel, BoxLayout.Y_AXIS));
		mainPanel.setPreferredSize(new Dimension(sizeX, sizeY));

		// Method call to initiate the labels
		initiateGame();

		mainPanel.add(title);

		// Adding the labels that have to do with the human player to pnlHuman
		pnlHuman.add(human);
		pnlHuman.add(human_score);
		pnlHuman.add(humanChoice);

		// Adding the labels that have to do with the computer player to
		// pnlHuman
		pnlComputer.add(computer);
		pnlComputer.add(computer_score);
		pnlComputer.add(computerChoice);

		// Adding the panels to container panel for human and computer
		pnlHumanAndComputer.add(pnlHuman);
		// Dummy panel to make some space between
		dummyPanel.setPreferredSize(new Dimension(100, 50));
		pnlHumanAndComputer.add(dummyPanel);

		pnlHumanAndComputer.add(pnlComputer);

		mainPanel.add(title);
		mainPanel.add(pnlHumanAndComputer);

		add(mainPanel);
		setVisible(true);
	}

	// Instansiates the JLabels
	private void initiateGame() {
		title = new JLabel("Först till 3 vinner!");
		human = new JLabel("Human");
		computer = new JLabel("Computer");
		human_score = new JLabel("0");
		computer_score = new JLabel("0");
		humanChoice = new JLabel("");
		computerChoice = new JLabel("");
	}

	// Updates the choice labels of the players in this window
	public void updateChoice(String computerChoice, String humanChoice) {
		this.humanChoice.setText(humanChoice);
		this.computerChoice.setText(computerChoice);
	}

	// Updates the score of the game
	public void updateScores(int humanScore, int computerScore) {
		human_score.setText(Integer.toString(humanScore));
		computer_score.setText(Integer.toString(computerScore));
	}

	// Visar vem som vann
	public void Winner(String winner) {
		title.setText(winner);
	}

	// Resets the labels to a new game state
	public void reset() {
		title.setText("Först till 3 vinner!");
		human_score.setText("0");
		computer_score.setText("0");
		humanChoice.setText("");
		computerChoice.setText("");
	}

}