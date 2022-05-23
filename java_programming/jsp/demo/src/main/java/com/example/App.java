package com.example;
import java.sql.*;
import java.util.*;
/**
 * Hello world!
 */


public final class App {

    /******************************************************
 *Assignment: To implement JDBC.
 *Name,RollNo: Pooja Baba,TE 302003.
 ******************************************************/


	// private static final Readable InputStream = null;
	static  String URL="jdbc:mysql://localhost:3306/";	//final constant optional
	/* jdbc-protocol that is used
	 * mysql-subprotocol
	 * 172.20.35.20-hostname
	 */
	static  String USER="mysql";
	static String PASWD="";
	public static void main(String args[])
	{
		int ch,ans;
		try
		{
			do
			{
					//1.Get a connection to the database.
					Connection con=DriverManager.getConnection(URL,USER,PASWD);
					/*getConnection-method which will return an object*/
				
					System.out.println("Connection accquired!!");
						
					//2.Create a statement.
					Statement stat=con.createStatement();
					System.out.println("***MENU***\n1.Insert a new data.\n2.Display data.\n3.Delete data.\n4.Update data.\n5.Search a value.\nEnter your choice: ");
					Scanner s=new Scanner(System.in);
					ch=s.nextInt();
					/***************************INSERT A NEW DATA IN studentS TABLE**********************************************/		
					if(ch==1)
					{
						Scanner scan=new Scanner(System.in);
						int roll;
						String name,add;
						System.out.print("Enter the name: ");
						name=scan.next();
						System.out.print("Enter the roll number: ");
						roll=scan.nextInt();
						System.out.print("Enter the address: ");
						add=scan.next();
						stat.executeUpdate("insert into student values("+roll+",'"+name+"','"+add+"');");		
						//above statement returns 1 if the required item is found and it is deleted.Else it is 0
						ResultSet r=stat.executeQuery("select *from student;");
						System.out.print("\tRoll_no\t\t\tName\t\tAddress\n");
						int i = 0;
						while(r.next())
						{
							String rn=r.getString("Rollno");
							String n=r.getString("Name");
							String a=r.getString("Address");
							System.out.println("\t"+rn+"\t\t\t"+n+"\t\t\t"+a);
							i+=1;
						}
						System.out.println("Record inserted!!");
						con.close();
						scan.close();
					}
					/***************************SELECT FROM student TABLE**********************************************/
					if(ch==2)
					{
						//3.Execute the statement with SQL Query.
						ResultSet res=stat.executeQuery("select *from student;");
						/*ResultSet contains the table for the fired Query.
						 * executeQuery-will execute the select queries.
						 * executeUpdate-will execute insert,delete,etc  
						 */
						System.out.print("\tRollNo\t\tName\t\tAddress\n");
						while(res.next())
						{
							String rn=res.getString("Rollno");
							String name=res.getString("Name");
							String add=res.getString("Address");
							System.out.println("\t"+rn+"\t\t"+name+"\t\t"+add);
						}	
					}
					/***************************DELETE FROM RESULT TABLE**********************************************/
						if(ch==3)
						{
		
							stat.executeUpdate("delete from Result where Roll_no=5 and Sub_code=101;");		
							//above statement returns 1 if the required item is found and it is deleted.Else it is 0
							ResultSet r=stat.executeQuery("select *from Result;");
							System.out.print("\tRoll_no\t\t\tSub_code\t\tMarks\n");
							int i = 0;
							while(r.next())
							{
								String rn=r.getString("Roll_no");
								String sc=r.getString("Sub_code");
								String m=r.getString("Marks");
								System.out.println("\t"+rn+"\t\t\t"+sc+"\t\t\t"+m);
								i+=1;
							}
							System.out.println("Record deleted!!");
							con.close();
						}
						/***************************UPDATE A VALUE FROM RESULT TABLE**********************************************/
						if(ch==4)
						{
		
							Scanner sca=new Scanner(System.in);
							int marks,rol,subc;
							System.out.print("Enter roll number: ");
							rol=sca.nextInt();
							System.out.print("Enter new subject code: ");
							subc=sca.nextInt();
							System.out.print("Enter new marks: ");
							marks=sca.nextInt();		
							stat.executeUpdate("update  Result set Marks="+marks+" where Roll_no="+rol+" and Sub_code="+subc+";");		
							//above statement returns 1 if the required item is found and it is deleted.Else it is 0
							ResultSet r=stat.executeQuery("select *from Result;");
							System.out.print("\tRoll_no\t\t\tSub_code\t\tMarks\n");
							int i = 0;
							while(r.next())
							{
								String rn=r.getString("Roll_no");
								String sc=r.getString("Sub_code");
								String m=r.getString("Marks");
								System.out.println("\t"+rn+"\t\t\t"+sc+"\t\t\t"+m);
								i+=1;
							}
							System.out.println("Record updated!!");
							con.close();
                            sca.close();
						}
						/***************************SEARCH A VALUE***********************************/				
						if(ch==5)
						{					
							CallableStatement stmnt =null;
							Scanner sca=new Scanner(System.in);
							int rolno;
							System.out.print("Enter roll number: ");
							rolno=sca.nextInt();
							String sql="{call fetch_detail(?,?,?)}";
							stmnt=con.prepareCall(sql);
							 //Bind IN parameter first, then bind OUT parameter
							stmnt.setInt(1,rolno);// This would set rollno
							// Because second parameter is OUT so register it
						      stmnt.registerOutParameter(2,java.sql.Types.VARCHAR);
						      stmnt.registerOutParameter(3,java.sql.Types.VARCHAR);
							//above statement returns 1 if the required item is found and it is deleted.Else it is 0
							
						    //Use execute method to run stored procedure.
						      stmnt.execute();
						      
						    //Retrieve employee name with getXXX method
						      String SName = stmnt.getString(2);
						      String SAddress=stmnt.getString(3);
						      System.out.print("student's Name: "+SName+"\nstudent's Address: "+SAddress);      
						      stmnt.close();
						      con.close();
							  sca.close();
						}
						System.out.print("Do you want to continue: ");
						ans=s.nextInt();
                        s.close();
			}while(ans==1);
		}
		catch (SQLException se){se.printStackTrace();} //SQL Exception 		
	}
	private static int nextInt() {
		// TODO Auto-generated method stub
		return 0;

}
    
}

