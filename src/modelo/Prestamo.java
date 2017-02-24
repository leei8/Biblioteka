package modelo;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Prestamo {
	// -----Atributos
	int id_libro;
	int id_socio;
	Date fecha;
	boolean devuelto;

	//-----Constructores
	public Prestamo(int id_libro, int id_socio, Date fecha, boolean devuelto) {
		super();
		this.id_libro = id_libro;
		this.id_socio = id_socio;
		this.fecha = fecha;
		this.devuelto = devuelto;
	}
	
	public Prestamo() {
		super();
		// TODO Auto-generated constructor stub
	}

	//-----Metodos
	
	public void mostrarInfo() {
	
		//socio, titulo, fecha y devuelto
		Libro_modelo lm = new Libro_modelo("Biblioteka");
		Socio_modelo sm = new Socio_modelo("Biblioteka");
		
		Libro libro = lm.select(this.id_libro);
		Socio socio  = sm.select(this.id_socio);
		
		System.out.println("Nombre de libro: " + libro.getTitulo());
		System.out.println("Nombre de socio: " + socio.getNombre());
		System.out.println("Fecha: " + this.fecha);
		System.out.println("Ha sido devuelto?: " + this.devuelto);
	}
	
	
	
	public int getId_libro() {
		return id_libro;
	}

	public void setId_libro(int id_libro) {
		this.id_libro = id_libro;
	}

	public int getId_socio() {
		return id_socio;
	}

	public void setId_socio(int id_socio) {
		this.id_socio = id_socio;
	}

	public Date getFecha() {
		return fecha;
	}

	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}

	public boolean isDevuelto() {
		return devuelto;
	}

	public void setDevuelto(boolean devuelto) {
		this.devuelto = devuelto;
	}

}
