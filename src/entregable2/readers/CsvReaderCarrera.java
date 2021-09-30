package entregable2.readers;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVParser;
import org.apache.commons.csv.CSVRecord;

import entregable2.entities.Carrera;

public class CsvReaderCarrera implements CsvReaderInterface<Carrera> {

	String file;
	public CsvReaderCarrera (String file) {
		this.file = file;
	}
	@Override
	public List<Carrera> readAndGetCsvFile() throws FileNotFoundException, IOException {
		@SuppressWarnings("deprecation")
		CSVParser parser = CSVFormat.DEFAULT.withHeader().parse(new FileReader(this.file));
		ArrayList<Carrera> carreraList = new ArrayList<Carrera>();
		for(CSVRecord row: parser) {
			int id = Integer.parseInt(row.get("id"));
			String nombre = row.get("nombre");
			Carrera carrera = new Carrera(id,nombre);
			carreraList.add(carrera);
		}
		return carreraList;
	}

}
