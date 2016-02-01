/*
 * Author: Sebastian Börebäck
 * Copyright (c) 2016.
 */

package DA353A_programmering2_datastrukturer.labbar.lab7;
import DA353A_programmering2_datastrukturer.labbar.lab7.f7.ObjectNode;

public class ObjectListSize {
    private ObjectNode list = null;
    
    private ObjectNode locate(int index) {
    	ObjectNode node = list;
        for( int i = 0; i < index; i++)
            node = node.getNext();
        return node;
    }  
    
    public int size() {
        // Koplettera med kod
        int count = 0;
	    ObjectNode next = list;
	    while (next != null) {
		    next = next.getNext();
		    count++;
	    }
	    return count;
    }

    public Object get( int index ) {
        if( ( index < 0 ) || ( index >= size() ) )
            throw new IndexOutOfBoundsException( "size=" + size() + ", index=" + index );
        
        ObjectNode node = locate( index );
        return node.getData();
    }
    
    public void add( int index, int data ) {
//        if( ( index < 0 ) || ( index > size() ) )
//            throw new IndexOutOfBoundsException( "size=" + size() + ", index=" + index );
        
        if( index == 0 )
            list = new ObjectNode( data, list );
        else {
        	ObjectNode node = locate( index - 1 );
        	ObjectNode newNode = new ObjectNode( data, node.getNext() );
            node.setNext( newNode );
        }
    }
    
    public Object remove( int index ) {
        if( ( index < 0 ) || ( index >= size() ) )
            throw new IndexOutOfBoundsException( "size=" + size() + ", index=" + index );
        
        Object res;
        if( index == 0 ) {
            res = list.getData();
            list = list.getNext();
        } else {
        	ObjectNode node = locate( index - 1 );
            res = node.getNext().getData();
            node.setNext( node.getNext().getNext() );
        }
        return res;
    }
    
    public String toString() {
    	if( list != null )
    		return list.toString();
    	else
    		return "[]";
    }
    
    public static void main(String[] args) {
        ObjectListSize list = new ObjectListSize();
        for(int i=0; i<10; i++)
            list.add(i,i);
        System.out.println(list);
        System.out.println( "Size = " + list.size() );
    }
}
