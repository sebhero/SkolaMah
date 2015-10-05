package skola.lab3.upg5d;

import java.text.MessageFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

/**
 * Created by sebadmin on 2015-09-14.
 */
public class Program5dExtra {

    private final LocalDateTime theDate;

    public Program5dExtra() {
        theDate = LocalDateTime.now();
    }


    public static void main(String[] args) {
        Program5dExtra prog = new Program5dExtra();

        prog.dateAndTime(DateTimeFormatter.ofPattern("HH:mm:ss"),"Dagens datum:");
        prog.dateAndTime(DateTimeFormatter.ofPattern("d/M-yyyy"),"Klockan är:");
        prog.dateAndTime(DateTimeFormatter.ofPattern("HH:mm:ss"),"Dagens datum:",DateTimeFormatter.ofPattern("d/M-yyyy"),"Klockan är:");
    }

    private void dateAndTime(DateTimeFormatter dateTimeFormatter, String headline) {
        String todayDate = theDate.format(dateTimeFormatter);

        String text = MessageFormat.format("{0} {1}",headline,todayDate);
        System.out.println(text);
        //JOptionPane.showMessageDialog(null, text);
    }
    private void dateAndTime(DateTimeFormatter dateTimeFormatter, String headline,DateTimeFormatter dateTimeFormatter2, String headline2) {
        String todayDate = theDate.format(dateTimeFormatter);
        String todayDate2 = theDate.format(dateTimeFormatter2);

        String text = MessageFormat.format("{0} {1}\n{2} {3}",headline,todayDate,headline2,todayDate2);
        System.out.println(text);
        //JOptionPane.showMessageDialog(null, text);
    }


}
