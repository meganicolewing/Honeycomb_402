package sprint1;

import java.util.ArrayList;
import java.util.HashMap;

public class Company extends Page {
	/**
	 * 
	 */
	public Company() {
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
	public Company(String id, String name, String description, ArrayList<String> externalLinks,
			HashMap<String, ArrayList<String>> internalLinks) {
		super(id, name, description, externalLinks, internalLinks);
		// TODO Auto-generated constructor stub
	}
	private static final String[] rolesIs = {"contributor","follower"};
	private static final String[] linksHas = {"employee","project","job","news","editor","mentor","viewer"};
	public Company(String name) {
		super(name);
	}
	public Company(PageDesc p) {
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
		Page[] news = Storage.pullAll("NewsArticle");
		Page[] projects = Storage.pullAll("Project");
		ArrayList<Page> pages = new ArrayList<Page>();
		for(int i = 0; i<jobs.length;i++) {
			pages.add(jobs[i]);
		}
		for(int i = 0; i<news.length; i++) {
			pages.add(news[i]);
		}
		for(int i = 0; i<projects.length; i++) {
			pages.add(projects[i]);
		}
		return pages;
	}
	@Override
	protected HashMap<String,ArrayList<String>> pullRelations(ArrayList<Page> pages) {
		HashMap<String,ArrayList<String>> relations = new HashMap<String,ArrayList<String>>();
		for(Page page:pages) {
			relations.put(page.getId(),page.getInternalLinks("contributor"));
		}
		return relations;
	}
	@Override
	protected HashMap<String, Integer> findPageIds() {
		Page[] companies = Storage.pullAll("Company");
		HashMap<String,Integer> pageLinks = new HashMap<String,Integer>();
		for(Page c: companies) {
			if(!c.getId().equals(this.getId())) {
				pageLinks.put(c.getId(), 0);
			}
		}
		return pageLinks;
	}
}
