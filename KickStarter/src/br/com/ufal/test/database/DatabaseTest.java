package br.com.ufal.test.database;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.Date;

import org.junit.Test;

import br.com.ufal.database.Database;
import br.com.ufal.project.Project;
import br.com.ufal.user.User;
import br.com.ufal.util.TimerDays;

public class DatabaseTest {

	private Database database = Database.getInstance();
	@Test
	public void searchUserByEmailTest() {
		
		User user = database.searchUserByEmail("notfound@email.com");
		assertEquals(user, null);
		
		user = new User(null, "anonymous", null);
		database.createUser(user);
		assertEquals(user, database.searchUserByEmail("anonymous"));
		
		
	}
	
	@Test
	public void searchAvailableProjectsByTitleTest() {
		
		Project project = new Project();
		project.setTitle("notfound");
		project.setFundingDuration( new TimerDays(new Date(), 10) );
		database.createProject(project);
		
		assertFalse(project.getFundingDuration().isExpired());
		
		ArrayList<Project> projects = database.searchAvailableProjectsByTitle("notfound");
		assertEquals(projects.get(0), project);
		
	}
	
	@Test
	public void searchProjectsByTitleTest() {
		
		ArrayList<Project> projects = database.searchProjectsByTitle("X");
		assertEquals(projects.size(), 0);
		
	}

}
