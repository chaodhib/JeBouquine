package be.jebouquine.business.impl;

import java.util.List;

import org.springframework.transaction.annotation.Transactional;

import be.jebouquine.business.interfaces.ICommentBusiness;
import be.jebouquine.dao.interfaces.IBookDAO;
import be.jebouquine.dao.interfaces.IClientDAO;
import be.jebouquine.dao.interfaces.ICommentDAO;
import be.jebouquine.entities.Book;
import be.jebouquine.entities.Client;
import be.jebouquine.entities.Comment;

@Transactional(readOnly = false)
public class CommentBusinessImpl implements ICommentBusiness {

	ICommentDAO commentDAO;
	IBookDAO bookDAO;
	IClientDAO clientDAO;

	public String add(Comment comment) throws Exception {
		if (null == comment.getContent() || comment.getContent().isEmpty()
				|| comment.getContent().trim().isEmpty())
			return NOCONTENT;
		comment.setContent(comment.getContent().trim());

		if (null == comment.getBook())
			return FAILURE;

		if (null == comment.getClient())
			return FAILURE;

		try {
			commentDAO.add(comment);
			return SUCCESS;
		} catch (Exception e) {
			throw new Exception(e);
		}

	}

	public void remove(Comment comment) {
		commentDAO.remove(comment);
	}

	public String modify(Comment comment) throws Exception {
		if (null == comment.getContent() || comment.getContent().isEmpty()
				|| comment.getContent().trim().isEmpty())
			return NOCONTENT;
		comment.setContent(comment.getContent().trim());

		if (null == comment.getBook())
			return FAILURE;

		if (null == comment.getClient())
			return FAILURE;

		try {
			commentDAO.modify(comment);
			return SUCCESS;
		} catch (Exception e) {
			throw new Exception(e);
		}
	}

	public Comment findByID(Integer id) {
		return commentDAO.findByID(id);

	}

	public List<Comment> findByBook(Book book) {
		Book realBook = bookDAO.findByID(book.getId());
		if (null == realBook) {
			return null;
		} else {
			List<Comment> comments = realBook.getComments();
			comments.size();
			return comments;
		}
	}

	public List<Comment> findByClient(Client client) {
		Client realClient = clientDAO.findByID(client.getId());
		if (null == realClient)
			return null;

		return realClient.getComments();
	}

	public ICommentDAO getCommentDAO() {
		return commentDAO;
	}

	public IBookDAO getBookDAO() {
		return bookDAO;
	}

	public IClientDAO getClientDAO() {
		return clientDAO;
	}

	public void setCommentDAO(ICommentDAO commentDAO) {
		this.commentDAO = commentDAO;
	}

	public void setBookDAO(IBookDAO bookDAO) {
		this.bookDAO = bookDAO;
	}

	public void setClientDAO(IClientDAO clientDAO) {
		this.clientDAO = clientDAO;
	}

}
