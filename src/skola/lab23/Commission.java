package skola.lab23;

public class Commission extends WageEmployee {
    private double rate;
    private double sales;
    
    public Commission( long id, double rate ) {
        super( id );
        this.rate = rate;
    }
    
    public double getSales() {
        return this.sales;
    }
    
    public void setSales(double sales) {
        this.sales = sales;
    }
    
    public double getRate() {
        return this.rate;
    }
    
    public void setRate(double rate) {
        this.rate = rate;
    }
    
    public double wage() {
        return this.sales * this.rate;
    }
}
