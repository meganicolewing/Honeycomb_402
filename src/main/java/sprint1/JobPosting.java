package sprint1;

public class JobPosting extends Page {
	private static final String[] roles = {"job"};
	private static final String[] links = {"skill","contributor","applicant","editor","mentor","viewer"};
	public JobPosting(String name) {
		super(name);
	}
	public String[] getRoles() {
		return roles;
	}
	@Override
	public String[] getLinks() {
		return links;
	}
}
