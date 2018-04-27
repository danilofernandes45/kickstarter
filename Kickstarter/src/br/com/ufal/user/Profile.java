package br.com.ufal.user;

import br.com.ufal.util.Location;

public class Profile {

	private String name;
	private String biografy;
	private Location location;
	private String website;
	private String idGoogleAnalytics;
	
	public Profile(String name, Location location) {
		this.name = name;
		this.location = location;
	}

	public Profile(String name, String biografy, Location location,
			String website, String idGoogleAnalytics) {
		super();
		this.name = name;
		this.biografy = biografy;
		this.location = location;
		this.website = website;
		this.idGoogleAnalytics = idGoogleAnalytics;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getBiografy() {
		return biografy;
	}

	public void setBiografy(String biografy) {
		this.biografy = biografy;
	}

	public Location getLocation() {
		return location;
	}

	public void setLocation(Location location) {
		this.location = location;
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
	
	
	
}
