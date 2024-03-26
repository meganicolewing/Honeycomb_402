package sprint1;

import java.util.ArrayList;

public class Person extends Page {
	private String pronouns;
	private String email;
	private String phone_number;
	private static final String[] roles = {"editor","viewer","mentor","contributor",
			"employee","follower","applicant","friend"};
	private static final String[] links = {"friend","project","skill","news","job","follower","mentor","editor","viewer"};
	
	/**
	 * @param name
	 * @param pronouns
	 * @param email
	 * @param phone_number
	 */
	public Person(String name, String pronouns, String email, String phone_number) {
		super(name);
		this.pronouns = pronouns;
		this.email = email;
		this.phone_number = phone_number;
	}
	public String getPronouns() {
		return pronouns;
	}
	public void setPronouns(String pronouns) {
		this.pronouns = pronouns;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPhoneNumber() {
		return phone_number;
	}
	public void setPhoneNumber(String phone_number) {
		this.phone_number = phone_number;
	}
	public String[] getRoles() {
		return roles;
	}
	@Override
	public String[] getLinks() {
		return links;
	}
	public boolean canView(Page p) {
		ArrayList<Page> viewers = p.getInternalLinks().get("viewer");
		if(viewers.isEmpty()) {
			return true;
		}
		return viewers.contains(this);
	}
	public boolean canEdit(Page p) {
		ArrayList<Page> editors = p.getInternalLinks().get("editor");
		return editors.contains(this);
	}
}
