package es.eoi.jdbc.app;

import java.sql.SQLException;
import java.util.Scanner;

import es.eoi.jdbc.entity.Alumno;
import es.eoi.jdbc.service.AlumnoServiceImpl;

public class GestionInstituto {
	private static AlumnoServiceImpl alumnoServiceImpl;

	public static void main(String[] args) throws SQLException {
		System.out.println("---MENU---");
		System.out.println("1- Crear alumno");
		System.out.println("2- Eliminar alumno");
		System.out.println("3- Actualizar alumno");
		System.out.println("4- Ver todos los alumnos");
		System.out.println("5- Buscar alumno");
		System.out.println("6- Salir");
		System.out.println("----------");

		Scanner sc = new Scanner(System.in);
		String option = sc.nextLine();
		int iOption = Integer.parseInt(option);

		switch (iOption) {

		case 1:
			System.out.println("----------------------------------------");
			System.out.println("Escribe DNI del nuevo alumno (9 digitos)");
			Scanner sc1 = new Scanner(System.in);
			String scdni = sc1.nextLine();
			System.out.println("...");

			System.out.println("Escribe NOMBRE del nuevo alumno");
			Scanner sc2 = new Scanner(System.in);
			String scnombre = sc2.nextLine();
			System.out.println("...");

			System.out.println("Escribe APELLIDOS del nuevo alumno");
			Scanner sc3 = new Scanner(System.in);
			String scapellidos = sc3.nextLine();
			System.out.println("...");

			System.out.println("Escribe EDAD del nuevo alumno");
			Scanner sc4 = new Scanner(System.in);
			String scedad = sc4.nextLine();
			System.out.println("...");
			int iscedad = Integer.parseInt(scedad);

			Alumno alumno = new Alumno(scdni, scnombre, scapellidos, iscedad);
			creating(alumno);

			break;

		case 2:
			System.out.println("----------------------------------------");
			System.out.println("Escribe DNI del alumno a eliminar(9 digitos)");
			Scanner sc6 = new Scanner(System.in);
			String deletedni = sc6.nextLine();
			System.out.println("...");

			deleting(deletedni);

			break;

		case 3:
			System.out.println("----------------------------------------");
			System.out.println("Escribe DNI del alumno (9 digitos)");
			Scanner sc10 = new Scanner(System.in);
			String scdni1 = sc10.nextLine();
			System.out.println("...");

			System.out.println("Escribe NOMBRE del alumno");
			Scanner sc11 = new Scanner(System.in);
			String scnombre1 = sc11.nextLine();
			System.out.println("...");

			System.out.println("Escribe APELLIDOS del alumno");
			Scanner sc12 = new Scanner(System.in);
			String scapellidos1 = sc12.nextLine();
			System.out.println("...");

			System.out.println("Escribe EDAD del alumno");
			Scanner sc13 = new Scanner(System.in);
			String scedad1 = sc13.nextLine();
			System.out.println("...");
			int iscedad1 = Integer.parseInt(scedad1);

			updating(scdni1, scnombre1, scapellidos1, iscedad1);

			break;

		case 4:
			readingall();
			break;

		case 5:
			System.out.println("----------------------------------------");
			System.out.println("Escribe DNI del alumno que quieras ver (9 digitos)");
			Scanner sc15 = new Scanner(System.in);
			String scdni2 = sc15.nextLine();
			System.out.println("...");

			readingDNI(scdni2);
			break;

		case 6:
			break;

		default:
			System.out.println("----------------------------------------");
			System.out.println("Esa opcion no esta disponible");
			break;

		}
	};

//CREAR
	private static void creating(Alumno alumno) throws SQLException {
		try {
			alumnoServiceImpl = new AlumnoServiceImpl();
			if (alumnoServiceImpl.create(alumno)) {
				System.out.println("Alumno creado correctamente");
			}

		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
	}

//ELIMINAR
	private static void deleting(String dni) throws SQLException {
		try {
			alumnoServiceImpl = new AlumnoServiceImpl();
			if (alumnoServiceImpl.delete(dni)) {
				System.out.println("Alumno eliminado correctamente");
			}

		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
	}

//ACTUALIZAR
	private static void updating(String dni, String nombre, String apellidos, int edad) throws SQLException {
		try {
			alumnoServiceImpl = new AlumnoServiceImpl();
			if (alumnoServiceImpl.update(dni, nombre, apellidos, edad)) {
				System.out.println("Actualizado con exito");
			}
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
	}

//LISTAR TODXS

	private static void readingall() throws SQLException {
		try {
			alumnoServiceImpl = new AlumnoServiceImpl();
			for (Alumno a : alumnoServiceImpl.findAll()) {
				System.out.println(a);
			}

		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
	}

//BUSCAR POR DNI
	private static void readingDNI(String dni) throws SQLException {
		try {
			Alumno alumno = alumnoServiceImpl.findByDni(dni);
			if (alumno != null) {
				System.out.println(alumno.toString());
			} else {
				System.out.println("El usuario introducido no existe en la base de datos.");
			}

		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
	}
}
