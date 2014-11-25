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
	
	/**
	 * Stores information about the user.
	 */
	public User()
	{
		
	}
	
	/**
	 * Sets the user's name.
	 * @param name The user's name.
	 */
	public void setName(String name)
	{
		this.name = name;
	}
	
	/**
	 * Gets the user's name. 
	 * @return The user's name.
	 */
	public String getName()
	{
		return name;
	}
	
	/**
	 * Sets the user's age.
	 * @param age The user's age.
	 */
	public void setAge(int age)
	{
		this.age = age;
	}
	
	/**
	 * Gets the user's age.
	 * @return The use's age.
	 */
	public int getAge()
	{
		return age;
	}

}
