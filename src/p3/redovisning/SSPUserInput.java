package p3.redovisning;

import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JPanel;

public class SSPUserInput extends JPanel {

	// Private instance variables
	private SSPController controller;

	private JButton btnStone, btnSax, btnBag, btnNew_game, btnQuit;
	private JPanel mainPanel = new JPanel();
	private int sizeX = 200, sizeY = 100;

	private JPanel topPanel = new JPanel(new FlowLayout());

	public SSPUserInput(SSPController controller2) {
		this.controller = controller2;

		setPreferredSize(new Dimension(sizeX, sizeY));

		mainPanel.setLayout(new BoxLayout(mainPanel, BoxLayout.Y_AXIS));
		// Calling method in class to initiate the buttons
		initiateButtons();

		// Adding buttons to main panel
		topPanel.add(btnStone);
		topPanel.add(btnSax);
		topPanel.add(btnBag);

		// Adding panels to main panel
		mainPanel.add(topPanel);
		mainPanel.add(btnNew_game);
		mainPanel.add(btnQuit);

		// Adding listener to these buttons
		btnStone.addActionListener(new ButtonListener());
		btnSax.addActionListener(new ButtonListener());
		btnBag.addActionListener(new ButtonListener());
		btnNew_game.addActionListener(new ButtonListener());
		btnQuit.addActionListener(new ButtonListener());

		// Adding to the JFrame and making visible
		add(mainPanel);
		setVisible(true);

	}

	// Initiating the different button, creting the object and giving a String name.
	private void initiateButtons() {
		btnStone = new JButton("Sten");
		btnSax = new JButton("Sax");
		btnBag = new JButton("Påse");

		btnNew_game = new JButton("Nytt spel");
		btnNew_game.setSize(sizeX, sizeY / 3);

		btnQuit = new JButton("Avsluta");
		btnQuit.setSize(sizeX, sizeY / 3);

	}

	// ButtonListener: lyssnar ifall någon knapp trycks ned
	private class ButtonListener implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			// Sten
			if (btnStone == e.getSource()) {
				controller.humanChoice(0);
			}
			// Sax
			else if (btnSax == e.getSource()) {
				controller.humanChoice(1);
			}
			// Påse
			else if (btnBag == e.getSource()) {
				controller.humanChoice(2);
			}
			// Nytt spel
			else if (btnNew_game == e.getSource()) {
				controller.newGame();

			}
			// Avsluta spelet
			else if (btnQuit == e.getSource()) {
				System.exit(0);
			}
		}
	}

}
