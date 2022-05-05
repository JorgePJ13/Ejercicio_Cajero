package dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import model.Cuenta;
import model.Movimiento;

public interface CuentasDao extends JpaRepository<Cuenta, Integer> {

	// con findById validamos la cuenta ya que el id de Cuenta es: numeroCuenta,
	// no hace falta implementar findByCuenta
}
