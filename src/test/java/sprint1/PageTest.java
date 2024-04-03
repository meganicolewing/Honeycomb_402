package sprint1;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.HashMap;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class PageTest {
Page a;
Page b;
Page c;
Page d;
Page e;

	@BeforeEach
	void setUp() throws Exception {
		a = new Company("a");
		b = new Company(new PageDesc(a));
		c = new Skill("b");
		d = new Skill(new PageDesc(a));
		e = new Skill("e");
	}

	@Test
	void testEquals() {
		assertTrue(a.equals(a));
		assertTrue(a.equals(b));
		assertFalse(a.equals(c));
		assertFalse(a.equals(d));
		assertFalse(c.equals(e));
		assertFalse(a.equals(null));
	}
	
	@Test
	void testExternalLinks() {
		assertTrue(a.getExternalLinks().equals(new ArrayList<String>()));
		ArrayList<String> links = new ArrayList<String>();
		links.add("url1");
		links.add("url2");
		links.add("url3");
		links.add("url4");
		a.setExternalLinks(links);
		assertTrue(a.getExternalLinks().equals(links));
	}
	@Test
	void testInternalLinks() {
		HashMap<String,ArrayList<String>> links = new HashMap<String,ArrayList<String>>();
		links.put("follower", null);
		links.put("url2", null);
		links.put("url3", null);
		links.put("url4", null);
		a.setInternalLinks(links);
		assertTrue(a.getInternalLinks().equals(links));
	}
	@Test
	void testSetId() {
		String currId = a.getId();
		a.setId("abcdefg");
		assertTrue(a.getId().equals(currId));
	}
	@Test
	void testSetLinksHas() {
		String[] currLinksHas = a.getLinksHas();
		a.setLinksHas(null);
		assertTrue(a.getLinksHas().equals(currLinksHas));
	}
	@Test
	void testSetRolesIs() {
		String[] currRolesIs = a.getRolesIs();
		a.setRolesIs(null);
		assertTrue(a.getRolesIs().equals(currRolesIs));
	}
	
}
