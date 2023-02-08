package com.techpalle;

import java.sql.*;

public class A 
{
	public static Connection con=null;
	public static Statement s=null;
	public static PreparedStatement ps=null;
	
	public static String driverPath="com.mysql.cj.jdbc.Driver";
	public static String url="jdbc:mysql://localhost:3306/jdbc";
	public static String userName="root";
	public static String password="aryan";
	
	/* HW by sir
	public void creating(String ename,int esal)
	{
		try 
		{
			Class.forName("com.mysql.cj.jdbc.Driver");
			
			con=DriverManager.getConnection("jdbc:mysql://localhost:3306/jdbc","root","aryan");
			
			s=con.createStatement();
			
			//int row=s.executeUpdate("create table emp (ename varchar(40),esal int)");
			String qry="insert into emp values ('"+ename+"',"+esal+")";
			
			int row=s.executeUpdate(qry);
			System.out.println(row);
		} 
		catch (ClassNotFoundException | SQLException e) 
		{
			e.printStackTrace();
		}
		finally 
		{
			try 
			{
				if (s!=null) 
				{
					s.close();
				}
				if (con!=null) 
				{
					con.close();
				} 
			}
			catch (SQLException e) 
			{
				e.printStackTrace();
			}
		}
	}
	*/
	
	public void creating(String ename,int esal)
	{
		try 
		{
			Class.forName(driverPath);
			
			con=DriverManager.getConnection(url,userName,password);
			
			s=con.createStatement();
			
			int row=s.executeUpdate("create table emp(eid int primary key auto_increment, "
					+ "ename varchar(80) not null,esal int,email varchar(80) unique)");
			
			System.out.println(row);
		} 
		catch (ClassNotFoundException | SQLException e) 
		{
			e.printStackTrace();
		}
		finally 
		{
			try 
			{
				if (s!=null) 
				{
					s.close();
				}
				if (con!=null) 
				{
					con.close();
				} 
			}
			catch (SQLException e) 
			{
				e.printStackTrace();
			}
		}
	}
	
	public int inserting (String name,int sal,String mail) throws ClassNotFoundException, SQLException 
	{
		Class.forName(driverPath);
		
		con=DriverManager.getConnection(url,userName,password);
		
		ps=con.prepareStatement("insert into emp(ename,esal,email) values(?,?,?)");
		
		ps.setString(1, name);
		ps.setInt(2, sal);
		ps.setString(3, mail);
		
		int row= ps.executeUpdate();
//		System.out.println(row);
		
		ps.close();
		con.close();
		
		return row;
	}
	
	
	public void updating (int id, String name,int sal,String mail) throws ClassNotFoundException, SQLException 
	{
		Class.forName(driverPath);
		
		con=DriverManager.getConnection(url,userName,password);
		
		ps=con.prepareStatement("update emp set ename=?,esal=?,email=? where eid=?");
		ps.setString(1, name);
		ps.setInt(2, sal);
		ps.setString(3, mail);
		ps.setInt(4, id);
		
		int row= ps.executeUpdate();
		System.out.println(row);
		
		ps.close();
		con.close();
	}
	
	
	public void deleting (int id) throws ClassNotFoundException, SQLException 
	{
		Class.forName(driverPath);
		
		con=DriverManager.getConnection(url,userName,password);
		
		ps=con.prepareStatement("delete from emp where eid=?");
		ps.setInt(1, id);
		
		int row= ps.executeUpdate();
		System.out.println(row);
		
		ps.close();
		con.close();
	}
	
	
}
