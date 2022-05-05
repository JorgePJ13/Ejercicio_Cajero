package service;

import java.sql.Timestamp;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import converters.ConversorEntityDto;
import dao.CuentasDao;
import dao.MovimientosDao;
import dto.CuentaDto;
import dto.MovimientoDto;
import model.Cuenta;
import model.Movimiento;

@Service
public class CajeroServiceImpl implements CajeroService {

	@Autowired
	ConversorEntityDto conversor;

	CuentasDao cuentasDao;

	MovimientosDao movimientosDao;

	public CajeroServiceImpl(@Autowired CuentasDao cuentasDao, @Autowired MovimientosDao movimientosDao) {
		super();
		this.cuentasDao = cuentasDao;
		this.movimientosDao = movimientosDao;
	}

	@Override
	public CuentaDto validarCuenta(int numeroCuenta) {
		Optional<Cuenta> cuenta = cuentasDao.findById(numeroCuenta);
		if (cuenta.isPresent()) {
			return conversor.cuentaToDto(cuenta.get());
		} else {
			return null;
		}
	}

	@Transactional
	@Override
	public void ingresarDinero(double cantidad, CuentaDto cuenta) {
		cuenta.setSaldo(cuenta.getSaldo() + cantidad);
		conversor.cuentaToDto(cuentasDao.save(conversor.dtoToCuenta(cuenta)));
		// save lleva objeto Cuenta, entonces se emplea el conversor dtoToCuenta
		Long fecha = System.currentTimeMillis();
		Timestamp timestamp = new Timestamp(fecha);
		movimientosDao.save(new Movimiento(cuenta.getNumeroCuenta(), timestamp, cantidad, "ingreso"));
	}

	@Transactional
	@Override
	public void extraerDinero(double cantidad, CuentaDto cuenta) {
		cuenta.setSaldo(cuenta.getSaldo() - cantidad);
		conversor.cuentaToDto(cuentasDao.save(conversor.dtoToCuenta(cuenta))); 
		// save lleva objeto Cuenta, entonces se emplea el conversor dtoToCuenta
		Long fecha = System.currentTimeMillis();
		Timestamp timestamp = new Timestamp(fecha);
		movimientosDao.save(new Movimiento(cuenta.getNumeroCuenta(), timestamp, cantidad, "extracción"));
	}

	@Transactional
	@Override
	public boolean transferencia(CuentaDto cOrigen, CuentaDto cDestino, double cantidad) {
		if(cOrigen.getSaldo() > 0) {
			extraerDinero(cantidad, cOrigen); // primero extraemos dinero de la cuenta origen
			ingresarDinero(cantidad, cDestino); // segundo ingresamos dinero en la cuenta destino
			return true;
		} else {
			return false;
		}
		
	}

	@Override
	public List<MovimientoDto> consultarMovimientos(Date f1, Date f2, CuentaDto c) {
		return movimientosDao.findByBetweenDate(c.getNumeroCuenta(), f1, f2).stream().map(m -> conversor.movimientoToDto(m))
				.collect(Collectors.toList());
	}

	@Override
	public double consultarSaldo(CuentaDto c) {
		return c.getSaldo();
	}

}
