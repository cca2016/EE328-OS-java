import java.net.*;
import java.io.*;
import java.util.Scanner;
//this program is used to get the data from a http:// website
//while enter the file name ,you need to enter the total path of the file

public class Wget
{
	public static boolean fileExists(String filePath){
		File file=new File(filePath); 
		if(!file.exists()) { 
		return false;//if the result exists
		} else{
		return true;
		}
		} 
   public static void main(String [] args)
   {	   
	   //get the info
	   String Website= args[0];
	   String FilePaths= args[1];
       InputStream inputStream;
       InputStreamReader inputStreamReader;
       BufferedReader bufferedReader;
       FileOutputStream fileOutputStream;
       OutputStreamWriter outputStreamWriter;
      try
      {
    	 if(fileExists(FilePaths))
    	 {
    	 System.out.println("The name has already existed,please enter another file");
    	 }
    	 else
    	 {
         URL url = new URL(Website);
         inputStream = url.openStream();
         inputStreamReader = new InputStreamReader(inputStream, "gb2312");//input to buffer
         bufferedReader = new BufferedReader(inputStreamReader);
         String s;
         File dest = new File(FilePaths);
         fileOutputStream = new FileOutputStream(dest);
         outputStreamWriter = new OutputStreamWriter(fileOutputStream, "gb2312");
         while ((s = bufferedReader.readLine()) != null) {//buffer to output
             outputStreamWriter.write(s);
         }
         outputStreamWriter.close();//close
         fileOutputStream.close();
         bufferedReader.close();
         inputStreamReader.close();
         inputStream.close();  
    	 }
      }catch(IOException e)
      {
         e.printStackTrace();
      }
   }
}