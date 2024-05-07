package sprint1;

import java.util.ArrayList;
import java.util.HashMap;

public class Skill extends Page {
	/**
	 * 
	 */
	public Skill() {
		super();
		// TODO Auto-generated constructor stub
	}
	/**
	 * @param id
	 * @param name
	 * @param description
	 * @param externalLinks
	 * @param internalLinks
	 */
	public Skill(String id, String name, String description, ArrayList<String> externalLinks,
			HashMap<String, ArrayList<String>> internalLinks) {
		super(id, name, description, externalLinks, internalLinks);
		// TODO Auto-generated constructor stub
	}
	private static final String[] rolesIs = {"skill","follower"};
	private static final String[] linksHas = {"editor","mentor","viewer"};
	public Skill(String name) {
		super(name);
	}
	public Skill(PageDesc p) {
		super(p);
	}

	@Override
	public String[] getRolesIs() {
		return rolesIs;
	}
	@Override
	public String[] getLinksHas() {
		return linksHas;
	}
	@Override
	protected ArrayList<Page> pullPages() {
		Page[] jobs = Storage.pullAll("JobPosting");
		Page[] people = Storage.pullAll("Person");
		ArrayList<Page> pages = new ArrayList<Page>();
		for(Page j:jobs) {
			pages.add(j);
		}
		for(Page p: people) {
			pages.add(p);
		}
		return pages;
	}
	@Override
	protected HashMap<String,ArrayList<String>> pullRelations(ArrayList<Page> pages) {
		HashMap<String,ArrayList<String>> relations = new HashMap<String,ArrayList<String>>();
		for(Page page:pages) {
			if(page.getClass().getName().equals("sprint1.Person")) {
				relations.put(page.getId(),page.getInternalLinks("follower"));
			}
			else if(page.getClass().getName().equals("sprint1.JobPosting")) {
				relations.put(page.getId(),page.getInternalLinks("skill"));
			}
		}
		return relations;
	}
	@Override
	protected HashMap<String, Integer> findPageIds() {
		Page[] skills = Storage.pullAll("Skill");
		HashMap<String,Integer> pageLinks = new HashMap<String,Integer>();
		for(Page s: skills) {
			if(!s.getId().equals(this.getId())) {
				pageLinks.put(s.getId(), 0);
			}
		}
		return pageLinks;
	}
}
