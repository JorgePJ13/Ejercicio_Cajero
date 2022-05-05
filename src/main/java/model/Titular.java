package model;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
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
@Table(name = "titulares")
public class Titular {

	@EmbeddedId
	private TitularPK id;
	
	@ManyToOne
	@JoinColumn(name = "idCliente", referencedColumnName = "dni", insertable = false, updatable = false)
	Cliente cliente;
	
	@ManyToOne
	@JoinColumn(name = "idCuenta", referencedColumnName = "numeroCuenta", insertable = false, updatable = false)
	Cuenta cuenta;

	public Titular(Cliente cliente, Cuenta cuenta) {
		super();
		this.cliente = cliente;
		this.cuenta = cuenta;
	}
	
	
}
