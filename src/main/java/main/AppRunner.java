package main;

import sprint1.Company;
import sprint1.InvalidLinkException;
import sprint1.JobPosting;
import sprint1.NewsArticle;
import sprint1.Person;
import sprint1.Project;
import sprint1.Skill;
import sprint1.Storage;

public class AppRunner
{
	public static void main(String[] args)
	{
	reset();
	Main.main(args);
	}
	private static void reset() {
		Storage.wipeAll();
		Person[] people;
		Company[] companies;
		Skill[] skills;
		NewsArticle[] news;
		JobPosting[] jobs;
		Project[] projects;
		people = new Person[10];
		companies = new Company[10];
		skills = new Skill[10];
		news = new NewsArticle[10];
		jobs = new JobPosting[10];
		projects = new Project[10];
		people[0] = new Person("Megan Ewing", "she/her", null, null);
		people[1] = new Person("Michael", null, null, null);
		people[2] = new Person("Dave", null, null, null);
		people[3] = new Person("Thomas", null, null, null);
		people[4] = new Person("William", null, null, null);
		people[5] = new Person("Lesley", null, null, null);
		people[6] = new Person("Alex", null, null, null);
		people[7] = new Person("Jeff", null, null, null);
		people[8] = new Person("George", null, null, null);
		people[9] = new Person("Hailey", null, null, null);

		companies[0] = new Company("Google");
		companies[1] = new Company("Amazon");
		companies[2] = new Company("SkillShare");
		companies[3] = new Company("Meta");
		companies[4] = new Company("Norstella");
		companies[5] = new Company("Apple");
		companies[6] = new Company("Deloitte");
		companies[7] = new Company("IBM");
		companies[8] = new Company("Innowise");
		companies[9] = new Company("Electronic Arts");

		skills[0] = new Skill("Java");
		skills[1] = new Skill("Object Oriented Programming");
		skills[2] = new Skill("Python");
		skills[3] = new Skill("Swift");
		skills[4] = new Skill("C");
		skills[5] = new Skill("Agile");
		skills[6] = new Skill("SQL");
		skills[7] = new Skill("HTML");
		skills[8] = new Skill("PHP");
		skills[9] = new Skill("CSS");

		news[0] = new NewsArticle("news1");
		news[1] = new NewsArticle("news2");
		news[2] = new NewsArticle("news3");
		news[3] = new NewsArticle("news4");
		news[4] = new NewsArticle("news5");
		news[5] = new NewsArticle("news6");
		news[6] = new NewsArticle("news7");
		news[7] = new NewsArticle("news8");
		news[8] = new NewsArticle("news9");
		news[9] = new NewsArticle("news10");

		jobs[0] = new JobPosting("Software Intern");
		jobs[1] = new JobPosting("Game Development");
		jobs[2] = new JobPosting("Front-End");
		jobs[3] = new JobPosting("Linked-In Engineer");
		jobs[4] = new JobPosting("Software Engineer");
		jobs[5] = new JobPosting("Cloud Computing");
		jobs[6] = new JobPosting("AI Developer");
		jobs[7] = new JobPosting("IT Intern");
		jobs[8] = new JobPosting("App Developer");
		jobs[9] = new JobPosting("Web Development");

		projects[0] = new Project("project1");
		projects[1] = new Project("project2");
		projects[2] = new Project("project3");
		projects[3] = new Project("project4");
		projects[4] = new Project("project5");
		projects[5] = new Project("project6");
		projects[6] = new Project("project7");
		projects[7] = new Project("project8");
		projects[8] = new Project("project9");
		projects[9] = new Project("project10");

		try {
			people[0].addInternalLink("follower", people[6]);
			people[0].addInternalLink("follower", people[7]);
			people[0].addInternalLink("follower", people[8]);
			
			people[1].addInternalLink("follower", people[0]);
			people[1].addInternalLink("follower", people[4]);
			people[1].addInternalLink("friend", people[4]);
			people[1].addInternalLink("follower", people[2]);
			people[1].addInternalLink("friend", people[2]);
			people[1].addInternalLink("follower", people[3]);
			people[1].addInternalLink("friend", people[3]);
			people[1].addInternalLink("follower", people[5]);
			people[1].addInternalLink("follower", people[6]);

			
			people[3].addInternalLink("follower", people[1]);
			people[3].addInternalLink("friend", people[2]);
			people[3].addInternalLink("follower", people[2]);
			people[3].addInternalLink("follower", people[4]);
			
			people[4].addInternalLink("follower", people[1]);
			people[4].addInternalLink("follower", people[2]);
			people[4].addInternalLink("follower", people[3]);
			people[4].addInternalLink("friend", people[1]);
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
			jobs[0].addInternalLink("skill", skills[1]);
			jobs[0].addInternalLink("skill", skills[4]);
			
			jobs[1].addInternalLink("skill", skills[0]);
			jobs[1].addInternalLink("skill", skills[2]);
			jobs[1].addInternalLink("skill", skills[1]);
			
			jobs[2].addInternalLink("skill", skills[1]);
			jobs[2].addInternalLink("skill", skills[2]);
			jobs[2].addInternalLink("skill", skills[3]);
			
			jobs[3].addInternalLink("skill", skills[1]);
			jobs[3].addInternalLink("skill", skills[4]);
			jobs[3].addInternalLink("skill", skills[3]);
			
			jobs[4].addInternalLink("skill", skills[0]);
			jobs[4].addInternalLink("skill", skills[1]);
			jobs[4].addInternalLink("skill", skills[2]);
			jobs[4].addInternalLink("skill", skills[5]);
			
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
