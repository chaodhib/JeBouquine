package be.jebouquine.business.interfaces;

import java.util.List;

import be.jebouquine.entities.Book;
import be.jebouquine.entities.Client;
import be.jebouquine.entities.Comment;

public interface ICommentBusiness {
	
	public static final String NOCONTENT = "no content in the comment";
	public static final String SUCCESS = "success";
	public static final String FAILURE = "failure";
	
	public abstract String add(Comment comment) throws Exception;

	public abstract void remove(Comment comment);

	public abstract String modify(Comment comment) throws Exception;

	public abstract Comment findByID(Integer id);

	public abstract List<Comment> findByBook(Book book);

	public abstract List<Comment> findByClient(Client client);

}