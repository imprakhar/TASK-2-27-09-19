package wp.bank;

public class BankAccount 
{

	double ano;
	String name;
	double balance;
	String atype;
	double avgBalance;
	static double totalDeposit;
	static double totalWithdraw;
	
	
	
	public BankAccount(double ano, String name, double balance, String atype) 
	{
		this.ano = ano;
		this.name = name;
		this.balance = balance;
		this.atype = atype;
	}

	public void initializeAccount(double ano,String name,double balance,String atype)
	{
		this.ano=ano;
		this.name=name;
		this.balance=balance;
		this.atype=atype;
	}
	
	public void displayDetails()
	{
		System.out.println(" Account Number: "+ano+"\n Name: "+name+"\n Balance: "+balance+"\n Account type: "+atype);
	}
	
	public static void averageBalance(BankAccount...tmp)
	{
		int total=0;
		for(BankAccount s: tmp)
		{
			total+=s.balance;
		}
		System.out.println("Average balance of accounts "+total/tmp.length);
	}
	
	public void depositMoney(double deposit)
	{
		balance+=deposit;
		totalDeposit+=deposit;
		System.out.println(" Rs. "+deposit+" credited to account: "+ano);
	}
	
	public void withdrawMoney(double withdraw)
	{
		if(balance>=withdraw)
		{
			balance -= withdraw;
			totalWithdraw += withdraw;
			System.out.println(" Rs. "+withdraw+" debited from account: "+ano);
		}
		else
		{
			System.out.println("Insufficient Balance");
		}
	}
	
	public static void totalTransactions()
	{
		System.out.println("Total Deposit: "+totalDeposit+"\nTotal Withdraw: "+totalWithdraw);
	}
	
	public static void main(String[] args) 
	{
		BankAccount b1=new BankAccount(100, "Prakhar", 10000, "Savings");
		BankAccount b2=new BankAccount(101, "Ayushi", 10000, "Current");
		BankAccount b3=new BankAccount(102, "Rishabh", 10000, "Savings");
		
		
		/*b1.initializeAccount(100, "Prakhar", 10000, "Savings");
		b2.initializeAccount(101, "Ayushi", 10000, "Current");
		b3.initializeAccount(102, "Rishabh", 10000, "Savings");*/
		
		//b1.displayDetails();
		
		b2.depositMoney(5000);
		
		b2.displayDetails();
		
		//b3.withdrawMoney(15000);
		
		b3.withdrawMoney(500);
		
		b3.displayDetails();
		
		averageBalance(b1,b2,b3);
		totalTransactions();
		b1.displayDetails();
	}

}
