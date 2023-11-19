package mk.com;

import com.google.inject.Guice;
import com.google.inject.Injector;

public class MainApp {

	public static void main(String[] args) {

		Injector injector = Guice.createInjector(new MyModule());

		// Get the BookDao instance
		BookDao bookDao = injector.getInstance(BookDao.class);

		// Example CRUD operations
		Book book1 = new Book(0, "Introduction to Guice", "John Doe");
		bookDao.createBook(book1);

		Book retrievedBook = bookDao.getBook(book1.getId());
		System.out.println("Retrieved Book: " + retrievedBook);

		java.util.List<Book> allBooks = bookDao.getAllBooks();
		System.out.println("All Books: " + allBooks);

		Book updatedBook = new Book(book1.getId(), "Guice for Beginners", "Jane Doe");
		bookDao.updateBook(updatedBook);

		allBooks = bookDao.getAllBooks();
		System.out.println("All Books after update: " + allBooks);

		bookDao.deleteBook(updatedBook.getId());

		allBooks = bookDao.getAllBooks();
		System.out.println("All Books after delete: " + allBooks);
		
	}

}
