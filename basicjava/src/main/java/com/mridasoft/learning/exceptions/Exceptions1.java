package com.mridasoft.learning.exceptions;

public class Exceptions1 
{
	//return in finally gets executed
	private int testReturn()
	{
		try
		{			
			throw new Exception("get lost");
		}
		catch(Exception e)
		{
			e.printStackTrace();
			return 0;
		}
		finally
		{
			return 2;
		}
	
	}
	
	
	private void methodA() throws Exception
	{
		try
		{			
			throw new Exception("get lost in try");
		}
		catch(Exception e)
		{
			throw new Exception("retrow in catch");
		}
		finally
		{
			throw new Exception("get lost in finally");
		}
	}
	
	//Suppressed exceptions has to be added to the exception thrown in finally
	//, no magic wand to do that automatically
	private void testExceptionSuppression() 
	{
		try
		{
			methodA();
		}
		catch(Exception e)
		{
			System.out.println("Exception caught-"+e.getMessage() + " suppressed exc count="+e.getSuppressed().length);
			for(Throwable t: e.getSuppressed())
			{
				System.out.println("suppresed exceptions-"+t.getMessage());
			}
		}
	}
	
	
	public static void main(String[] args) 
	{
		Exceptions1 app = new Exceptions1();
		int rtnVal = app.testReturn();
		System.out.println("rtnval="+rtnVal);
		
		app.testExceptionSuppression();
	}
}
