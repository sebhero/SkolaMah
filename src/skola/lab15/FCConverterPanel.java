package skola.lab15;

import java.awt.Color;
import java.awt.Dimension;

import java.text.MessageFormat;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFormattedTextField;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

public class FCConverterPanel extends JPanel {

	private final JLabel lblDegrees = new JLabel("Grader");
	private final JLabel lblResult = new JLabel("Resultat> ");
	private final JFormattedTextField tfDegrees = new JFormattedTextField();
	private final JButton btnFToC = new JButton("Till Celsisus");
	private final JButton btnCToF = new JButton("Till Fahrenheit");
	private final JButton btnExit = new JButton("Avsluta");

	public FCConverterPanel() {
		setPreferredSize(new Dimension(260, 130));

		lblDegrees.setPreferredSize(new Dimension(60, 20));
		lblResult.setPreferredSize(new Dimension(246, 30));
        btnFToC.setPreferredSize(new Dimension(120, 30));
		btnCToF.setPreferredSize(new Dimension(120, 30));
		btnExit.setPreferredSize(new Dimension(246, 30));
		tfDegrees.setPreferredSize(new Dimension(160, 20));

        btnFToC.addActionListener(ae -> {
                    System.out.println("Called btn FToC");
                    double deg, res;
                    String txt;

                    deg = Double.parseDouble(tfDegrees.getText());
                    res = (deg - 32) / 1.8;
                    txt = MessageFormat.format("Resultat: {0} F är {1} C", deg, res);
                    lblResult.setText( txt );
                }
        );

		btnCToF.addActionListener(ae -> {
            System.out.println("Called btn ctof");
            double deg, res;
            String txt;

            deg = Double.parseDouble(tfDegrees.getText());
            res = 32+1.8*deg;
            txt = MessageFormat.format("Resultat: {0} C är {1} F", deg, res );
            lblResult.setText( txt );
        });

        //exit the program
        btnExit.addActionListener(actionEvent-> System.exit(0));

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
}
