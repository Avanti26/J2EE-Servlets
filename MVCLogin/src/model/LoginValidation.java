package model;


//MODEL LAYER
public class LoginValidation 
{
	public static boolean validate(String username,String password)
	{
		if(username.equals("admin") && password.equals("123"))
		{
			return true;
		}
		else
		{
			return false;
		}
	}
}
