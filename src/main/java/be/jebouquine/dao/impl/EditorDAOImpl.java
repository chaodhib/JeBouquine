package be.jebouquine.dao.impl;

import java.io.Serializable;
import java.util.List;

import be.jebouquine.dao.interfaces.IEditorDAO;
import be.jebouquine.entities.Editor;

public class EditorDAOImpl extends GenericDAOImpl<Editor> implements IEditorDAO {

	@Override
	public void add(Editor editor) throws Exception {
		if (null == editor)
			throw new NullPointerException();
		if (findByName(editor.getName())!=null)
			throw new Exception("The Publisher Already Exists");
		if (!editor.getName().isEmpty())
			super.add(editor);
	}

	@Override
	public void remove(Editor editor) {
		Editor trueEditor = findByID(editor.getId());
		this.sessionFactory.getCurrentSession().delete(trueEditor);
	}

	@Override
	public void modify(Editor editor) throws Exception {
		Editor edi = findByID(editor.getId());
		//Cas où la personne n'a rien changé
		if (edi.equals(editor))
			return;
		
		// Check d'un éventuel conflit au niveau des noms
		Editor sameName=findByName(editor.getName());
		if(sameName!=null && edi!=sameName)
				throw new Exception("The Category Already Exists");

		edi.setName(editor.getName());
		this.sessionFactory.getCurrentSession().saveOrUpdate(edi);
	}

	public List<Editor> findAll() {
		return super.findAll(Editor.class);
	}

	public Editor findByID(Serializable id) {
		return (Editor) super.findByID(Editor.class, id);
	}
	
	
	@SuppressWarnings("unchecked")
	public Editor findByName(String name){
		List<Editor> list=sessionFactory.getCurrentSession()
		.createQuery("from Editor where name ='" + name + "'").list();
		if(list.size()==1)
			return list.get(0);
		else if(list.size()==0)
			return null;
		else
			throw new RuntimeException("Doublon dans les éditeurs");
	}
}
