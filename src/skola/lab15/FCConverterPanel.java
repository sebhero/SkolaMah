package skola.lab15;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.MessageFormat;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFormattedTextField;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

public class FCConverterPanel extends JPanel implements ActionListener {

	private JLabel lblDegrees = new JLabel("Grader");
	private JLabel lblResult = new JLabel("Resultat> ");
	private JFormattedTextField tfDegrees = new JFormattedTextField();
	private JButton btnFToC = new JButton("Till Celsisus");
	private JButton btnCToF = new JButton("Till Fahrenheit");
	private JButton btnExit = new JButton("Avsluta");

	public FCConverterPanel() {
		setPreferredSize(new Dimension(260, 130));

		lblDegrees.setPreferredSize(new Dimension(60, 20));
		lblResult.setPreferredSize(new Dimension(246, 30));
		btnCToF.setPreferredSize(new Dimension(120, 30));
		btnCToF.setPreferredSize(new Dimension(120, 30));
		btnCToF.setPreferredSize(new Dimension(120, 30));
		btnExit.setPreferredSize(new Dimension(246, 30));
		tfDegrees.setPreferredSize(new Dimension(160, 20));

		btnCToF.addActionListener(this);
		btnCToF.addActionListener(this);
		btnCToF.addActionListener(this);

		add(lblDegrees);
		add(tfDegrees);
		add(lblResult);
		add(btnCToF);
		add(btnFToC);
		add(btnExit);

	}

	public static void main(String[] args) {
		FCConverterPanel panel = new FCConverterPanel();
		panel.setBorder(BorderFactory.createLineBorder(Color.BLACK));
		JOptionPane.showMessageDialog(null, panel);
	}

	@Override
	public void actionPerformed(ActionEvent e) {

		double deg, res;
		String txt;

		if (e.getSource() == btnCToF)
		{
			deg = Double.parseDouble(tfDegrees.getText());
			res = (deg - 32) / 1.8;
			txt = MessageFormat.format("Resultat: {0} F är {1} C", deg, res);
		}

	}
}
