package DA339A_programmering1.Patterns.skola.lab24;
import java.util.Random;
import javax.swing.JOptionPane;

public class EstimateTime {
    public void action() {
        Stopwatch watch = new Stopwatch();
        Random rand = new Random();
        long estimation, rndTime = rand.nextInt(4) + 2;
        String txt = "Du ska uppskatta "+rndTime+" sekunder.\n\n"+
                "Tryck på OK för att starta tidtagningen.", res;
        
        JOptionPane.showMessageDialog( null, txt );
        watch.start();
        JOptionPane.showMessageDialog( null, "Tryck på OK för att stoppa tidtagningen" );
        watch.stop();
        
        estimation = watch.getMilliSeconds();
        res = "Uppskattning: " + estimation + "\nFel: " + (estimation - rndTime*1000) + " ms";
        JOptionPane.showMessageDialog( null, res );
    }
    
    public static void main(String[] args) {
        EstimateTime prog = new EstimateTime();
        prog.action();
    }
}
