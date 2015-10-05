/*
 * EmployeeTest.java
 * Den 5/10 - 2015
 */
package laboration11;

public class EmployeeTest {
    public static void main( String[] args ) {
        Employee emp = new Employee( "Ergil Tuveberg", "Renlighet AB", 27000 );
        
        System.out.println( "Namn: " + emp.getName() );
        System.out.println( "Arbetar hos: " + emp.getEmployer() );
        System.out.println( "Lön: " + emp.getWage() );
        System.out.println( emp.toString() );
    }
}
