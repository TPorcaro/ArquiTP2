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

		ArrayList<Estudiante> estudianteList = (ArrayList<Estudiante>) new CsvReaderEstudiante(
				"./src/filesCsv/Estudiante.csv").readAndGetCsvFile();
		ArrayList<Carrera> carreraList = (ArrayList<Carrera>) new CsvReaderCarrera("./src/filesCsv/Carrera.csv")
				.readAndGetCsvFile();
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
		// ---
//		ArrayList<Carrera> carrerasList = (ArrayList<Carrera>) repoCarrera.getCarrerasWithEstudiantesByCantidadInscriptos();
//		for(Carrera c: carrerasList) {
//			System.out.println(c);
//		}
//		ArrayList<ReporteCarrera> reporteList = (ArrayList<ReporteCarrera>) repoMatricula.generarReporte();
//		for(ReporteCarrera s: reporteList) {
//			System.out.println(s);
//		}

		/**
		 * 2 a) dar de alta un estudiante
		 * 
		 */

//		Estudiante e=new Estudiante (69, "juan", "Pancho", 25, "m", 12121232,"Omal");
//		repoEstudiante.create(e);

		/**
		 * 2 b) matricular un estudiante en una carrera
		 */

//		Carrera c=new Carrera(74,"ciencias");
//		Estudiante e=new Estudiante (55, "Pamela", "Pancho", 22, "f", 12122232,"Omal");
//		repoEstudiante.create(e);
//		repoCarrera.create(c);
//		repoEstudiante.matricularse(e,c);

		/**
		 * 2 c)recuperar todos los estudiantes, y especificar algún criterio de
		 * ordenamiento simple.
		 */

//		ArrayList<Estudiante> estudianteBydni = (ArrayList<Estudiante>) repoEstudiante.getEstudiantesByDni();
//		for(Estudiante s: estudianteBydni) {
//			System.out.println(s);
//		}

		/**
		 * 2 d)recuperar un estudiante, en base a su número de libreta universitaria.
		 */
//		Estudiante a=repoEstudiante.getEstudianteByLibreta(1);
//		System.out.println(a);

		/**
		 * 2 e)recuperar todos los estudiantes, en base a su género.
		 */
//			ArrayList<Estudiante> EstudianteOrd = (ArrayList<Estudiante>) repoEstudiante.getEstudiantesByGenero("m");
//			for(Estudiante s: EstudianteOrd) {
//				System.out.println(s);
//			}

		/**
		 * 2 f)recuperar las carreras con estudiantes inscriptos, y ordenar por cantidad
		 * de inscriptos.
		 */
		// ArrayList<Carrera> car = (ArrayList<Carrera>)
		// repoCarrera.getCarrerasWithEstudiantesByCantidadInscriptos();
		// for (Carrera c : car) {
		// System.out.println(c);
		// }

		/**
		 * 2 g)recuperar los estudiantes de una determinada carrera, filtrado por ciudad
		 * de residencia.
		 */
//			
//		ArrayList<Estudiante> carrerasList = (ArrayList<Estudiante>) repoEstudiante.getEstudiantesByCarreraAndCiudad(1,"Yorkton");
//		for(Estudiante c: carrerasList) {
//			System.out.println(c);
//		}

	}

}
