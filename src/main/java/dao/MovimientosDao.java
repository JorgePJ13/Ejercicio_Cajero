package dao;

import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import model.Movimiento;

public interface MovimientosDao extends JpaRepository<Movimiento, Integer> {

	/**
	 * Metodo que devuelve una lista de todos los movimientos habidos en una cuenta entre dos fechas determinadas
	 * 
	 * @param f1: fecha de inicio de movimientos de la cuenta
	 * @param f2: fecha de fin de los movimientos de la cuenta
	 * @return la lista con todos los movimientos entre esas dos fechas dadas
	 */
	@Query("select m from Movimiento m where m.idCuenta=?1 and m.fecha between ?2 and ?3")
	List<Movimiento> findByBetweenDate(int idCuenta, Date f1, Date f2);
}
