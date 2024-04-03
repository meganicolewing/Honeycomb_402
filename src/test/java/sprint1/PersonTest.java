package sprint1;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.HashMap;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class PersonTest {
Person a;
Person aa;
Person b;
Person c;
Person d;
Person e;
Person f;
Person g;
Person h;
Page i;
Project j;


	@BeforeEach
	void setUp() throws Exception {
		PersonDesc pa = new PersonDesc("100", "a", "she/her", "a@aol.com", new String[0], new String [0], "1236457890", new ArrayList<String>(), new HashMap<String,ArrayList<String>>());
		PersonDesc pb = new PersonDesc("200", "a", "she/her", "a@aol.com", new String[0], new String [0], "1236457890", new ArrayList<String>(), new HashMap<String,ArrayList<String>>());
		PersonDesc pc = new PersonDesc("100", "b", "she/her", "a@aol.com", new String[0], new String [0], "1236457890", new ArrayList<String>(), new HashMap<String,ArrayList<String>>());
		PersonDesc pd = new PersonDesc("100", "a", "she/they", "a@aol.com", new String[0], new String [0], "1236457890", new ArrayList<String>(), new HashMap<String,ArrayList<String>>());
		PersonDesc pe = new PersonDesc("100", "a", "she/her", "b@aol.com", new String[0], new String [0], "1236457890", new ArrayList<String>(), new HashMap<String,ArrayList<String>>());
		PersonDesc pf = new PersonDesc("100", "a", "she/her", "a@aol.com", new String[0], new String [0], "5555555555", new ArrayList<String>(), new HashMap<String,ArrayList<String>>());
		PersonDesc pg = new PersonDesc("100", "a", "she/her", "a@aol.com", new String[0], new String [0], "1236457890", null, new HashMap<String,ArrayList<String>>());
		PersonDesc ph = new PersonDesc("100", "a", "she/her", "a@aol.com", new String[0], new String [0], "1236457890", new ArrayList<String>(), null);
		PageDesc pi = new PageDesc("100", "a", new ArrayList<String>(), new HashMap<String,ArrayList<String>>(),new String[0], new String [0]);

		a = new Person(pa);
		aa = new Person (pa);
		b = new Person(pb);
		c = new Person(pc);
		d = new Person(pd);
		e = new Person(pe);
		f = new Person(pf);
		g = new Person(pg);
		h = new Person(ph);
		i = new Company(pi);
		j = new Project("a");

	}

	@Test
	void testEquals() {
		assertTrue(a.equals(a));
		assertTrue(a.equals(aa));
		assertFalse(a.equals(b));
		assertFalse(a.equals(c));
		assertFalse(a.equals(d));
		assertFalse(a.equals(e));
		assertFalse(a.equals(f));
		assertFalse(a.equals(g));
		assertFalse(a.equals(h));
		assertFalse(a.equals(i));
		assertFalse(a.equals(j));
		assertFalse(a.equals(null));

	}

}
