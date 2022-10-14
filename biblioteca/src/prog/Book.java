 package prog;

public class Book{
	
	public enum BookType {
		ACTION,
		TERROR,
		ROMANCE
	}
	
	private String title;
	private String author;
	private BookType type;
	private boolean available;
	private String name;
	
	public Book(String title, String author, BookType type, boolean available, String name) {
		this.title = title;
		this.author = author;
		this.type = type;
		this.available = available;
		this.name = name;
	}
	
	public String getTitle() {
		return title;
	}
	
	public void setTitle(String title) {
		this.title = title;
	}
	
	public String getAuthor() {
		return author;
	}
	
	public void setAuthor(String author) {
		this.author = author;
	}
	
	public BookType getType() {
		return type;
	}
	
	public void setType(BookType type) {
		this.type = type;
	}
	
	public boolean isAvailable() {
		return available;
	}
	
	public boolean setAvailable(boolean available) {
		return this.available = available;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	public String toString() {
		return title;
	}
	
	@Override
	public boolean equals(Object o) {
        if (o == this) {
            return true;
        }
 
        if (!(o instanceof Book)) {
            return false;
        }
         
        Book c = (Book) o;
      
        return c.getTitle().equals(getTitle())
        		&& c.getAuthor().equals(getAuthor())
        		&& c.getType().equals(getType());
	}
}
