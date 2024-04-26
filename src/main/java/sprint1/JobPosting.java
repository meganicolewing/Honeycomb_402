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
}
