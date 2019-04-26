package com.xworkz.spring.dao;

import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import com.xworkz.spring.dto.PostOfficeDTO;
@Service
@Component
public class PostOfficeDAO {

	@Autowired
	private SessionFactory factory = null;

	public Integer save(PostOfficeDTO dto) {
		Session session = null;
		try {
			System.out.println("saving post office");
			session = factory.openSession();
			Transaction transaction = session.beginTransaction();
			Integer id = (Integer) session.save(dto);
			transaction.commit();
			return id;
		} catch (HibernateException e) {
			e.printStackTrace();
		} finally {

			session.close();
		}
		return null;

	}
	public List<PostOfficeDTO>fetchByPincode(int pincode) {
		System.out.println("invoked a fetchByPincode");
		Session session=null;
		String hqlQuery="select dto from PostOfficeDTO dto where pincode='"+pincode+"'";
		try {
			session=factory.openSession();
			Query query=session.createQuery(hqlQuery);
			List<PostOfficeDTO> dtos=query.list();
			return dtos;
			
		} catch (HibernateException e) {

			e.printStackTrace();
		} finally {

		}
		return null;
	}

/*	@Override
	public List<PostOfficeDTO> fetchByAll() {
		System.out.println("Invoked fetch method");
		Session session=null;
		
		try {
			String hqlQuery="select dto from PostOfficeDTO dto";
			session=factory.openSession();
			 Query query=session.createQuery(hqlQuery);
			 List<PostOfficeDTO> dto=(List<PostOfficeDTO>) query.list();
			
			 return dto;
		} catch (HibernateException e) {
			e.printStackTrace();
		} finally {
		}
		return null;
	}*/

	// hibenate delete operation using spring
	/*
	 * @Override public Integer deleteByPincode(int pincode) {
	 * System.out.println("invoked delete method\t"+pincode); String hqlQuery=
	 * "delete from PostOfficeDTO dto where dto.pincode='"+pincode+"'"; Session
	 * session=null; Transaction transaction = null; try {
	 * session=factory.openSession(); transaction=session.beginTransaction();
	 * Query query=session.createQuery(hqlQuery); Integer
	 * id=query.executeUpdate(); transaction.commit(); return id; } catch
	 * (Exception e) { transaction.rollback(); e.printStackTrace(); } finally {
	 * session.close(); } return null;
	 * 
	 * }
	 */
	
	 
	/*
	 * @Override public Integer updateByPincode(int pincode, String branchName)
	 * { System.out.println("updating post office"); String hqlQuery=
	 * "update PostOfficeDTO dto set dto.branchName='"+branchName+
	 * "' where dto.pincode='"+pincode+"'"; Session session=null; Transaction
	 * transaction=null; try { session=factory.openSession();
	 * transaction=session.beginTransaction(); Query
	 * query=session.createQuery(hqlQuery); Integer id=query.executeUpdate();
	 * transaction.commit(); return id; } catch (HibernateException e) {
	 * transaction.rollback(); e.printStackTrace(); } finally { session.close();
	 * } return null; }
	 */

	

}
