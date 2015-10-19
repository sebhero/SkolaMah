/*
 * Author: Sebastian Börebäck
 * Copyright (c) 2015.
 */

package skola.lab16.upg16c;

import javax.swing.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by sebadmin on 2015-10-19.
 */
public class Controller {

    private ImageViewer viewer;
    private Pattern pattern;
    private Matcher matcher;

//    (			#Start of the group #1
//            [^\s]+			#  must contains one or more anything (except white space)
//    (		#    start of the group #2
//            \.		#	follow by a dot "."
//            (?i)		#	ignore the case sensive checking for the following characters
//            (		#	  start of the group #3
//                    jpg	#	    contains characters "jpg"
//                    |		#	    ..or
//                    png	#	    contains characters "png"
//                    |		#	    ..or
//                    gif	#	    contains characters "gif"
//                    |		#	    ..or
//                    bmp	#	    contains characters "bmp"
//            )		#	  end of the group #3
//            )		#     end of the group #2
//    $			#  end of the string
//    )			#end of the group #1


    private static String IMAGE_PATTERN = "([^\\s]+(\\.(?i)(jpg|png|gif|bmp))$)";

    public Controller(ImageViewer viewer) {
        this.viewer = viewer;
        pattern = Pattern.compile(IMAGE_PATTERN);
    }

    public void newImage(String imagePath)
    {

        matcher = pattern.matcher(imagePath);
        if(matcher.matches())
        {
            System.out.println("show image");
            this.viewer.showImage(imagePath);

        }
        else {
            JOptionPane.showMessageDialog(null, "Felaktig filtyp! maste vara jpg,png eller gif\n" +
                    "Du gav: "+imagePath);
        }

    }


    public void eraseImage()
    {
        this.viewer.noImage();
    }

    public static void main(String[] args) {
        ImageViewer viewer = new ImageViewer();
        Controller cont = new Controller( viewer );
        cont.newImage( "/skola/lab16/filmlogga.jpg" );
        JOptionPane.showMessageDialog( null, viewer );
// cont.newImage( "M:/bilder/karta.bmp" ); // ej tillåten filtyp
//  cont.eraseImage();
    }
}
