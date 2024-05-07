package sprint1;

import org.springframework.http.MediaType;
import org.springframework.web.client.RestClient;

public class Storage {
	private static RestClient client = RestClient.create();
	private static String baseUri = null;
	private static String[] classes = {"sprint1.Person","sprint1.Company",
			"sprint1.JobPosting","sprint1.Project","sprint1.NewsArticle","sprint1.Skill"};
	private static void create() {
		baseUri = "http://localhost:9000/v1/honeycomb";
		Desc team = new Desc("honeycomb","the honeycomb platform","");
		client.post()
			.uri(baseUri)
			.contentType(MediaType.APPLICATION_JSON)
			.body(team)
			.retrieve();
		for(String className: classes) {
			Desc newClass = new Desc(className,"a page","");
			client.post()
				.uri(baseUri+"/"+className)
				.contentType(MediaType.APPLICATION_JSON)
				.body(newClass)
				.retrieve();
		}
	}
	public static String getBaseUri() {
		return baseUri;
	}
	
	public static boolean push(Page p) {
		if(baseUri == null) {
			create();
		}
		String className = p.getClass().getName();
		Response resp = client.post()
			.uri(baseUri+"/"+className+"/"+p.getId())
			.contentType(MediaType.APPLICATION_JSON)
			.body(p)
			.retrieve()
			.body(Response.class);

		return resp.successful();
	}
	
	public static Page pull(String id) {
		if(baseUri == null) {
			create();
		}
		for(int i =0; i<classes.length; i++) {
			Response guess = client.get()
					.uri(baseUri+"/"+classes[i]+"/"+id)
					.retrieve()
					.body(Response.class);
			if(guess.successful()) {
				if(classes[i].equals("sprint1.Person")) {
					PersonResponse resp = client.get()
							.uri(baseUri+"/"+classes[i]+"/"+id)
							.retrieve()
							.body(PersonResponse.class);
					if(resp.successful()) {
						return PageFactory.makePage(classes[i], resp.data());
					}
				}
				else {
					PageResponse resp = client.get()
							.uri(baseUri+"/"+classes[i]+"/"+id)
							.retrieve()
							.body(PageResponse.class);
					if(resp.successful()) {
						return PageFactory.makePage(classes[i],resp.data());
					}
				}
			}
		}
		return null;
	}
	
	public static boolean update(Page p) {
		if(baseUri == null) {
			create();
			return push(p);
		}
		GeneralDesc desc;
		if(p.getClass().getName().equals("sprint1.Person")) {
			desc = new PersonDesc((Person)p);
		}
		else {
			desc = new PageDesc(p);
		}
		Response resp = client.put()
				.uri(baseUri+"/"+p.getClass().getName()+"/"+p.getId())
				.contentType(MediaType.APPLICATION_JSON)
				.body(desc)
				.retrieve()
				.body(Response.class);
		return resp.successful();
	}
	
	private static Person[] pullPeople(){
		if(baseUri == null) {
			create();
			return null;
		}
		ListResponse resp = client.get().uri(baseUri+"/sprint1.Person")
				.retrieve()
				.body(ListResponse.class);
		int numPeople = resp.data().length;
		if(numPeople == 0) {
			return null;
		}
		Person[] people = new Person[numPeople];
		for(int i = 0; i<numPeople;i++) {
			PersonResponse personResp = client.get()
					.uri(baseUri+"/sprint1.Person"+"/"+resp.data()[i].name())
					.retrieve()
					.body(PersonResponse.class);
			people[i] = new Person(personResp.data());
		}
		return people;
	}
	public static Page[] pullAll(String type){
		type = "sprint1."+type;
		if(baseUri == null) {
			create();
			return null;
		}
		Response guess = client.get().uri(baseUri+"/"+type)
				.retrieve()
				.body(Response.class);
		if(!guess.successful()) {
			return null;
		}
		if(type.equals("sprint1.Person")) {
			return pullPeople();
		}
		ListResponse resp = client.get().uri(baseUri+"/"+type)
				.retrieve()
				.body(ListResponse.class);
		int numPages = resp.data().length;
		if(numPages == 0) {
			return null;
		}
		Page[] pages = new Page[numPages];
		for(int i = 0; i<numPages;i++) {
			PageResponse pageResp = client.get()
					.uri(baseUri+"/"+type+"/"+resp.data()[i].name())
					.retrieve()
					.body(PageResponse.class);
			pages[i] = PageFactory.makePage(type, pageResp.data());
		}
		return pages;
	}
	public static void wipeAll() {
		client.delete()
			.uri("http://localhost:9000/v1/honeycomb")
			.retrieve()
			.body(String.class);
		baseUri = null;
		IDSingleton.resetID();
	}
}
