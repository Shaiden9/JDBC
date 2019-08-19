package es.eoi.jdbc.service;

import java.sql.SQLException;
import java.util.List;

import es.eoi.jdbc.entity.Alumno;
import es.eoi.jdbc.repository.AlumnoRepositoryImpl;

public class AlumnoServiceImpl implements AlumnoService{
	private AlumnoRepositoryImpl miRepositorio;

	public AlumnoServiceImpl() {
		this.miRepositorio = new AlumnoRepositoryImpl();
	}
	
	public boolean create(Alumno alumno) throws SQLException {
		return this.miRepositorio.create(alumno);
	}
	
	public boolean delete(String dni) throws SQLException {
		return this.miRepositorio.delete(dni);
	}
	
	public boolean update(String dni, String nombre, String apellidos, int edad) throws SQLException {
		return this.miRepositorio.update(dni, nombre, apellidos, edad);
	}	
	
	public List<Alumno> findAll() throws SQLException {
		return this.miRepositorio.findAll();
	}

	public Alumno findByDni(String dni) throws SQLException {
		return this.miRepositorio.findByDni(dni);
	}

	
}
