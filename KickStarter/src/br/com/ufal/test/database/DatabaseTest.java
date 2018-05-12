package br.com.ufal.test.database;

import static org.junit.Assert.*;

import org.junit.Test;

import br.com.ufal.database.Database;
import br.com.ufal.user.User;

public class DatabaseTest {

	@Test
	public void searchUserByEmailTest() {
		
		Database database = Database.getInstance();
		User user = database.searchUserByEmail("notfound@email.com");
		assertEquals(user, null);
		
	}

}
