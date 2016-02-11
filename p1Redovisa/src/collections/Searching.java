package collections;

/**
 * Klassen Searching s�ker igenom listan efter ett specifikt element och returnerar dess
 * position om det potr�ffas, annars returneras -1.
 * @author Jelena
 *
 */
public class Searching {
	
	/**
	 * S�ker igenom listan efter ett specifikt element som ska returneras om det p�tr�ffas.
	 * S�kningen sker bin�rt, dvs att s� l�nge det finns flera element att s�ka igenom och elementet
	 * som man s�ker efter inte hittats s� ska man g�mf�ra det mittersta elementet och dividera med tv� 
	 * s� sm�ningom hitta det man s�kte.
	 * @param list listan som ska s�kas igenom
	 * @param element �r det element som man ska s�ka efter
	 * @return res som �r positionen d�r elementet hittades, eller -1 om det inte hittas
	 */
	public static int binearSearch(ArrayList list, Object element){
		
		int res = -1, compare, min = 0, max = list.size() - 1, pos;
		Comparable comp = (Comparable)element;
		while((min <= max) && (res == -1)) {
			pos = (min+max)/2;
			compare = comp.compareTo(list.get(pos));
			if(compare == 0) {
				res = pos;
			}
			else if(compare < 0) {
				max = pos -1;
			}
			else {
				min = pos +1;
			}
		}
		return res;
	}
		
	
	/**
	 * S�ker igenom listan efter ett element genom att g� igenom den i tur
	 * och ordning fr�n f�rsta position.
	 * @param list �r listan som ska s�kas igenom
	 * @param element �r det element som man s�ker efter
	 * @return i (positionen) d�r elementet hittades, eller -1 och elementet inte hittades
	 * i listan
	 */
	public static int linearSearch(List list, Object element) {
		
		for(int i = 0; i<list.size(); i++) {
			if(element.equals(list.get(i))) {
				return i;
			}
		}
		return -1;
	}
	
	
	public static void main(String[] args) {
		
		ArrayList<Integer> list = new ArrayList<Integer>(10);
		for(int i=0; i<10; i+=2) {
			list.add(i);
		}
		System.out.println(list);
		
		Searching srch = new Searching();
		
		
		
	}

}
