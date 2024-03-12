package es.unican.is2.FranquiciasUCBusiness;



import es.unican.is2.FranquiciasUCCommon.*;

public class GestionEmpleados implements IGestionEmpleados{
	
	
	private IEmpleadosDAO ieDAO;
	private ITiendasDAO itDAO;

	public GestionEmpleados(ITiendasDAO tiendasDAO, IEmpleadosDAO empleadosDAO) {
		
		this.ieDAO = empleadosDAO;
		this.itDAO = tiendasDAO;
	}
	

	public Empleado nuevoEmpleado(Empleado empleado, String nombre) throws OperacionNoValidaException, DataAccessException {
		Tienda tienda = itDAO.tiendaPorNombre(nombre);
		
		if (tienda == null) {
			return null;
		}
		
		if (tienda.getEmpleados().contains(empleado) == true) {
			throw new OperacionNoValidaException("Este empleado ya se encuentra en la tienda");
		}
		tienda.getEmpleados().add(empleado);
		
		
		return empleado;
	}

	public Empleado eliminarEmpleado(String dni, String nombre) throws OperacionNoValidaException, DataAccessException {
		Tienda tienda = itDAO.tiendaPorNombre(nombre);
		Empleado empleado = ieDAO.empleado(dni);
		
		if (tienda == null || empleado == null) {
			return null;
		}
		if (tienda.getEmpleados().contains(empleado) == false) {
			throw new OperacionNoValidaException("El empleado no esta en esta tienda");
		}
		tienda.getEmpleados().remove(empleado);
		
		
		return empleado;
	}

	public boolean trasladarEmpleado(String dni, String actual, String destino)
			throws OperacionNoValidaException, DataAccessException {
		
		Empleado empleado = eliminarEmpleado(dni, actual);
		
		if (nuevoEmpleado(empleado, destino) != null) {
			return true;
		}
		
		return false;
	}

	public Empleado empleado(String dni) throws DataAccessException {
		
		return ieDAO.empleado(dni);
	}

}

