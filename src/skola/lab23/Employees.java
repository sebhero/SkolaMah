package skola.lab23;

public class Employees {
    public void program() {
        Commission cWage;
        WageEmployee[] employees = new WageEmployee[ 3 ];        //skapar en WageEmployee array med 3 platser
        employees[ 0 ] = new FullTime( 19938278, 21500 ); //sätter att plats 0 har id 19938278 och wage 21500
        employees[ 1 ] = new Commission( 19278865, 0.10 ); //sägger att plats 1 har id 19278865 och rate 0.10
        cWage = (Commission)employees[ 1 ]; // länkar ihop cWage med employee[1] som är den ny skapade Commission
        cWage.setSales( 208000 );//sätter att sales på commision i pos 1 är 208000
        employees[ 2 ] = new Hours( 17233534, 95.0 );//skapar en Hours po position 2
        (( Hours )employees[ 2 ]).setHours( 128 ); //get Hours hours 128
        for( int i = 0; i < employees.length; i++ ) {
            System.out.println( employees[ i ] ); //kallar po toString po varje objekt i arrayn
        }
    }
    public static void main( String[] args ) {
        Employees prog = new Employees();
        prog.program();
    }
}
