package edu.sjsu.cmpe275.lab2.dao;

import java.io.Serializable;
import java.lang.reflect.ParameterizedType;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import org.springframework.transaction.annotation.Transactional;

@Transactional
public abstract class AbstractDao<PK extends Serializable, T> {
	
	private Class<T> persistentClass;
	
	@PersistenceContext(unitName = "springJPAUnit")
	private EntityManager entityManager;
	
	@SuppressWarnings("unchecked")
	public AbstractDao(){
		this.persistentClass =(Class<T>) ((ParameterizedType) this.getClass().getGenericSuperclass()).getActualTypeArguments()[1];
	}
	
	protected EntityManager getEntityManager(){
		return this.entityManager;
	}
	
	protected void setEntityManager(EntityManager entityManager){
		this.entityManager = entityManager;
	}

	public Class<T> getPersistentClass() {
		return this.persistentClass;
	}
	
	public void setPersistentClass(Class< T > clazzToSet){
		this.persistentClass = clazzToSet;
    }
	
	public T findById(PK id) {
		T entity = (T) this.getEntityManager().find(getPersistentClass(), id);
		return entity;
	}
	
	@SuppressWarnings("unchecked")
	public List<T> findAll() {
		return this.entityManager.createQuery( "from " + this.persistentClass.getName()).getResultList();
	}

	public T save(T entity) {
		this.getEntityManager().persist(entity);
		return entity;
	}
	
	public T update(T entity) {
		T mergedEntity = this.getEntityManager().merge(entity);
		return mergedEntity;
	}
	
	public void deleteById(PK id ){
		T entity = this.findById(id);
      	this.delete(entity);
	}

	public void delete( T entity ){
		this.entityManager.remove( entity );
    }
	
	public void flush() {
		this.getEntityManager().flush();
	}
	
}
