package oppgover;

public class Oppgove6_tabellerOgMetoder {

	public static void main(String[] args) {
		int[] tabell= {3,3,5,5,5};
		int[] tabel2= {4,4,1,1,1};

		System.out.print("a) ");   skrivUt(tabell);
		
		System.out.println("b) " + tilStreng(tabell));
		
		System.out.println("c) " + summer1(tabell));
		System.out.println("c) " + summer2(tabell));
		System.out.println("c) " + summer3(tabell));
		
		System.out.println("d) " + finnesTall(tabell, -1));
	
		System.out.println("e) " + posisjonTall(tabell, 5));
		
		System.out.println("f) " + tilStreng(reverser(tabell)));

		System.out.println("g) " + erSortert(tabell));

		System.out.println("h) " + tilStreng(settSammen(tabell, tabel2)));		
	}
	//a)
	public static void skrivUt (int[] tabell) {
		for (int i:tabell) {
			System.out.print(i + " ");
		}
		System.out.println();
	}
	//b)
	public static String tilStreng (int[] tabell) {
		String svarTekst="[";
		for (int i=0; i<tabell.length; i++) {
			if (i==tabell.length-1) {
				svarTekst+=(tabell[i] + "]");
			} else {
				svarTekst+=(tabell[i] + ", ");
			}
		}
		return svarTekst;
	}
	//c)
	public static int summer1 (int[] tabell) {
		int sum=0;
		for (int i: tabell) {
			sum+=i;
		}
		return sum;
	}
	public static int summer2 (int[] tabell) {
		int sum=0;
		for (int i=0; i<tabell.length; i++) {
			sum+=tabell[i];
		}
		return sum;
	}
	public static int summer3 (int[] tabell) {
		int sum=0;
		int i=0;
		while(i<tabell.length) {
			sum+=tabell[i];
			i++;
		}
		return sum;
	}
	//d)
	public static boolean finnesTall (int[] tabell, int tall) {
		for (int i: tabell) {
			if (i==tall) {
				return true;
			}
		}
		return false;
	}
	
	//e)
	public static int posisjonTall (int[] tabell, int tall) {
		for (int i=0; i<tabell.length; i++) {
			if (tabell[i]==tall) {
				return i;
			}
		}
	return -1;
	}
	
	//f)
	public static int[] reverser(int[] tabell) {
		int[] nyTabell= new int[tabell.length]; 
		for(int i=0; i<tabell.length; i++) {
			nyTabell[i]=tabell[tabell.length-i-1];
		}
		return nyTabell;
	}
	
	//g)
	public static boolean erSortert (int[] tabell) {
		int storsteTall=tabell[0];
		for (int i=1; i<tabell.length;i++) {
			if (storsteTall>tabell[i]) {
				return false;
			} else {
				storsteTall=tabell[i];
			}
		}
		return true;			
	}
	
	//h)
	public static int[] settSammen(int[] tabell1,int[] tabell2) {
		int nyTabell[]=new int[tabell1.length+tabell2.length];
		for (int i=0; i<tabell1.length; i++) {
			nyTabell[i]=tabell1[i];
		}
		for (int i=tabell1.length; i<(tabell2.length+tabell1.length); i++) {
			nyTabell[i]=tabell2[(i-tabell1.length)];
		}
		return nyTabell;
	}
}
