package model;

import java.io.Serializable;

import javax.persistence.Embeddable;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@EqualsAndHashCode // implementa lombok los metodos hashCode y equals
@Embeddable
public class TitularPK implements Serializable {

	private int idCuenta;
	private int idCliente;
}
