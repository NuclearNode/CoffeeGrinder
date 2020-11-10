package com.NuclearNode.CoffeeGrinder;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

import org.springframework.stereotype.Service;

import com.sun.rowset.CachedRowSetImpl;

@Service 
public class QueryHandler 
{
	String database_name;
	CachedRowSetImpl crs ;
	
	
	QueryHandler()
	{
		try 
		{
			String q1 = "SELECT * FROM CoffeeGrinder_drinks.starbucks_drink";
			Connection con = DriverManager.getConnection("jdbc:mysql://starbucks-drinks-online.ci8dkiszgiw2.us-east-2.rds.amazonaws.com:3299/CoffeeGrinder_drinks",
		            "root", "CoffeeGrinder1!");
		    Statement smt = con.createStatement();
		    ResultSet rs = smt.executeQuery(q1);
		    crs = new CachedRowSetImpl();			
		}
		
		catch (Exception e)
		{
			System.err.println(e);
		
		}
	}
	
	
	
	@SuppressWarnings("restriction")
	void resetCachedSet() 
	{
		try 
		{
			crs.getOriginal();
		}
		
		catch (Exception e)
		{
			System.err.println(e);
			
		}
		
	}

}
