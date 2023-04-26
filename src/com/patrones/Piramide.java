package com.patrones;

public class Piramide {

	public static void main(String[] args) {
		final int n = 6;
		
		for (int i = 1; i <=n; i++) {
			
			for (int j = i; j < n; j++) {
				System.out.print("-");
			}
			
			for (int k = 1; k < 2*i ; k++) {
				System.out.print("*");
			}
			System.out.print(System.lineSeparator());
			;
		}

	}

}
