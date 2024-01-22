package dao;

import java.util.HashSet;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import tables.Investigador;
import utils.HibernateUtil;

public class InvestigadorDAO implements IDao<Investigador, Integer>{

	@Override
	public boolean crear(Investigador inv) {
		try (Session session = HibernateUtil.getSessionFactory().openSession()){
			Transaction tx = session.beginTransaction();
			
			session.persist(inv);
			tx.commit();	
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}

	@Override
	public Investigador leer(Integer invId) {
		Investigador inv = null;
		try (Session session = HibernateUtil.getSessionFactory().openSession()){
			String hql = "from Investigador where invId= :invId" ;
	        Query query = session.createQuery(hql);
	        query.setParameter("invId", invId);
	        query.setMaxResults(1);
			inv = (Investigador)  query.getSingleResult();					
		} catch (Exception e) {
			e.printStackTrace();
		}		
		return inv;	
	}

	@Override
	public boolean actualizar(Investigador modelo, Integer id) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean eliminar(Integer id) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public List<Investigador> listar() {
		// TODO Auto-generated method stub
		return null;
	}

}
