package collections;

import java.util.Iterator;
import java.util.NoSuchElementException;
//import laboration7.ObjectNode;

/**
 * 
 * Klassen LinkedList<E> representerar en dynamisk lista med n�dv�ndiga metoder 
 * som get, set, size och indexOf.
 * 
 * @author Jelena Novacic
 * @param <E>
 */
public class LinkedList<E> implements List<E>, Iterable<E> {
    private ListNode<E> list = null;
    
    /**
     * Returnerar en ListNode<E> i positionen som anges av index.
     * @param index f�r nod
     * @return ListNode<E>
     */
    private ListNode<E> locate(int index) {
        ListNode<E> node = list;
        for( int i = 0; i < index; i++)
            node = node.getNext();
        return node;
    }

    /**
	 * Returnerar antalet element som finns i listan.
	 * @return n som �r antalet element som finns i listan
	 */
    public int size() {
        int n = 0;
        ListNode<E> node = list;
        while( node != null ) {
            node = node.getNext();
            n++;
        }
        return n;
    }
    
    /**
     * Returnerar elementet i den angivna positionen i listan. 
	 * @param index f�r elementet som ska returneras
	 * @return elementet i den angivna positionen
     */
    public E get( int index ) {
        if( ( index < 0 ) || ( index >= size() ) ) {
            throw new IndexOutOfBoundsException( "size=" + size() + ", index=" + index );
        }
        ListNode<E> node = locate( index );
        return node.getData();
    }
    
    /**
     * * Ers�tter elementet i den angivna positionen i listan med 
	 * det angivna elementet.
	 * @param index f�r elementet som ska ers�ttas
	 * @param element som ska placeras i den angivna positionen
	 * @return res som �r det element som ersatts med det nya
     */
    public E set( int index, E data ) { 
    	if( ( index < 0 ) || ( index >= size() ) ) {
            throw new IndexOutOfBoundsException( "size=" + size() + ", index=" + index );
        }
    	ListNode<E> node = locate(index);
    	E res = node.getData();
    	node.setData(data);
    	return res;
    }
    
    /**
     * L�gger till det angivna elementet i sista positionen i listan.
	 * @param data som ska placeras i listan
     */
	public void add(E data) {
		add(size(), data);
	}

	/**
	 * L�gger till angivet element i f�rsta positionen i listan
	 * @param data som placeras i f�rsta positionen i listan
	 */
    public void addFirst( E data ) {
    	add(0, data);
    }
    
    /**
     * L�gger till angivet element i sista (f�rsta lediga) positionen i listan
	 * @param data som ska placeras sist i listan
     */
    public void addLast( E data ) {
    	add(size(), data);
    }
    
    /**
     * Metoden l�gger till element i index (position).
	 * Om man f�rs�ker l�gga in ett element i en position som �r utanf�r
	 * listan s� f�r man ett felmeddelande.
	 * Om hela listan fyllts s� anropas grow-metoden f�r att dubbla storleken.
	 * @param index f�r positionen som ett angivet element ska placeras i
	 * @param data som ska placeras i listan
     */
    public void add( int index, E data ) {
    	   if( ( index < 0 ) || ( index > size() ) )
               throw new IndexOutOfBoundsException( "size=" + size() + ", index=" + index );
           
           if( index == 0 )
           	list = new ListNode<E>( data, list );
           else {
               ListNode<E> node = locate( index - 1 );
               ListNode<E> newNode = new ListNode<E>( data, node.getNext() );
               node.setNext( newNode );
           }
    }
    
    /**
     * Tar bort och returnerar det f�rsta elementet fr�n listan.
	 * @return elementet som togs bort fr�n f�rsta positionen i listan returneras
     */
    public E removeFirst() {
    	return remove(0);
    }
    
    /**
     * Tar bort och returnerar det sista elementet fr�n listan.
	 * @return elementet som togs bort fr�n sista positionen i listan returneras
     */
    public E removeLast() {
    	return remove(size()-1);
    }
    
