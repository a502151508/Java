import java.util.Scanner;
public class Account 
{
	private double balance=-1;

	public void createAccount(Account a)
	{
		System.out.print("请输入开户金额： ");
		inputMoney();
		Menu(a);
	}
	public double getBalance()
	{
		return balance;
	}
	public void Deposit(Account a)
	{
		System.out.print("请输出存款金额：");
		depositMoney(a);
	}
	public void withDraw(Account a)
	{
		System.out.print("请输出提款金额：");
		withdrawMoney(a);
	}
	public void Menu(Account a)
	{
		String i;
		System.out.println("***Main Menu***");
		System.out.println("1)开户");
		System.out.println("2)存款");
		System.out.println("3)提款");
		System.out.println("4)目前余额");
		System.out.println("0)Exit");
		System.out.println();
		System.out.println("Please enter a number in [1,2,3,4,0]");
		Scanner input=new Scanner(System.in );
		i=input.nextLine();
		while(true)
		{
			if("1".equals(i))
				break;
			if("2".equals(i))
				break;
			if("3".equals(i))
				break;
			if("4".equals(i))
				break;
			if("0".equals(i))
				break;
			System.out.print("请重新输入合法数字：");
			Scanner input2=new Scanner(System.in );
			i=input2.nextLine();
		}
		if("1".equals(i)) 
		{
			System.out.println("已开户");
			Menu(a);
		}
		if("2".equals(i)) 
		{
			Deposit(a);
			Menu(a);
		}
		if("3".equals(i)) 
		{
			withDraw(a);
			Menu(a);
		}
		if("4".equals(i))
		{
			System.out.println("目前余额为: $"+a.getBalance()+"元");
			Menu(a);
		}
		if("0".equals(i))
		{
			System.exit(0);
		}
	}
	
	public static void Main()
	{
		Account a=new Account();
		String i;
		System.out.println("***Main Menu***");
		System.out.println("1)开户");
		System.out.println("2)存款");
		System.out.println("3)提款");
		System.out.println("4)目前余额");
		System.out.println("0)Exit");
		System.out.println();
		System.out.println("Please enter a number in [1,2,3,4,0]");
		Scanner input=new Scanner(System.in );
		i=input.nextLine();
		while(true)
		{
			if("1".equals(i))
				break;
			if("2".equals(i))
				break;
			if("3".equals(i))
				break;
			if("4".equals(i))
				break;
			if("0".equals(i))
				break;
			System.out.print("请重新输入合法数字： ");
			Scanner input2=new Scanner(System.in );
			i=input2.nextLine();
		}
		if("1".equals(i)) 
		{
			a.createAccount(a);
		}
		if("2".equals(i))
		{
			System.out.println("未开户");
			Main();
		}
		if("3".equals(i))
		{
			System.out.println("未开户");
			Main();
		}
		if("4".equals(i))
		{
			System.out.println("未开户");
			Main();
		}
		if("0".equals(i))
		{
			System.exit(0);
		}
	}

	public  void inputMoney()
	{
		Scanner input=new Scanner(System.in );
		double money = 0;
		try
		{
			money=input.nextDouble();
			if(money<=1000)
			{
				System.out.println("开户金额必须大于1000");
				Main();
			}
			else
			{
				balance=money;
				System.out.println("开户成功，存入$"+balance+"元!");
			}
		}
		catch(Exception e)
		{
			System.out.println("请输入合法金额");
			Main();
		}
	}
	public void depositMoney(Account a)
	{
		Scanner input=new Scanner(System.in );
		double money = 0;
		try
		{
			money=input.nextDouble();
			if(money<0)
			{
				System.out.println("存款失败！请输入非负数值");
				Menu(a);
			}
			else{
				a.balance=a.balance+money;
				System.out.println("成功存入"+money+"元!");
		
			}
		}
		catch(Exception e)
		{
			System.out.println("存款失败！请输入金额！");
			Menu(a);
		}
	}
	public void withdrawMoney(Account a)
	{
		Scanner input=new Scanner(System.in );
		double money = 0;
		try
		{
			money=input.nextDouble();
			if(money<0)
			{
				System.out.println("提款失败！请输入非负数值");
				Menu(a);
			}
			else if(money>a.balance)
			{
				System.out.println("提款失败！提款金额大于目前余额");
				Menu(a);
			}
			else
			{
				a.balance=a.balance-money;
				System.out.println("成功领出"+money+"元!");
				
			}
		}
		catch(Exception e)
		{
			System.out.println("提款失败！请输入金额！");
			Menu(a);
		}
	}
	

}
	
