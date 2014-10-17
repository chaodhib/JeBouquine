package be.jebouquine.dao.impl;

import java.io.Serializable;
import java.util.List;

import be.jebouquine.dao.interfaces.ICategoryDAO;
import be.jebouquine.entities.Category;

public class CategoryDAOImpl extends GenericDAOImpl<Category> implements
		ICategoryDAO {

	@Override
	public void add(Category category) throws Exception {
		if (null == category)
			throw new NullPointerException();
		if (findByName(category.getName())!=null)
			throw new Exception("The Category Already Exists");
		if (!category.getName().isEmpty())
			super.add(category);
	}

	@Override
	public void remove(Category category) {
		Category trueCategory = findByID(category.getId());
		this.sessionFactory.getCurrentSession().delete(trueCategory);
	}

	@Override
	public void modify(Category category) throws Exception {
		Category cat = findByID(category.getId());
		//Cas où la personne n'a rien changé
		if (cat.equals(category))
			return;
			
		// Check d'un éventuel conflit au niveau des noms
		if(findByName(category.getName())!=null && cat!=findByName(category.getName()))
				throw new Exception("The Category Already Exists");

		cat.setName(category.getName());
		this.sessionFactory.getCurrentSession().saveOrUpdate(cat);
	}

	public List<Category> findAll() {
		return super.findAll(Category.class);
	}

	public Category findByID(Serializable id) {
		return (Category) sessionFactory.getCurrentSession().get(
				Category.class, id);
	}

	@SuppressWarnings("unchecked")
	@Override
	public Category findByName(String name) {
		List<Category> list=sessionFactory.getCurrentSession()
		.createQuery("from Category where name ='" + name + "'").list();
		if(list.size()==1)
			return list.get(0);
		else if(list.size()==0)
			return null;
		else
			throw new RuntimeException("Doublon dans les catégories");
	}
}
