package sprint1;

import java.util.ArrayList;
import java.util.HashMap;

public class NewsArticle extends Page {
	/**
	 * 
	 */
	public NewsArticle() {
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
	public NewsArticle(String id, String name, String description, ArrayList<String> externalLinks,
			HashMap<String, ArrayList<String>> internalLinks) {
		super(id, name, description, externalLinks, internalLinks);
		// TODO Auto-generated constructor stub
	}
	private static final String[] rolesIs = {"news","follower"};
	private static final String[] linksHas = {"contributor","editor","mentor","viewer"};
	public NewsArticle(String name) {
		super(name);
	}
	public NewsArticle(PageDesc p) {
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
		Page[] pages = Storage.pullAll("NewsArticle");
		ArrayList<Page> pageList = new ArrayList<Page>();
		for(Page p:pages) {
			pageList.add(p);
		}
		return pageList;
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
		Page[] news = Storage.pullAll("NewsArticle");
		HashMap<String,Integer> pageLinks = new HashMap<String,Integer>();
		for(Page n: news) {
			if(!n.getId().equals(this.getId())) {
				pageLinks.put(n.getId(), 0);
			}
		}
		return pageLinks;
	}
	@Override
	protected HashMap<String,Integer> parseRelations(HashMap<String,ArrayList<String>> relations, HashMap<String,Integer> pageLinks){
		ArrayList<String> thisLinks = this.getInternalLinks("contributor");
		for(String key:relations.keySet()) {
			if(pageLinks.containsKey(key)) {
				int count = 0;
				ArrayList<String> thatLinks = relations.get(key);
				for(String link:thisLinks) {
					if(thatLinks.contains(link)) {
						count++;
					}
				}
				pageLinks.put(key, count);
			}
		}
		return pageLinks;
	}
}
