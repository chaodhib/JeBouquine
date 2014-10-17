package be.jebouquine.dao.interfaces;

import java.io.Serializable;

import be.jebouquine.entities.Comment;

public interface ICommentDAO extends IGenericDAO<Comment>{

	public abstract Comment findByID(Serializable id);

}