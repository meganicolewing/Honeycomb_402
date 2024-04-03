package sprint1;

import java.util.ArrayList;
import java.util.HashMap;

public record PersonDesc(String id, String name, String pronouns, String email, 
		String[] linksHas, String[] rolesIs, String phoneNumber, ArrayList<String> externalLinks, 
		HashMap<String,ArrayList<String>> internalLinks)implements GeneralDesc {
		public PersonDesc(Person p) {
			this(p.getId(),p.getName(),p.getPronouns(),p.getEmail(),p.getLinksHas(),p.getRolesIs(),
					p.getPhoneNumber(),p.getExternalLinks(),p.getInternalLinks());
		}
};
