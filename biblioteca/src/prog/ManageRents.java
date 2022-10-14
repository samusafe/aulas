package prog;

import prog.Book.BookType;

import java.util.ArrayList;

public class ManageRents {
	
	private ArrayList<Book> books = new ArrayList<>();
	
	public boolean hasBooks() {
		return books.size() > 0;
	}
	
	public boolean newBook(String title, String author, BookType type, boolean available, String name) {
		Book book = new Book(title, author, type, true, null);
		for(int i = 0; i < books.size(); i++) {
			if (books.get(i).equals(book)) {
				return false;
			}
		}
		return books.add(book);
	}
	
	public boolean newRent(Book book, String name) {
		for (int i = 0; i < books.size(); i++) {
			if (books.get(i).isAvailable() == false) {
				return false;
			}
		}
		book.setName(name);
		book.setAvailable(false);
		return true;
	}
	
	public Book getBookByTitle(String title) {
		for (int i = 0; i < books.size(); i++) {
			if (title.equals(books.get(i).getTitle())) {
				return books.get(i);
			}
		}
		return null;
	}
}
