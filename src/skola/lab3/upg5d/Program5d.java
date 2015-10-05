package skola.lab3.upg5d;

import java.text.MessageFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

/**
 * Created by sebadmin on 2015-09-14.
 */
public class Program5d {

    private final LocalDateTime theDate;

    public Program5d() {
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
        Program5d prog = new Program5d();
        prog.date();
        prog.time();
        prog.dateAndTime();
    }

    private void dateAndTime() {
        DateTimeFormatter timeFormat = DateTimeFormatter.ofPattern("HH:mm:ss");
        DateTimeFormatter dateFormat = DateTimeFormatter.ofPattern("d/M-yyyy");
        String todayDate = theDate.format(dateFormat);
        String todayTime = theDate.format(timeFormat);

        String text = MessageFormat.format("Dagens datum: {0}\n" +
                "Klockan är: {1}", todayDate,todayTime);
        System.out.println(text);
        //JOptionPane.showMessageDialog(null, text);
    }

    private void time() {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("HH:mm:ss");
        String todayTime = theDate.format(formatter);

        String text = MessageFormat.format("Klockan är: {0}", todayTime);
        System.out.println(text);
        //JOptionPane.showMessageDialog(null, text);

    }
}
