package com.metodos;

public class CalculaMetodos {

	int num1;
	int num2;

	public static void main(String[] args) {
		
		//Por scanner agregas a y b para que lo ingrese usuario

		CalculaMetodos calcula = new CalculaMetodos(5,3);
		
		int resultadoSuma = calcula.sumar();
		System.out.print("Suma: " + resultadoSuma);		
		System.out.print(System.lineSeparator());
		
		int resultadoResta = calcula.restar();
		System.out.print("Resta: " + resultadoResta);
		System.out.print(System.lineSeparator());
		
		int resultadoMultiplicacion = calcula.multiplicar();
		System.out.print("Multiplicación: " + resultadoMultiplicacion);
		System.out.print(System.lineSeparator());
	
		float resultadoDivision = calcula.dividir();
		System.out.print("División: " + resultadoDivision);
	}
	
	public CalculaMetodos(int i, int j) {
		num1 = i;
		num2 = j;
	}
	
	private int restar() {
		int resultado = num1 - num2;
		return resultado;
	}
	

	private int sumar() {
		int resultado = num1 + num2;
		return resultado;
	}
	
	private int multiplicar() {
		int resultado = num1 * num2;
		return resultado;
	}
	
	private float dividir() {
		float resultado = (float) num1 / (float) num2;
		return resultado;
	}

}
