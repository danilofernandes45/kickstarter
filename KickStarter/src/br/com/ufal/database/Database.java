package br.com.ufal.database;

import java.util.ArrayList;

import br.com.ufal.project.Project;
import br.com.ufal.user.User;

public class Database {

	private ArrayList<User> users;
	private ArrayList<Project> projects;
	
	private static Database instance;
	
	private Database(){
		users = new ArrayList<>();
		projects = new ArrayList<>();
	}
	
	public static Database getInstance() {
		if(instance == null)
			instance = new Database();
		return instance;
	}

	public User searchUserByEmail(String email) {
		
		for(User user : users){
			if(email.equals(user.getEmail())){
				return user;
			}
		}
		
		return null;
	}
	
	public void createUser(User user){
		users.add(user);
	}

	public ArrayList<Project> searchProjectsByTitle(String title) {
		
		ArrayList<Project> result = new ArrayList<>();
		
		for(Project p : projects){
			
			if(p.getTitle().contains(title)){
				result.add(p);
			}
		}
		
		return result;
	}

	public ArrayList<Project> searchAvailableProjectsByTitle(String title) {
		
		ArrayList<Project> result = new ArrayList<>();
		
		for(Project p : projects){
			
			if(p.getTitle().contains(title) && !p.getFundingDuration().isExpired()){
				result.add(p);
			}
		}
		
		return result;
	}
	
	public void createProject(Project project) {
		projects.add(project);
		
	}

	public void removeProject(Project project) {
		projects.remove(project);
		
	}

}
