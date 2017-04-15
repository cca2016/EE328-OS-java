import java.net.*;
import java.io.*;

public class GreetingServer extends Thread
{
   private ServerSocket serverSocket;
   public int total;
   public GreetingServer(int port) throws IOException
   {
      serverSocket = new ServerSocket(port);
      serverSocket.setSoTimeout(50000);
   }

   public void run()
   {
      while(true)
      {
         try
         {
            System.out.println("Waiting for client on port " +
            serverSocket.getLocalPort() + "...");
            Socket server = serverSocket.accept();
            DataInputStream in =
                 new DataInputStream(server.getInputStream());
            String content=in.readUTF();
            if (content.equals("exit")) server.close();
            else {
            	try{
                	int tmp=Integer.parseInt(content);                    
                    	 total = total+Integer.parseInt(content);
                         System.out.println("total= "+total);           	
                }catch(NumberFormatException e){
                	System.out.println("please enter a number!");
                 }
                
            }
            
            
           
            //DataOutputStream out =
             //    new DataOutputStream(server.getOutputStream());
            //out.writeUTF("Thank you for connecting to "
             // + server.getLocalSocketAddress() + "\nGoodbye!");
            //server.close();
         }catch(SocketTimeoutException s)
         {
            System.out.println("Socket timed out!");
            break;
         }catch(IOException e)
         {
            e.printStackTrace();
            break;
         }
      }
   }
   public static void main(String [] args)
   {
      int port = Integer.parseInt(args[0]);
      try
      {
         Thread t = new GreetingServer(port);
         t.start();
      }catch(IOException e)
      {
         e.printStackTrace();
      }
   }
}