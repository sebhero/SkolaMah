package DA339A_programmering1.Patterns.p5;

public interface Dice {
    /*
     * Kastar tärningen en gång och returnerar resultatet.
     * @returns Antalet prickar som tärningen visar vid kastet
     **/
    public int throwDice();
    
    /*
     * Returnerar antalet sidor som tärningen har
     * @returns Antalet sidor på tärningen
     **/
    public int getSides();
}
