import java.util.Scanner;
import java.util.InputMismatchException;
import java.io.*;
import java.net.*;
/**
* Programa Menu para el manejo de una lista doblemente ligada
* @author Andrea Alvarado Camacho
* @author Alfonso Mondragon Segoviano
* @version 1.0
*/
public class Main{
	public static void main(String []args){
		// Colores de letra
		String black="\033[30m"; 
	   	String red="\033[31m"; 
	   	String green="\033[32m"; 
	   	String yellow="\033[33m"; 
	   	String blue="\033[34m"; 
	   	String purple="\033[35m"; 
	   	String cyan="\033[36m"; 
	   	String white="\033[37m"; 
	   	// Reset
	   	String reset="\u001B[0m";

		DoubleLinkedList lista = new DoubleLinkedList();
		Scanner in = new Scanner(System.in);
		Scanner on = new Scanner(System.in);
		boolean repetir=true;
		boolean excep=true;
		String cadena = "";
		int indice = 0;
		int opc;

		System.out.println(purple + "\n\t*** BIENVENIDO ***" + reset);
		do{
			try{
				System.out.println("\n\t\t*** Menu ***");
				System.out.println("--------------------------------------------");
				System.out.println("1. Agregar una cadena a la lista");
				System.out.println("2. Eliminar una cadena de la lista");
				System.out.println("3. Limpiar lista");
				System.out.println("4. Verificar si un elemento esta en la lista");
				System.out.println("5. Obtener un elemento de la lista");
				System.out.println("6. Verificar si la lista es vacía");
				System.out.println("7. Obtener la longitud de la lista");
				System.out.println("8. Obtener la reversa de la lista");
				System.out.println("9. Cortar la lista");
				System.out.println("10. Mostrar la lista");
				System.out.println("11. Salir del menu");
				System.out.println("--------------------------------------------");
				System.out.print("Ingresa una opcion del menu: ");
				opc = in.nextInt();

				switch(opc){
					// Agregar una cadena a la lista
					case 1: repetir=true;
							System.out.print("Cadena a agregar: ");
							cadena = on.nextLine();
							do{	
								try{
									System.out.print("¿En que posicion lo quieres agregar?: ");
									indice = in.nextInt();
									lista.add(indice,cadena);
									// Se agrego el elemento 
									System.out.println(green + "\n\tSe agrego el elemento a la lista en la posicion " + indice + reset);
									repetir=false;
								}catch(InputMismatchException e){
									System.out.println(yellow + "\tDebes ingresar un numero\tIntentalo de nuevo" + reset);
									in.next();
								}catch(IndexOutOfBoundsException e){
									System.out.println(yellow + "\tDebes ingresar un numero dentro del rango\tIntentalo de nuevo" + reset);
								}
							}while(repetir);
					break;
					// Eliminar una cadena de la lista
					case 2: repetir=true;
							if(!lista.isEmpty()){
								do{
									try{
										System.out.print("¿En que posicion esta el elemento a eliminar?: ");
										indice = in.nextInt();
										System.out.println(red +"\n\tEl elemento " + lista.remove(indice) + " se elimino de la lista" + reset);
										repetir=false;
									}catch(InputMismatchException e){
										System.out.println(yellow + "\tDebes ingresar un numero\n\tIntentalo de nuevo" + reset);
										in.next();
									}catch(IndexOutOfBoundsException e){
										System.out.println(yellow + "\tDebes ingresar un numero dentro del rango\n\tIntentalo de nuevo" + reset);
									}
								}while(repetir);
							}else{
								System.out.println(yellow + "\n\tNo hay elementos en la lista que se puedan borrar" + reset);
							}
					break;
					// Eliminar de la lista
					case 3: if(!lista.isEmpty()){
								lista.clear();
								System.out.println(green + "\n\tAhora la lista esta vacia" + reset);
							}else{
								System.out.println(yellow + "\n\tNo hay elementos en la lista" + reset);
							}
							
					break;
					// Verificar si un elemento esta en la lista
					case 4: if(!lista.isEmpty()){
								System.out.print("¿Cual es el elemento que quieres verificar?: ");
								cadena = on.nextLine();
								if(lista.contains(cadena)){
									System.out.println(green + "\n\tEl elemento si esta contenido en la lista" + reset);
								}else{
									System.out.println(red + "\n\tEl elemento no esta contenido en la lista" + reset);
								}
							}else{
								System.out.println(yellow + "\n\tNo hay elementos en la lista" + reset);
							}
					break;
					// Obtener un elemento de la lista
					case 5: repetir=true;
							if(!lista.isEmpty()){
								do{
									try{
										System.out.print("¿En que posicion esta el elemento a obtener?: ");
										indice = in.nextInt();
										System.out.println(green + "\n\tEl elemento es: " + lista.get(indice) + reset);
										repetir=false;
									}catch(InputMismatchException e){
										System.out.println(yellow + "\tDebes ingresar un numero\tIntentalo de nuevo" + reset);
										in.next();
									}catch(IndexOutOfBoundsException e){
										System.out.println(yellow + "\tDebes ingresar un numero dentro del rango\tIntentalo de nuevo" + reset);
									}
								}while(repetir);
							}else{
								System.out.println(yellow + "\n\tNo hay elementos en la lista" + reset);
							}
					break;
					// Verificar si la lista es vacía
					case 6: if(lista.isEmpty()){
								System.out.println(yellow + "\n\tLa lista es vacia" + reset);
							}else{
								System.out.println(cyan + "\n\tLa lista no esta vacia" + reset);
							}
					break;
					// Obtener la longitud de la lista
					case 7: if(!lista.isEmpty()){
								System.out.println(green +"\n\tLa lista tiene un tamaño de: "+lista.size() + reset);
							}else{
								System.out.println(yellow + "\n\tNo hay elementos en la lista" + reset);
							}
					break;
					// Obtener la reversa de la lista
					case 8: if(!lista.isEmpty()){
								lista.revert();
								System.out.println(green + "\n\tLa lista en reversa es: "+lista.toString() + reset);
							}else{
								System.out.println(yellow + "\n\t" + lista.toString() + reset);
							}
							
					break;
					// Cortar la lista
					case 9: repetir = true;
							if(!lista.isEmpty()){
								do{
									System.out.println("¿Que mitad quieres cortar?\t¿Derecha o izquierda?");
									cadena = on.nextLine();
									if(cadena.equalsIgnoreCase("Derecha")){
										System.out.println(green + "\n\t" + lista.cut(true) + reset);
										repetir = false;
									}else if(cadena.equalsIgnoreCase("izquierda")){
										System.out.println(green + "\n\t" + lista.cut(false) + reset);
										repetir = false;
									}else{
										System.out.println(yellow + "\n\tDebes escribir derecha o izquierda\n" + reset);
									}
								}while(repetir);
							}else{
								System.out.println(yellow + "\n\tLa lista es vacia, no se puede cortar" + reset);
							}
					break;
					// Mostrar la lista
					case 10:if(!lista.isEmpty()){
								System.out.println(green + "\n\t" + lista.toString() + reset);
							}else{
								System.out.println(yellow + "\n\t" + lista.toString() + reset);
							}
							
					break;
					// Salir del programa
					case 11:System.out.println(purple + "\n\tHasta luego :)\n" + reset);
							System.exit(0); // Salida del programa 
					break;

					default:
							System.out.println(yellow + "\n\tElige una opcion de menu plis :c" + reset);
					break;
				}
			}catch(Exception e2){
				System.out.println(yellow + "\n\tDebes ingresar un numero\tIntentalo de nuevo" + reset);
				in.next();
				excep=true;
			}
		}while(excep);
	}
}