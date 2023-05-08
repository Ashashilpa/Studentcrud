package dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.transaction.Transaction;


import dto.Student;

public class StudentDao {
	
	EntityManagerFactory e=Persistence.createEntityManagerFactory("dev");
	EntityManager m=e.createEntityManager();
	EntityTransaction t=m.getTransaction();
	public void save(Student student) {
		t.begin();
		m.persist(student);
		t.commit();
	}
	
	public List<Student> fetchAll()
	{
		return m.createQuery("select x from Student x").getResultList();
	}

	public Student find(int id) {
		
		return m.find(Student.class, id);
	}

	 public void delete(int id)
	 {
		 t.begin();
		 m.remove(m.find(Student.class, id));
		 t.commit();
	 }
	 public void update(Student student){
		 t.begin();
		 m.merge(student);
		 t.commit();
	 }
}
