package mk.com;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;

public class InMemoryBookDao implements BookDao {

	private Map<Integer, Book> books = new HashMap<Integer, Book>();
	private AtomicInteger idCounter = new AtomicInteger(1);

	public Book createBook(Book book) {
		int id = idCounter.getAndIncrement();
		book.setId(id);
		books.put(id, book);

		return book;
	}

	public Book getBook(int id) {

		return books.get(id);
	}

	public List<Book> getAllBooks() {

		return new ArrayList<Book>(books.values());
	}

	public Book updateBook(Book book) {

		if (books.containsKey(book.getId())) {
			books.put(book.getId(), book);
			return book;
		} else {
			throw new IllegalArgumentException("Book not found");
		}
	}

	public void deleteBook(int id) {
		books.remove(id);

	}

//	    @Override
//	    public Book createBook(Book book) {
//	        int id = idCounter.getAndIncrement();
//	        book.setId(id);
//	        books.put(id, book);
//	        return book;
//	    }
//
//	    @Override
//	    public Book getBook(int id) {
//	        return books.get(id);
//	    }
//
//	    @Override
//	    public List<Book> getAllBooks() {
//	        return new ArrayList<>(books.values());
//	    }
//
//	    @Override
//	    public Book updateBook(Book book) {
//	        if (books.containsKey(book.getId())) {
//	            books.put(book.getId(), book);
//	            return book;
//	        } else {
//	            throw new IllegalArgumentException("Book not found");
//	        }
//	    }
//
//	    @Override
//	    public void deleteBook(int id) {
//	        books.remove(id);
//	    }
}
