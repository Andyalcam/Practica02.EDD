import java.util.Scanner;
import java.util.InputMismatchException;
import java.io.*;
/**
* Programa Menu para el manejo de una lista doblemente ligada
* @author Andrea Alvarado Camacho
* @author Alfonso Mondragon Segoviano
* @version 1.0
*/
public class Main{
	public static void main(String []args){

		DoubleLinkedList lista = new DoubleLinkedList();
		Scanner in = new Scanner(System.in);
		Scanner on = new Scanner(System.in);
		boolean repetir=true;
		boolean excep=true;
		String cadena = "";
		int indice = 0;
		int opc;

		System.out.println("\n\t*** BIENVENIDO ***");
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
							do{
								try{
									System.out.print("Cadena a agregar: ");
									cadena = on.nextLine();
									System.out.print("¿En que posicion lo quieres agregar?: ");
									indice = in.nextInt();
									lista.add(indice,cadena);
									repetir=false;
								}catch(InputMismatchException e){
									System.out.println("\t"+e+" Debes ingresar un numero\n\tIntentalo de nuevo");
									in.next();
								}catch(IndexOutOfBoundsException e){
									System.out.println("\t"+e+" Debes ingresar un numero dentro del rango\n\tIntentalo de nuevo");
									on.next();
								}catch(NullPointerException e){
									System.out.println("\t"+e+" Ocurrio un error\n\tIntentalo de nuevo");
									in.next();
								}
							}while(repetir);
					break;
					// Eliminar una cadena de la lista
					case 2: repetir=true;
							do{
								try{
									System.out.print("¿En que posicion esta el elemento a eliminar?: ");
									indice = in.nextInt();
									lista.remove(indice);
									repetir=false;
								}catch(InputMismatchException e){
									System.out.println("\t"+e+" Debes ingresar un numero\n\tIntentalo de nuevo");
									in.next();
								}catch(IndexOutOfBoundsException e){
									System.out.println("\t"+e+" Debes ingresar un numero dentro del rango\n\tIntentalo de nuevo");
									on.next();
								}catch(NullPointerException e){
									System.out.println("\t"+e+" Ocurrio un error\n\tIntentalo de nuevo");
									in.next();
								}
							}while(repetir);
					break;
					// Eliminar de la lista
					case 3: lista.clear();
							System.out.println("Ahora la lista esta vacia");
					break;
					// Verificar si un elemento esta en la lista
					case 4: System.out.print("¿Cual es el elemento que quieres verificar?: ");
							cadena = on.nextLine();
							if(lista.contains(cadena)){
								System.out.println("El elemento si esta contenido en la lista");
							}else{
								System.out.println("El elemento no esta contenido en la lista");
							}
					break;
					// Obtener un elemento de la lista
					case 5: repetir=true;
							do{
								try{
									System.out.print("¿En que posicion esta el elemento a obtener?: ");
									indice = in.nextInt();
									System.out.println(lista.get(indice));
									repetir=false;
								}catch(InputMismatchException e){
									System.out.println("\t"+e+" Debes ingresar un numero\n\tIntentalo de nuevo");
									in.next();
								}catch(IndexOutOfBoundsException e){
									System.out.println("\t"+e+" Debes ingresar un numero dentro del rango\n\tIntentalo de nuevo");
									on.next();
								}catch(NullPointerException e){
									System.out.println("\t"+e+" Ocurrio un error\n\tIntentalo de nuevo");
									in.next();
								}
							}while(repetir);
					break;
					// Verificar si la lista es vacía
					case 6:
					break;
					// Partidas registradas
					case 10:
							System.out.println(lista.toString());
					break;
					// Salir del programa
					case 11:System.out.println("\n\tHasta luego :)\n");
							System.exit(0); // Salida del programa 
					break;

					default:
							System.out.println("Elige una opcion de menu plis :c");
					break;
				}
			}catch(Exception e2){
				System.out.println("\n\n"+e2+"\nDebes ingresar un numero");
				in.next();
				excep=true;
			}
		}while(excep);
	}
}