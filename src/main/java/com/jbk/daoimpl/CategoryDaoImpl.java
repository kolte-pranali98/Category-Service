package com.jbk.daoimpl;

import java.io.FileInputStream;

import javax.persistence.RollbackException;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.jbk.dao.CategoryDao;
import com.jbk.entity.CategoryEntity;
import com.jbk.exception.ResourceAlreadyExistsException;
import com.jbk.exception.SomethingWentWrongException;


@Repository
public class CategoryDaoImpl implements CategoryDao {

	
	@Autowired
	private SessionFactory sessionFactory;

	@Override
	public boolean addCategory(CategoryEntity categoryEntity) {
		
		boolean isAdded = false;
		Session session=null;
		
		FileInputStream fileInputStream=null;
		
		try {
			Transaction transaction;
			session = sessionFactory.openSession();
			
			

			
			CategoryEntity dbEntity = getCategoryByid(categoryEntity.getCategoryid());

			if (dbEntity == null) {
				session.save(categoryEntity); // insert into
				transaction = session.beginTransaction();
				transaction.commit();
				isAdded = true;
				
				//session=null;
			} else {
				throw new ResourceAlreadyExistsException(
						"Category Already Exists with Id : " + categoryEntity.getCategoryid());
			}

		} catch (RollbackException e) {
			e.printStackTrace();
			throw new SomethingWentWrongException("Something went wrong in during add category, check unique fields");
		}finally {
			if(session!=null) {
				session.close();
			}
			
		}

		return isAdded;
	}

	@Override
	public CategoryEntity getCategoryByid(long categoryid) {
		
		CategoryEntity categoryEntity = null;
		try {
			Session session = sessionFactory.openSession();

			categoryEntity = session.get(CategoryEntity.class, categoryid); 
																			
		} catch (HibernateException e) {
			throw new SomethingWentWrongException("Connection Failure");
		}
		return categoryEntity;
	}

	

	@Override
	public boolean updateCategory(CategoryEntity categoryEntity) {
		boolean isUpdated = false;
		try {
			Session session = sessionFactory.openSession();

			CategoryEntity dbCategory = getCategoryByid(categoryEntity.getCategoryid());

			if (dbCategory != null) {
				session.update(categoryEntity);
				session.beginTransaction().commit();
				isUpdated = true;

			} else {
				isUpdated=false;
				//throw new ResourceNotExistsException("Category Not Exists with ID : " + categoryEntity.getCategoryid());
			}

		} 
//		catch (ResourceNotExistsException e) {
//			throw new ResourceNotExistsException("Category Not Exists with ID : " + categoryEntity.getCategoryid());
//		}
		catch (Exception e) {
			throw new SomethingWentWrongException("Something Went Wrong During Update Category");
		}
		return isUpdated;
	}

	
}
