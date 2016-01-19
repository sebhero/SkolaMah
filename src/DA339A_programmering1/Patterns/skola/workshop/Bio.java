/*
 * Author: Sebastian Börebäck
 * Copyright (c) 2015.
 */

package DA339A_programmering1.Patterns.skola.workshop;

import java.util.Random;

/**
 * Created by seb on 2015-11-19.
 */
public class Bio {

    public static void main(String[] args) {


        Random rnd = new Random();

        int[][] bioArr = {{1,0,0,2,1,1,1},{1,0,0,0,1,1,1},{1,1,1,1,0,0,1},{1,1,1,1,1,1,1},{0,0,0,1,1,1,1},{1,1,0,0,1,1,1},{1,1,0,0,0,0,1}};


        for (int i = 0; i < bioArr.length; i++) {
            int[] col = bioArr[i];

            for (int row : col) {
                System.out.print(row+ " ");
            }
            System.out.print(" , row "+(i+1));
            System.out.println();
        }

        int antal = 3;
        int match = 0;
        int startRowPlats = 0;
        int startColPlats = 0;

        int empty = 0;

        for (int rowPlats = 0; rowPlats < bioArr.length; rowPlats++) {
            for (int colPlats = 0; colPlats < bioArr[rowPlats].length; colPlats++) {
                if(bioArr[rowPlats][colPlats] == 0)
                {
                    startRowPlats = rowPlats;
                    startColPlats = colPlats;
                    for (int i = 0; i < antal; i++) {
                        if ((colPlats + i) < bioArr[rowPlats].length) {
                            if (bioArr[rowPlats][colPlats + i] == 0) {
                                match++;
                                if (match == antal) {
                                    System.out.println("found platser from startpos");
                                    System.out.println("row " + (startRowPlats+1));
                                    System.out.println("col " + (startColPlats+1));
                                    match =0;
                                }
                            }
                        }
                    }
                    match =0;
                }
                //hittat ledig plats
//                if(bioArr[row][col] == 0){
//                    startCol = col;
//                    startRow = row;
//
//                    for (int i = row; i < antal; i++) {
//                      if(bioArr[col][row] == 0){
//                          match++;
//                      }
//                    }
//                    if (match == antal) {
//                        System.out.println("found platser "+match);
//                        System.out.println("col: "+startCol);
//                        System.out.println("row: "+startRow);
//                    }
//                    else
//                    {
//                        match = 0;
//                    }

//                }
            }
        }

    }
}
