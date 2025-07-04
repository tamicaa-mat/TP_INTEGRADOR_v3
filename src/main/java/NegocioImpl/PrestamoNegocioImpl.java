package NegocioImpl;

import Negocio.PrestamoNegocio;
import dao.PrestamoDao;
import dominio.Prestamo;
import dominio.Usuario;


public class PrestamoNegocioImpl implements PrestamoNegocio	{
	
	//private PrestamoDao prestamoDao = new PrestamoDaoImpl(); 
	
	
	private PrestamoDao prestamoDao;

	public PrestamoNegocioImpl(PrestamoDao prestamoDao) {
	    this.prestamoDao = prestamoDao;
	}

	

	    @Override
	    public boolean solicitarPrestamo(Usuario usuario, Prestamo prestamo) {
	        if (usuario != null && prestamo != null) {
	            return prestamoDao.insert(prestamo); // llamás al DAO
	        }
	        return false;
	    }

	    @Override
	    public boolean actualizarEstadoPrestamo(int idPrestamo) {
	   
	        return false;
	    }

	    @Override
	    public boolean eliminarPrestamo(int idPrestamo) {
	        return false; //  prestamoDao.delete(idPrestamo) 
	    }

	    public boolean pagarPrestamo(int idPrestamo, double montoPago) {
	    	   Prestamo prestamo = prestamoDao.getPrestamoPorId(idPrestamo); 
	    	    if (prestamo != null && montoPago > 0) {
	    	        double nuevoSaldo = prestamo.getImportePedido() - montoPago;

	    	        if (nuevoSaldo >= 0) {
	    	            return prestamoDao.actualizarImportePedido(idPrestamo, nuevoSaldo);
	    	        }
	    	    }
	    	    return false;
	
}
	    
}
