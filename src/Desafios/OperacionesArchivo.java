/*
 * Requerimientos
1. Crear un método llamado crearArchivo(directorio,fichero), este método
recibe el nombre del directorio y el fichero como parámetros de entrada.
2. El nombre del fichero debe terminar con “.txt”, para indicar que es un archivo de
texto.
3. Validar que el nombre del directorio no exista dentro del programa.
○ Si el directorio no existe, se debe crear.
○ Si existe se mostrará el siguiente mensaje por consola
○ Si existe algún otro problema al crear el directorio, se mostrará el siguiente
mensaje por consola:
Error al crear directorio
4. Escribir en el archivo con un salto de línea lo que se encuentra en el siguiente
ArrayList.
Considerar utilizar Iterator para recorrer la lista.
ArrayList<String> lista = new ArrayList<String>();
lista.add("Perro");
lista.add("Gato");
lista.add("Juan");
lista.add("Daniel");
lista.add("Juan");
lista.add("Gato");
lista.add("Perro");
lista.add("Camila");
lista.add("Daniel");
lista.add("Camila");
5. Crear un método llamado buscarTexto(nombreFichero,texto), este método
recibe el nombre del fichero y el texto a buscar como parámetros de entrada.
6. Validar que el fichero exista.
○ Si el fichero no existe, se mostrará el siguiente mensaje por consola.
El fichero ingresado no existe
7. Si el fichero existe, buscar el texto ingresado dentro del archivo.
8. Mostrar por consola la cantidad de veces que la palabra ingresada se encuentra en el
texto.
cantidad de repeticiones del texto -> 2
 */
package Desafios;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Scanner;

public class OperacionesArchivo {
//	static int repeticiones = 0;
	static Scanner sc = new Scanner(System.in);

	public static void main(String[] args) {

		String directorio = null;
		String fichero = ".txt";

		System.out.println("Nombre directorio: ");
		directorio = sc.nextLine();
		System.out.println("Nombre del archivo: ");
		fichero = sc.nextLine();

		// 1:Exito , 2:Fallo al crear directorio, 3: Error escritura/lectura
		int crearArchivoStatus = crearArchivo(directorio, fichero);

		System.out.println("código de crearArchivo: " + crearArchivoStatus);

		String nombreFichero = "src" + File.separatorChar + directorio + File.separatorChar;
		System.out.println("Nombre del archivo: ");
		nombreFichero = nombreFichero + sc.nextLine();
		// trabajamos sobre el mismo directorio inicial

		if (validarExistenciaFichero(nombreFichero) == false) {
			System.out.println("Saliendo del programa");
			System.exit(0);
		}

		String texto = null;
		System.out.println("Texto a buscar: ");
		texto = sc.nextLine();

		buscarTexto(nombreFichero, texto);

//		escribirTexto(fichero,rutaArchivo);
		sc.close();
	}

