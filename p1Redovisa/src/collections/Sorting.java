package collections;

/**
 * Klassen Sorting sorterar en array med hj�lp av quicksort 
 * och en ArrayList med hj�lp av mergesort.
 * @author Jelena Novacic
 *
 */
public class Sorting {

	/**
	 * Sorterar den angivna arrayen med hj�lp av quick sort algoritmen
	 * @param array �r arrayen som ska sorteras
	 */
	public static void quicksort(double[]array) {
		sort(array, 0, array.length-1);
	}

	/**
	 * Metoden v�ljer det mittersta v�rdet i arrayen som pivotIndex och 
	 * sorterar v�rden runt om detta till h�ger eller v�nster beroende p�
	 * om det �r h�gre respektive l�gre �n pivotIndex.
	 * @param array �r den array som ska sorteras
	 * @param left �r minsta v�rdet
	 * @param right �r h�gsta v�rdet
	 */
	private static void sort(double[] array, int left, int right) {
		int pivotIndex;
		if(left < right) {
			pivotIndex = partition(array, left, right, (left+right)/2);
			sort(array, left, pivotIndex-1);
			sort(array, pivotIndex+1, right);	
		}
	}

	/**
	 * Metoden v�ljer det mittersta v�rdet i arrayen som pivotIndex och 
	 * sorterar v�rden runt om detta till h�ger eller v�nster beroende p�
	 * om det �r h�gre respektive l�gre �n pivotIndex.
	 * @param array �r den array som ska sorteras
	 * @param left �r minsta v�rdet
	 * @param right �r h�gsta v�rdet
	 */
	private static int partition(double[] array, int left, int right, int pivotIndex) {
		double pivotValue = array[pivotIndex];
		int storeIndex = left;
		swap(array, pivotIndex, right);
		for(int i=left; i<right; i++) {
			if(array[i] < pivotValue) {
				swap(array, i, storeIndex);
				storeIndex++;
			}
		}
		swap(array, storeIndex, right);
		return storeIndex;
	}


	/**
	 * Metoden byter plats p� element  i olika positioner, och anv�nder en
	 * tempor�r double temp f�r att spara element och inte skriva �ver det.
	 * @param array ska sorteras
	 * @param pos1 position 1 som ska byta element
	 * @param pos2 position 2 som ska byta element
	 */
	private static void swap(double[] array, int pos1, int pos2) {
		double temp = array[pos1];
		array[pos1] = array[pos2];
		array[pos2] = temp;
	}


	//	
	//	//Listan list ska sorteras med hj�lp av mergesort
	//	
	//			public static double[] randomArray(int n, double min, double max) {
	//				double[] array = new double[10];
	//				for ( int i = 0; i < array.length; i++) {
	//					array[i] = Math.random() * (max - min) + min;
	//					System.out.println(array[i]);
	//				}
	//				
	//				System.out.println(" ");
	//				return array;
	//			}

	/**
	 * Metoden ska sortera en ArrayList med hj�lp av mergemsort. 
	 * I denna metod skapas en tom array med samma storlek som den som ska sorteras.
	 * @list �r listan som ska sorteras
	 */
	public static void mergesort(ArrayList list ) {	
		Object[] temp = new Object[ list.size() ];		
		mergesort( list, 0, list.size(), temp );		
		temp = null;									
	}

	/**
	 * Metoden delar listan i 2 delar hela tiden tills listan delats upp i enstaka element.
	 * @param list ska sorteras
	 * @param first �r f�rsta v�rdet i vardera del
	 * @param n antal element i listan
	 * @param temp �r sparningslista
	 */
	private static void mergesort(ArrayList list , int first, int n, Object[] temp ) {
		int n1,n2;										
		if( n > 1 ) {									
			n1 = n / 2;									
			n2 = n - n1;								
			mergesort( list, first, n1, temp );		
			mergesort( list, first + n1, n2, temp );	
			merge( list, first, n1, n2, temp );		
		}
	}

	/**
	 * Metoden bygger ihop del f�r del genom att j�mf�ra v�rden stegvis
	 * genom varje del och p� s� s�tt sortera listan.
	 * @param list ska sorteras
	 * @param first �r f�rsta v�rdet i delen
	 * @param n1 �r det h�gra delen
	 * @param n2 �r den v�nstra delen
	 * @param temp �r sparningslista
	 */
	private static void merge(ArrayList list, int first, int n1, int n2, Object[] temp) {
		int cursor1 = 0;		
		int cursor2 = n1;		
		int counter = 0;		 
		int last = (n1 + n2);	
		int compare;			
		while( (cursor1 < n1) && (cursor2 < last) ) {					
			Comparable comp = (Comparable)list.get(first + cursor1);	
			compare = comp.compareTo(list.get(first + cursor2));		
			if( compare < 0 ) {					
				temp[ counter ] = list.get(first + cursor1);
				cursor1++;
			} else  {
				temp[ counter ] = list.get(first + cursor2);
				cursor2++;
			}
			// FIXME: 2016-02-11 THIS IS A MAJOR BUG. because you skip to do anything when its == 0
//			} else if ( compare > 0) {
//				temp[ counter ] = list.get(first + cursor2);
//				cursor2++;
//			}
			counter++;  
		}

		while( cursor1 < n1) {
			temp[ counter ] = list.get(first + cursor1);
			cursor1++;
			counter++;
		}

		while( cursor2 < last ) {
			temp[ counter ] = list.get(first + cursor2);
			cursor2++;
			counter++;
		}

		for(int i = 0; i < last; i++) {
			list.set((first + i), temp[i]);
		}
	}



	//		    public void testMergesort() {
	//		    	double[] array = randomArray(10, 0, 50);
	//		    	mergesort(array);
	//		    	for (int i=0; i<array.length; i++) {
	//		    		System.out.println(array[i]);
	//		    	}
	//		    }
	//
	//		    public void testquicksort() {
	//		    	double[] array = randomArray(10, 0, 50);
	//		    	quicksort(array);
	//		    	for (int i=0; i<array.length; i++) {
	//		    		System.out.println(array[i]);
	//		    	}
	//		    }

	public static void main(String[] args) {
		Sorting so = new Sorting();
		//				so.randomArray(10, 0, 50);
		//				so.testMergesort();
		//				so.testquicksort();



	}

}
