public class BankAccount {
	double money;
	static int id=1;
    int currentid;
	public BankAccount(){
		currentid=id;
		++id;
	}
	public void withdraw(int money){
		this.money=this.money-money;
	}
	public void deposit(int money){
		this.money=this.money+money;
	}
	public void endMonth(){
	}
	public void print(){
	}
}
class CheckingAccount extends BankAccount{
	int currentid;
	double money;
	double fee=2.0;
	public CheckingAccount(double money){
		this.money=money;
		this.currentid=super.currentid;
		//System.out.println(this.currentid);
	}
	public void withdraw(int money){
		this.money=this.money-money;
	}
	public void deposit(int money){
		this.money=this.money+money;
	}
	public void endMonth(){
		this.money=this.money-fee;
	}
	public void print(){
		System.out.println("my checking number is "+ currentid+", my balance is "+money);
	}
}
class SavingAccount extends BankAccount{
	int currentid;
	double money;
	double rate=0.05;
	public SavingAccount(double money){
		this.money=money;
		this.currentid=super.currentid;
		//System.out.println(this.currentid);
	}
	public void withdraw(int money){
		this.money=this.money-money;
	}
	public void deposit(int money){
		this.money=this.money+money;
	}
	public void endMonth(){
		this.money=this.money*(1+rate);
	}
	public void print(){
		System.out.println("my saving number is "+ currentid+", my balance is "+money);
	}
}
class AccountTest{
    public static void main(String[] args){

        BankAccount[] bank = new BankAccount[10];
        for(int i=0;i<5;i++)
            bank[i]=new CheckingAccount(50);
        for(int i=5;i<10;i++)
            bank[i]=new SavingAccount(100);

        for(int i=0;i<10;i++){
            bank[i].withdraw(20);
            bank[i].deposit(10);
            //bank[i].withdraw(10); 
        }

        for(int i=0;i<10;i++){
            bank[i].endMonth();
            bank[i].print(); 
        }

    } 
}
