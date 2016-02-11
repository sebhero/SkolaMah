package collections;

import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 * Klassen ArrayList implementerar interfacet List och skapar en array d�r 
 * anv�ndaren kan �ndra storlek och element i listan och komma �t varje 
 * element med hj�lp av index f�r positionerna.
 * @author Jelena Novacic
 * @param <E>
 */

public class ArrayList<E> implements List<E> {
	private E[] elements;
	private int size;
	
	/**
	 * Skapar en array med dubbelt s� stor
	 * kapacitet som elements.
	 */
	private void grow() {
		E[] temp = (E[]) new Object[2*elements.length];
		for(int i = 0; i<elements.length; i++) {
			temp[i] = elements[i];
		}
		elements = temp;
	}
	
	/**
	 * Tom konstruktor som skapar en array med 20 element
	 */
	public ArrayList() {
		this(20);
	}
	
	/**
	 * Konstruktor som ser till att arrayen best�r av minst 1 element
	 * @param initialCapacity �r listans "startkapacitet" 
	 */
	public ArrayList(int initialCapacity) {
		initialCapacity = Math.max(1, initialCapacity);
		elements = (E[])new Object[initialCapacity];
	}

	/**
	 * Metoden l�gger till element i index (position).
	 * Om man f�rs�ker l�gga in ett element i en position som �r utanf�r
	 * listan s� f�r man ett felmeddelande.
	 * Om hela listan fyllts s� anropas grow-metoden f�r att dubbla storleken.
	 * @param index f�r positionen som ett angivet element ska placeras i
	 * @param element som ska placeras i listan
	 */
	public void add(int index, E element) {
		if(index<0 || index>size)
			throw new IndexOutOfBoundsException("add: index is invalid!");
		if(size==elements.length)
			grow();
		for(int i=size; i>index; i--) {
			elements[i]=elements[i-1];
		}
		elements[index] = element;
		size++;
	}

	/**
	 * L�gger till det angivna elementet i sista positionen i listan.
	 * @param element som ska placeras i listan
	 */
	public void add(E element) {
		add(size,element);
	}

	/**
	 * L�gger till angivet element i f�rsta positionen i listan
	 * @param element som placeras i f�rsta positionen i listan
	 */
	public void addFirst(E element) {
		add(0,element);
	}

	/**
	 * L�gger till angivet element i sista (f�rsta lediga) positionen i listan
	 * @param element som ska placeras sist i listan
	 */
	public void addLast(E element) {
		add(size,element);
	}

