package com.arraylist;

public class Listas2daParte {

	public static void main(String[] args) {
		
		int matrizEjemplo[][] = { { 1, 2, 3, 444, 99 }, { 4, 12 }, { 33 }, { 7, 8, 7, 44 } };

		for (int i = 0; i < matrizEjemplo.length; i++) {
			
			for (int j = 0; j < matrizEjemplo[i].length; j++) {
				System.out.print(matrizEjemplo[i][j] + "\t");
				System.out.println("  Posición: (" + i + " , " + j +")");
			}
			
		}

	}

}
