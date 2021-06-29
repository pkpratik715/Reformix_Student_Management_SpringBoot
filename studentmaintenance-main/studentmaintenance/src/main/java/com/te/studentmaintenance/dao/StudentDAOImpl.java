package com.te.studentmaintenance.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.PersistenceUnit;
import javax.persistence.Query;

import org.springframework.stereotype.Repository;

import com.te.studentmaintenance.bean.StudentBean;

@Repository
public class StudentDAOImpl implements StudentDAO {
	EntityManager entityManager = null;
	EntityTransaction transaction = null;

	@PersistenceUnit
	private EntityManagerFactory factory;

	@Override
	public StudentBean getStudent(int user_Id) {
		entityManager = factory.createEntityManager();

		StudentBean studentBean = entityManager.find(StudentBean.class, user_Id);
		return studentBean;
	}

	@Override
	public boolean deleteStudent(int user_Id) {
		entityManager = factory.createEntityManager();
		transaction = entityManager.getTransaction();
		try {
			transaction.begin();
			StudentBean bean = entityManager.find(StudentBean.class, user_Id);
			if (bean != null) {
				entityManager.remove(bean);
				transaction.commit();
				return true;
			} else {
				return false;
			}
		} catch (Exception e) {
			e.printStackTrace();
			return false;

		}
	}

	@Override
	public List<StudentBean> getAllStudents() {
		entityManager = factory.createEntityManager();

		String data = " from StudentBean ";
		Query query = entityManager.createQuery(data);

		List<StudentBean> bean = query.getResultList();

		return bean;

	}

	@Override
	public boolean addStudent(StudentBean bean) {
		entityManager = factory.createEntityManager();
		transaction = entityManager.getTransaction();

		try {
			if (bean != null) {
				transaction.begin();
				entityManager.persist(bean);
				transaction.commit();
				return true;
			} else {
				return false;
			}

		} catch (Exception e) {
			if (transaction != null) {
				transaction.rollback();
			}

			e.printStackTrace();
		} finally {
			if (entityManager != null) {
				entityManager.close();
			}
		}
		return false;
	}

	@Override
	public boolean updateStudent(StudentBean bean) {
		entityManager = factory.createEntityManager();
		transaction = entityManager.getTransaction();
		boolean isUpdated = false;

		try {
			transaction.begin();
			StudentBean info = entityManager.find(StudentBean.class, bean.getUser_Id());
			if (bean.getName() != null && bean.getName() != "") {
				info.setName(bean.getName());
			}

			if (bean.getMarks() != 0.0) {
				info.setMarks(bean.getMarks());
			}

			if (bean.getEmail() != null && bean.getEmail() != "") {
				info.setEmail(bean.getEmail());
			}

			if (bean.getGrade() != null && bean.getGrade() != "") {
				info.setGrade(bean.getGrade());
			}

			transaction.commit();
			isUpdated = true;
		} catch (Exception e) {

			e.printStackTrace();
		}

		return isUpdated;
	}

}
