package model;

import sprint1.Page;
import sprint1.Storage;

public class SessionSingleton
{
	static SessionSingleton currentSession = new SessionSingleton();
	String userId;
	
	private SessionSingleton()
	{
		this.userId = "";
	}
	
	public static SessionSingleton getInstance()
	{
		return currentSession;
	}
	
	public String getUserId()
	{
		return this.userId;
	}
	
	public void endSession()
	{
		this.userId = "";
	}
	
	public boolean startSession(String id, String password)
	{
		if(checkPassword(id, password)&&checkID(id))
		{
			this.userId = id;
			return true;
		}
		else
		{
			return false;
		}
	}
	
	private boolean checkPassword(String id, String password)
	{
		if(password == "" || id == "")
		{
			return false;
		}
		
		return true;
	}
	private boolean checkID(String id) {
		Page p = Storage.pull(id);
		if(p==null || !p.getClass().getName().equals("sprint1.Person")) {
			//return false;
		}
		return true;
	}
	
}
