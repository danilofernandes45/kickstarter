package br.com.ufal.user;

import java.util.ArrayList;
import java.util.Date;

import br.com.ufal.project.Project;
import br.com.ufal.util.Address;
import br.com.ufal.util.Location;

public class User {

	private Profile profile;
	private String email;
	private String password;
	private String name;
	private Location location;
	private String biografy;
	private String website;
	private String idGoogleAnalytics;
	private ArrayList<Project> projects;
	
	public User(String name, String email, String password) {

		this.email = email;
		this.name = name;
		this.password = password;
		this.profile = new Profile();
		projects = new ArrayList<>();

	}

	public Profile getProfile() {
		return profile;
	}

	public void setProfile(Profile profile) {
		this.profile = profile;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Location getLocation() {
		return location;
	}

	public void setLocation(Location location) {
		this.location = location;
	}

	public String getBiografy() {
		return biografy;
	}

	public void setBiografy(String biografy) {
		this.biografy = biografy;
	}

	public String getWebsite() {
		return website;
	}

	public void setWebsite(String website) {
		this.website = website;
	}

	public String getIdGoogleAnalytics() {
		return idGoogleAnalytics;
	}

	public void setIdGoogleAnalytics(String idGoogleAnalytics) {
		this.idGoogleAnalytics = idGoogleAnalytics;
	}

	public ArrayList<Project> getProjects() {
		return projects;
	}

	public void setProjects(ArrayList<Project> projects) {
		this.projects = projects;
	}
	
	public void addProject(Project p) {
		projects.add(p);
	}

	public void removeProject(Project p) {
		projects.remove(p);
		
	}
	
}
