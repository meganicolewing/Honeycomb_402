package sprint1;

import java.util.*;

public abstract class Page {
	private String id;
	private String name;
	private ArrayList<String> external_links;
	private HashMap<String,ArrayList<Page>> internal_links;
	private static final String[] default_links = {"mentor","editor","viewer"};
	
	/**
	 * @param id
	 * @param name
	 * @param external_links
	 * @param internal_links
	 */
	public Page(String name, String[] roles) {
		this.id = IDSingleton.getNextID();
		this.name = name;
		this.external_links = new ArrayList<String>();
		this.internal_links = new HashMap<String,ArrayList<Page>>();
		for(String role: default_links) {
			this.internal_links.put(role,new ArrayList<Page>());
		}
		for(String role: roles) {
			this.internal_links.put(role,new ArrayList<Page>());
		}
	}
	public String getId() {
		return id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public void addExternalLink(String e) {
		external_links.add(e);
	}
	public void removeExternalLink(String e) {
		external_links.remove(e);
	}
	public ArrayList<String> getExternalLinks(){
		return external_links;
	}
	public void addInternalLink(String type, Page link) throws InvalidLinkException {
		if((internal_links.get(type) == null) || !link.hasRole(type)) {
			throw new InvalidLinkException(this.getClass().getName(),link.getClass().getName(),type);
		}
		else {
			internal_links.get(type).add(link);
		}
	}
	public void removeInternalLink(String type, Page link) throws InvalidLinkException {
		if((internal_links.get(type) == null) || !link.hasRole(type)) {
			throw new InvalidLinkException(this.getClass().getName(),link.getClass().getName(),type);
		}
		else {
			internal_links.get(type).remove(link);
		}
	}
	public HashMap<String,ArrayList<Page>> getInternalLinks(){
		return internal_links;
	}
	public abstract String[] getRoles();
	public abstract String[] getLinks();
	
	private boolean hasRole(String role) {
		String[] roles = this.getRoles();
		for(int i=0; i<roles.length;i++) {
			if(roles[i].equals(role)) {
				return true;
			}
		}
		return false;
	}
}
