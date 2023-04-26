package com.patrones;

import java.util.Scanner;

/*
 * Ejercicio propuesto
Realiza el patrón para medio
triángulo inverso
jjjjj
*****i
**** i
***  i
**   i
*    i

 */
public class TrianguloInverso {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		System.out.printf("Ingresa un numero ");
		int n = sc.nextInt();

		for (int i = n; i >= 1; i--) {

			for (int j = 0; j < i; j++) {

				System.out.print("*");

			}
			System.out.println();

		}

//		for (int i = 5; i >= 1; i--)
//	    {
//	 
//	        // impresión '*'
//	        for (int k = 0; k < i; k++) {
//	        	System.out.print("*");
//	        }
//	 
//	        // pasar a la siguiente linea
//	        System.out.print("\n");
//	    }
		
		sc.close();

	}

}
