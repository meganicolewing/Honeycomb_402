package sprint1;

import java.util.ArrayList;
import java.util.HashMap;

public class Project extends Page {
	/**
	 * 
	 */
	public Project() {
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
	public Project(String id, String name, String description, ArrayList<String> externalLinks,
			HashMap<String, ArrayList<String>> internalLinks) {
		super(id, name, description, externalLinks, internalLinks);
		// TODO Auto-generated constructor stub
	}
	private static final String[] rolesIs = {"project","follower"};
	private static final String[] linksHas = {"contributor","editor","mentor","viewer"};
	public Project(String name) {
		super(name);
	}
	public Project(PageDesc p) {
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
