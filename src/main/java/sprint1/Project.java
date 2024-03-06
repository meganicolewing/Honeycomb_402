package sprint1;

public class Project extends Page {
	private static final String[] roles = {"project"};
	private static final String[] links = {"contributor","follower"};
	public Project(String name) {
		super(name, links);
	}
	public String[] getRoles() {
		return roles;
	}
	@Override
	public String[] getLinks() {
		return links;
	}
}
