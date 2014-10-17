package be.jebouquine.controlers;

import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import be.jebouquine.business.interfaces.IClientBusiness;
import be.jebouquine.business.interfaces.ICommentBusiness;
import be.jebouquine.entities.Book;
import be.jebouquine.entities.Comment;

public class FOCommentAction implements SessionAware  {

	private static final String SA_KEY = "sessionAccount";
	private ICommentBusiness commentBusiness;
	private IClientBusiness clientBusiness;
	private Comment comment;
	private boolean emptyComment;
	private boolean noSession;
	private Map<String, Object> session;
	private Book book;

	
	
	public String addComment() {
		if(null == session.get(SA_KEY)){
			noSession = true;
			return "reload";
		}
			
		try {
			Integer idClient = (Integer)session.get(SA_KEY);
			comment.setClient(clientBusiness.findByID(idClient));
			comment.setBook(book);
			
			String result = commentBusiness.add(comment);
			if (result == ICommentBusiness.NOCONTENT){
				emptyComment = true;
				return "reload";
			}
			if (result == ICommentBusiness.FAILURE)
				return "error";
			
			return "success";
		} catch (Exception e) {
			e.printStackTrace();
			return "error";
		}

	}


	public ICommentBusiness getCommentBusiness() {
		return commentBusiness;
	}

	public Comment getComment() {
		return comment;
	}

	public void setCommentBusiness(ICommentBusiness commentBusiness) {
		this.commentBusiness = commentBusiness;
	}

	public void setComment(Comment comment) {
		this.comment = comment;
	}

	public boolean isEmptyComment() {
		return emptyComment;
	}

	public void setEmptyComment(boolean emptyComment) {
		this.emptyComment = emptyComment;
	}

	@Override
	public void setSession(Map<String, Object> session) {
		this.session = session;
	}
	
	public Map<String, Object> getSession() {
		return session;
	}


	public boolean isNoSession() {
		return noSession;
	}


	public Book getBook() {
		return book;
	}


	public void setNoSession(boolean noSession) {
		this.noSession = noSession;
	}


	public void setBook(Book book) {
		this.book = book;
	}

}
