package controller;

import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import dto.CuentaDto;
import dto.MovimientoDto;
import model.Cuenta;
import service.CajeroService;

@CrossOrigin("*")
@Controller
public class CajeroController {

	@Autowired
	CajeroService service;

	private CuentaDto cuenta;

	@PostMapping("Validar")
	public String validarCuenta(@ModelAttribute CuentaDto c, HttpSession session) {
		CuentaDto cAux = service.validarCuenta(c.getNumeroCuenta());
		if (cAux != null) {
			cuenta = cAux;
			return "menu";
		}
		session.setAttribute("error", "El numero de cuenta no existe");
		return "login";
	}

	@GetMapping(value = "Movimientos", produces = MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody List<MovimientoDto> movimientos(
			@RequestParam("fechaIni") @DateTimeFormat(pattern = "yyyy-MM-dd") Date fechaIni,
			@RequestParam("fechaFin") @DateTimeFormat(pattern = "yyyy-MM-dd") Date fechaFin) {
		return service.consultarMovimientos(fechaIni, fechaFin, cuenta);
	}

	@GetMapping(value = "Saldo", produces = MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody double saldo() {
		return service.consultarSaldo(cuenta);
	}

	@PostMapping("Ingresar")
	public String ingresar(@RequestParam("cantidad") double cantidad, HttpSession session) {
		service.ingresarDinero(cantidad, cuenta);
		session.setAttribute("operacion", "Operación realizada con éxito");
		return "menu";
	}

	@PostMapping("Extraer")
	public String extraer(@RequestParam("cantidad") double cantidad, HttpSession session) {
		if (cantidad < cuenta.getSaldo()) {
			service.extraerDinero(cantidad, cuenta);
			session.setAttribute("operacion", "Operación realizada con éxito");
			return "menu";
		} else {
			session.setAttribute("operacion", "ERROR: Saldo insuficiente para poder sacar esa cantidad de dinero");
			return "menu";
		}

	}

	@PostMapping("Transferir")
	public String transferirACuenta(@RequestParam("cuentaTransferencia") int cuentaTransferencia,
			@RequestParam("cantidad") double cantidad, HttpSession session) {
		if (cantidad < cuenta.getSaldo()) {
			CuentaDto cuentaAux = service.validarCuenta(cuentaTransferencia);
			service.transferencia(cuenta, cuentaAux, cantidad);

			session.setAttribute("operacion", "Operación realizada con éxito");
			return "menu";
		} else {
			session.setAttribute("operacion", "ERROR: Saldo insuficiente para poder transferir esa cantidad de dinero");
			return "menu";
		}
	}

}
