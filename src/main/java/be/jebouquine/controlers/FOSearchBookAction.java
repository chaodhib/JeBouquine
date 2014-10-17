package be.jebouquine.controlers;

import java.util.List;

import be.jebouquine.business.criteria.CriteriaSearchBook;
import be.jebouquine.business.interfaces.IAuthorBusiness;
import be.jebouquine.business.interfaces.IBookBusiness;
import be.jebouquine.business.interfaces.ICategoryBusiness;
import be.jebouquine.business.interfaces.IEditorBusiness;
import be.jebouquine.entities.Author;
import be.jebouquine.entities.Book;
import be.jebouquine.entities.Category;
import be.jebouquine.entities.Editor;

public class FOSearchBookAction {
	// Business Beans
	private IBookBusiness bookBusiness;
	private IAuthorBusiness authorBusiness;
	private ICategoryBusiness categoryBusiness;
	private IEditorBusiness publisherBusiness;
	
	// METHOD ACTION 1
	
	private CriteriaSearchBook searchBook;
	private List<Book> searchResults;
	private String keywords;
	private Integer authorId, categoryId, publisherId;
	private Integer numberOfResult;

	public String search() {
		if(searchBook==null) // cas où l'action n'est pas appelé depuis un formulaire (bouton de catégorie)
			searchBook=new CriteriaSearchBook(); 
		
		if (keywords == null) { // cas de la recherche avancée
			searchBook.setAuthor(authorBusiness.findByID(authorId));
			searchBook.setCategory(categoryBusiness.findByID(categoryId));
			searchBook.setEditor(publisherBusiness.findByID(publisherId));
			searchResults = bookBusiness.findByCriteria(searchBook);
		} else { // cas de la recherche simple (keyword)
			searchResults = bookBusiness.findByKeywords(keywords);
		}
		setNumberOfResult(searchResults.size());
		return "success";
	}
	
	// METHOD ACTION 2
	
	private List<Author> authorList;
	private List<Category> categoryList;
	private List<Editor> publisherList;
	
	public String prepAdvancedSearch(){
		setAuthorList(authorBusiness.findAll());
		setCategoryList(categoryBusiness.findAll());
		setPublisherList(publisherBusiness.findAll());
		
		return "success";
	}
	
	// ---------------------------
	// -----GETTERS - SETTERS-----
	// ---------------------------

	public CriteriaSearchBook getSearchBook() {
		return searchBook;
	}

	public void setSearchBook(CriteriaSearchBook searchBook) {
		this.searchBook = searchBook;
	}

	public IBookBusiness getBookBusiness() {
		return bookBusiness;
	}

	public void setBookBusiness(IBookBusiness bookBusiness) {
		this.bookBusiness = bookBusiness;
	}

	public List<Book> getSearchResults() {
		return searchResults;
	}

	public void setSearchResults(List<Book> searchResults) {
		this.searchResults = searchResults;
	}

	public String getKeywords() {
		return keywords;
	}

	public void setKeywords(String keywords) {
		this.keywords = keywords;
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

	public Integer getNumberOfResult() {
		return numberOfResult;
	}

	public void setNumberOfResult(Integer numberOfResult) {
		this.numberOfResult = numberOfResult;
	}
	
}
