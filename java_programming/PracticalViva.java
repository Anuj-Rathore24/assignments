import java.sql.*;
import java.util.*;
import java.io.*;

public class PracticalViva{
	public static void main(String args[]){
		Scanner input=new Scanner(System.in);
		String bookName,author;
		int bookId;
		System.out.print("Enter Book Name ->");
		bookName=input.next();
		System.out.print("Enter Author ->");
		author=input.next();
		System.out.print("Enter Book Id ->");
		bookId=input.nextInt();

		try{

			BufferedWriter fl=new BufferedWriter(new FileWriter("practical.txt",true));
			fl.write(bookName+" "+author+" "+bookId);
			
			System.out.println("\n\t**The Contents of the file are**");
			BufferedReader rd=new BufferedReader(new FileReader("practical.txt"));
	
			while(rd.read()!=-1){
				System.out.print(rd.readLine);
			}
			// fl.close();
			rd.close();
		}catch(Exception e){
			System.out.println(e.toString());
		}
		input.close();
		
	}
}