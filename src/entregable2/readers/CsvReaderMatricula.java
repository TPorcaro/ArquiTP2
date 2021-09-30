package entregable2.readers;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Persistence;

import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVParser;
import org.apache.commons.csv.CSVRecord;

import entregable2.entities.Carrera;
import entregable2.entities.Estudiante;
import entregable2.entities.Matricula;
import entregable2.repositories.CarreraRepositoryImpl;
import entregable2.repositories.EstudianteRepositoryImpl;


public class CsvReaderMatricula implements CsvReaderInterface<Matricula> {

	String file;
	CarreraRepositoryImpl repoCarrera;
	EstudianteRepositoryImpl repoEstudiante;
	public CsvReaderMatricula (String file, CarreraRepositoryImpl repoCarrera,EstudianteRepositoryImpl repoEstudiante) {
		this.file = file;
		this.repoCarrera = repoCarrera;
		this.repoEstudiante = repoEstudiante;
		
	}
	
	@SuppressWarnings("deprecation")
	@Override
	public List<Matricula> readAndGetCsvFile() throws FileNotFoundException, IOException {	
		CSVParser parser = CSVFormat.DEFAULT.withHeader().parse(new FileReader(this.file));
		ArrayList<Matricula> matriculaList = new ArrayList<Matricula>();
		for(CSVRecord row: parser) {
			int estudiante = Integer.parseInt(row.get("estudiante"));
			int carrera = Integer.parseInt(row.get("carrera"));
			String fecha_inicio = row.get("fecha_inicio");
			boolean egresado = false;
			if(Integer.parseInt(row.get("egresado")) == 1) {
				egresado = true;
			}
			Estudiante estudianteForConstructor = this.repoEstudiante.getEstudianteByLibreta(estudiante);
			Carrera carreraForConstructor = this.repoCarrera.getCarreraById(carrera);
			System.out.println(estudianteForConstructor);
			System.out.println(carreraForConstructor);
			Matricula matricula = new Matricula(estudianteForConstructor,carreraForConstructor,Timestamp.valueOf(fecha_inicio),egresado);
			matriculaList.add(matricula);
		}
		return matriculaList;
	}

}
