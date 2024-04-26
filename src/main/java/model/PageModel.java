package model;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Set;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import sprint1.Page;
import sprint1.Company;
import sprint1.Project;
import sprint1.JobPosting;
import sprint1.NewsArticle;
import sprint1.Skill;
import sprint1.Storage;

public class PageModel {
	StringProperty  name = new SimpleStringProperty();
	StringProperty  id = new SimpleStringProperty();
	StringProperty  description= new SimpleStringProperty();
	ObservableList<String> externalLinks = FXCollections.observableArrayList();
	HashMap<String, ObservableList<String>> internalLinks;
	
	public PageModel(String id) {
		Page p = Storage.pull(id);
		this.name.set(p.getName());
		this.id.set(p.getId());
		this.description.set(p.getDescription());
		this.externalLinks.setAll(p.getExternalLinks());
		this.internalLinks = new HashMap<String,ObservableList<String>>();
		Set<String> keys = p.getInternalLinks().keySet();
		for(String key: keys) {
			ObservableList<String> observableIntLinks = FXCollections.observableArrayList();
			observableIntLinks.setAll(p.getInternalLinks(key));
			this.internalLinks.put(key, observableIntLinks);
		}
	}

	public StringProperty getName() {
		return name;
	}

	public void setName(StringProperty name) {
		this.name = name;
	}

	public StringProperty getId() {
		return id;
	}

	public StringProperty getDescription() {
		return description;
	}

	public void setDescription(StringProperty description) {
		this.description = description;
	}

	public ObservableList<String> getExternalLinks() {
		return externalLinks;
	}

	public void setExternalLinks(ObservableList<String> externalLinks) {
		this.externalLinks = externalLinks;
	}

	public HashMap<String, ObservableList<String>> getInternalLinks() {
		return internalLinks;
	}

	public void setInternalLinks(HashMap<String, ObservableList<String>> internalLinks) {
		this.internalLinks = internalLinks;
	}
	public Page getPage() {
		String className = Storage.pull(id.getValue()).getClass().getName();
		ArrayList<String> arrayExternalLinks = new ArrayList<String>();
		for(String link:externalLinks) {
			arrayExternalLinks.add(link);
		}
		HashMap<String,ArrayList<String>> arrayInternalLinks = new HashMap<String,ArrayList<String>>();
		for(String key:internalLinks.keySet()) {
			arrayInternalLinks.put(key, new ArrayList<String>());
			for(String link:internalLinks.get(key)) {
				arrayInternalLinks.get(key).add(link);
			}
		}
		if(className.equals("sprint1.Company")) {
			return new Company(id.getValue(),name.getValue(),description.getValue(),arrayExternalLinks,arrayInternalLinks);
		}
		if(className.equals("sprint1.JobPosting")) {
			return new JobPosting(id.getValue(),name.getValue(),description.getValue(),arrayExternalLinks,arrayInternalLinks);
		}
		if(className.equals("sprint1.NewsArticle")) {
			return new NewsArticle(id.getValue(),name.getValue(),description.getValue(),arrayExternalLinks,arrayInternalLinks);
		}
		if(className.equals("sprint1.Project")) {
			return new Project(id.getValue(),name.getValue(),description.getValue(),arrayExternalLinks,arrayInternalLinks);
		}
		if(className.equals("sprint1.Skill")) {
			return new Skill(id.getValue(),name.getValue(),description.getValue(),arrayExternalLinks,arrayInternalLinks);
		}
		return null;
	}
	
}
