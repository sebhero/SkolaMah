/*
 * Author: Sebastian Börebäck
 * Copyright (c) 2015.
 */

package TileGame.utils;

import java.io.*;
import java.net.URI;
import java.net.URL;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

/**
 * Created by Sebastian Börebäck on 2015-11-06.
 */
public class Utils {

    public static String loadFileAsString(String path) {
        StringBuilder builder = new StringBuilder();

//        URL urlPath = this.getClass().getResource(path);
        URL relativePath = Utils.class.getResource(path);

//        FileInputStream fIn;
//        FileChannel fChan;
//        long fSize;
//        ByteBuffer mBuf;


        InputStream in = Utils.class.getResourceAsStream(path);
        try {

            BufferedReader br = new BufferedReader(new InputStreamReader(in));


            String line;
            while ((line = br.readLine()) != null) {
                builder.append(line+"\n");
            }

            br.close();

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        return builder.toString();
    }

    public static int parseInt(String number) {
        try {

            return Integer.parseInt(number);

        } catch (NumberFormatException e) {
            e.printStackTrace();
            return 0;
        }
    }
}
