package converters;

import org.springframework.stereotype.Component;

import dto.ClienteDto;
import dto.CuentaDto;
import dto.MovimientoDto;
import dto.TitularDto;
import model.Cliente;
import model.Cuenta;
import model.Movimiento;
import model.Titular;
import model.TitularPK;

@Component
public class ConversorEntityDtoImpl implements ConversorEntityDto {

	@Override
	public ClienteDto clienteToDto(Cliente cliente) {
		return new ClienteDto(cliente.getDni(), cliente.getNombre(), cliente.getDireccion(), cliente.getTelefono());
	}

	@Override
	public Cliente dtoToCliente(ClienteDto dto) {
		return new Cliente(dto.getDni(), dto.getNombre(), dto.getDireccion(), dto.getTelefono());
	}

	@Override
	public CuentaDto cuentaToDto(Cuenta cuenta) {
		return new CuentaDto(cuenta.getNumeroCuenta(), cuenta.getSaldo(), cuenta.getTipoCuenta());
	}

	@Override
	public Cuenta dtoToCuenta(CuentaDto dto) {
		return new Cuenta(dto.getNumeroCuenta(), dto.getSaldo(), dto.getTipoCuenta());
	}

	@Override
	public MovimientoDto movimientoToDto(Movimiento movimiento) {
		return new MovimientoDto(movimiento.getIdMovimiento(), movimiento.getIdCuenta(), movimiento.getFecha(),
				movimiento.getCantidad(), movimiento.getOperacion());
	}

	@Override
	public Movimiento dtoToMovimiento(MovimientoDto dto) {
		return new Movimiento(dto.getIdCuenta(), dto.getFecha(), dto.getCantidad(),
				dto.getOperacion());
	}

	@Override
	public TitularDto titularToDto(Titular titular) {
		return new TitularDto(clienteToDto(titular.getCliente()), cuentaToDto(titular.getCuenta()));
	}

	@Override
	public Titular dtoToTitular(TitularDto dto) {
		return new Titular(new TitularPK(dto.getCuentaDto().getNumeroCuenta(), dto.getClienteDto().getDni()), null,
				null);
	}

}
