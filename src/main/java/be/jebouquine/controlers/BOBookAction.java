package be.jebouquine.controlers;


import java.util.HashMap;
import java.util.List;
import java.util.Map;

import be.jebouquine.business.criteria.CriteriaSearchBook;
import be.jebouquine.business.interfaces.IAuthorBusiness;
import be.jebouquine.business.interfaces.IBookBusiness;
import be.jebouquine.business.interfaces.ICategoryBusiness;
import be.jebouquine.business.interfaces.IEditorBusiness;
import be.jebouquine.entities.Author;
import be.jebouquine.entities.Book;
import be.jebouquine.entities.Category;
import be.jebouquine.entities.Editor;

public class BOBookAction {
	// Param utilisés par plusieurs actions
	private IBookBusiness bookBusiness;
	private IAuthorBusiness authorBusiness;
	private ICategoryBusiness categoryBusiness;
	private IEditorBusiness publisherBusiness;
	
	private Book book;
	private List<Author> authorList;
	private List<Category> categoryList;
	private List<Editor> publisherList;
	private Integer authorId, categoryId, publisherId;
	
	private String errorMessage;
	// METHOD ACTION 1
	public String add() {
		try{
			book.setAuthor(authorBusiness.findByID(authorId));
			book.setCategory(categoryBusiness.findByID(categoryId));
			book.setPublisher(publisherBusiness.findByID(publisherId));
			
			
			if(bookBusiness.add(book))
				return "success";
			else{
				errorMessage="";
				return "error";
			}
		} catch(Exception e){
			e.printStackTrace();
			return "error";
		}
	}

	// METHOD ACTION 2 celle ci preremplit le champs qui va permettre de modifier le nom d'une categorie/auteur/editeur/...
	private Map<String, String[]> modifMap=new HashMap<String, String[]>();
	
	public String preModifOrSuppr() {
		// bout de code obscure incoming (vive Struts2)
		String[] modif= modifMap.keySet().toArray(new String[0]); // recupere le set key (de String) de la map sous forme d'array de String en les castant
		Integer ID=Integer.parseInt(modif[0]); // dans le set key de la map, il n'y a qu'un element, l'id de la categorie/auteur/etc.. correspodant à celui choisi pour la modification/supression
		book=bookBusiness.findByID(ID);// mon controleur va peupler l'objet book qui sera disponible pour la page suivant si c'est un modif
		
		String[] value=(String[]) modifMap.get(modif[0]); // recupere la value associé à la key modif[0] qui est un array de String de dimension 1
		if(value[0].equals("Modifier"))
		{
			try {
				authorList=authorBusiness.findAll();
				categoryList=categoryBusiness.findAll();
				publisherList=publisherBusiness.findAll();
				
				return "modif";
			} catch (Exception e) {
				return "error";
			}
		}
		else if(value[0].equals("Supprimer")){
			try {
				bookBusiness.remove(book);
			} catch (Exception e) {
				return "error";
			}
			return "suppr";
		}
		else if(value[0].equals("Voir")){
			return "voir";
		}
		else
			return "error";
	}

	// METHOD ACTION 3
	private List<Book> books;
	private CriteriaSearchBook searchBook;
	private int numberOfResult;
	
	public String findByCriteria() throws Exception {
		searchBook.setAuthor(authorBusiness.findByID(authorId));
		searchBook.setCategory(categoryBusiness.findByID(categoryId));
		searchBook.setEditor(publisherBusiness.findByID(publisherId));
		books=bookBusiness.findByCriteria(searchBook);
		setNumberOfResult(books.size());
		
		return "success";
	}

	// METHOD ACTION 4
	public String modify() {
		book.setAuthor(authorBusiness.findByID(authorId));
		book.setCategory(categoryBusiness.findByID(categoryId));
		book.setPublisher(publisherBusiness.findByID(publisherId));
		
		if(bookBusiness.modify(book))
			return "success";
		else
			return "error";
	}

	// METHOD ACTION 5
	public String prepFields() {
		authorList=authorBusiness.findAll();
		categoryList=categoryBusiness.findAll();
		publisherList=publisherBusiness.findAll();

		return "success";
	}
	
	// ---------------------------
	// -----GETTERS - SETTERS-----
	// ---------------------------
	
	public IBookBusiness getBookBusiness() {
		return bookBusiness;
	}

	public void setBookBusiness(IBookBusiness bookBusiness) {
		this.bookBusiness = bookBusiness;
	}

	public Book getBook() {
		return book;
	}

	public void setBook(Book book) {
		this.book = book;
	}

	public Map<String, String[]> getModifMap() {
		return modifMap;
	}

	public void setModifMap(Map<String, String[]> modifMap) {
		this.modifMap = modifMap;
	}

	public List<Book> getBooks() {
		return books;
	}

	public void setBooks(List<Book> books) {
		this.books = books;
	}

	public CriteriaSearchBook getSearchBook() {
		return searchBook;
	}

	public void setSearchBook(CriteriaSearchBook searchBook) {
		this.searchBook = searchBook;
	}

	public List<Author> getAuthorList() {
		return authorList;
	}

	public void setAuthorList(List<Author> authorList) {
		this.authorList = authorList;
	}

	public List<Category> getCategoryList() {
		return categoryList;
	}

	public void setCategoryList(List<Category> categoryList) {
		this.categoryList = categoryList;
	}

	public List<Editor> getPublisherList() {
		return publisherList;
	}

	public void setPublisherList(List<Editor> publisherList) {
		this.publisherList = publisherList;
	}

	public IAuthorBusiness getAuthorBusiness() {
		return authorBusiness;
	}

	public void setAuthorBusiness(IAuthorBusiness authorBusiness) {
		this.authorBusiness = authorBusiness;
	}

	public ICategoryBusiness getCategoryBusiness() {
		return categoryBusiness;
	}

	public void setCategoryBusiness(ICategoryBusiness categoryBusiness) {
		this.categoryBusiness = categoryBusiness;
	}

	public IEditorBusiness getPublisherBusiness() {
		return publisherBusiness;
	}

	public void setPublisherBusiness(IEditorBusiness publisherBusiness) {
		this.publisherBusiness = publisherBusiness;
	}

	public int getNumberOfResult() {
		return numberOfResult;
	}

	public void setNumberOfResult(int numberOfResult) {
		this.numberOfResult = numberOfResult;
	}

	public Integer getAuthorId() {
		return authorId;
	}

	public void setAuthorId(Integer authorId) {
		this.authorId = authorId;
	}

	public Integer getCategoryId() {
		return categoryId;
	}

	public void setCategoryId(Integer categoryId) {
		this.categoryId = categoryId;
	}

	public Integer getPublisherId() {
		return publisherId;
	}

	public void setPublisherId(Integer publisherId) {
		this.publisherId = publisherId;
	}

	public String getErrorMessage() {
		return errorMessage;
	}

	public void setErrorMessage(String errorMessage) {
		this.errorMessage = errorMessage;
	}
	
	
}
