                     //     Buffer.java                                  page-1


package dime;
/*
 * demi_god & SS27
 */
import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.util.Scanner;

public class Buffer{
	public static boolean dataReceived=false;
	public static String S;
	public synchronized void getSourceCode(String u){
		URL url;
		URLConnection conn=null;
		try {
			// get URL content
			url = new URL(u);
			conn = url.openConnection();
			conn.connect();
			int status = ((HttpURLConnection) conn).getResponseCode();
			//System.out.println("Status-Code: "+ status);
			switch (status) {
			case 200: 
			case 201:
				
				StringBuilder sb = new StringBuilder();
				   for(Scanner sc = new Scanner(url.openStream()); sc.hasNext(); )
				     sb.append(sc.nextLine());
				   S=new String();
				   S=sb.toString();
			       dataReceived = true;
			       notify();	
			}}
			catch (MalformedURLException ex) {
				dataReceived = false;
				setbits.je.setText(ex.toString());
				//System.out.println(ex.toString());
				}
		   catch (IOException ex) {
				dataReceived = false;
				setbits.je.setText(ex.toString());
				//System.out.println(ex.toString());	
		   }
		finally {
				if (conn != null) {
				try {
				((HttpURLConnection) conn).disconnect();
				} catch (Exception ex) {
				ex.printStackTrace();
				System.out.println(ex.toString());
				}
				}
				
		}
	}
	public synchronized void parser(){
		int cnt=0,i,flag=-1;
		StringBuilder ans= new StringBuilder();
		//System.out.println(dataReceived);
		if(dataReceived){
			S=S.replace("\n"," ");
			for(i=0;i<S.length();++i)
		   {
			 if(S.charAt(i)=='<') 
			{
				 ++cnt;
			if(flag==1) {
				ans.append("\n");flag=0;}
			}
			if(cnt==0) {
				ans.append(S.charAt(i));flag=1;}
			if(S.charAt(i)=='>') --cnt;
		}
		S=ans.toString();
	    S=S.replaceAll("(?m)^[\t]*\r?>","");
	    S=S.replaceAll("(?m)^[\t]*\r?\n","");
		setbits.je.setText(S);
		dataReceived=false;
		notify();
		}
	}
}

	
