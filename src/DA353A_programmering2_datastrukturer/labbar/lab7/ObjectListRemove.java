/*
 * Author: Sebastian Börebäck
 * Copyright (c) 2016.
 */

package DA353A_programmering2_datastrukturer.labbar.lab7;
import DA353A_programmering2_datastrukturer.labbar.lab7.f7.ObjectNode;

public class ObjectListRemove {
    private ObjectNode list = null;
    
    private ObjectNode locate(int index) {
    	ObjectNode node = list;
        for( int i = 0; i < index; i++)
            node = node.getNext();
        return node;
    }  
    
    public int size() {
        int n = 0;
        ObjectNode node = list;
        while( node != null ) {
            node = node.getNext();
            n++;
        }
        return n;
    }

    public Object get( int index ) {
        if( ( index < 0 ) || ( index >= size() ) )
            throw new IndexOutOfBoundsException( "size=" + size() + ", index=" + index );
        
        ObjectNode node = locate( index );
        return node.getData();
    }
    
    public void add( int index, int data ) {
        if( ( index < 0 ) || ( index > size() ) )
            throw new IndexOutOfBoundsException( "size=" + size() + ", index=" + index );
        
        if( index == 0 )
            list = new ObjectNode( data, list );
        else {
        	ObjectNode node = locate( index - 1 );
        	ObjectNode newNode = new ObjectNode( data, node.getNext() );
            node.setNext( newNode );
        }
    }
    
    // Metod att ändra och komplettera
    public Object remove( int index ) {
	    if( ( index < 0 ) || ( index >= size() ) )
		    throw new IndexOutOfBoundsException( "size=" + size() + ", index=" + index );


	    ObjectNode temp;
	    Object res;
	    if (index == 0) {
		    res = list.getData();
		    temp = list;
		    list = list.getNext();
		    temp = null;
		    return res;
	    } else {
		    ObjectNode last = locate(index-1);
		    ObjectNode current = last.getNext();
		    ObjectNode next = current.getNext();
		    last.setNext(next);
		    res = current.getData();
		    current = null;
		    return res;
	    }
    }
    
    public String toString() {
    	if( list != null )
    		return list.toString();
    	else
    		return "[]";
    }

    public static void main(String[] args) {
        ObjectListRemove list = new ObjectListRemove();
        for( int i = 0; i < 10; i++)
            list.add(i,i);
        System.out.println(list);
        
        for( int i = 4; i >= 0; i-- )
            System.out.println( list.remove( i ) );
        System.out.println(list);
    }
}
