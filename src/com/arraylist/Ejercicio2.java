/*
 * Realizar las siguientes operaciones
● Utilizando reduce, sumar todos los valores del array
● Utilizando reduce, sumar todos los valores no repetidos del array
● Convertir todos los datos al tipo float
● Filtrar todos los elementos menores a 5 sin repetir
● Utilizando mapToInt, sumar todos los valores del arreglo
● Utilizando .count() contar todos los elementos menores que 5
 */
package com.arraylist;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Ejercicio2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		List<String> nombres =
				Arrays.asList("Anastasia","Beatriz","Clara","Carla","Marianela","Paula","Pia");
		
		
		
		 //Obtener todos los elementos que excedan los 5 caracteres
		nombres.stream().filter(x -> x.length()>5).forEach(x -> System.out.print(x + ". "));
		System.out.println();
		
		 //Utilizar map para transformar todos los nombres a minúscula
		nombres.stream().map(x -> x.toLowerCase()).forEach(x -> System.out.print(x + ". "));
		System.out.println();
		 //Crear un arreglo con todos los nombres que comiencen con P
		nombres.stream().filter( x -> x.startsWith("P")).forEach(x -> System.out.print(x + ". "));
		System.out.println();
		 //Utilizando .count, contar los elementos que empiecen con 'A', 'B' o 'C'.
		nombres.stream().filter( x -> x.startsWith("A") || x.startsWith("B") || x.startsWith("C") ).forEach(x -> System.out.print(x + ". "));
		System.out.println();
		 //Utilizando .map, crear un arreglo con la cantidad de letras que tiene cada nombre.
		System.out.println(nombres.stream().map(x -> x.length()).collect(Collectors.toList()));

		
	
	}
}
