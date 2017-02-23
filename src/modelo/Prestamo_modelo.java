package modelo;

import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class Prestamo_modelo extends Conector{

	Prestamo_modelo(String dbIzena) {
		super(dbIzena);
		// TODO Auto-generated constructor stub
	}

	public ArrayList<Prestamo> select() {
		ArrayList<Prestamo> prestamos = new ArrayList<Prestamo>();
		try {
			Statement st = this.conexion.createStatement();
			ResultSet rs = st.executeQuery("select * from prestamos");
			while (rs.next()) {
				Prestamo prestamo = new Prestamo(rs.getInt("id_libro"),rs.getInt("id_socio"),
												 rs.getDate("fecha"),rs.getBoolean("devuelto"));
				prestamos.add(prestamo);
			}
		}

		catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return prestamos;

	}
	
	
	//PRESTAMO select id-s y fecha
	

	public void insert(Prestamo prestamo) {
		try {
			PreparedStatement ps;
			ps = this.conexion.prepareStatement("insert into "
											  + "prestamos (id_libro,id_socio,fecha,devuelto)"
											  + " values(?,?,?,?)");

			ps.setInt(1, prestamo.getId_libro()); // lehen galdera ikurra bete
			ps.setInt(2, prestamo.getId_socio()); // bigarren galdera ikurra bete
			java.sql.Date fecha_sql = new java.sql.Date(prestamo.getFecha().getTime());
			ps.setDate(3,  fecha_sql); // hirugarren galdera ikurra bete
			ps.setBoolean(4,false); // laugarren galdera ikurra bete
			//Al insertar un nuevo prestamo, nunca está devuelto, por eso siempre es false
			ps.execute();
			// Statement st = this.conexion.createStatement();
			//
			// st.execute("INSERT INTO `libros`(`titulo`, `autor`, `num_pag`)
			// VALUES ('" + libro.getTitulo()+"', '"
			// +libro.getAutor()+"','"+libro.getNum_pag()+ "')");

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
