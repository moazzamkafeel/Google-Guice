package mk.com;

import java.util.List;

public interface BookDao {

	Book createBook(Book book);

	Book getBook(int id);

	List<Book> getAllBooks();

	Book updateBook(Book book);

	void deleteBook(int id);

}
