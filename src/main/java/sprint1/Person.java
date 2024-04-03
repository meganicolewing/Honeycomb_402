package sprint1;

import java.util.ArrayList;
import java.util.Objects;


public class Person extends Page {
	/**
	 * @param name
	 * @param pronouns
	 * @param email
	 * @param phoneNumber
	 */
	private String pronouns;
	private String email;
	private String phoneNumber;
	private static final String[] rolesIs = {"editor","viewer","mentor","contributor",
			"employee","follower","applicant","friend"};
	private static final String[] linksHas = {"recommended","friend","project","skill","news","job","follower","mentor","editor","viewer"};
	
	/**
	 * @param name
	 * @param pronouns
	 * @param email
	 * @param phoneNumber
	 */
	public Person(String name, String pronouns, String email, String phoneNumber) {
		super(name);
		this.pronouns= pronouns;
		this.email = email;
		this.phoneNumber = phoneNumber;
		Storage.update(this);
	}
	public Person(PersonDesc p) {
		super(new PageDesc(p.id(),p.name(),p.externalLinks(),p.internalLinks(),null,null));
		this.pronouns = p.pronouns();
		this.email = p.email();
		this.phoneNumber = p.phoneNumber();
	}
	public String getPronouns() {
		return pronouns;
	}
	public void setPronouns(String pronouns) {
		this.pronouns = pronouns;
		Storage.update(this);
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
		Storage.update(this);
	}
	public String getPhoneNumber() {
		return phoneNumber;
	}
	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
		Storage.update(this);
	}
	@Override
	public String[] getRolesIs() {
		return rolesIs;
	}
	@Override
	public String[] getLinksHas() {
		return linksHas;
	}
	public boolean canView(Page p) {
		ArrayList<String> viewers = p.getInternalLinks("viewer");
		if(viewers.isEmpty()) {
			return true;
		}
		return viewers.contains(this.getId());
	}
	public boolean canEdit(Page p) {
		ArrayList<String> editors = p.getInternalLinks("editor");
		return editors.contains(this.getId());
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!super.equals(obj))
			return false;
		Person other = (Person) obj;
		return Objects.equals(email, other.email) && Objects.equals(phoneNumber, other.phoneNumber)
				&& Objects.equals(pronouns, other.pronouns);
	}
	
}
