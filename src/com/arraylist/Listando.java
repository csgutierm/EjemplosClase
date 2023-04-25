package com.arraylist;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Locale;
import java.util.stream.Stream;


public class Listando {

	public static void main(String[] args) {
		// TODO Auto-generated method stub


		String[] vowels = {"a","e","i","o","u"};
		String[] numbers = {"1","2","3","4","5"};
		
		
		List<String> vowelsList = Arrays.asList(vowels);
		
		
		List<Integer> lista = new ArrayList<Integer>();
		lista.add(123);
		lista.add(null);	
		lista.add(111);
		
		System.out.println(Arrays.stream(numbers).mapToInt(Integer::parseInt).filter(x -> 0 <= x && x <= 3 ).average().getAsDouble());

		
		List<String> result = Stream.of(Locale.getISOCountries()).toList();
		
		System.out.println(result);

		for (String string : vowelsList) {
			System.out.println(string);
		}
		
		for (Integer integer : lista) {
			System.out.println(integer);
		}

	}

}
