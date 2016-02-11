package collections;

/**
 * Klassen Searching söker igenom listan efter ett specifikt element och returnerar dess
 * position om det poträffas, annars returneras -1.
 * @author Jelena
 *
 */
public class Searching {
	
	/**
	 * Söker igenom listan efter ett specifikt element som ska returneras om det påträffas.
	 * Sökningen sker binärt, dvs att så länge det finns flera element att söka igenom och elementet
	 * som man söker efter inte hittats så ska man gämföra det mittersta elementet och dividera med två 
	 * så småningom hitta det man sökte.
	 * @param list listan som ska sökas igenom
	 * @param element är det element som man ska söka efter
	 * @return res som är positionen där elementet hittades, eller -1 om det inte hittas
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
	 * Söker igenom listan efter ett element genom att gå igenom den i tur
	 * och ordning från första position.
	 * @param list är listan som ska sökas igenom
	 * @param element är det element som man söker efter
	 * @return i (positionen) där elementet hittades, eller -1 och elementet inte hittades
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
