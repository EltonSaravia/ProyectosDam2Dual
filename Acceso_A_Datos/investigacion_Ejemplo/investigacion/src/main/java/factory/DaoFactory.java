package factory;

import dao.InvestigadorDAO;
import dao.ProyectosDAO;
import dao.IDao;


public class DaoFactory {
    
    
    public enum DaoType{
        INVESTIGADOR,
        PROYECTOS
    }
    /**
     * @param daoType recibe el tipo de dao que quieres crear. INVESTIGADOR |     
     * @return una instancia del dao que indicamos
    */
    public static IDao getDao (DaoType daoType){
        IDao dao = null;
        switch (daoType){
            case INVESTIGADOR:
                dao = new InvestigadorDAO();
                break;
            case PROYECTOS:
                dao = new ProyectosDAO();
                break;            
        }
        return dao;
    }
    
}