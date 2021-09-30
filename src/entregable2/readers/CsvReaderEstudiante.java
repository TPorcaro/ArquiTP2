package entregable2.readers;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVParser;
import org.apache.commons.csv.CSVRecord;

import entregable2.entities.Estudiante;

public class CsvReaderEstudiante implements CsvReaderInterface<Estudiante> {

	String file;
	public CsvReaderEstudiante (String file) {
		this.file = file;
	}
	@Override
	public List<Estudiante> readAndGetCsvFile() throws FileNotFoundException, IOException {
		@SuppressWarnings("deprecation")
		CSVParser parser = CSVFormat.DEFAULT.withHeader().parse(new FileReader(this.file));
		ArrayList<Estudiante> estudianteList = new ArrayList<Estudiante>();
		for(CSVRecord row: parser) {
			int nmro_libreta = Integer.parseInt(row.get("nmro_libreta"));
			String nombre = row.get("nombre");
			String apellido = row.get("apellido");
			int edad = Integer.parseInt(row.get("edad"));
			String genero = row.get("genero");
			int dni = Integer.parseInt(row.get("dni"));
			String ciudad_residencia = row.get("ciudad_residencia");
			Estudiante estudiante = new Estudiante(nmro_libreta,nombre,apellido,edad,genero,dni,ciudad_residencia);
			estudianteList.add(estudiante);
		}
		return estudianteList;
	}

}
