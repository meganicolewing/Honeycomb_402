package sprint1;

import java.util.ArrayList;
import java.util.HashMap;

public record PageDesc(String id, String name, ArrayList<String> externalLinks, HashMap<String,ArrayList<String>> internalLinks, String[] rolesIs, String[] linksHas,String description) implements GeneralDesc {
	public PageDesc(Page p){
		this(p.getId(),p.getName(),p.getExternalLinks(),p.getInternalLinks(),p.getRolesIs(),p.getLinksHas(),p.getDescription());
	}
}
