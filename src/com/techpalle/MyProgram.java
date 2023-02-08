package com.techpalle;

import java.sql.SQLException;

public class MyProgram 
{
	public static void main(String[] args) 
	{
		A a=new A();
		//a.creating("Aryan",50);
		
		try 
		{
			int r= a.inserting("Varun", 60000, "varuna@gmail.com");
			System.out.println(r);
			//a.updating(4, "Santosh", 7000, "santosh@gmail.com");
			//a.deleting(4);
		} 
		catch (ClassNotFoundException | SQLException e) 
		{
			e.printStackTrace();
		}
	}

}
// how to set the autoincrement valuefrom 1 and if any skiped how to delete. 
//if delete any auto increment value then why it not assigned again