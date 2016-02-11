package collections;

/**
 * KLassen ListNode<E> är en klass som stegar igenom de olika noderna
 * för att kunna flytta vidare de olika elementen.
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
     * Sätter in det data som ska in i listan
     * @param data som ska in i listan
     */
    public void setData( E data ) {
        this.data = data;
    }
    
    /**
     * Hämtar nästa data och returnarar det
     * @return nästa data
     */
    public ListNode<E> getNext() {
        return this.next;
    }
    
    /**
     * Sätter in data i nästa nod
     * @param next sätter in data i nästa nod
     */
    public void setNext( ListNode<E> next ) {
        this.next = next;
    }
    
    /**
     * Returnerar en sträng som visar alla elementen i listan. 
	 * @return strängrepresentation av objektet
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