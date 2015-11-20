package skola.lab23;

public abstract class WageEmployee implements Comparable {
    private long id;
    
    public WageEmployee( long id ) {
        this.id = id;
    }
    
    public long getId() {
        return this.id;
    }
    
    public String toString() {
        return "Id: " + this.id + ", lön denna månad: " + wage() + " kr";
    }
    
    public abstract double wage(); 

    public int compareTo( Object obj ) {
        WageEmployee employed;
        employed = ( WageEmployee )obj;
        double wage1 = this.wage();
        double wage2 = employed.wage();
        if( wage1 < wage2 ) {
            return -1;
        } else if( wage1 > wage2 ) {
            return 1;
        } else {
            return 0;
        }
    }
}
