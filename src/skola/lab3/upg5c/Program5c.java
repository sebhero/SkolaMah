package skola.lab3.upg5c;

import java.text.MessageFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

/**
 * Created by sebadmin on 2015-09-14.
 */
public class Program5c {

    private final LocalDateTime theDate;

    public Program5c() {
        theDate = LocalDateTime.now();
    }

    public void date() {


        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("d/M-yyyy");
        String todayDate = theDate.format(formatter);

        String text = MessageFormat.format("Dagens datum: {0}", todayDate);
        System.out.println(text);
        //JOptionPane.showMessageDialog(null, text);


    }
    public static void main(String[] args) {
        Program5c prog = new Program5c();
        prog.date();
        prog.time();
    }

    private void time() {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("HH:mm:ss");
        String todayTime = theDate.format(formatter);

        String text = MessageFormat.format("Klockan är: {0}", todayTime);
        System.out.println(text);
        //JOptionPane.showMessageDialog(null, text);

    }
}
