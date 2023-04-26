package parallel;

import java.util.stream.IntStream;

public class Principal {

	public static void main(String[] args) {

//		int total = 0;
//
//		long numero1 = System.currentTimeMillis();
//
//		for (int i = 0; i < 10; i++) {
//
//			total += duplicar(i);
//		}
//
//		long numero2 = System.currentTimeMillis();
//
//		System.out.println(numero2 - numero1);
//		System.out.println(total);
//		
//
		long numero1 = System.currentTimeMillis();

		IntStream lista = IntStream.range(1, 100);
		int total = lista.parallel().map(Principal::duplicar).sum();

		long numero2 = System.currentTimeMillis();
		System.out.println(numero2 - numero1);
		System.out.println(total);

	}

	public static int duplicar(int numero) {

//		try {
//			Thread.sleep(1000);
//		} catch (InterruptedException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//
//		return numero * 2;

		try {
			Thread.sleep(10);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return numero * 2;

	}

}
