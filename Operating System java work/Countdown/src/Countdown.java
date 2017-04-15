import java.util.Scanner;

public class Countdown {
	public static boolean flag=true;
	public static int i=10;
	public static void main(String args[]) {
		Thread t1 = new Thread(){
			public void run()
			{
				while ((i >= 0)&&(flag)) {
					System.out.println(i--);
					try {
						Thread.sleep(1000);
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
			}
		};
		t1.start();
		Thread t2 = new Thread(){
			public void run()
			{
				Scanner input = new Scanner(System.in);//scan input from console
				while (true) {
					String b = input.nextLine();
					if (b == null || b.length() <= 0) {//if input==ENTER...
						flag=false;
						break;
					}
				}
				if(i<0&&(!flag))
				{
					System.out.println("Finished");
				}
				else if(!flag)
				{
					System.out.println("Interrupted");
					
				}
			}
			
		};
		t2.start();
		
	}

}
	
