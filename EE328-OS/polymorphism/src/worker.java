
import java.util.*;
public class worker {
	String name;
	static int jishu=0;
	double salary_rate;
	double total_salary;
	//ArrayList<worker> list=new ArrayList<worker>();
	public worker(){
		//list.add(this);	
		++jishu;
	}
	public void computepay(int hours){		
	}
	public void printworker(){		
	}
}
class hourlyworker extends worker{
	String name;
	double salary_rate;
	double total_salary;
	public hourlyworker(String name, double s_r,double t_s){
		this.name=name;super.name=name;
		this.salary_rate=s_r;super.salary_rate=s_r;
		this.total_salary=t_s;super.total_salary=t_s;
		}
	public void computepay(int hours){
		if (hours<=40){
			for (int j=1;j<=hours;++j){
				this.total_salary=this.total_salary*(1+this.salary_rate);
			}
		}
		else{
			for (int j=1;j<=40;++j){
				this.total_salary=this.total_salary*(1+this.salary_rate);
			}
			for (int j=1;j<=hours-40;++j){
				this.total_salary=this.total_salary*(1+2*this.salary_rate);
			}
		}
		super.total_salary=this.total_salary;
	}
	
	 public String toString() {
	        return getClass().getSimpleName() + "\t" + this.name+"\t"+this.salary_rate+"\t"+this.total_salary;
	    }
}
class salaryworker extends worker{
	String name;
	double salary_rate;
	double total_salary;
	int hour;
	public salaryworker(String name, double s_r,double t_s){
		this.name=name;super.name=name;
		this.salary_rate=s_r;super.salary_rate=s_r;
		this.total_salary=t_s;super.total_salary=t_s;
	}
	public void computepay(int hours){		
		if (hours<=40){
			for (int j=1;j<=hours;++j){
				this.total_salary=this.total_salary*(1+this.salary_rate);
			}
		}
		super.total_salary=this.total_salary;
	}
	
	//public void printworker(){
	//	System.out.println(this.getClass().getSimpleName()+"\t"+this.name+"\t"+this.salary_rate+"\t"+this.total_salary);
	//}
	public String toString() {
        return getClass().getSimpleName() + "\t" + this.name+"\t"+this.salary_rate+"\t"+this.total_salary;
    }
}

//Comparator
class nameComparator implements Comparator<worker>{   
    public int compare(worker o1,worker o2) {  
        int t=o1.name.compareTo(o2.name);
    	if (t>0) t=1;
    	if (t==0) t=0;
    	if (t<0) t=-1;
		return t;
    }  
    
}  
class rateComparator implements Comparator<worker>{   
    public int compare(worker o1,worker o2) {  
        double t=o1.salary_rate-o2.salary_rate;
        int tt=0;
    	if (t>0) tt=-1;
    	if (t==0) tt=0;
    	if (t<0) tt=1;
		return tt;
    }  
}  
class totalComparator implements Comparator<worker>{   
    public int compare(worker o1,worker o2) {  
        double t=o1.total_salary-o2.total_salary;
        int tt=0;
    	if (t>0) tt=1;
    	if (t==0) tt=0;
    	if (t<0) tt=-1;
		return tt;
    }  
}  
class test{
	public static void main(String[] args){
		//basic info
		worker []a=new worker[6];
		a[0]=new hourlyworker("ddd",0.03,100);a[0].computepay(44);
		a[1]=new hourlyworker("fff",0.04,100);a[1].computepay(43);
		a[2]=new hourlyworker("ccc",0.05,100);a[2].computepay(45);
		a[3]=new salaryworker("aaa",0.07,100);a[3].computepay(40);
		a[4]=new salaryworker("eee",0.06,100);a[4].computepay(40);
		a[5]=new salaryworker("bbb",0.08,100);a[5].computepay(39);
		
		for (int i=0;i<=5;++i){
			
			System.out.println(a[i]);
		}
		//change totalComparator to name..or rate.. 
		Arrays.sort(a, new nameComparator());
		System.out.println("after ordering:");
		for (int i=0;i<=5;++i){
			
			System.out.println(a[i]);
		}
	}
}





