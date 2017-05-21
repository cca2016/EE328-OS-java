package mydate;
import java.util.*;
public class mydata {
	int year;
	int month;
	int day;
	boolean run_year;
	int this_month_has_day;
	int this_year_has_day;
	public mydata(int year,int month,int day){
		//current info
		this.year=year;
		this.month=month;
		this.day=day;
		//"run" year
		if (this.year % 400==0) this.run_year=true;
		else if (this.year % 100 !=0 && this.year % 4==0) this.run_year=true;
		else this.run_year=false;
		// whole info of the date
		if (this.month==1 || this.month==3 || this.month==5 || this.month==7 || this.month==8 || this.month==10 || this.month==12){
			this.this_month_has_day=31;
		}
		else if (this.month==4 || this.month==6 || this.month==9 || this.month==11){
			this.this_month_has_day=30;
		}
		else if (this.month==2 && this.run_year) this.this_month_has_day=29;
		else this.this_month_has_day=28;
	
		if (this.run_year) this_year_has_day=366;
		else this_year_has_day=365;
		
		//System.out.print(this.year+" "+this.month+" "+this.day+" "+this.run_year+" "+this.this_month_has_day+" "+this.this_year_has_day);
		//System.out.println("\n");
		
	}
	// laterthan:
	public boolean laterThan(mydata date){
		if (this.year<date.year) return false;
		else if (this.year==date.year && this.month<date.month) return false;
		else if (this.year==date.year && this.month==date.month && this.day<date.day) return false;
		return true;
	}
	// first put them in right order then caculate the difference.
	public static int dayDifference(mydata date1, mydata date2){
		mydata date3;
		int difference=0;
		if (date1.laterThan(date2)) {
			date3=date1;	
			date1=date2;
			date2=date3;
		}
		//the same year
		if (date1.year==date2.year){
			if (date1.month==date2.month){
				if (date1.day==date2.day) {
					//System.out.println("0");
					//System.exit(0);
					return 0;
				}
				else {
					return date2.day-date1.day;
				}
			}
			else{
				difference=difference+date1.this_month_has_day-date1.day+date2.day;
				//System.out.println("difference="+);
				for (int i=date1.month+1;i<date2.month;++i){
					mydata date4=new mydata(date1.year,i,1);
					difference=difference+date4.this_month_has_day;
				}
				return difference;
			}
		}
		//different year
		else {
			mydata date5=new mydata(date1.year,12,31);
			mydata date6=new mydata(date2.year,1,1);
			for(int i=date1.year+1;i<date2.year;++i){
				mydata date7=new mydata(i,1,1);
				difference=difference+date7.this_year_has_day;
			}
			difference=difference+dayDifference(date1,date5)+dayDifference(date2,date6);
			return difference+date2.year-date1.year;//12.31-1.1 still has 1 day!
		}
		
	}
	
	//output
	public static void main(String []args) {
		mydata test1=new mydata(2017,2,30);
		mydata test2=new mydata(2000,12,30);
		System.out.println(test1.laterThan(test2));
		int temp=dayDifference(test1,test2);
		System.out.println(temp);
	}
}

