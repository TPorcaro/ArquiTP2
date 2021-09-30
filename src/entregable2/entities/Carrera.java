package entregable2.entities;

import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Carrera {
	@Id
	int idCarrera;
	@Column
	String nombre;
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Carrera other = (Carrera) obj;
		return Objects.equals(nombre, other.nombre);
	}
	
	public Carrera() {
		super();
	}
	public Carrera(int id, String nombre) {
		super();
		this.idCarrera = id;
		this.nombre = nombre;
	}

	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public int getId() {
		return idCarrera;
	}

	@Override
	public String toString() {
		return "Carrera [nombre=" + nombre + "]";
	}
	
	
}
