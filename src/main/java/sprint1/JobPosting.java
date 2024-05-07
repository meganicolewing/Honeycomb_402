package sprint1;

import java.util.ArrayList;
import java.util.HashMap;

public class JobPosting extends Page {
	/**
	 * 
	 */
	public JobPosting() {
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
	public JobPosting(String id, String name, String description, ArrayList<String> externalLinks,
			HashMap<String, ArrayList<String>> internalLinks) {
		super(id, name, description, externalLinks, internalLinks);
		// TODO Auto-generated constructor stub
	}
	private static final String[] rolesIs = {"job","recommended","follower"};
	private static final String[] linksHas = {"skill","contributor","applicant","editor","mentor","viewer"};
	public JobPosting(String name) {
		super(name);
	}
	public JobPosting(PageDesc p) {
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
	public void recommend(Recommender r) throws InvalidLinkException {
		Page[] people = Storage.pullAll("Person");
		for(int i = 0; i<people.length; i++) {
			System.out.println(people[i].getId());
			if(r.isQualified(this, (Person)people[i])) {
				people[i].addInternalLink("recommended", this);
			}
		}
		System.out.println(people[0].getInternalLinks());
	}
	@Override
	protected ArrayList<Page> pullPages() {
		Page[] pages = Storage.pullAll("JobPosting");
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
			ArrayList<String> links = page.getInternalLinks("skill");
			links.addAll(page.getInternalLinks("contributor"));
			relations.put(page.getId(),links);
		}
		return relations;
	}
	@Override
	protected HashMap<String, Integer> findPageIds() {
		Page[] jobs = Storage.pullAll("JobPosting");
		HashMap<String,Integer> pageLinks = new HashMap<String,Integer>();
		for(Page j: jobs) {
			if(!j.getId().equals(this.getId())) {
				pageLinks.put(j.getId(), 0);
			}
		}
		return pageLinks;
	}
	@Override
	protected HashMap<String,Integer> parseRelations(HashMap<String,ArrayList<String>> relations, HashMap<String,Integer> pageLinks){
		ArrayList<String> thisLinks = this.getInternalLinks("contributor");
		thisLinks.addAll(this.getInternalLinks("skill"));
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
