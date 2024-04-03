package sprint1;

public class PageFactory {
	public static Page makePage(String className, PageDesc r) {
		if(className.equals("sprint1.Company")) {
			return new Company(r);
		}		
		if(className.equals("sprint1.JobPosting")) {
			return new JobPosting(r);
		}		
		if(className.equals("sprint1.NewsArticle")) {
			return new NewsArticle(r);
		}		
		if(className.equals("sprint1.Project")) {
			return new Project(r);
		}
		if(className.equals("sprint1.Skill")) {
			return new Skill(r);
		}
		else {
			return null;
		}
	}
	public static Person makePage(String className, PersonDesc r) {
		if(className.equals("sprint1.Person")) {
			Person p = new Person(r);
			return p;
		}
		return null;
	}
}
