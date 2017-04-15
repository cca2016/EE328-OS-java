import java.net.*;
import java.io.*;
 
public class GreetingClient
{
	//static int total=0;
	public static void main(String [] args)
   {
	  
      String serverName = args[0];
      int port = Integer.parseInt(args[1]);
      //int para = Integer.parseInt(args[2]);
      String para= args[2];//get add number as a String
      try
      {
         Socket client = new Socket(serverName, port);     
         OutputStream outToServer = client.getOutputStream();
         DataOutputStream out =new DataOutputStream(outToServer);
         out.writeUTF(para);
         client.close();
      }catch(IOException e)
      {
         e.printStackTrace();
      }
   }
}