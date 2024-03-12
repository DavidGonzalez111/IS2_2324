package es.unican.is2.FranquiciasUCBusiness;

import es.unican.is2.FranquiciasUCCommon.*;

public class GestionTiendas implements IGestionTiendas {
	private ITiendasDAO itDAO;

	public GestionTiendas(ITiendasDAO tiendasDAO) {
		this.itDAO = tiendasDAO;
	}

	public Tienda nuevaTienda(Tienda t) throws DataAccessException {
		
		if (itDAO.tiendas().contains(t) == true) {
			return null;
		}
		
		itDAO.tiendas().add(t);
		return t;
	}

	public Tienda eliminarTienda(String nombre) throws OperacionNoValidaException, DataAccessException {
		if (itDAO.tiendaPorNombre(nombre) != null) {
			return itDAO.eliminarTienda(itDAO.tiendaPorNombre(nombre).getId());
		}
		return null;
	}

	public Tienda tienda(String nombre) throws DataAccessException {
		return itDAO.tiendaPorNombre(nombre);
	}
	
}

