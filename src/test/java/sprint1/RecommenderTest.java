package sprint1;

import static org.junit.jupiter.api.Assertions.*;


import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class RecommenderTest {
	JobPosting j;
	Person o;
	Person p;
	Person q;
	Person r;
	Company b;
	Company c;
	Company d;
	Skill w;
	Skill x;
	Skill y;
	Skill z;
	Recommender a;
	Recommender f;
	Recommender s;
	@BeforeEach
	void setUp() throws Exception {
		Storage.wipeAll();
		j = new JobPosting("j");
		o = new Person("o", "she/her", "o@gmail.com", "5555555555");
		p = new Person("p", "he/they", "p@gmail.com", "4853797547");
		q = new Person("q", "they/she", "q@gmail.com", "1880458192");
		r = new Person("r", "he/him", "r@gmail.com", "7891046725");
		b = new Company("b");
		c = new Company("c");
		d = new Company("d");
		w = new Skill("w");
		x = new Skill("x");
		y = new Skill("y");
		z = new Skill("z");
		a = new AllRecommender();
		f = new FollowingRecommender();
		s = new SkillsRecommender();
		/*add skills and companies to the job*/
		j.addInternalLink("skill", w);
		j.addInternalLink("skill", x);
		j.addInternalLink("contributor", b);
		j.addInternalLink("contributor", c);
		/*add companies and skills to people*/
		o.addInternalLink("follower", b);
		o.addInternalLink("follower", c);
		p.addInternalLink("follower", c);
		q.addInternalLink("follower", d);
		o.addInternalLink("skill", w);
		o.addInternalLink("skill", x);
		o.addInternalLink("skill", y);
		p.addInternalLink("skill", w);
		p.addInternalLink("skill", x);
		q.addInternalLink("skill", x);
		q.addInternalLink("skill", z);
		r.addInternalLink("skill", y);
		r.addInternalLink("skill", z);
	}

	@Test
	void testAllRecommender() {
		assertTrue(a.isQualified(j,o));
		assertTrue(a.isQualified(j,p));
		assertTrue(a.isQualified(j,q));
		assertTrue(a.isQualified(j,r));
	}
	@Test
	void testFollowingRecommender() {
		assertTrue(f.isQualified(j,o));
		assertFalse(f.isQualified(j,p));
		assertFalse(f.isQualified(j,q));
		assertFalse(f.isQualified(j,r));
	}
	@Test
	void testSkillsRecommender() {
		assertTrue(s.isQualified(j,o));
		assertTrue(s.isQualified(j,p));
		assertFalse(s.isQualified(j,q));
		assertFalse(s.isQualified(j,r));
	}
	@Test
	void testJobRecommender() {
		try {
			j.recommend(s);
		} catch (InvalidLinkException e) {
			fail("failed to add job");
		}
		o = (Person) Storage.pull(o.getId());
		p = (Person) Storage.pull(p.getId());
		q = (Person) Storage.pull(q.getId());
		r = (Person) Storage.pull(r.getId());
		assertTrue(o.getInternalLinks("recommended").contains(j.getId()));
		assertTrue(p.getInternalLinks("recommended").contains(j.getId()));
		assertFalse(q.getInternalLinks("recommended").contains(j.getId()));
		assertFalse(r.getInternalLinks("recommended").contains(j.getId()));
	}
}