	/**
	 * Tar bort elementet i den angivna positionen i 
	 * listan och skiftar sedan alla element till h�ger 
	 * om den angivna positionen ett steg till v�nster 
	 * (f�r att fylla tomrummet).
	 * @param index f�r det element som ska tas bort
	 * @return elmnt som �r det element som tagits bort fr�n listan
	 */
	public E remove(int index) {
		
		if(index < 0 || index >= size) {
			throw new IndexOutOfBoundsException();
		}
		
		E elmnt = elements[index];
		for(int i = index; i<elements.length-1; i++) {
			elements[i] = elements[i+1];
		}
		
		elements[size-1] = null;
		size--;

		return elmnt;
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
		
		return remove(size-1);
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
	 * Returnerar elementet i den angivna positionen i listan. 
	 * @param index f�r elementet som ska returneras
	 * @return elementet i den angivna positionen
	 */
	public E get(int index) {
		if(index < 0 || index >= size) {
			throw new IndexOutOfBoundsException("get: index is invalid");
		}
		return elements[index];
	}

	/**
	 * Ers�tter elementet i den angivna positionen i listan med 
	 * det angivna elementet.
	 * @param index f�r elementet som ska ers�ttas
	 * @param element som ska placeras i den angivna positionen
	 * @return prevElement som �r det element som ersatts med det nya
	 */
	public E set(int index, E element) {
		if(index < 0 || index >= size) {
			throw new IndexOutOfBoundsException("set: index is invalid");
		}
		E prevElement = elements[index];
		elements[index] = element;
		return prevElement;
	}

	/**
	 * Returnerar indexet f�r f�rsta f�rekomsten av det angivna elementet 
	 * i listan, eller -1 om listan inte inneh�ller detta element.
	 * @param element som man ska s�ka igenom listan efter
	 * @return i som �r index f�r positionen i listan d�r det angivna elementet 
	 * p�tr�ffas f�rst i listan, eller -1 om listan inte inneh�ller detta element
	 */
	public int indexOf(E element) {
		for( int i = 0; i < size; i++) {
			if(element.equals(elements[i])) {
				return i;
			}
		}
		return -1;
	}

	/**
	 * Returnerar indexet f�r f�rsta f�rekomsten av det angivna elementet 
	 * i listan, eller -1 om listan inte inneh�ller detta element.
	 * S�kningen b�rjar vid startIndex.
	 * @param startIndex s�kningen startar i positionen startIndex i listan
	 * @param element element som ska s�kas efter
	 * @return i som index f�r positionen i listan d�r det angivna elementet 
	 * p�tr�ffas f�rst i listan, eller -1 om listan inte inneh�ller detta element
	 */
	public int indexOf(int startIndex, E element) {
		if(startIndex < 0 || startIndex >= size) {
			throw new IndexOutOfBoundsException("indexOf: index is invalid");
		}
		for(int i = startIndex; i < size; i++) {
			if(element.equals(elements[i])) {
				return i;
			}
		}
		return -1;
	}

	/**
	 * Returnerar antalet element som finns i listan.
	 * @return size som �r antalet element som finns i listan
	 */
	public int size() {
		return size;
	}
	
	/**
	 * Returnerar en str�ng som visar alla elementen i listan. 
	 * @return str�ngrepresentation av objektet
	 */
	public String toString() {
		StringBuilder res = new StringBuilder("[ ");
		for(int i=0; i<size; i++) {
			res.append(elements[i]);
			if(i<size-1)
				res.append("; ");
		}
		res.append(" ]");
		return res.toString();
	}

	/**
	 * Returnerar en iterator �ver  elementen i listan i r�tt ordning.
	 * @return en iterator �ver  elementen i listan i r�tt ordning
	 */
	public Iterator<E> iterator() {
		return new Iter();
	}

	/**
	 * Klass som implementerar Iterator
	 * @author Jelena Novacic
	 */
	private class Iter implements Iterator<E> {
		private int index=0;
		
		/**
		 * Returnerar true om iterationen har flera element. 
		 * @return true om iterationen har flera element.
		 */
		public boolean hasNext() {
			return index<size;
		}

		/**
		 * Returnerar n�sta element i iterationen.
		 * @return n�sta element i iterationen.
		 */
		public E next() {
			if(index==size)
				throw new NoSuchElementException();
			return elements[index++];
		}
		
		/**
		 * "Remove"-operationen st�ds ej.
		 */
		public void remove() {
			throw new UnsupportedOperationException();
		}
	}
	
	public static void main(String[] args) {
		ArrayList<Integer> list = new ArrayList<Integer>(10);
		
		for(int i=0; i<=100; i+=10) {
			list.add(i);
		}
		System.out.println(list);
		Iterator<Integer> numbers = list.iterator();
		while(numbers.hasNext())
			System.out.print(numbers.next()+ " ");
		System.out.println("");
//		list.add(1);
//		list.add(2);
//		list.add(3);
//		list.addFirst(5);
//		list.addLast(5);
//		list.remove(3);
//		list.removeFirst();
//		list.removeLast();
//		list.clear();
//		System.out.println(list.get(2));
//		list.set(4, 0);
//		list.add(9, 11111);
//		list.add(10, 2222);
		list.add(11, 0000);
		
		System.out.println(list);
	}

}
