/*
 * Author: Sebastian Börebäck
 * Copyright (c) 2015.
 */

package skola.lab20.upg1a;

/**
 * Created by Sebastian Börebäck on 2015-11-10.
 */
public class upg1 {

    public static void main(String[] args) {
        Book book = new Book();
        book.setTitle("En fantastisk varld");
        book.setId(1337);
        book.setAuthor("Alice green");

        String res = book.getTitle() +" av "+book.getAuthor()+ "\n" +
                "ToString-metod: " + "\n"+
                book.toString();
        System.out.println(res);

        //new media
        System.out.println();
        System.out.println("New Media");
        Media media = new Media(1337, "En fantastisk varld");
        res = media.getTitle() + " är ett '" + media.getClass().getName() +
                "'-objekt" + "\n" + "toString-metoden: " + media.toString();

        System.out.println(res);
        System.out.println();

        System.out.println("New Book");
        Book book2 = new Book(1337, "En fantastisk varld","Alice Green");
        res = book2.getTitle() + " av " + book2.getAuthor() + "\n" +
                "toString-metoden: " + book2.toString();

        System.out.println(res);
        System.out.println();

    }

}
