/*
 * Author: Sebastian Börebäck
 * Copyright (c) 2015.
 */

package skola.lab16.upg16c;

import skola.lab16.ColorPanelView;

import javax.swing.*;
import java.awt.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by Sebastian Börebäck on 2015-10-19.
 */
public class Controller {

    private ColorPanelView colorPanelView;
    private ImageViewer imagePanelView;
    private Pattern pattern;

//    (			#Start of the group #1
//            [^\s]+			#  must contains one or more anything (except white space)
//    (		#    start of the group #2
//            \.		#	follow by a dot "."
//            (?i)		#	ignore the case sensitive checking for the following characters
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


    /**
     * Controller for the image imagePanelView
     * take a imageViewer to display images
     * @param imagePanelView a ImageViewer object for showing images.
     */
    public Controller(ImageViewer imagePanelView) {
        this.imagePanelView = imagePanelView;
        String IMAGE_PATTERN = "([^\\s]+(\\.(?i)(jpg|png|gif|bmp))$)";
        pattern = Pattern.compile(IMAGE_PATTERN);
    }

    /**
     * A controller for the a colorPanelView
     * @param colorPanelView a colorpanelView
     */
    public Controller(ColorPanelView colorPanelView) {

        this.colorPanelView = colorPanelView;

    }

    /**
     * Change the image in the imagePanelView
     * @param filepath the filepath for the new image
     */
    public void newImage(String filepath)
    {

        Matcher matcher = pattern.matcher(filepath);
        if(matcher.matches())
        {
            System.out.println("show image");
            this.imagePanelView.showImage(filepath);

        }
        else {
            JOptionPane.showMessageDialog(null, "Felaktig filtyp! maste vara jpg,png eller gif\n" +
                    "Du gav: "+filepath);
        }

    }

    /**
     * Remove the image from the imagePangelView
     */
    public void eraseImage()
    {
        this.imagePanelView.noImage();
    }

    /**
     * Handles the change of color in for the Color panel
     * @param newBackgroundColorForLabelView
     */
    public void setLabelPanelViewColor(Color newBackgroundColorForLabelView) {
        this.colorPanelView.setBackground(newBackgroundColorForLabelView);

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
