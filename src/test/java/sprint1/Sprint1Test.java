package sprint1;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class Sprint1Test {
	ArrayList<Page> pages;
	/*list of all links types to test*/
	final String[] links = {"editor","viewer","mentor","contributor",
			"employee","follower","applicant","friend","project","job","skill","news",
			/*include a link that is not valid in any class*/"general"};
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
		/*test that the IDSingleton creates IDs in sequence*/
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
		/*test all getters and setters of the page abstract class, 
		 * except those related to internal links*/
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
		/*test Person-specific getters and setters along with the internal links*/
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
	
	@Test
	void testCompany() {
		/*test the Company links*/
		Company c = new Company("p");
		checkLinks(c);
	}
	@Test
	void testSkill() {
		/*test the Skill links*/
		Skill s = new Skill("p");
		checkLinks(s);
	}
	@Test
	void testProject() {
		/*test the Project links*/
		Project p = new Project("p");
		checkLinks(p);
	}
	@Test
	void testNewsArticle() {
		/*test the NewsArticle links*/
		NewsArticle n = new NewsArticle("p");
		checkLinks(n);
	}
	@Test
	void testJobPosting() {
		/*test the JobPosting links*/
		JobPosting j = new JobPosting("j");
		checkLinks(j);
	}
	
	void checkLinks(Page p) {
		/*attempt to add every type of page as every type of link to Page p.
		 * use the links held in Page p to determine if the link type is valid
		 * use the roles held in each page to see if they can be that type of link
		 * ensures an exception is thrown when an invalid link is added or removed
		 * ensures all valid links do not throw an exception
		 */
		for(int i = 0; i<links.length; i++) {
			boolean is_valid_link = contains(p.getLinks(),links[i]) || isDefaultLink(links[i]);
			for(int j = 0; j<pages.size(); j++) {
				boolean is_valid_role = contains(pages.get(j).getRoles(),links[i]);
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
