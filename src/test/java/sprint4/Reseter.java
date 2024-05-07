package sprint4;


import sprint1.Company;
import sprint1.InvalidLinkException;
import sprint1.JobPosting;
import sprint1.NewsArticle;
import sprint1.Person;
import sprint1.Project;
import sprint1.Skill;
import sprint1.Storage;

public class Reseter {
	public static void reset() {
		Storage.wipeAll();
		Person[] people;
		Company[] companies;
		Skill[] skills;
		NewsArticle[] news;
		JobPosting[] jobs;
		Project[] projects;
		people = new Person[5];
		companies = new Company[5];
		skills = new Skill[5];
		news = new NewsArticle[5];
		jobs = new JobPosting[5];
		projects = new Project[5];
		for(int i = 0; i<5; i++) {
			people[i] = new Person(i+"p", null, null, null);
			companies[i] = new Company(i+"c");
			skills[i] = new Skill(i+"s");
			news[i] = new NewsArticle(i+"n");
			jobs[i] = new JobPosting(i+"j");
			projects[i] = new Project(i+"r");
		}
		try {
			people[0].addInternalLink("follower", people[1]);
			people[0].addInternalLink("friend", people[1]);
			people[0].addInternalLink("follower", people[3]);
			people[0].addInternalLink("follower", people[4]);
			
			people[1].addInternalLink("follower", people[0]);
			people[1].addInternalLink("friend", people[0]);
			people[1].addInternalLink("friend", people[2]);
			people[1].addInternalLink("follower", people[2]);
			people[1].addInternalLink("follower", people[4]);
			
			people[2].addInternalLink("follower", people[1]);
			people[2].addInternalLink("friend", people[1]);
			people[2].addInternalLink("friend", people[4]);
			people[2].addInternalLink("follower", people[4]);
			people[2].addInternalLink("follower", people[3]);
			
			people[3].addInternalLink("follower", people[0]);
			people[3].addInternalLink("friend", people[4]);
			people[3].addInternalLink("follower", people[1]);
			people[3].addInternalLink("follower", people[4]);
			
			people[4].addInternalLink("follower", people[0]);
			people[4].addInternalLink("follower", people[2]);
			people[4].addInternalLink("follower", people[3]);
			people[4].addInternalLink("friend", people[0]);
			people[4].addInternalLink("friend", people[2]);
			people[4].addInternalLink("friend", people[3]);
			
			news[0].addInternalLink("contributor", companies[0]);
			news[0].addInternalLink("contributor", companies[1]);
			
			news[1].addInternalLink("contributor", companies[0]);
			news[1].addInternalLink("contributor", companies[2]);
			news[1].addInternalLink("contributor", companies[4]);

			news[2].addInternalLink("contributor", companies[1]);
			news[2].addInternalLink("contributor", companies[3]);
			
			news[3].addInternalLink("contributor", companies[2]);
			news[3].addInternalLink("contributor", companies[4]);
			
			news[4].addInternalLink("contributor", companies[0]);
			news[4].addInternalLink("contributor", companies[1]);
			news[4].addInternalLink("contributor", companies[2]);

			jobs[0].addInternalLink("contributor", companies[0]);
			jobs[0].addInternalLink("contributor", companies[2]);
			
			jobs[1].addInternalLink("contributor", companies[1]);
			jobs[1].addInternalLink("contributor", companies[3]);
			jobs[1].addInternalLink("contributor", companies[4]);

			jobs[2].addInternalLink("contributor", companies[1]);
			jobs[2].addInternalLink("contributor", companies[2]);
			
			jobs[3].addInternalLink("contributor", companies[0]);
			jobs[3].addInternalLink("contributor", companies[3]);
			
			jobs[4].addInternalLink("contributor", companies[1]);
			jobs[4].addInternalLink("contributor", companies[4]);
			jobs[4].addInternalLink("contributor", companies[2]);
			
			projects[0].addInternalLink("contributor", companies[1]);
			projects[0].addInternalLink("contributor", companies[0]);
			
			projects[1].addInternalLink("contributor", companies[0]);
			projects[1].addInternalLink("contributor", companies[1]);
			projects[1].addInternalLink("contributor", companies[4]);

			projects[2].addInternalLink("contributor", companies[3]);
			projects[2].addInternalLink("contributor", companies[4]);
			
			projects[3].addInternalLink("contributor", companies[1]);
			projects[3].addInternalLink("contributor", companies[3]);
			
			projects[4].addInternalLink("contributor", companies[2]);
			projects[4].addInternalLink("contributor", companies[3]);
			projects[4].addInternalLink("contributor", companies[4]);
			
			jobs[0].addInternalLink("skill", skills[0]);
			jobs[0].addInternalLink("skill", skills[2]);
			jobs[0].addInternalLink("skill", skills[4]);
			
			jobs[1].addInternalLink("skill", skills[0]);
			jobs[0].addInternalLink("skill", skills[2]);
			jobs[1].addInternalLink("skill", skills[1]);
			
			jobs[2].addInternalLink("skill", skills[1]);
			jobs[2].addInternalLink("skill", skills[2]);
			jobs[2].addInternalLink("skill", skills[4]);
			jobs[2].addInternalLink("skill", skills[3]);
			
			jobs[3].addInternalLink("skill", skills[1]);
			jobs[3].addInternalLink("skill", skills[4]);
			jobs[3].addInternalLink("skill", skills[3]);
			
			jobs[4].addInternalLink("skill", skills[0]);
			jobs[4].addInternalLink("skill", skills[2]);
			jobs[4].addInternalLink("skill", skills[4]);
			
			people[0].addInternalLink("follower", skills[0]);
			people[0].addInternalLink("follower", skills[1]);
			people[0].addInternalLink("follower", skills[3]);

			people[1].addInternalLink("follower", skills[2]);
			people[1].addInternalLink("follower", skills[3]);
			people[1].addInternalLink("follower", skills[4]);
			
			people[2].addInternalLink("follower", skills[0]);
			people[2].addInternalLink("follower", skills[4]);

			people[3].addInternalLink("follower", skills[1]);
			people[3].addInternalLink("follower", skills[3]);
			people[3].addInternalLink("follower", skills[2]);

			people[4].addInternalLink("follower", skills[0]);
			people[4].addInternalLink("follower", skills[2]);
			
			jobs[0].addInternalLink("contributor", companies[0]);
			jobs[1].addInternalLink("contributor", companies[0]);
			jobs[3].addInternalLink("contributor", companies[0]);
			jobs[4].addInternalLink("contributor", companies[0]);

			jobs[2].addInternalLink("contributor", companies[1]);

			jobs[0].addInternalLink("contributor", companies[2]);
			jobs[1].addInternalLink("contributor", companies[2]);
			jobs[2].addInternalLink("contributor", companies[2]);
			jobs[3].addInternalLink("contributor", companies[2]);

			jobs[1].addInternalLink("contributor", companies[3]);
			jobs[3].addInternalLink("contributor", companies[3]);
			jobs[4].addInternalLink("contributor", companies[3]);
			
			jobs[0].addInternalLink("contributor", companies[4]);
			jobs[2].addInternalLink("contributor", companies[4]);
			jobs[3].addInternalLink("contributor", companies[4]);
			
			jobs[1].addInternalLink("skill", skills[0]);
			jobs[2].addInternalLink("skill", skills[0]);
			jobs[3].addInternalLink("skill", skills[0]);

			jobs[0].addInternalLink("skill", skills[1]);
			jobs[2].addInternalLink("skill", skills[1]);

			jobs[0].addInternalLink("skill", skills[2]);
			jobs[1].addInternalLink("skill", skills[2]);
			jobs[2].addInternalLink("skill", skills[2]);

			jobs[1].addInternalLink("skill", skills[3]);
			jobs[4].addInternalLink("skill", skills[3]);

			jobs[0].addInternalLink("skill", skills[4]);
			jobs[2].addInternalLink("skill", skills[4]);
			jobs[3].addInternalLink("skill", skills[4]);
			jobs[4].addInternalLink("skill", skills[4]);
			
			news[0].addInternalLink("contributor", companies[0]);
			news[1].addInternalLink("contributor", companies[0]);
			news[3].addInternalLink("contributor", companies[0]);

			news[1].addInternalLink("contributor", companies[1]);
			news[2].addInternalLink("contributor", companies[1]);
			news[3].addInternalLink("contributor", companies[1]);


			news[0].addInternalLink("contributor", companies[2]);
			news[1].addInternalLink("contributor", companies[2]);
			news[2].addInternalLink("contributor", companies[2]);
			news[4].addInternalLink("contributor", companies[2]);

			news[1].addInternalLink("contributor", companies[3]);
			news[3].addInternalLink("contributor", companies[3]);
			
			news[2].addInternalLink("contributor", companies[4]);
			news[3].addInternalLink("contributor", companies[4]);
			
			projects[0].addInternalLink("contributor", companies[0]);
			projects[1].addInternalLink("contributor", companies[0]);
			projects[3].addInternalLink("contributor", companies[0]);

			projects[1].addInternalLink("contributor", companies[1]);
			projects[2].addInternalLink("contributor", companies[1]);
			projects[3].addInternalLink("contributor", companies[1]);


			projects[0].addInternalLink("contributor", companies[2]);
			projects[1].addInternalLink("contributor", companies[2]);
			projects[2].addInternalLink("contributor", companies[2]);
			projects[4].addInternalLink("contributor", companies[2]);

			projects[1].addInternalLink("contributor", companies[3]);
			projects[3].addInternalLink("contributor", companies[3]);
			
			projects[2].addInternalLink("contributor", companies[4]);
			projects[3].addInternalLink("contributor", companies[4]);
		} catch (InvalidLinkException e) {
			//fail("failed to add link");
		}
	}
}
