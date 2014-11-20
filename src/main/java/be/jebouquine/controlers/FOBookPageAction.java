package be.jebouquine.controlers;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import be.jebouquine.business.interfaces.IBookBusiness;
import be.jebouquine.business.interfaces.IClientBusiness;
import be.jebouquine.business.interfaces.ICommentBusiness;
import be.jebouquine.entities.Book;
import be.jebouquine.entities.Comment;
import be.jebouquine.modelview.SessionAccount;

import com.opensymphony.xwork2.Action;

public class FOBookPageAction implements Action, SessionAware {


	private IBookBusiness bookBusiness;
	private ICommentBusiness commentBusiness;
	private Book book;


	
	// Action Method 1
	private Integer bookId;

	
	@Override
	public String execute() {
		try {
//			Integer bookId = Integer.parseInt(bookIdInput);
			prepareBookPage(bookId);// cette methode va peupler l'objet book qui sera disponible pour la page suivante
			return SUCCESS;
		} catch (Exception e) {
			return ERROR;
		}
	}
	
	// Action Method 2
	
	//Pour l'ajout de commentaires
	private IClientBusiness clientBusiness;
	private Map<String, Object> session;
	private static final String SA_KEY = "sessionAccount";
	
	private Comment commentToAdd;	
	private List<Comment> comments;
	
	public String addCommentAndRefresh() {
		try {
			SessionAccount sa = (SessionAccount)session.get(SA_KEY);
			if(null == sa)
				return ERROR;
			
			book=bookBusiness.findByID(bookId);
			commentToAdd.setBook(book);
			Integer idClient=sa.getId();
			commentToAdd.setClient(clientBusiness.findByID(idClient));
			
			String result = commentBusiness.add(commentToAdd);
			if (result == ICommentBusiness.NOCONTENT && result == ICommentBusiness.FAILURE){
				return ERROR;
			}
			else{ // refait le job de l'action View pour refresh la fiche du livre
				prepareBookPage(bookId);
				
				return SUCCESS;
			}
				
		} catch (Exception e) {
			e.printStackTrace();
			return ERROR;
		}

	}
	
	// Private Method 1
	private List<Integer> qttChoice;
	
	private void prepareBookPage(Integer bookId) throws Exception{
		book=bookBusiness.findByID(bookId);
		if(book==null)
			throw new Exception();
		if(null != commentBusiness.findByBook(book))
			setComments(commentBusiness.findByBook(book));
		qttChoice=new ArrayList<Integer>();
		for(int i=1; i<=30 ; i++)
			qttChoice.add(i);
	}


	public final IBookBusiness getBookBusiness() {
		return bookBusiness;
	}

	public final void setBookBusiness(IBookBusiness bookBusiness) {
		this.bookBusiness = bookBusiness;
	}

	public Book getBook() {
		return book;
	}


	public void setBook(Book book) {
		this.book = book;
	}


	public List<Integer> getQttChoice() {
		return qttChoice;
	}


	public void setQttChoice(List<Integer> qttChoice) {
		this.qttChoice = qttChoice;
	}


	public List<Comment> getComments() {
		return comments;
	}


	public void setComments(List<Comment> comments) {
		this.comments = comments;
	}


	public ICommentBusiness getCommentBusiness() {
		return commentBusiness;
	}


	public void setCommentBusiness(ICommentBusiness commentBusiness) {
		this.commentBusiness = commentBusiness;
	}
	
	@Override
	public void setSession(Map<String, Object> session) {
		this.session = session;
	}
	
	public Map<String, Object> getSession() {
		return session;
	}


	public Comment getCommentToAdd() {
		return commentToAdd;
	}

	public void setCommentToAdd(Comment commentToAdd) {
		this.commentToAdd = commentToAdd;
	}

	public IClientBusiness getClientBusiness() {
		return clientBusiness;
	}



	public void setClientBusiness(IClientBusiness clientBusiness) {
		this.clientBusiness = clientBusiness;
	}


	public Integer getBookId() {
		return bookId;
	}


	public void setBookId(Integer bookId) {
		this.bookId = bookId;
	}
}
