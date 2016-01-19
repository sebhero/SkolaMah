package DA339A_programmering1.Patterns.p5;

public class TestProbabilityDice {

    public static void main(String[] args) {
        Dice dice1 = null;
	    Dice dice2 = null;
	    Dice dice3= null;
        try {
            dice1 = new ProbabilityDice(new int[]{20,10,10,10,10,40});
            dice2 = new ProbabilityDice(new int[]{0,25,0,25,0,25,0,25,0});
	        dice3 = new ProbabilityDice(new int[]{40,30,20,10});
        } catch (BadProbabilityException e) {
            e.printStackTrace();
        }


        TextWindow.println("{20,10,10,10,10,40}");
        TestDice.test(dice1,10);
        TextWindow.println();
        TextWindow.println("{0,25,0,25,0,25,0,25,0}");
        TestDice.test(dice2,1000000);
        TextWindow.println();
        TextWindow.println("{40,30,20,10}");
        TestDice.test(dice3,1000000);
        TextWindow.println();
        try {

           dice1 = new ProbabilityDice(new int[] {0,20,30,10});
        } catch(Exception e) {
        	TextWindow.println(e);
        }
        try {
            dice1 = new ProbabilityDice(new int[] {});
        } catch(Exception e) {
        	TextWindow.println(e);
        }
    }
}
