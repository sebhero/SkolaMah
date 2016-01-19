package DA339A_programmering1.Patterns.skola.lab11b;
/*
 * Author: Sebastian Börebäck
 * Copyright (c) 2015.
 */



/**
 * Created by sebadmin on 2015-10-05.
 */
public class KitchenTableTest {
    public static void main(String[] args) {

        KitchenTable kt = new KitchenTable("wood", 3, 5, 2);
        System.out.println(kt.toString());

        System.out.println("the size: " + kt.size());

        System.out.println("change the size");
        kt.setWidth(8);
        System.out.println("the NEW size: " + kt.size());

    }
}