package collections;

/**
 * KLassen ListNode<E> �r en klass som stegar igenom de olika noderna
 * f�r att kunna flytta vidare de olika elementen.
 * @author Jelena Novacic
 * @param <E>
 */
public class ListNode<E> {
    private E data;
    private ListNode<E> next;
    
    /**
     * Konstruktor som placerar angivet data (element) i angiven next (position)
     * @param data som ska placeras i listan
     * @param next positionen dit data ska flyttas
     */
    public ListNode( E data, ListNode<E> next ) {
        this.data = data;
        this.next = next;
    }
    
    /**
     * Returnerar det data som ska in i listan
     * @return data som ska in i listan
     */
    public E getData() {
        return this.data;
    }
    
    /**
     * S�tter in det data som ska in i listan
     * @param data som ska in i listan
     */
    public void setData( E data ) {
        this.data = data;
    }
    
    /**
     * H�mtar n�sta data och returnarar det
     * @return n�sta data
     */
    public ListNode<E> getNext() {
        return this.next;
    }
    
    /**
     * S�tter in data i n�sta nod
     * @param next s�tter in data i n�sta nod
     */
    public void setNext( ListNode<E> next ) {
        this.next = next;
    }
    
    /**
     * Returnerar en str�ng som visar alla elementen i listan. 
	 * @return str�ngrepresentation av objektet
     */
    public String toString() {
    	StringBuilder str = new StringBuilder("[ ");
    	str.append(data.toString());
    	ListNode<E> node = next;
        while( node!=null ) {
        	str.append( "; ");
            str.append( node.getData().toString() );
            node = node.getNext();
        }
        str.append( " ]");
        return str.toString();
    }
}