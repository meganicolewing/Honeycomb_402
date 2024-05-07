package sprint4;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import sprint1.Person;
import sprint1.InvalidLinkException;
import sprint1.Company;
import sprint1.Skill;
import sprint1.Storage;
import sprint1.NewsArticle;
import sprint1.JobPosting;
import sprint1.Project;

class TestFindRecommendations {
	Person[] people;
	Company[] companies;
	Skill[] skills;
	NewsArticle[] news;
	JobPosting[] jobs;
	Project[] projects;
	
	@BeforeEach
	void setUp() throws Exception {
		Storage.wipeAll();
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
	}

	@Test
	void testPerson() {
			//set up for Person test
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
		} catch (InvalidLinkException e) {
			fail("failed to add link");
		}
		ArrayList<String> links = people[0].findRecommendations();
		assertTrue(links.get(0).equals(people[2].getId()));
		assertTrue(links.get(1).equals(people[4].getId()));
		assertTrue(links.get(2).equals(people[3].getId()));
		assertTrue(links.get(3).equals(people[1].getId()));
		links = people[1].findRecommendations();
		assertTrue(links.get(0).equals(people[4].getId()));
		assertTrue(links.get(1).equals(people[3].getId()));
		assertTrue(links.get(2).equals(people[0].getId()));
		assertTrue(links.get(3).equals(people[2].getId()));
		links = people[2].findRecommendations();
		assertTrue(links.get(0).equals(people[0].getId()));
		assertTrue(links.get(1).equals(people[3].getId()));
		assertTrue(links.get(2).equals(people[4].getId()));
		assertTrue(links.get(3).equals(people[1].getId()));
		links = people[3].findRecommendations();
		assertTrue(links.get(0).equals(people[1].getId()));
		assertTrue(links.get(1).equals(people[4].getId()));
		assertTrue(links.get(2).equals(people[0].getId()));
		assertTrue(links.get(3).equals(people[2].getId()));
		links = people[4].findRecommendations();
		assertTrue(links.get(0).equals(people[1].getId()));
		assertTrue(links.get(1).equals(people[0].getId()));
		assertTrue(links.get(2).equals(people[2].getId()));
		assertTrue(links.get(3).equals(people[3].getId()));
	}
	
	@Test
	void testCompany() {
		//set up for companies
		try {
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
		} catch (InvalidLinkException e) {
			fail("failed to add link");
		}
		ArrayList<String> links = companies[0].findRecommendations();
		assertTrue(links.get(0).equals(companies[1].getId()));
		assertTrue(links.get(1).equals(companies[2].getId()));
		assertTrue(links.get(2).equals(companies[4].getId()));
		assertTrue(links.get(3).equals(companies[3].getId()));
		links = companies[1].findRecommendations();
		assertTrue(links.get(0).equals(companies[0].getId()));
		assertTrue(links.get(1).equals(companies[2].getId()));
		assertTrue(links.get(2).equals(companies[4].getId()));
		assertTrue(links.get(3).equals(companies[3].getId()));
		links = companies[2].findRecommendations();
		assertTrue(links.get(0).equals(companies[4].getId()));
		assertTrue(links.get(1).equals(companies[0].getId()));
		assertTrue(links.get(2).equals(companies[1].getId()));
		assertTrue(links.get(3).equals(companies[3].getId()));
		links = companies[3].findRecommendations();
		assertTrue(links.get(0).equals(companies[4].getId()));
		assertTrue(links.get(1).equals(companies[1].getId()));
		assertTrue(links.get(2).equals(companies[0].getId()));
		assertTrue(links.get(3).equals(companies[2].getId()));
		links = companies[4].findRecommendations();
		assertTrue(links.get(0).equals(companies[2].getId()));
		assertTrue(links.get(1).equals(companies[1].getId()));
		assertTrue(links.get(2).equals(companies[3].getId()));
		assertTrue(links.get(3).equals(companies[0].getId()));
	}

	@Test
	void testSkills() {
		try {
			//set up for skills
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
		} catch (InvalidLinkException e) {
			fail("failed to add links");
		}
		ArrayList<String> links = skills[0].findRecommendations();
		assertTrue(links.get(0).equals(skills[2].getId()));
		assertTrue(links.get(1).equals(skills[4].getId()));
		assertTrue(links.get(2).equals(skills[1].getId()));
		assertTrue(links.get(3).equals(skills[3].getId()));
		links = skills[1].findRecommendations();
		assertTrue(links.get(0).equals(skills[3].getId()));
		assertTrue(links.get(1).equals(skills[0].getId()));
		assertTrue(links.get(2).equals(skills[2].getId()));
		assertTrue(links.get(3).equals(skills[4].getId()));
		links = skills[2].findRecommendations();
		assertTrue(links.get(0).equals(skills[4].getId()));
		assertTrue(links.get(1).equals(skills[0].getId()));
		assertTrue(links.get(2).equals(skills[3].getId()));
		assertTrue(links.get(3).equals(skills[1].getId()));
		links = skills[3].findRecommendations();
		assertTrue(links.get(0).equals(skills[1].getId()));
		assertTrue(links.get(1).equals(skills[2].getId()));
		assertTrue(links.get(2).equals(skills[4].getId()));
		assertTrue(links.get(3).equals(skills[0].getId()));
		links = skills[4].findRecommendations();
		assertTrue(links.get(0).equals(skills[2].getId()));
		assertTrue(links.get(1).equals(skills[0].getId()));
		assertTrue(links.get(2).equals(skills[3].getId()));
		assertTrue(links.get(3).equals(skills[1].getId()));
	}
	
	@Test
	void testJobPostings() {
		try {
			//set up for jobs
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


		} catch (InvalidLinkException e) {
			fail("failed to add links");
		}
		
		ArrayList<String> links = jobs[0].findRecommendations();
		assertTrue(links.get(0).equals(jobs[2].getId()));
		assertTrue(links.get(1).equals(jobs[3].getId()));
		assertTrue(links.get(2).equals(jobs[1].getId()));
		assertTrue(links.get(3).equals(jobs[4].getId()));
		links = jobs[1].findRecommendations();
		assertTrue(links.get(0).equals(jobs[3].getId()));
		assertTrue(links.get(1).equals(jobs[0].getId()));
		assertTrue(links.get(2).equals(jobs[2].getId()));
		assertTrue(links.get(3).equals(jobs[4].getId()));
		links = jobs[2].findRecommendations();
		assertTrue(links.get(0).equals(jobs[0].getId()));
		assertTrue(links.get(1).equals(jobs[3].getId()));
		assertTrue(links.get(2).equals(jobs[1].getId()));
		assertTrue(links.get(3).equals(jobs[4].getId()));
		links = jobs[3].findRecommendations();
		assertTrue(links.get(0).equals(jobs[0].getId()));
		assertTrue(links.get(1).equals(jobs[2].getId()));
		assertTrue(links.get(2).equals(jobs[1].getId()));
		assertTrue(links.get(3).equals(jobs[4].getId()));
		links = jobs[4].findRecommendations();
		assertTrue(links.get(0).equals(jobs[3].getId()));
		assertTrue(links.get(1).equals(jobs[1].getId()));
		assertTrue(links.get(2).equals(jobs[0].getId()));
		assertTrue(links.get(3).equals(jobs[2].getId()));
	}
	
	@Test
	void testNewsArticles() {
		try {
			//set up for jobs
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
		} catch (InvalidLinkException e) {
			fail("failed to add links");
		}
		
		ArrayList<String> links = news[0].findRecommendations();
		assertTrue(links.get(0).equals(news[1].getId()));
		assertTrue(links.get(1).equals(news[2].getId()));
		assertTrue(links.get(2).equals(news[4].getId()));
		assertTrue(links.get(3).equals(news[3].getId()));
		links = news[1].findRecommendations();
		assertTrue(links.get(0).equals(news[3].getId()));
		assertTrue(links.get(1).equals(news[0].getId()));
		assertTrue(links.get(2).equals(news[2].getId()));
		assertTrue(links.get(3).equals(news[4].getId()));
		links = news[2].findRecommendations();
		assertTrue(links.get(0).equals(news[1].getId()));
		assertTrue(links.get(1).equals(news[3].getId()));
		assertTrue(links.get(2).equals(news[0].getId()));
		assertTrue(links.get(3).equals(news[4].getId()));
		links = news[3].findRecommendations();
		assertTrue(links.get(0).equals(news[1].getId()));
		assertTrue(links.get(1).equals(news[2].getId()));
		assertTrue(links.get(2).equals(news[0].getId()));
		assertTrue(links.get(3).equals(news[4].getId()));
		links = news[4].findRecommendations();
		assertTrue(links.get(0).equals(news[0].getId()));
		assertTrue(links.get(1).equals(news[2].getId()));
		assertTrue(links.get(2).equals(news[1].getId()));
		assertTrue(links.get(3).equals(news[3].getId()));
	}
	
	@Test
	void testProjects() {
		try {
			//set up for jobs
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
			fail("failed to add links");
		}
		
		ArrayList<String> links = projects[0].findRecommendations();
		assertTrue(links.get(0).equals(projects[1].getId()));
		assertTrue(links.get(1).equals(projects[3].getId()));
		assertTrue(links.get(2).equals(projects[2].getId()));
		assertTrue(links.get(3).equals(projects[4].getId()));
		links = projects[1].findRecommendations();
		assertTrue(links.get(0).equals(projects[3].getId()));
		assertTrue(links.get(1).equals(projects[0].getId()));
		assertTrue(links.get(2).equals(projects[2].getId()));
		assertTrue(links.get(3).equals(projects[4].getId()));
		links = projects[2].findRecommendations();
		assertTrue(links.get(0).equals(projects[1].getId()));
		assertTrue(links.get(1).equals(projects[3].getId()));
		assertTrue(links.get(2).equals(projects[0].getId()));
		assertTrue(links.get(3).equals(projects[4].getId()));
		links = projects[3].findRecommendations();
		assertTrue(links.get(0).equals(projects[1].getId()));
		assertTrue(links.get(1).equals(projects[2].getId()));
		assertTrue(links.get(2).equals(projects[0].getId()));
		assertTrue(links.get(3).equals(projects[4].getId()));
		links = projects[4].findRecommendations();
		assertTrue(links.get(0).equals(projects[1].getId()));
		assertTrue(links.get(1).equals(projects[0].getId()));
		assertTrue(links.get(2).equals(projects[2].getId()));
		assertTrue(links.get(3).equals(projects[3].getId()));
	}
}
