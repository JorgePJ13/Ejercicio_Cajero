package service;

import java.util.Date;
import java.util.List;

import dto.CuentaDto;
import dto.MovimientoDto;
import model.Cuenta;
import model.Movimiento;

public interface CajeroService {

	/**
	 * Metodo que valida si la cuenta introducida es correcta
	 * 
	 * @param numeroCuenta: numero de la cuenta en la que se llevan a cabo los
	 *                      movimientos
	 * @return la cuenta validada
	 */
	CuentaDto validarCuenta(int numeroCuenta);

	/**
	 * Metodo que ingresa una determinada cantidad de dinero en la cuenta
	 * 
	 * @param cantidad: el dinero que desea ingresar el usuario
	 * @param cuenta:   la cuenta donde ingresar el dinero
	 */
	void ingresarDinero(double cantidad, CuentaDto cuenta);

	/**
	 * Metodo que extrae una determinada cantidad de dinero de la cuenta
	 * 
	 * @param cantidad: el dinero que desea extraer el usuario
	 * @param cuenta:   la cuenta donde ingresar el dinero
	 */
	void extraerDinero(double cantidad, CuentaDto cuenta);

	/**
	 * Metodo que lleva a cabo la transferencia de dinero a una determinada cuenta destino
	 * @param c: cuenta donde mandar la transferencia
	 * @param cantidad: dinero a enviar
	 * @return true si la transferencia es realizada con éxito; false en caso contrario
	 */
	boolean transferencia(CuentaDto c, CuentaDto transferencia, double cantidad);

	/**
	 * Metodo que devuelve una lista con todos los movimientos habidos en la cuenta
	 * entre dos fechas determinadas
	 * 
	 * @param f1: fecha de inicio de los movimientos
	 * @param f2: fecha de fin de los movimientos
	 * @return la lista de movimientos de la cuenta
	 */
	List<MovimientoDto> consultarMovimientos(Date f1, Date f2, CuentaDto c);
	
	/**
	 * Metodo que muestra el saldo de la cuenta al realizar la consulta de los movimientos
	 * @param c: cuenta donde se mostrara el saldo
	 * @return el saldo que tiene la cuenta
	 */
	double consultarSaldo(CuentaDto c);
}
