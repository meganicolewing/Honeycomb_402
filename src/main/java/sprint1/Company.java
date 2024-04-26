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
}
