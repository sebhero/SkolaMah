package DA339A_programmering1.Patterns.skola.lab15;

import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class CalcPanel extends JPanel implements ActionListener {

	private final Font fontLabels = new Font("SansSerif", Font.PLAIN, 18);
	private final Font fontButtons = new Font("SansSerif", Font.PLAIN, 24);
	private final JLabel lblNbr1 = new JLabel("Tal 1");
	private final JTextField tfNbr1 = new JTextField();
	private final JLabel lblNbr2 = new JLabel("Tal 2");
	private final JTextField tfNbr2 = new JTextField();

	private final JButton btnAdd = new JButton("+");
	private final JButton btnSub = new JButton("-");

	private final JLabel lblResult = new JLabel("Resultat");

	public CalcPanel() {
		// set window dimensions for panel
		setPreferredSize(new Dimension(250, 105));

		// add input txtbox 1
		lblNbr1.setPreferredSize(new Dimension(100, 20));
		lblNbr1.setFont(fontLabels);
		add(lblNbr1);
		tfNbr1.setPreferredSize(new Dimension(100, 20));
		add(tfNbr1);

		// add input txtbox 2
		lblNbr2.setPreferredSize(new Dimension(100, 20));
		lblNbr2.setFont(fontLabels);
		add(lblNbr2);
		tfNbr2.setPreferredSize(new Dimension(100, 20));
		add(tfNbr2);

		// add button
		btnAdd.setPreferredSize(new Dimension(100, 20));
		btnAdd.setFont(fontButtons);
		add(btnAdd);

		// minus button
		btnSub.setPreferredSize(new Dimension(100, 20));
		btnSub.setFont(fontButtons);
		add(btnSub);

		// label for result
		lblResult.setPreferredSize(new Dimension(200, 20));
		lblResult.setFont(fontLabels);
		add(lblResult);

		btnAdd.addActionListener(this);
		btnSub.addActionListener(this);

	}

	public void actionPerformed(ActionEvent e) {
		double nbr1, nbr2;
		String nbr1Str, nbr2Str, res;
		nbr1Str = tfNbr1.getText();
		nbr2Str = tfNbr2.getText();
		nbr1 = Double.parseDouble(nbr1Str);
		nbr2 = Double.parseDouble(nbr2Str);
		if (e.getSource() == btnAdd) {
			res = nbr1Str + " + " + nbr2Str + " = " + (nbr1 + nbr2);
			lblResult.setText(res);
		}
		else if (e.getSource() == btnSub) {

			res = nbr1Str + " - " + nbr2Str + " = " + (nbr1 - nbr2);
			lblResult.setText(res);
		}

	}
}
