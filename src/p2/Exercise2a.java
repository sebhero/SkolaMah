package p2;

import javax.swing.JOptionPane;

public class Exercise2a {
	public void demo() {
		Painting p1 = new Painting("Mona Lisa", "Leonardo da Vinci", 1507);
		Painting p2 = new Painting("Guernica", "Pablo Picasso", 1937);
		JOptionPane.showMessageDialog(null, p1.getTitle()
				+ " m�lad av den enast�ende konstn�ren " + p1.getPainter()
				+ ", f�rdigst�lld " + p1.getYear());
		JOptionPane.showMessageDialog(null, p2.toString());
	}

	public static void main(String[] args) {
		Exercise2a prog = new Exercise2a();
		prog.demo();

	}
}