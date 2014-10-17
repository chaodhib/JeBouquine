package be.jebouquine.dao.impl;

import java.io.Serializable;

import be.jebouquine.dao.interfaces.ICommentDAO;
import be.jebouquine.entities.Comment;
import be.jebouquine.exceptions.JeBouquineException;

public class CommentDAOImpl extends GenericDAOImpl<Comment> implements ICommentDAO {

	
	public void add(Comment object) throws Exception{
		super.add(object);
		
	}
	
	@Override
	public void remove(Comment object) {
		Comment trueComment = findByID(object.getId());
		this.sessionFactory.getCurrentSession().delete(trueComment);
	}

	@Override
	public void modify(Comment object) throws Exception {
		Comment originalComment = findByID(object.getId());
		
		if(!originalComment.getBook().equals(object.getBook()))
			throw new JeBouquineException("DAO: can't transfer comment to other book");
	
		if(!originalComment.getClient().equals(object.getClient()))
			throw new JeBouquineException("DAO: can't transfer comment to other client");
	
		originalComment.setContent(object.getContent());
		this.sessionFactory.getCurrentSession().saveOrUpdate(originalComment);
	}

	public Comment findByID(Serializable id) {
		return (Comment) super.findByID(Comment.class, id);
	}
	
	
}
