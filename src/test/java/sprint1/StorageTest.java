package sprint1;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class StorageTest {
	@BeforeEach
	void setUp() throws Exception {
		Storage.wipeAll();
	}

	@Test
	void testPull() {
		PersonDesc pDesc = new PersonDesc("10","a", null, null, null, null, null, null, null);
		Person a = PageFactory.makePage("sprint1.Person",pDesc);
		assertTrue(Storage.getBaseUri()==null);
		assertTrue(Storage.pull(a.getId())==null);
		assertFalse(Storage.getBaseUri()==null);
		assertTrue(Storage.push(a));
		assertTrue(Storage.pull(a.getId()).equals(a));
		pDesc = new PersonDesc("20","b", null, null, null, null, null, null, null);
		Person b = PageFactory.makePage("sprint1.Person",pDesc);
		assertTrue(Storage.pull(b.getId())==null);
		Person c = new Person("c", null, null, null);
		assertTrue(Storage.pull(c.getId()).equals(c));
		Page d = new Company("d");
		Page e = Storage.pull(d.getId());
		assertTrue(e.equals(d));
	}
	@Test
	void testUpdate() {
		PersonDesc pDesc = new PersonDesc("10","a", null, null, null, null, null, null, null);
		Person a = PageFactory.makePage("sprint1.Person",pDesc);
		assertTrue(Storage.update(a));
		Page c = new Company("c");
		assertTrue(Storage.update(c));
	}
	
	@Test
	void testPush() {
		PersonDesc pDesc = new PersonDesc("10","a", null, null, null, null, null, null, null);
		Person a = PageFactory.makePage("sprint1.Person",pDesc);
		assertTrue(Storage.push(a));
		assertTrue(Storage.pull(a.getId()).equals(a));
	}
	
	@Test
	void testPullPeople() {
		assertTrue(Storage.pullAll("Recommender")==null);
		assertTrue(Storage.pullAll("Person")==null);
		Page a = new Company("a");
		assertTrue(Storage.pullAll("Person")==null);
		Person b = new Person("b", "she/her", "b@gmail.com", "1542369845");
		Person c = new Person("c", "they/him", "b@gmail.com", "1542369845");
		Person d = new Person("d", "she/they", "b@gmail.com", "1542369845");
		Person e = new Person("e", "he/him", "b@gmail.com", "1542369845");
		Person f = new Person("f", "they/them", "b@gmail.com", "1542369845");
		Page[] p = Storage.pullAll("Person");
		ArrayList<String> names = new ArrayList<String>();
		for(int i = 0; i<p.length; i++) {
			names.add(p[i].getName());
		}
		assertTrue(names.contains(b.getName()));
		assertTrue(names.contains(c.getName()));
		assertTrue(names.contains(d.getName()));
		assertTrue(names.contains(e.getName()));
		assertTrue(names.contains(f.getName()));
		assertFalse(names.contains(a.getName()));
	}
	@Test
	void testPullCompany() {
		assertTrue(Storage.pullAll("Company")==null);
		Page a = new Skill("a");
		assertTrue(Storage.pullAll("Company")==null);
		Company b = new Company("b");
		Company c = new Company("c");
		Company d = new Company("d");
		Company e = new Company("e");
		Company f = new Company("f");
		Page[] p = Storage.pullAll("Company");
		ArrayList<String> names = new ArrayList<String>();
		for(int i = 0; i<p.length; i++) {
			names.add(p[i].getName());
		}
		assertTrue(names.contains(b.getName()));
		assertTrue(names.contains(c.getName()));
		assertTrue(names.contains(d.getName()));
		assertTrue(names.contains(e.getName()));
		assertTrue(names.contains(f.getName()));
		assertFalse(names.contains(a.getName()));
	}
	@Test
	void testPullSkill() {
		assertTrue(Storage.pullAll("Skill")==null);
		Page a = new Company("a");
		assertTrue(Storage.pullAll("Skill")==null);
		Skill b = new Skill("b");
		Skill c = new Skill("c");
		Skill d = new Skill("d");
		Skill e = new Skill("e");
		Skill f = new Skill("f");
		Page[] p = Storage.pullAll("Skill");
		ArrayList<String> names = new ArrayList<String>();
		for(int i = 0; i<p.length; i++) {
			names.add(p[i].getName());
		}
		assertTrue(names.contains(b.getName()));
		assertTrue(names.contains(c.getName()));
		assertTrue(names.contains(d.getName()));
		assertTrue(names.contains(e.getName()));
		assertTrue(names.contains(f.getName()));
		assertFalse(names.contains(a.getName()));
	}
	@Test
	void testPullJobPosting() {
		assertTrue(Storage.pullAll("JobPosting")==null);
		Page a = new Company("a");
		assertTrue(Storage.pullAll("JobPosting")==null);
		JobPosting b = new JobPosting("b");
		JobPosting c = new JobPosting("c");
		JobPosting d = new JobPosting("d");
		JobPosting e = new JobPosting("e");
		JobPosting f = new JobPosting("f");
		Page[] p = Storage.pullAll("JobPosting");
		ArrayList<String> names = new ArrayList<String>();
		for(int i = 0; i<p.length; i++) {
			names.add(p[i].getName());
		}
		assertTrue(names.contains(b.getName()));
		assertTrue(names.contains(c.getName()));
		assertTrue(names.contains(d.getName()));
		assertTrue(names.contains(e.getName()));
		assertTrue(names.contains(f.getName()));
		assertFalse(names.contains(a.getName()));
	}
	@Test
	void testPullNewsArticle() {
		assertTrue(Storage.pullAll("NewsArticle")==null);
		Page a = new Company("a");
		assertTrue(Storage.pullAll("NewsArticle")==null);
		NewsArticle b = new NewsArticle("b");
		NewsArticle c = new NewsArticle("c");
		NewsArticle d = new NewsArticle("d");
		NewsArticle e = new NewsArticle("e");
		NewsArticle f = new NewsArticle("f");
		Page[] p = Storage.pullAll("NewsArticle");
		ArrayList<String> names = new ArrayList<String>();
		for(int i = 0; i<p.length; i++) {
			names.add(p[i].getName());
		}
		assertTrue(names.contains(b.getName()));
		assertTrue(names.contains(c.getName()));
		assertTrue(names.contains(d.getName()));
		assertTrue(names.contains(e.getName()));
		assertTrue(names.contains(f.getName()));
		assertFalse(names.contains(a.getName()));
	}
	@Test
	void testPullProject() {
		assertTrue(Storage.pullAll("Project")==null);
		Page a = new Company("a");
		assertTrue(Storage.pullAll("Project")==null);
		Project b = new Project("b");
		Project c = new Project("c");
		Project d = new Project("d");
		Project e = new Project("e");
		Project f = new Project("f");
		Page[] p = Storage.pullAll("Project");
		ArrayList<String> names = new ArrayList<String>();
		for(int i = 0; i<p.length; i++) {
			names.add(p[i].getName());
		}
		assertTrue(names.contains(b.getName()));
		assertTrue(names.contains(c.getName()));
		assertTrue(names.contains(d.getName()));
		assertTrue(names.contains(e.getName()));
		assertTrue(names.contains(f.getName()));
		assertFalse(names.contains(a.getName()));
	}
}
