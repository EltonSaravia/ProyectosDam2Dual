package dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;

import tables.Proyectos;
import utils.HibernateUtil;

public class ProyectosDAO  implements IDao<Proyectos, Integer> {

	@Override
	public boolean crear(Proyectos proy) {
		try (Session session = HibernateUtil.getSessionFactory().openSession()){
			Transaction tx = session.beginTransaction();
			//Proyectos proy = new Proyectos(inv, nombre, fechaPub, monto);
			session.persist(proy);
			tx.commit();
			return true;
			
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}

	@Override
	public Proyectos leer(Integer id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean actualizar(Proyectos modelo, Integer id) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean eliminar(Integer id) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public List<Proyectos> listar() {
		// TODO Auto-generated method stub
		return null;
	}

}
