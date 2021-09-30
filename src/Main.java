import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import entregable2.DTO.ReporteCarrera;
import entregable2.entities.Carrera;
import entregable2.entities.Estudiante;
import entregable2.entities.Matricula;
import entregable2.readers.CsvReaderCarrera;
import entregable2.readers.CsvReaderEstudiante;
import entregable2.readers.CsvReaderMatricula;
import entregable2.repositories.CarreraRepositoryImpl;
import entregable2.repositories.EstudianteRepositoryImpl;
import entregable2.repositories.MatriculaRepositoryImpl;

public class Main {

	public static void main(String[] args) throws FileNotFoundException, IOException {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("ddbbentregable2");
		EstudianteRepositoryImpl repoEstudiante = new EstudianteRepositoryImpl(emf.createEntityManager());
		CarreraRepositoryImpl repoCarrera = new CarreraRepositoryImpl(emf.createEntityManager());
		MatriculaRepositoryImpl repoMatricula = new MatriculaRepositoryImpl(emf.createEntityManager());
		
		ArrayList<Estudiante> estudianteList = (ArrayList<Estudiante>) new CsvReaderEstudiante("./src/filesCsv/Estudiante.csv").readAndGetCsvFile();
		ArrayList<Carrera> carreraList = (ArrayList<Carrera>) new CsvReaderCarrera("./src/filesCsv/Carrera.csv").readAndGetCsvFile();
//		System.out.print("-----------------");
//		for(Estudiante e: estudianteList) {
//			repoEstudiante.create(e);
//		}
//		System.out.print("-----------------");
//		for(Carrera e: carreraList) {
//			repoCarrera.create(e);
//		}
//		ArrayList<Matricula> matriculaList = (ArrayList<Matricula>) new CsvReaderMatricula("./src/filesCsv/Matricula.csv",repoCarrera,repoEstudiante).readAndGetCsvFile();
//		System.out.print("-----------------");
//		for(Matricula e: matriculaList) {
//			repoMatricula.create(e);
//		}
		ArrayList<Carrera> carrerasList = (ArrayList<Carrera>) repoCarrera.getCarrerasWithEstudiantesByCantidadInscriptos();
		for(Carrera c: carrerasList) {
			System.out.println(c);
		}
		ArrayList<ReporteCarrera> reporteList = (ArrayList<ReporteCarrera>) repoMatricula.generarReporte();
		for(ReporteCarrera s: reporteList) {
			System.out.println(s);
		}

	}

}
