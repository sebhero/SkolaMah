package skola.lab23;

public class FullTime extends WageEmployee {
    private double wage;
    
    public FullTime( long id, double lön ) {
        super( id ); // Anropa konstruktorn WageEmployee( long )
        this.wage = lön;
    }
    
    public double getWage() {
        return this.wage;
    }

    public void setWage(double wage) {
        this.wage = wage;
    }
    
    public double wage() {
        return this.wage;
    }
}
