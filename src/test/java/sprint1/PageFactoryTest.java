package sprint1;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class PageFactoryTest {
PageDesc a;
PersonDesc b;
PersonDesc c;
PageDesc[] d;
Person e;
Page[] p;
	@BeforeEach
	void setUp() throws Exception {
		a = new PageDesc("1","a",null,null,null,null,null);
		b = new PersonDesc("2","b","they/them","b@aol.com",null,null,"5555555555",null,null,null);
		d = new PageDesc[5];
		p = new Page[5];
		e = new Person("p","she/they","c@hotmail.com","1236547890");
		p[0] = new Company("c");
		p[1] = new JobPosting("j");
		p[2] = new NewsArticle("n");
		p[3] = new Project("r");
		p[4] = new Skill("s");
		c = new PersonDesc(e);
		for(int i = 0; i<5; i++) {
			d[i] = new PageDesc(p[i]);
		}
	}

	@Test
	void test() {
		Person person = PageFactory.makePage("sprint1.Person", b);
		assertTrue(person.getClass().getName().equals("sprint1.Person"));
		assertTrue(person.getId().equals("2"));
		assertTrue(person.getName().equals("b"));
		assertTrue(person.getPronouns().equals("they/them"));
		assertTrue(person.getEmail().equals("b@aol.com"));
		assertTrue(person.getPhoneNumber().equals("5555555555"));
		assertTrue(person.getRolesIs()!=(null));
		assertTrue(person.getName()!=(null));
		person = PageFactory.makePage("sprint1.Company", b);
		assertTrue(person==null);
		Page page = PageFactory.makePage("sprint1.Company", a);
		assertTrue(page.getClass().getName().equals("sprint1.Company"));
		assertTrue(page.getId().equals("1"));
		assertTrue(page.getName().equals("a"));
		assertTrue(page.getRolesIs()!=(null));
		assertTrue(page.getName()!=(null));
		page = PageFactory.makePage("sprint1.Person", a);
		assertTrue(page==null);
		person = PageFactory.makePage("sprint1.Person", c);
		assertTrue(person.equals(e));
		for(int i = 0; i<5; i++) {
			page = PageFactory.makePage(p[i].getClass().getName(), d[i]);
			assertTrue(page.equals(p[i]));
		}
	}

}