    /**
     * Tar bort elementet i den angivna positionen i 
	 * listan och skiftar sedan alla element till h�ger 
	 * om den angivna positionen ett steg till v�nster 
	 * (f�r att fylla tomrummet).
	 * @param index f�r det element som ska tas bort
	 * @return res som �r det element som tagits bort fr�n listan
     */
    public E remove( int index ) {
        if( ( index < 0 ) || ( index >= size() ) )
            throw new IndexOutOfBoundsException( "size=" + size() + ", index=" + index );
        
        E res;
        if( index == 0 ) {
            res = list.getData();
            list = setNull(list);
//            list = list.getNext();
        } else {
            ListNode<E> node = locate( index - 1 );
            res = node.getNext().getData();
            node.setNext(setNull(node.getNext()));
//            node.setNext( node.getNext().getNext() );
        }
        return res;
    }
    
    /**
     * Metoden s�tter metoderna i klassen ListNode till null, och f�r att ta bort 
     * den f�rsta positionen i listan s� returneras elementet fr�n f�rsta positionen
     * @param toNull
     * @return elementet i f�rsta positionen
     */
    private ListNode<E> setNull(ListNode<E> toNull) {
    	ListNode<E> res = toNull.getNext();
    	toNull.setData(null);
    	toNull.setNext(null);
    	return res;
    }

    /**
     * Tar bort alla element fr�n listan. 
     */
	public void clear() {
		int time = size();
		for(int i = 0; i<time; i++) {
			removeLast();
		}
	}
	
	/**
	 * Returnerar indexet f�r f�rsta f�rekomsten av det angivna elementet 
	 * i listan, eller -1 om listan inte inneh�ller detta element.
	 * @param data som man ska s�ka igenom listan efter
	 * @return index f�r positionen i listan d�r det angivna elementet 
	 * p�tr�ffas f�rst i listan, eller -1 om listan inte inneh�ller detta element
	 */
	public int indexOf(E data) {
		
		ListNode<E> theNode = list;
		int index = 0;
		while( theNode != null) {
			if(theNode.getData().equals(data)) {
				return index;
			}
			theNode = theNode.getNext();
			index++;
		}
		return -1;
	}

	/**
	 * Returnerar indexet f�r f�rsta f�rekomsten av det angivna elementet 
	 * i listan, eller -1 om listan inte inneh�ller detta element.
	 * S�kningen b�rjar vid startIndex.
	 * @param startIndex s�kningen startar i positionen startIndex i listan
	 * @param element element som ska s�kas efter
	 * @return index f�r positionen i listan d�r det angivna elementet 
	 * p�tr�ffas f�rst i listan, eller -1 om listan inte inneh�ller detta element
	 */
	public int indexOf(int startIndex, E data) {
		ListNode<E> theNode = locate(startIndex);
		int index = startIndex;
		while( theNode != null) {
			if(theNode.getData().equals(data)) {
				return index;
			}
			theNode = theNode.getNext();
			index++;
		}
		return -1;
	}

	/**
	 * Returnerar en iterator �ver  elementen i listan i r�tt ordning.
	 * @return en iterator �ver  elementen i listan i r�tt ordning
	 */
	public Iterator<E> iterator() {
		return new Iter();
	}    
    
	/**
	 * Returnerar en str�ng som visar alla elementen i listan. 
	 * @return str�ngrepresentation av objektet
	 */
    public String toString() {
    	if( list != null )
    		return list.toString();
    	else
    		return "[]";
    }
    
    /**
     * Klass som implementerar Iterator
     * @author Jelena
     */
    private class Iter implements Iterator<E> {
    	
    	ListNode<E> iterList = list;
    	
    	/**
    	 * Returnerar true om iterationen har flera element. 
		 * @return true om iterationen har flera element.
    	 */
    	public boolean hasNext() {
    		if(iterList != null) {
    			return true;
    		}
    		return false;
    	}
    	
    	/**
    	 * Returnerar n�sta element i iterationen.
		 * @return n�sta element i iterationen.
    	 */
    	public E next() {
    		ListNode<E> temp = iterList;
    		iterList = temp.getNext();
    		return temp.getData();
    	}
    	
    	/**
    	 * "Remove"-operationen st�ds ej.
    	 */
		public void remove() {
			throw new UnsupportedOperationException();
		}
    }
    
    public static void main(String[] args) {
		LinkedList<Integer> test = new LinkedList<Integer>();
		test.add(0, 1);
		test.add(0,2);
		test.add(2, 8);
		test.addFirst(11);
		test.addLast(22);
//		test.remove(1);
//		test.removeFirst();
//		test.removeLast();
//		test.clear();
		System.out.println(test);
		System.out.println(test.get(1));
		test.set(0, 99999);
		System.out.println(test);

	}
}
