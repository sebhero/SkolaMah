/*
 * Author: Sebastian Börebäck
 * Copyright (c) 2015.
 */

package DA339A_programmering1.Patterns.A_Test;

import java.io.*;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;
import java.util.zip.CheckedInputStream;

/**
 * Created by Sebastian Börebäck on 2015-12-05.
 */
public class ReadXMLTest {

    private static FileReader TheFR;
    private static CheckedInputStream is;
    private static BufferedOutputStream os;

    public static void main(String[] args) throws IOException {

//        URL file = ReadXMLTest.class.getClassLoader().getResource("DA339A_programmering1.Patterns.A_Test/products.xml");
        ClassLoader loader = ReadXMLTest.class.getClassLoader();
        File file = new File(loader.getResource("DA339A_programmering1/Patterns/A_Test/products.xml").getFile());

        RandomAccessFile aFile = null;
        try {
            aFile = new RandomAccessFile(loader.getResource("DA339A_programmering1/Patterns/A_Test/products.xml").getFile(), "r");
        } catch (FileNotFoundException e) {

            FileChannel inChannel = aFile.getChannel();

            ByteBuffer buffer = ByteBuffer.allocate(1024);

            int bytesRead = inChannel.read(buffer);

            buffer.flip();

            while (buffer.hasRemaining()) {
                buffer.get();
            }

            buffer.clear();
            bytesRead = inChannel.read(buffer);

            aFile.close();
        }

//
//        try {
//            try (BufferedReader br = new BufferedReader(new FileReader(file))) {
//                String line;
//                for (int i = 0; i < 1; i++) {
//                    line = br.readLine();
//                    System.out.println(line);
//                }
////                while ((line = br.readLine()) != null) {
////                    // process the line.
////                    System.out.println(line);
////                }
//            }
//        } catch (IOException e) {
//            e.printStackTrace();
//        }

    }

}
