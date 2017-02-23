package principal;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Scanner;

import modelo.*;

public class Main {
	
	public final static int INSERTAR_LIBRO = 1;
	public final static int INSERTAR_SOCIO = 2;
	public final static int VER_LIBROS = 3;
	public final static int VER_SOCIOS = 4;
	public final static int VER_LIBRO_ID = 5;
	public final static int VER_SOCIO_ID = 6;
	public final static int ELIMINAR_LIBRO = 7;
	public final static int ELIMINAR_SOCIO = 8;
	public final static int VER_LIBROS_AUTOR = 9;
	public final static int VER_PRESTAMO = 10;
	
	public final static int SALIR = 0;
	

	public static void main(String[] args) {
		// MAIN DE PRUEBA PARA LIBRO

		// Instanciar

		Libro_modelo lm = new Libro_modelo("biblioteka");
		Socio_modelo sm = new Socio_modelo("biblioteka");
		Prestamo_modelo pm = new Prestamo_modelo("biblioteka");
		
		Scanner scan = new Scanner(System.in);

		int opcion;
		do {
			System.out.println("\n~~~~~ MENÚ PRINCIPAL ~~~~~");
			System.out.println("1. Insertar libro");
			System.out.println("2. Insertar socio");
			System.out.println("3. Ver libros");
			System.out.println("4. Ver socios");
			System.out.println("5. Ver libro por ID");
			System.out.println("6. Ver socio por ID");
			System.out.println("7. Eliminar libro");
			System.out.println("8. Eliminar socio");
			System.out.println("9. Ver libros por autor");
			System.out.println("10. Ver prestamo");
			System.out.println("0. Salir del menú\n");
			
			opcion = Integer.parseInt(scan.nextLine());
			switch (opcion) {

			case INSERTAR_LIBRO: // INSERT LIBRO
				System.out.println("Introduce el titulo del libro:");
				String titulo = scan.nextLine();
				
				System.out.println("Introduce el autor del libro:");
				String autor = scan.nextLine();
				System.out.println("Introduce el numero de paginas del libro:");
				int num_pag = Integer.parseInt(scan.nextLine());
				
				lm.insert(new Libro(0, titulo, autor, num_pag));
				break;

			case INSERTAR_SOCIO:
				
				System.out.println("Mete los siguientes datos requeridos.");
				System.out.print("Nombre:");
				String nombre = scan.nextLine();
				System.out.print("Apellido:");
				String apellido = scan.nextLine();
				System.out.print("Direccion:");
				String direccion = scan.nextLine();
				System.out.print("Poblacion:");
				String poblacion = scan.nextLine();
				System.out.print("Provincia:");
				String provincia = scan.nextLine();
				System.out.print("DNI:");
				String dni = scan.nextLine();

				Socio socio = new Socio(0,nombre,apellido,direccion,poblacion,provincia,dni);
				sm.insert(socio);
				break;

			case VER_LIBROS:
				ArrayList<Libro> libros = lm.select();
				Iterator<Libro> il = libros.iterator();
				
				while(il.hasNext()){
					il.next().mostrarInfo();
				}
				break;
				
			case VER_SOCIOS:
				ArrayList<Socio> socios = sm.select();
				Iterator<Socio> is = socios.iterator();
				
				while(is.hasNext()){
					is.next().mostrarInfo();
				}
				break;
				
			case VER_LIBRO_ID:
				Scanner pedir_id = new Scanner(System.in);
				System.out.print("Mete un ID para ver el libro: ");
				int id = Integer.parseInt(pedir_id.nextLine());
				lm.select(id).mostrarInfo();
		
				break;
				
			case VER_SOCIO_ID:
				pedir_id = new Scanner(System.in);
				System.out.print("Mete un ID para ver el socio: ");
				id = Integer.parseInt(pedir_id.nextLine());
				sm.select(id).mostrarInfo();
				break;
				
			case ELIMINAR_LIBRO:
				pedir_id = new Scanner(System.in);
				System.out.print("Mete un ID para borrar el libro: ");
				id = Integer.parseInt(pedir_id.nextLine());
				lm.delete(id);
				break;
				
			case ELIMINAR_SOCIO:
				pedir_id = new Scanner(System.in);
				System.out.print("Mete un ID para borrar el socio: ");
				id = Integer.parseInt(pedir_id.nextLine());
				sm.delete(id);
				break;
				
			case VER_LIBROS_AUTOR:
				
				Scanner pedir_autor = new Scanner(System.in);
				System.out.print("Mete el nombre de un autor para ver sus libros: ");
				autor = pedir_autor.nextLine();
				Iterator<Libro> i = lm.select(autor).iterator();
				while (i.hasNext()){
					i.next().mostrarInfo();
				}
				break;	
			case VER_PRESTAMO:
				//pm.select(1,1,Date(2017/03/23));
				
				break;	
			
			case SALIR:
				System.out.println("Saliendo....");
				break;

			default:
				System.out.println("Elige una de las opciones del menú.");
			}
		} while (opcion != 0);

	}

}