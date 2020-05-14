package model;

public class LoginBean 
{
	String name;
	String password;
	
	public String getName()
	{
		return name;
	}
	
	public void setName(String name)
	{
		this.name=name;
	}
	
	public String getPassword()
	{
		return password;
	}
	
	public void setPassword(String password)
	{
		this.password=password;
	}
	
	public boolean validate()
	{
		if(name.equals("admin") && password.equals("123"))
		{
			return true;
		}
		else
		{
			return false;
		}
	}
}
