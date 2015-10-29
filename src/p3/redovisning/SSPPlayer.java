package p3.redovisning;

import java.util.Random;

public class SSPPlayer {

	// The computer gets a choice between 0 and 2 that is random and
	// corresponds to Sten, Sax or Påse
	// Returns int
	public int newChoice() {
		Random rand = new Random();
		int choice = rand.nextInt(3);
		return choice;
	}

}
