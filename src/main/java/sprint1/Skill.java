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
	
}
