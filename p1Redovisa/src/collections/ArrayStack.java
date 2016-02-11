package collections;
import java.util.EmptyStackException;

/**
 * Klassen ArrayStack<T> lagrar element i stacken (ist�llet f�r i lista). 
 * @author Jelena Novacic
 * @param <T>
 */
public class ArrayStack<T> implements Stack<T> {
    private T[] elements;
    private int size=0;
    
    /**
     * Konstruktor som skapar en tom arraystack med en angiven kapacitet
     * @param capacity kapaciteten f�r stacken
     */
    public ArrayStack(int capacity) {
        elements = (T[])(new Object[capacity]);
    }
   
    /**
     * Placerar ett element i stacken
     * @param element elementet som l�ggs p� stacken
     */
    public void push(T element) {
    	if(size>=elements.length)
    		throw new IllegalArgumentException();
        elements[ size ] = element;
        size++;
    }
    
    /**
     * Elementet som senast placerades i stacken tas bort fr�n stacken och returneras. 
     * @return elem elementet som senast placerades i stacken
     */
    public T pop() {
        if(isEmpty()) {
            throw new EmptyStackException();
        }
        T elem = elements[--size];
        elements[size] = null;
        return elem;
    }

    /**
     * Returnerar elementet som senast placerades i stacken men det tas inte bort fr�n stacken.
     * @return elementet som senast placerades i stacken
     */
    public T peek() {
        if(isEmpty()) {
            throw new EmptyStackException();
        }
        return elements[size-1];
    }

    /**
     * Returnerar true om stacken inte inneh�ller n�gra element, eller false om det finns element i stacken.
     * @return true om stacken inte inneh�ller n�gra element, eller false om det finns element i stacken
     */
    public boolean isEmpty() {
        return (size==0);
    }

    /**
     * Returnerar antalet element som finns i stacken.
     * @return antalet element som finns i stacken
     */
    public int size() {
        return size;
    }

    public static void main(String[] args) {
        ArrayStack<Integer> stack = new ArrayStack<Integer>(20);
        Integer elem;
        for(int i=0; i<10; i++) {
            stack.push(new Integer(i));
        }
//        stack.push("HEJ"); // kompileringsfel
        while(!stack.isEmpty()) {
            elem = stack.pop();
            System.out.print(elem + " ");
        }
//        stack.toString();
    }
}
