package p5;
import javax.swing.*;

public class TestSimpleDice {
    public static void printResult( int[] result ) {
        for( int i = 0; i < result.length; i++ ) {
            TextWindow.println(String.format( "%-4s%10d", (i + 1), result[ i ] ));
        }
    }
    
    public static void main(String[] args) {
        Dice dice;
        int sides, aThrow;
        int[] result;
        sides = Integer.parseInt( JOptionPane.showInputDialog( "Hur många sidor ska tärningen ha? (-10 för avbrott)" ) );
        while( sides!=-10 ) {
            try {
                dice = new SimpleDice( sides );
                // Skapa en array f�r att r�kna antalet 1:or, 2:or osv som t�rningen visar vid kasten nedan
                result = new int[ sides ];
                TextWindow.println( "----- 100000 kast med " + dice.getSides() + "-sidig tärning ----- " );
                // Loop som upprepas 100000 ggr. Vid varje upprepning kastas t�rningen och r�knaren f�r antalet
                // prickar vid kastet r�knas upp. result[ 0 ] �r r�knare f�r antalet 1:or, result[ 1 ] �r r�knare
                // f�r antalet 2:or osv.
                for( int i = 0; i < 100000; i++ ) {
                    // Kasta t�rningen
                    aThrow = dice.throwDice();
                    // �ka r�knare f�r antalet prickar i kastet.
                    result[ aThrow - 1 ]++;
                }
                // Utskrift av antalet 1:r, 2:or osv
                TestSimpleDice.printResult( result );
            } catch( NegativeSidesException e1 ) {
                TextWindow.println( e1 );
            } catch( ArrayIndexOutOfBoundsException e2) {
                int res = Integer.parseInt( e2.getMessage() ) + 1;
                TextWindow.println( "Felaktigt resultat vid tärningskast: " + res );
            }          
            sides = Integer.parseInt( JOptionPane.showInputDialog( "Hur många sidor ska tärningen ha? (-10 för avbrott)" ) );
        }
    }
}
