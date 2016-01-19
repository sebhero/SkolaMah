/*
 * Author: Sebastian Börebäck
 * Copyright (c) 2015.
 */

package DA339A_programmering1.Patterns.skola.lab13;

public class Point {
    private int x;
    private int y;
    
    public Point(int x, int y) {
        this.x = x;
        this.y = y;
    }
    
    public Point( Point point ) {
        this.x = point.getX();
        this.y = point.getY();
    }
    
//    public Point copy() {
//        Point point = new Point( this.x, this.y);
//        return point;
//    }
    
    public void setPoint( Point point ) {
        this.x = point.getX();
        this.y = point.getY();
    }

    public void setX(int x) {
        this.x = x;
    }

    public void setY(int y) {
        this.y = y;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }
    
    public String toString() {
        return "(" + this.x + "," + this.y + ")";
    }
    
    public static void main(String[] args) {
        Point p1 = new Point( 10, 12 );
        Point p2 = new Point( 20, 15 );
        p1.setPoint( p2 );
        System.out.println( p1.toString() );
        System.out.println( p2.toString() );
    }

    public Point copy() {
        return new Point(this.x,this.y);
    }
}
