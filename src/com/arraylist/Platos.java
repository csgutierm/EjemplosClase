package com.arraylist;

import java.util.ArrayList;
import java.util.Collections;

//Git
public class Platos {

	public static void main(String[] args) {
		ordenar();
		
	}
	
	public static void ordenar() {
		ArrayList<String> lista = new ArrayList<String>();
		lista.add("Cazuela");
		lista.add("Porotos");
		lista.add("Pastel de Choclo");
		lista.add("Ají de Gallina");
		lista.add("Ceviche");
		lista.add("Arepas");
		
		for (String string : lista) {
			System.out.println(string);
		}
		
		Collections.sort(lista);
		System.out.println("La lista de comida es " + lista);
		System.out.println("Cantidad de Ceviches: " + Collections.synchronizedList(lista).stream().filter(x -> x == "Ceviche").count());
		Collections.reverse(lista);		
		System.out.println("La lista de comida es " + lista);
		
		Collections.swap(lista, 0, 2);
		System.out.println("La lista de comida es " + lista);
		
		Collections.fill(lista, "SIN STOCK");
		System.out.println("La lista de comida es " + lista);
		
		System.out.println("Cantidad de Ceviches: " + Collections.synchronizedList(lista).stream().filter(x -> x == "Ceviche").count());
		
	}

}
