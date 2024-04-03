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
		assertTrue(Storage.pullPeople()==null);
		Page a = new Company("a");
		assertTrue(Storage.pullPeople()==null);
		Person b = new Person("b", "she/her", "b@gmail.com", "1542369845");
		Person c = new Person("c", "they/him", "b@gmail.com", "1542369845");
		Person d = new Person("d", "she/they", "b@gmail.com", "1542369845");
		Person e = new Person("e", "he/him", "b@gmail.com", "1542369845");
		Person f = new Person("f", "they/them", "b@gmail.com", "1542369845");
		Person[] p = Storage.pullPeople();
		ArrayList<String> names = new ArrayList<String>();
		for(int i = 0; i<p.length; i++) {
			names.add(p[i].getName());
		}
		assertTrue(names.contains("b"));
		assertTrue(names.contains("c"));
		assertTrue(names.contains("d"));
		assertTrue(names.contains("e"));
		assertTrue(names.contains("f"));

	}

}
