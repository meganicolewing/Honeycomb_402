package model;
import java.util.ArrayList;
import java.util.HashMap;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import sprint1.Person;
import sprint1.Storage;

public class PersonModel extends PageModel
{
	StringProperty  email = new SimpleStringProperty();
	StringProperty  pronouns = new SimpleStringProperty();
	StringProperty phone = new SimpleStringProperty();
	/**
	 * @param name
	 * @param email
	 * @param pronoun
	 * @param phone
	 * @param id
	 * @param description
	 * @param external_links
	 * @param page_links
	 */
	
	public PersonModel(String id) {
		super(id);
		Person p = (Person)Storage.pull(id);
		this.email.set(p.getEmail());
		this.pronouns.set(p.getPronouns());
		this.phone.set(p.getPhoneNumber());
	}
	/**
	 * @return the email
	 */
	public StringProperty getEmail()
	{
		return email;
	}
	/**
	 * @param email the email to set
	 */
	public void setEmail(StringProperty email)
	{
		this.email = email;
	}
	/**
	 * @return the pronoun
	 */
	public StringProperty getPronouns()
	{
		return pronouns;
	}
	/**
	 * @param pronoun the pronoun to set
	 */
	public void setPronouns(StringProperty pronouns)
	{
		this.pronouns = pronouns;
	}
	/**
	 * @return the phone
	 */
	public StringProperty getPhone()
	{
		return phone;
	}
	/**
	 * @param phone the phone to set
	 */
	public void setPhone(StringProperty phone)
	{
		this.phone = phone;
	}
	public Person getPage() {
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
		return new Person(id.getValue(),name.getValue(),description.getValue(),
				arrayExternalLinks, arrayInternalLinks, pronouns.getValue(), 
				email.getValue(), phone.getValue());
	}
}