	private static void escribirTexto(FileWriter fileW) {

		BufferedWriter bufferedWriter = new BufferedWriter(fileW);

		ArrayList<String> lista = new ArrayList<String>();
		lista.add("Perro");
		lista.add("Gato");
		lista.add("Juan");
		lista.add("Daniel");
		lista.add("Juan");
		lista.add("Gato");
		lista.add("Perro");
		lista.add("Camila");
		lista.add("Daniel");
		lista.add("Camila");

		// cuatro formas distintas de escribir

//			for (String string : lista) {
//				bufferedWriter.write(string);
//				bufferedWriter.newLine();								
//			}

		Iterator<String> iterator = lista.iterator();
		try {
			while (iterator.hasNext()) {
				System.out.println("Escribiendo");
				bufferedWriter.write(iterator.next() + System.lineSeparator());
			}
			bufferedWriter.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
//		String data = lista.stream().
//				//valor inicial, (acumulador, string)
//				reduce("", (acumulador, string) -> acumulador + string + System.lineSeparator()); 
//		
//		try {
//			bufferedWriter.write(data);
//			bufferedWriter.close();
//		} catch (IOException e) {
//			e.printStackTrace();
//		}

//		System.out.println("data: " + data);

//		    iterator.forEachRemaining(t -> {
//				try {
//					bufferedWriter.write(t);
//					bufferedWriter.newLine();
//				} catch (IOException e) {
//					e.printStackTrace();
//				}
//			});

	}

	/**
	 * 
	 * @param directorio carpeta a crear
	 * @param fichero    archivo a crear
	 * @return EL directorio de creación
	 */
	private static int crearArchivo(String directorio, String fichero) {

		File directorioRutaLocal = new File("src" + File.separatorChar + directorio);
		if (directorioRutaLocal.exists() == false) {
			if (directorioRutaLocal.mkdir()) {
				System.out.println("Directorio creado");
			} else {
				System.out.println("Error al crear directorio");
				return 2;
			}
		} else {
			System.out.println("Directorio ya  existe");
		}

		File archivo = new File("src" + File.separatorChar + directorio + File.separatorChar + fichero);

		if (archivo.exists()) {
			System.out.println("Archivo ya  existe");
			System.out.println("Desea continuar, la información del archivo se sobrescribirá: SI o NO");

			Boolean respuesta = false;

			do {
				String input = sc.nextLine();

				switch (input) {
				case "SI", "si", "Si" -> {
					System.out.println("Continuamos ... Sobrescribiendo");
					respuesta = true;
				}
				case "NO", "no", "No" -> {
					System.out.println("Saliendo del programa");
					System.exit(0);
					;
				}
				default -> System.out.println("Escriba una opción válida (SI o NO) ");
				}

			} while (!respuesta);

		}

		FileWriter fileWriter;
		try {
			fileWriter = new FileWriter(archivo);
			// esta forma agrega datos al final (no sobrescribe)
//			fileW = new FileWriter(archivo, true);

//			bufferedWriter.write("texto");			
			escribirTexto(fileWriter);
		} catch (IOException e) {
			e.printStackTrace();
			return 3;
		}

		return 1;

	}

	/**
	 * Imprime la cantidad de veces que un texto se repite en un fichero
	 * 
	 * @param nombreFichero La ruta de un archivo
	 * @param texto         El texto a buscar
	 */
	private static void buscarTexto(String nombreFichero, String texto) {

		String nombreArchivo = nombreFichero;
		FileReader fileReader = null;
		BufferedReader bufferedReader = null;
		String data = "";
		ArrayList<String> nombres = new ArrayList<String>();
		try {
			fileReader = new FileReader(nombreArchivo);
			bufferedReader = new BufferedReader(fileReader);
			data = bufferedReader.readLine();
			while (data != null) {
				nombres.add(data);
				data = bufferedReader.readLine();
			}
			bufferedReader.close();
			fileReader.close();
		} catch (Exception exception) {
			System.out.println("Excepcion leyendo fichero " + nombreArchivo + ": " + exception);
		}
//		nombres.forEach((e) -> {
//		      if(e.contentEquals(texto))
//		      repeticiones++;
//		    });
//		
//		System.out.println("Cantidad de repeticiones del texto -> " + repeticiones);
//		repeticiones = 0;

		System.out.println("Cantidad de repeticiones del texto -> "
				+ nombres.stream().filter(e -> e.contentEquals(texto)).count());
	}

	/**
	 * Chequea la existencia de un archivo
	 * 
	 * @param fichero ruta del archivo
	 * @return false si no existe, true en caso de que exista el archivo en la ruta
	 *         especificada
	 */
	private static boolean validarExistenciaFichero(String fichero) {

		System.out.println("verificando existencia del archivo con ruta: " + fichero);
		// Creamos un objeto que nos permitirá a través del método exists
		File archivo = new File(fichero);

		// Chequeamos la existencia de un archivo en la ruta especificada
		if (!archivo.exists()) {
			System.out.println("El fichero ingresado no existe");
			return false;
		}
		System.out.println("Fichero encontrado");
		return true;
	}

}
