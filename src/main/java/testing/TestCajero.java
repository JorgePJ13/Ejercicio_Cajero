package testing;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Calendar;
import java.util.Date;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import config.ServiceConfig;
import dto.CuentaDto;
import model.Cuenta;
import service.CajeroService;

@ExtendWith(SpringExtension.class)
@ContextConfiguration(classes = { ServiceConfig.class })
public class TestCajero {

	@Autowired
	CajeroService service;

	@Test
	void testValidarCuenta() {
		assertNotNull(service.validarCuenta(1000));
		assertNotNull(service.validarCuenta(1234));
		assertNull(service.validarCuenta(4312));
	}

	@Test
	void testIngresarDinero() {
		CuentaDto c = new CuentaDto(3000, 670, "recibos");
		service.ingresarDinero(30, c);
		assertEquals(700, service.consultarSaldo(c));
	}

	@Test
	void testExtraerDinero() {
		CuentaDto c = new CuentaDto(4000, 880, "ahorro");
		service.extraerDinero(80, c);
		assertEquals(800, service.consultarSaldo(c));
	}

	@Test
	void testTransferencia() {
		CuentaDto cOrigen = new CuentaDto(5000, 6700, "recibos");
		CuentaDto cDestino = new CuentaDto(1234, 570, "prueba2");
		service.transferencia(cOrigen, cDestino, 100);
		assertEquals(6600, service.consultarSaldo(cOrigen));
		assertEquals(670, service.consultarSaldo(cDestino));
	}

	@Test
	void testConsultarSaldo() {
		CuentaDto c = new CuentaDto(2000, 12900, "ahorro");
		assertEquals(12900, service.consultarSaldo(c));
	}

	@Test
	void testConsultarMovimientos() {
		CuentaDto cuenta = new CuentaDto(1000, 500, "ahorro");

		Calendar c1 = Calendar.getInstance();
		Calendar c2 = Calendar.getInstance();

		c1.set(2020, 1, 1);
		c2.set(2022, 2, 28);

		Date d1 = c1.getTime();
		Date d2 = c2.getTime();

		assertEquals(11, service.consultarMovimientos(d1, d2, cuenta).size());
	}
}
