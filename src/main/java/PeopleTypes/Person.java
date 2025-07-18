package PeopleTypes;

import java.io.Serializable;
public abstract class Person implements Serializable{
    private static final long serialVersionUID = 1L;

protected String name;
protected String userName;
private static int id;
protected String gender;

    public Person(String name, String userName, String gender)
    {
        this.name = name;
        this.userName = userName;
        if(!(gender.equals("Male") || gender.equals("Female")))
        {
            throw new IllegalArgumentException("Error, gender must be explicitly \"Male\" or \"Female\" this is key for the sucess of the program");
        }
        else
            this.gender = gender;
        id++;
    }
    
    public Person(String name, String gender)
    {
        this.name = name;
        userName = name;
        if(!(gender.equals("Male") || gender.equals("Female")))
        {
            throw new IllegalArgumentException("Error, gender must be explicitly \"Male\" or \"Female\" this is key for the sucess of the program");
        }
        else
            this.gender = gender;
        id++;
    }

    public String getRole()
    {
        return getClass().getSimpleName();
    }

    public String getName()
    {
        return name;
    }
    
    public String getUserName()
    {
        return userName;
    }
    
    public int getId()
    {
        return id;
    }
}