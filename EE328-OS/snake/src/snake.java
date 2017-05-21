import java.util.*;
public class snake {
	public static void main(String []args) {
		int n=0;
		//input stage:
		Scanner input=new Scanner(System.in);
		System.out.println("Enter table size 1-9, 0 to exit:");
		n=input.nextInt();
		if ((n>9)||(n<0)) {
			System.out.println("please enter a number in the range 0-9");
			System.exit(0);
		}
		if (n==0) System.exit(0);
		
		// for odd row: upside-down sequence
		// for even row: original sequence
		int [][] snake=new int [n][n];
		int jishu=1;
		for (int i=0;i<n;++i)
		{
			if (i%2==0) 
			{
				for (int j=0;j<n;++j)
				{
					snake[i][j]=jishu;
					++jishu;
				}
			}
			else
			{
				for (int j=n-1;j>=0;--j)
				{
					snake[i][j]=jishu;
					++jishu;
				}
			}
		}
		
		//output
		for (int i=0;i<n;++i)
		{
			for (int j=0;j<n;++j)
				System.out.print(snake[i][j]+"\t");
			System.out.print("\n");
		}
		
	}

}
