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

public class Ejercicio1 {

	public static void main(String[] args) {
		List<Integer> numeros = Arrays.asList(1,9,2,10,2,4,7,4,7,1,4);
		
		//Utilizando reduce, sumar todos los valores del array
		System.out.println(numeros.stream().reduce(0, (a,b) -> a+b ));
//		a=0, b=1 -> 0+1 =1
//		a=1, b=9 -> 1+9 =10
//		a=10,b=2 -> 10+2 =12
//		
		//Utilizando reduce, sumar todos los valores no repetidos del array
		System.out.println(numeros.stream().distinct().reduce(0, (a,b) -> a+b ));
		
		//Convertir todos los datos al tipo float
		System.out.println(numeros.stream().map(x -> (float) x).collect(Collectors.toList()));
		
		//Filtrar todos los elementos menores a 5 sin repetir
		System.out.println(numeros.stream().distinct().filter(x -> x < 5).collect(Collectors.toList()));
		
		//Utilizando mapToInt, sumar todos los valores del arreglo
		System.out.println(numeros.stream().mapToInt(Integer::intValue).sum());
		
		//Utilizando .count() contar todos los elementos menores que 5
		System.out.println(numeros.stream().filter(x -> x < 5).count());
		
		
//		List<Integer> visitasDiarias = Arrays.stream(args).mapToInt(Integer::parseInt).boxed().collect(Collectors.toList());
		Arrays.stream(args).mapToInt(Integer::parseInt).forEach(System.out::print);

//		...
		
	}

}
