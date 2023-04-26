package com.arraylist;

import java.util.Arrays;
import java.util.List;
import java.util.stream.IntStream;


public class rutTestParalelismo {

	public static void main(String[] args) {

		final List<String> ruts = Arrays.asList("12451864-4", "16885786-1", "10243930-9", "18825623-6", "6267582-9",
				"21098361-9", "5869138-0", "11295564-2", "9677408-7", "21707011-2","21707011-3");

		Long timer1;
		Long timer2;

		timer1 = System.currentTimeMillis();
		
//		for (int i = 0; i < 1_000_000; i++) {
//			ruts.stream().filter(x -> !validador(x)).skip(10_000).forEach(System.out::print);
//
//		}
//		System.out.println(ruts.stream().filter(x -> !validador(x)).count());
//		
//		for (int i = 0; i < 1_000_000; i++) {
//			ruts.stream()
//			.map(x -> x.replace(".", ""))
//			.map(x -> x.replace("-", ""))
//			.map(x -> x.toUpperCase())
//			.mapToInt(Integer::parseInt)
//			.filter(x -> !validador2(x)).skip(10_000).forEach(System.out::print);
//		}
		
		IntStream.rangeClosed(1, 1_000_000).forEach(i -> {
			ruts.stream()
			.map(x -> x.replace(".", ""))
			.map(x -> x.replace("-", ""))
			.map(x -> x.toUpperCase())
			.mapToInt(Integer::parseInt)
			.filter(x -> !validador2(x)).skip(10_000).forEach(System.out::print);
	    });
		
		timer2 = System.currentTimeMillis();
		
		System.out.printf("Milisegundo de ejecución: ");
		System.out.println(timer2-timer1);
		
		
	}

	private static Boolean validador(String rut) {

	    boolean validacion = false;
	    try {
	        rut =  rut.toUpperCase();
	        rut = rut.replace(".", "");
	        rut = rut.replace("-", "");

	        int rutAux = Integer.parseInt(rut.substring(0, rut.length() - 1));

	        char dv = rut.charAt(rut.length() - 1);

	        int m = 0, s = 1;
	        for (; rutAux != 0; rutAux /= 10) {
	            s = (s + rutAux % 10 * (9 - m++ % 6)) % 11;
	        }
	        if (dv == (char) (s != 0 ? s + 47 : 75)) {
	            validacion = true;
	        }

	    } catch (java.lang.NumberFormatException e) {
	    } catch (Exception e) {
	    }
	    return validacion;
		
	}
	
	private static Boolean validador2(Integer rut) {

	    boolean validacion = false;
	    try {
	    	
	    	


	        int rutAux = Integer.parseInt(rut.toString().substring(0, rut.toString().length() - 1));

	        char dv = rut.toString().charAt(rut.toString().length() - 1);

	        int m = 0, s = 1;
	        for (; rutAux != 0; rutAux /= 10) {
	            s = (s + rutAux % 10 * (9 - m++ % 6)) % 11;
	        }
	        if (dv == (char) (s != 0 ? s + 47 : 75)) {
	            validacion = true;
	        }

	    } catch (java.lang.NumberFormatException e) {
	    } catch (Exception e) {
	    }
	    return validacion;
		
	}
	
	

}
