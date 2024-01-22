package app;

import java.util.HashSet;

import dao.IDao;
import factory.DaoFactory;
import tables.Investigador;
import tables.Proyectos;

public class MainApp {

	
	public static void main(String args[]) {
		
		// SECCIÓN INVESTIGADOR
		IDao dao = DaoFactory.getDao(DaoFactory.DaoType.INVESTIGADOR);

		//Creación del investigador. Para crear el registro se vincula con un Set vacío de proyectos
        Investigador inv = new Investigador("Paco",10,"pacoporras@gmail.com","P2+K2","AA","INF","Casa","Friki", new HashSet(0));
        dao.crear(inv);

        //Leer un investigador
        Investigador first_investigator = (Investigador) dao.leer(9);

        
        // SECCIÓN PROYECTOS
        dao = DaoFactory.getDao(DaoFactory.DaoType.PROYECTOS);
        
        // Aprovechamos el investigador recuperado para vincularlo al nuevo proyecto
        Proyectos proyecto = new Proyectos(inv,"PartyGate",1978,"Montomonto");
        dao.crear(proyecto);       
	}
}
