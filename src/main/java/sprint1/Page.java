package sprint1;

import java.util.*;

public abstract class Page {
	/**
	 * @param id
	 * @param name
	 * @param description
	 * @param externalLinks
	 * @param internalLinks
	 */
	public Page(String id, String name, String description, ArrayList<String> externalLinks,
			HashMap<String, ArrayList<String>> internalLinks) {
		this.id = id;
		this.name = name;
		this.description = description;
		this.externalLinks = externalLinks;
		this.internalLinks = internalLinks;
		if(this.externalLinks == null) {
			this.externalLinks = new ArrayList<String>();
		}
		if(this.internalLinks == null) {
			this.internalLinks = new HashMap<String,ArrayList<String>>();
			String[] links = this.getLinksHas();
			for(String link: links) {
				this.internalLinks.put(link,new ArrayList<String>());
			}
		}
	}
	protected String id;
	protected String name;
	protected String description;
	protected ArrayList<String> externalLinks;
	protected HashMap<String,ArrayList<String>> internalLinks;	
	/**
	 * @param id
	 * @param name
	 * @param externalLinks
	 * @param internalLinks
	 */
	public Page(String name) {
		this.id = IDSingleton.getNextID();
		this.name = name;
		this.externalLinks = new ArrayList<String>();
		this.internalLinks = new HashMap<String,ArrayList<String>>();
		String[] links = this.getLinksHas();
		for(String link: links) {
			this.internalLinks.put(link,new ArrayList<String>());
		}
		Storage.push(this);
	}
	public Page(PageDesc p) {
		this.id = p.id();
		this.name = p.name();
		this.description = p.description();
		this.externalLinks = p.externalLinks();
		this.internalLinks = p.internalLinks();
		if(this.externalLinks == null) {
			this.externalLinks = new ArrayList<String>();
		}
		if(this.internalLinks == null) {
			this.internalLinks = new HashMap<String,ArrayList<String>>();
			String[] links = this.getLinksHas();
			for(String link: links) {
				this.internalLinks.put(link,new ArrayList<String>());
			}
		}
		
	}
	public Page() {};
	public String getId() {
		return id;
	}
	public void setId(String id) {};
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
		Storage.update(this);
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String d) {
		description = d;
	}
	public void addExternalLink(String e) {
		externalLinks.add(e);
		Storage.update(this);
	}
	public void removeExternalLink(String e) {
		externalLinks.remove(e);
		Storage.update(this);
	}
	public ArrayList<String> getExternalLinks(){
		return externalLinks;
	}
	public void setExternalLinks(ArrayList<String> externalLinks) {
		this.externalLinks = externalLinks;
	}
	public void addInternalLink(String type, Page link) throws InvalidLinkException {
		if((internalLinks.get(type) == null) || !link.hasRole(type)) {
			throw new InvalidLinkException(this.getClass().getName(),link.getClass().getName(),type);
		}
		else {
			internalLinks.get(type).add(link.getId());
		}
		Storage.update(this);
	}
	public void removeInternalLink(String type, Page link) throws InvalidLinkException {
		if((internalLinks.get(type) == null) || !link.hasRole(type)) {
			throw new InvalidLinkException(this.getClass().getName(),link.getClass().getName(),type);
		}
		else {
			internalLinks.get(type).remove(link.getId());
		}
		Storage.update(this);
	}
	public ArrayList<String> getInternalLinks(String type){
		return internalLinks.get(type);
	}
	public HashMap<String,ArrayList<String>> getInternalLinks(){
		return internalLinks;
	}
	public void setInternalLinks(HashMap<String,ArrayList<String>> internalLinks) {
		this.internalLinks = internalLinks;
	}
	public abstract String[] getRolesIs();
	public abstract String[] getLinksHas();
	public void setRolesIs(String[] rolesIs) {};
	public void setLinksHas(String[] linksHas) {};
	
	private boolean hasRole(String role) {
		String[] roles = this.getRolesIs();
		for(int i=0; i<roles.length;i++) {
			if(roles[i].equals(role)) {
				return true;
			}
		}
		return false;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Page other = (Page) obj;
		return Objects.equals(externalLinks, other.externalLinks) && Objects.equals(id, other.id) && Objects.equals(description,  other.description)
				&& Objects.equals(internalLinks, other.internalLinks) && Objects.equals(name, other.name);
	}
	
	public ArrayList<String> findRecommendations(){
		ArrayList<Page> pages = pullPages();
		HashMap<String,ArrayList<String>> relations = pullRelations(pages);
		HashMap<String,Integer> pageLinks = findPageIds();
		pageLinks = parseRelations(relations,pageLinks);
		return orderRelations(pageLinks);
	}
	
	protected abstract ArrayList<Page> pullPages();
	protected abstract HashMap<String,ArrayList<String>> pullRelations(ArrayList<Page> pages);
	protected abstract HashMap<String,Integer> findPageIds();
	protected HashMap<String,Integer> parseRelations(HashMap<String,ArrayList<String>> relations, HashMap<String,Integer> pageLinks){
		for(ArrayList<String> page: relations.values()) {
			if(page.contains(this.id)) {
				for(String key: page) {
					if(pageLinks.containsKey(key)){
						int newNum = pageLinks.get(key)+1;
						pageLinks.replace(key,newNum);
					}
				}
			}
		}
		return pageLinks;
	}
	private ArrayList<String> orderRelations(HashMap<String,Integer> pageLinks){
		ArrayList<String> orderedRelations = new ArrayList<String>();
		Set<String> keys = pageLinks.keySet();
		System.out.println(pageLinks);
		for(String key:keys) {
			if(orderedRelations.size()==0) {
				orderedRelations.add(key);
			}
			else {
				int count = pageLinks.get(key);
				int i = 0;
				while(i<orderedRelations.size()&&!orderedRelations.contains(key)){
					if(pageLinks.get(orderedRelations.get(i))<count) {
						orderedRelations.add(i,key);
					}
					i++;
				}
				if(!orderedRelations.contains(key)) {
					orderedRelations.add(key);
				}
			}
		}
		return orderedRelations;
	}
}
