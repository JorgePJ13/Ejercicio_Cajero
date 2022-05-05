package model;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "clientes")
public class Cliente {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int dni;
	private String nombre;
	private String direccion;
	private int telefono;
	@ManyToMany()
	@JoinTable(name = "titulares", 
				joinColumns = @JoinColumn(name = "idCliente", referencedColumnName = "dni"), 
				inverseJoinColumns = @JoinColumn(name = "idCuenta", referencedColumnName = "numeroCuenta"))
	List<Cuenta> cuentas;

	public Cliente(int dni, String nombre, String direccion, int telefono) {
		this.dni = dni;
		this.nombre = nombre;
		this.direccion = direccion;
		this.telefono = telefono;
	}
}
