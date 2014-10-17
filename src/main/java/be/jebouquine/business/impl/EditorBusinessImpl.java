package be.jebouquine.business.impl;

import java.util.List;

import org.springframework.transaction.annotation.Transactional;

import be.jebouquine.business.interfaces.IEditorBusiness;
import be.jebouquine.dao.interfaces.IEditorDAO;
import be.jebouquine.entities.Editor;

@Transactional(readOnly = false)
public class EditorBusinessImpl implements IEditorBusiness {
	private IEditorDAO EditorDAO;

	// -------------------------------------------------------------------
	public IEditorDAO getEditorDAO() {
		return EditorDAO;
	}

	public void setEditorDAO(IEditorDAO language) {
		this.EditorDAO = language;
	}
	// -------------------------------------------------------------------

	@Override
	public boolean add(Editor editor) {
		try {
			if(editor.getName().length()>255)
				throw new Exception();
			editor.setName(editor.getName().trim());
			EditorDAO.add(editor);
			return true;
		} catch (Exception e) {
			return false;
		}
	}

	@Override
	public boolean remove(Editor editor) {
		try {
			EditorDAO.remove(editor);
			return true;
		} catch (Exception e) {
			return false;
		}
	}

	@Override
	public boolean modify(Editor editor) {
		try {
			if(editor.getName().length()>255)
				throw new Exception();
			editor.setName(editor.getName().trim());
			EditorDAO.modify(editor);
			return true;
		} catch (Exception e) {
			return false;
		}
	}

	@Override
	public List<Editor> findAll() {
		List<Editor> editors = null;
		try { 
			editors = EditorDAO.findAll();
			return editors;
		} catch (Exception e) {
			return editors;
		}
	}

	public Editor findByID(Integer id){
		Editor editor = null;
		try {
			editor = EditorDAO.findByID(id);
			return editor;
		} catch (Exception e) {
			return editor;
		}
	}

	@Override
	public Editor findByName(String name) {
		return EditorDAO.findByName(name);
	}
}
