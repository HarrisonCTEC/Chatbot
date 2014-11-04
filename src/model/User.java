package model;

/**
 * Stores information about the user.
 *
 */
public class User
{
	/**
	 * The user's first name.
	 */
	private String name;
	
	/**
	 * How many years old the user is.
	 */
	private int age;
	
	public User()
	{
		
	}
	
	
	/*
	 * Getters and Setters
	 */
	
	public void setName(String name)
	{
		this.name = name;
	}
	
	public String getName()
	{
		return name;
	}
	
	public void setAge(int age)
	{
		this.age = age;
	}
	
	public int getAge()
	{
		return age;
	}

}
