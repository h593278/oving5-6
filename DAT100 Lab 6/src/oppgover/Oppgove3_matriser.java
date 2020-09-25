package oppgover;

import java.util.Arrays;

public class Oppgove3_matriser {

	public static void main(String[] args) {
		int[][] matrise1= {
				{1,2,3,4},
				{2,4,1,4},
				{3,1,4,4}
		};
		int[][] matrise2= {
				{1,2,1},
				{2,4,5},
				{3,1,2},
				{3,1,2}

		};
		int[][] matrise3= {
				{0,0,1,1,1,1,0,0},
				{0,1,0,0,0,0,1,0},
				{0,1,0,0,0,0,1,0},
				{0,0,1,1,1,1,0,0},
				{0,1,0,0,0,0,1,0},
				{0,1,0,0,0,0,1,0},
				{0,1,0,0,0,0,1,0},
				{0,0,1,1,1,1,0,0}
		};
		
		System.out.println("a) ");	skrivUtv1(matrise1);
		
		System.out.println("b) " + tilStreng(matrise1));
		
		System.out.println("c) ");	skrivUtv1(skaler(4, matrise1));
		
		System.out.println("d) " + erLik(matrise1, matrise2));
		
		System.out.println("e) ");	skrivUtv1(speile(matrise3));

		System.out.println("f) ");	skrivUtv1(multipliser(matrise1, matrise2));

	}
	//a)
	public static void skrivUtv1(int[][] matrise) {
		for(int[] i:matrise) {
			for(int j:i) {
				System.out.print(j+" ");
			}
			System.out.println();
		}
	}
	
	//b)
	public static String tilStreng(int[][] matrise) {
		String tekst="";
		for(int[] i:matrise) {
			for(int j:i) {
				tekst+=(j+" ");
			}
			tekst+="\\n";
		}
		return tekst;
	}
	
	//c) 
	public static int[][] skaler(int tall, int[][] matrise) {
		int[][] nyMatrise=new int[matrise.length][matrise[0].length];
		
		/*for (int i=0;i<matrise.length; i++) {
			nyMatrise[i]=Arrays.copyOf(matrise[i], matrise[i].length);		//joksa lit her
		}*/
		
		for(int i=0; i<matrise.length; i++) {
			for(int j=0; j<matrise[i].length; j++) {
				nyMatrise[i][j]=matrise[i][j]*tall;
			}
		}
		return nyMatrise;
	}

	//d)
	public static boolean erLik(int[][] mat1, int[][] mat2) {
		for(int i=0; i<mat1.length; i++) {
			if (mat1[i].length!=mat2[i].length) {
				return false;
			} else {
				for(int j=0; j<mat1[i].length; j++) {
					if (mat1[i][j]!=mat2[i][j]) {
						return false;
					}
				}
			}
		}
		return true;
	}
	
	//e)
	public static int[][] speile(int [][] matrise) {
		int[][] speilaMat=new int[matrise.length][matrise[0].length];
		for (int i=0; i<matrise.length; i++) {
			for (int j=0;j<matrise[i].length;j++) {
				speilaMat[j][i]=matrise[i][j];
			}
		}
		return speilaMat;
	}
	
	//f) 1 	
	/*public static int[][] multipliser(int[][] a, int[][] b) {
		int[][] error= {{0,1,1,0,0,1,0,1}, {0,1,1,1,0,0,1,0}, {0,1,1,1,0,0,1,0}, {0,1,1,0,1,1,1,1}, {0,1,1,1,0,0,1,0}};	
		int[][] multiMatrise=new int[a.length][a[0].length];
		
		for (int i=0;i<a.length; i++) {
			multiMatrise[i]=Arrays.copyOf(a[i], a[i].length);		//joksa lit her
		}
		
		if (a.length!=b.length) {
			return error;
		}
		
		for (int i=0; i<a.length; i++) {
			if (a[i].length==b[i].length) {
				for (int j=0;j<a[i].length;j++) {
					multiMatrise[i][j]=a[i][j]*b[i][j];
				}
			} else {
				return error;
			}
		}
		return multiMatrise;
	} */
	
	//f) 2
	public static int[][] multipliser(int[][] a, int[][] b) {
		int[][] error= {{0,1,1,0,0,1,0,1}, {0,1,1,1,0,0,1,0}, {0,1,1,1,0,0,1,0}, {0,1,1,0,1,1,1,1}, {0,1,1,1,0,0,1,0}};	//Error on binary language
		int[][] multiMatrise=new int[a.length][b[0].length];
		
		if (a[0].length!=b.length || b[0].length!=a.length) {
			return error;
		}
		int sum=0;
		for (int i=0; i<a.length; i++) {	
			for (int j=0;j<a[i].length;j++) {
				sum+=a[i][j]*b[j][i];
			}
			for (int j=0; j<b[i].length; j++) {
				multiMatrise[i][j]=sum;
			}
			sum=0;
		}
		
		return multiMatrise;
	}
}
