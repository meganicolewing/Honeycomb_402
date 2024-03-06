package sprint1;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class Sprint1Test {
	ArrayList<Page> pages;
	final String[] links = {"editor","viewer","mentor","contributor",
			"employee","follower","applicant","friend","project","job","skill","news"};
	@BeforeEach
	void setUp() throws Exception {
		pages = new ArrayList<Page>();
		pages.add(new Person("a", "he/him", "a@gmail.com", "8595555555"));
		pages.add(new Company("b"));
		pages.add(new Skill("c"));
		pages.add(new Project("d"));
		pages.add(new NewsArticle("e"));
		pages.add(new JobPosting("f"));
	}

	@Test
	void testID() {
		ArrayList<Integer> ids = new ArrayList<Integer>();
		ids.add(Integer.parseInt(IDSingleton.getNextID()));
		for(int i = 1; i<20; i++) {
			int next = Integer.parseInt(IDSingleton.getNextID());
			assertFalse(ids.contains(next));
			assertTrue(ids.get(i-1) == next -1);
			ids.add(next);
		}
		
	}
	
	@Test
	void testPage() {
		int lastID = Integer.parseInt(IDSingleton.getNextID());
		int j = 0;
		for(int i = 6; i>0; i--) {
			assertEquals(lastID-i, Integer.parseInt(pages.get(j).getId()));
			j++;
		}
		Page p = new Company("p");
		assertTrue(p.getName().equals("p"));
		p.setName("k");
		assertTrue(p.getName().equals("k"));
		assertEquals(0,p.getExternalLinks().size());
		p.addExternalLink("abc.com");
		assertEquals(1,p.getExternalLinks().size());
		assertTrue(p.getExternalLinks().contains("abc.com"));
		p.addExternalLink("hello.com");
		assertEquals(2,p.getExternalLinks().size());
		assertTrue(p.getExternalLinks().contains("hello.com"));
		p.removeExternalLink("abc.com");
		assertEquals(1,p.getExternalLinks().size());
		assertFalse(p.getExternalLinks().contains("abc.com"));
		assertEquals(p.getLinks().length+3,p.getInternalLinks().size());
	}
	
	@Test
	void testPerson() {
		Person p = new Person("p","she/her","p@gmail.com","5555555555");
		assertTrue(p.getPronouns().equals("she/her"));
		p.setPronouns("they/them");
		assertTrue(p.getPronouns().equals("they/them"));
		assertTrue(p.getEmail().equals("p@gmail.com"));
		p.setEmail("p@ftc.gov");
		assertTrue(p.getEmail().equals("p@ftc.gov"));
		assertTrue(p.getPhoneNumber().equals("5555555555"));
		p.setPhoneNumber("0123456789");
		assertTrue(p.getPhoneNumber().equals("0123456789"));
		checkLinks(p);
	}
	
	void checkLinks(Page p) {
		for(int i = 0; i<links.length; i++) {
			boolean is_valid_link = contains(p.getLinks(),links[i]) || isDefaultLink(links[i]);
			System.out.println(links[i] + " " + is_valid_link);
			for(int j = 0; j<pages.size(); j++) {
				boolean is_valid_role = contains(pages.get(j).getRoles(),links[i]);
				System.out.println(pages.get(j).getClass().getName() + " " + is_valid_role);
				try {
					p.addInternalLink(links[i], pages.get(j));
					if(!is_valid_role || !is_valid_link) {
						fail("created invalid link from " + p.getClass().getName() + 
								" to " + pages.get(j).getClass().getName() + " as " + links[i]);
					}
				}catch(InvalidLinkException e) {
					if(is_valid_role && is_valid_link) {
						
						fail("failed to create valid link from " + p.getClass().getName() + 
								" to " + pages.get(j).getClass().getName() + " as " + links[i]);
					}
				}
				try {
					p.removeInternalLink(links[i], pages.get(j));
					if(!is_valid_role || !is_valid_link) {
						fail("removed invalid link from " + p.getClass().getName() + 
								" to " + pages.get(j).getClass().getName() + " as " + links[i]);
					}
				}catch(InvalidLinkException e) {
					if(is_valid_role && is_valid_link) {
						fail("failed to remove valid link from " + p.getClass().getName() + 
								" to " + pages.get(j).getClass().getName() + " as " + links[i]);
					}
				}
			}
		}
	}
	
	boolean contains(String[] arr, String check) {
		for(String s: arr) {
			if(s.equals(check)) {
				return true;
			}
		}
		return false;
	}

	boolean isDefaultLink(String role) {
		if(role.equals("editor") || role.equals("mentor") || role.equals("viewer")) {
			return true;
		}
		return false;
	}
}
