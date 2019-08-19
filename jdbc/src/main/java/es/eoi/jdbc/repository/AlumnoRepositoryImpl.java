package es.eoi.jdbc.repository;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import es.eoi.jdbc.entity.Alumno;

public class AlumnoRepositoryImpl implements AlumnoRepository {

	private List<Alumno> alumnos;

	public AlumnoRepositoryImpl() {
		alumnos = new ArrayList<Alumno>();
	}

// CONEXION
	private Connection openConnection() throws SQLException {
		String url = "jdbc:mysql://localhost:3306/alumnado?serverTimezone=UTC";
		String user = "root";
		String pass = "1234";

		Connection conexion = DriverManager.getConnection(url, user, pass);
		return conexion;
	}

// STATEMENT
	private Statement statConnection(Connection conexion) throws SQLException {
		Statement stat = conexion.createStatement();
		return stat;
	}

//RESULTSET
	private ResultSet resultConnection(ResultSet resultSet, Statement stat) throws SQLException {
		ResultSet result = resultSet;
		return result;
	}

//CLOSECONNECTION
	private void closeConnection(Connection conexion) throws SQLException {
		conexion.close();
	}

// CREAR
	public boolean create(Alumno alumno) throws SQLException {
		try {
			Connection connect = openConnection();

			StringBuilder sql = new StringBuilder();
			sql.append("insert into ALUMNO ");
			sql.append("(DNI, NOMBRE, APELLIDOS, EDAD) ");
			sql.append("values ");
			sql.append("(? ,? ,? ,?)");

			PreparedStatement prepaStat = connect.prepareStatement(sql.toString());

			prepaStat.setString(1, alumno.getDNI());
			prepaStat.setString(2, alumno.getNOMBRE());
			prepaStat.setString(3, alumno.getAPELLIDOS());
			prepaStat.setInt(4, alumno.getEDAD());

			prepaStat.executeUpdate();

			closeConnection(connect);

			return true;
		} catch (SQLException e) {
			return false;
		}
	}

// ELIMINAR
	public boolean delete(String dni) throws SQLException {
		try {
			Connection connect = openConnection();

			StringBuilder sql = new StringBuilder();
			sql.append("delete from ALUMNO ");
			sql.append("where DNI = ?");

			PreparedStatement prepaStat = connect.prepareStatement(sql.toString());
			prepaStat.setString(1, dni);

			prepaStat.executeUpdate();

			closeConnection(connect);

			return true;
		} catch (SQLException e) {
			return false;
		}
	}

// ACTUALIZAR
	public boolean update(String dni, String nombre, String apellidos, int edad) throws SQLException {
		try {
			Connection connect = openConnection();

			StringBuilder sql = new StringBuilder();
			sql.append("UPDATE ALUMNO ");
			sql.append("set DNI=?, NOMBRE=?, APELLIDOS=?, EDAD=?");
			sql.append("where DNI=?");

			PreparedStatement prepaStat = connect.prepareStatement(sql.toString());

			prepaStat.setString(1, dni);
			prepaStat.setString(2, nombre);
			prepaStat.setString(3, apellidos);
			prepaStat.setString(4, dni);

			prepaStat.executeUpdate();

			closeConnection(connect);

			return true;
		} catch (SQLException e) {
			return false;
		}
	}

// LISTAR TODOS
		public List<Alumno> findAll() throws SQLException {
			Connection connect = openConnection();
			Statement stat = statConnection(connect);

			StringBuilder sql = new StringBuilder();
			sql.append("select * ");
			sql.append("from ALUMNO");

			PreparedStatement prepaStat = connect.prepareStatement(sql.toString());

			ResultSet result = resultConnection(prepaStat.executeQuery(), stat);

			Alumno alumno;

			while (result.next()) {
				alumno = new Alumno(result.getString("DNI"), result.getString("NOMBRE"), result.getString("APELLIDOS"),
						result.getInt("EDAD"));
				alumnos.add(alumno);
			}

			closeConnection(connect);

			return alumnos;
		}
	
// ENCONTRAR POR DNI
	public Alumno findByDni(String dni) throws SQLException {
		Connection connect = openConnection();
		Statement stat = statConnection(connect);

		StringBuilder sql = new StringBuilder();
		sql.append("select * ");
		sql.append("from ALUMNO ");
		sql.append("where DNI=?");
		sql.append(dni.toString());

		PreparedStatement prepaStat = connect.prepareStatement(sql.toString());

		ResultSet result = resultConnection(prepaStat.executeQuery(), stat);

		Alumno alumno = null;

		while (result.next()) {
			alumno = new Alumno(result.getString("DNI"), result.getString("NOMBRE"), result.getString("APELLIDOS"),
					result.getInt("EDAD"));
		}

		closeConnection(connect);

		return alumno;
	}

}