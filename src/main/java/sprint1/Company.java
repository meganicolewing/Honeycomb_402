package sprint1;

public class Company extends Page {
	private static final String[] roles = {"contributor"};
	private static final String[] links = {"employee","follower","project","job"};
	public Company(String name) {
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
