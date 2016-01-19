package DA339A_programmering1.Patterns.skola.lab3.upg5b;

import java.text.MessageFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

/**
 * Created by sebadmin on 2015-09-14.
 */
public class Program5b {

    public void date() {


        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("d/M-yyyy");
        String todayDate = LocalDateTime.now().format(formatter);

        String text = MessageFormat.format("Dagens datum: {0}", todayDate);
        System.out.println(text);
        //JOptionPane.showMessageDialog(null, text);


    }
    public static void main(String[] args) {
        Program5b prog = new Program5b();
        prog.date();
    }
}
