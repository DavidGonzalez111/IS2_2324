package es.unican.is2.FranquiciasUCMain;

import es.unican.is2.FranquiciasUCBusiness.GestionEmpleados;
import es.unican.is2.FranquiciasUCBusiness.GestionTiendas;
import es.unican.is2.FranquiciasUCDAO.EmpleadosDAO;
import es.unican.is2.FranquiciasUCDAO.TiendasDAO;
import es.unican.is2.FranquiciasUCGUI.VistaGerente;

/**
 * Clase principal que construye la aplicación de tres capas y lanza su ejecución
 */
public class Runner {

	public static void main(String[] args) {
		// Crear componentes capa DAO
		TiendasDAO tiendasDAO = new TiendasDAO();
		EmpleadosDAO empleadosDAO = new EmpleadosDAO();
		
		// Crear componentes capa negocio
		GestionTiendas gTiendas = new GestionTiendas(tiendasDAO);
		GestionEmpleados gEmpleados = new GestionEmpleados(tiendasDAO, empleadosDAO);
		
		// Crear componentes capa presentacion
		VistaGerente vista = new VistaGerente(gTiendas, gEmpleados);
		
		// Lanzar ejecución (hacer visible la interfaz)
		vista.setVisible(true);
		
	
		
	}

}
