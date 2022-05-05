package converters;

import dto.ClienteDto;
import dto.CuentaDto;
import dto.MovimientoDto;
import dto.TitularDto;
import model.Cliente;
import model.Cuenta;
import model.Movimiento;
import model.Titular;

public interface ConversorEntityDto {

	public ClienteDto clienteToDto(Cliente cliente);
	
	public Cliente dtoToCliente(ClienteDto dto);
	
	public CuentaDto cuentaToDto(Cuenta cuenta);
	
	public Cuenta dtoToCuenta(CuentaDto dto);
	
	public MovimientoDto movimientoToDto(Movimiento movimiento);
	
	public Movimiento dtoToMovimiento(MovimientoDto dto);
	
	public TitularDto titularToDto(Titular titular);
	
	public Titular dtoToTitular(TitularDto dto);
}
