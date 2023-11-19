package mk.com;

import javax.sql.DataSource;

import com.google.inject.AbstractModule;
import com.google.inject.Provides;
import com.google.inject.Singleton;
import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;

public class MyModule extends AbstractModule {
	// Create a Guice module to bind the interfaces to their implementations.
	@Override
	protected void configure() {
		bind(BookDao.class).to(InMemoryBookDao.class);
	}
	
//	    @Provides
//	    @Singleton
//	    public DataSource provideDataSource() {
//	        HikariConfig config = new HikariConfig();
//	        config.setJdbcUrl("jdbc:postgresql://localhost:5432/mks");
//	        config.setUsername("postgres");
//	        config.setPassword("1234");
//
//	        return new HikariDataSource(config);
//	    }
}
