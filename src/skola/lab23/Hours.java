package skola.lab23;

public class Hours extends WageEmployee {
    private double hourlyWage;
    private double hours;
    
    public Hours( long id, double hourlyWage ) {
        super( id );
        this.hourlyWage = hourlyWage;
    }
    
    public double getHours() {
        return this.hours;
    }
    
    public void setHours(double hours) {
        this.hours = hours;
    }
    
    public double getHourlyWage() {
        return this.hourlyWage;
    }
    
    public void setHourlyWage(double hourlyWage) {
        this.hourlyWage = hourlyWage;
    }
    
    public double wage() {
        return this.hours * this.hourlyWage;
    }   
}
