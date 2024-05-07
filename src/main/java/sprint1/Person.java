package sprint1;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Objects;


public class Person extends Page {
	/**
	 * @param id
	 * @param name
	 * @param description
	 * @param externalLinks
	 * @param internalLinks
	 * @param pronouns
	 * @param email
	 * @param phoneNumber
	 */
	public Person(String id, String name, String description, ArrayList<String> externalLinks,
			HashMap<String, ArrayList<String>> internalLinks, String pronouns, String email, String phoneNumber) {
		super(id, name, description, externalLinks, internalLinks);
		this.pronouns = pronouns;
		this.email = email;
		this.phoneNumber = phoneNumber;
	}
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
		super(new PageDesc(p.id(),p.name(),p.externalLinks(),p.internalLinks(),null,null,p.description()));
		this.pronouns = p.pronouns();
		this.email = p.email();
		this.phoneNumber = p.phoneNumber();
	}
	public Person() {};
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
		if(this.getId().equals(p.getId())) {
			return true;
		}
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
	@Override
	protected ArrayList<Page> pullPages() {
		Page[] people = Storage.pullAll("Person");
		ArrayList<Page> pages = new ArrayList<Page>();
		for(Page p: people) {
			pages.add(p);
		}
		return pages;
	}
	@Override
	protected HashMap<String,ArrayList<String>> pullRelations(ArrayList<Page> pages) {
		HashMap<String,ArrayList<String>> relations = new HashMap<String,ArrayList<String>>();
		for(Page page:pages) {
			ArrayList<String> links = page.getInternalLinks("follower");
			links.addAll(page.getInternalLinks("friend"));
			relations.put(page.getId(),links);
		}
		return relations;
	}
	@Override
	protected HashMap<String, Integer> findPageIds() {
		Page[] people = Storage.pullAll("Person");
		HashMap<String,Integer> pageLinks = new HashMap<String,Integer>();
		for(Page p: people) {
			if(!p.getId().equals(this.getId())) {
				pageLinks.put(p.getId(), 0);
			}
		}
		return pageLinks;
	}
	
}
