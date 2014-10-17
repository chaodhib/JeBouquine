package be.jebouquine.business.interfaces;

import java.util.List;

import be.jebouquine.entities.Editor;

public interface IEditorBusiness {

	public abstract boolean add(Editor editor);

	public abstract boolean remove(Editor editor);

	public abstract boolean modify(Editor editor);

	public abstract List<Editor> findAll();

	public abstract Editor findByID(Integer id);

	public abstract Editor findByName(String name);

}