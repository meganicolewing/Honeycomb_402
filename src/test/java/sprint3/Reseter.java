package sprint3;

import sprint1.*;

public class Reseter {
	public static void reset() {
		Storage.wipeAll();
		Page[] pages = new Page[30];
		for(int i = 0; i<5; i++) {
			PersonDesc create = new PersonDesc(i+"",i+"", "she/her", i+"@gmail.com", null, null, i+"555555555", null, null,"hello " + i);
			pages[i] = new Person(create);
			Storage.push(pages[i]);
		}
		for(int i = 5; i<pages.length; i++) {
			PageDesc create = new PageDesc(i+"",i+"", null, null, null, null,"hello " + i);
			if((i%5)==0) {
				pages[i] = new Company(create);
			}
			else if((i%5)==1) {
				pages[i] = new JobPosting(create);
			}
			else if((i%5)==2) {
				pages[i] = new NewsArticle(create);
			}
			else if((i%5)==3) {
				pages[i] = new Project(create);
			}
			else {
				pages[i] = new Skill(create);
			}
			Storage.push(pages[i]);
		}
		for(int i =0; i<5; i++) {
			for(int j = i+1; j<pages.length; j+=5) {
				try {
					pages[i].addInternalLink("follower", pages[j]);
				} catch (InvalidLinkException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			try {
				pages[i].addInternalLink("recommended", pages[5*(i+1)+1]);
				pages[i].addInternalLink("friend", pages[4-i]);
				pages[i].addInternalLink("project", pages[5*(i+1)+3]);
				pages[i].addInternalLink("skill", pages[5*(i+1)+4]);
				pages[i].addInternalLink("news", pages[5*(i+1)+2]);
				pages[i].addInternalLink("job", pages[30-5*(i+1)+1]);
				int mentorID = (i+1)%5;
				pages[i].addInternalLink("mentor", pages[mentorID]);
			} catch (InvalidLinkException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			Storage.update(pages[i]);
		}
		try {
			pages[4].addInternalLink("editor",pages[0]);
			pages[3].addInternalLink("viewer", pages[1]);
			pages[3].addInternalLink("editor", pages[1]);
			pages[1].addInternalLink("follower", pages[3]);
			pages[5].addInternalLink("editor", pages[0]);
			pages[6].addInternalLink("editor", pages[1]);
			pages[6].addInternalLink("contributor",pages[5]);
			pages[6].addInternalLink("skill",pages[9]);
			pages[6].addInternalLink("skill",pages[19]);
			pages[3].addInternalLink("follower", pages[5]);
			pages[3].addInternalLink("skill", pages[9]);
			pages[3].addInternalLink("skill", pages[19]);
			pages[2].addInternalLink("skill", pages[9]);
			pages[2].addInternalLink("skill", pages[19]);
			pages[7].addInternalLink("viewer", pages[0]);
			pages[0].addInternalLink("follower",pages[17]);
			pages[17].addInternalLink("editor",pages[0]);

			Storage.update(pages[4]);
			Storage.update(pages[1]);
			Storage.update(pages[2]);
			Storage.update(pages[3]);
			Storage.update(pages[6]);
			Storage.update(pages[5]);
			Storage.update(pages[7]);
			Storage.update(pages[17]);
			Storage.update(pages[0]);
		} catch (InvalidLinkException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
