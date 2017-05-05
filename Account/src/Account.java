import java.util.Scanner;
public class Account 
{
	private double balance=-1;

	public void createAccount(Account a)
	{
		System.out.print("�����뿪���� ");
		inputMoney();
		Menu(a);
	}
	public double getBalance()
	{
		return balance;
	}
	public void Deposit(Account a)
	{
		System.out.print("���������");
		depositMoney(a);
	}
	public void withDraw(Account a)
	{
		System.out.print("���������");
		withdrawMoney(a);
	}
	public void Menu(Account a)
	{
		String i;
		System.out.println("***Main Menu***");
		System.out.println("1)����");
		System.out.println("2)���");
		System.out.println("3)���");
		System.out.println("4)Ŀǰ���");
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
			System.out.print("����������Ϸ����֣�");
			Scanner input2=new Scanner(System.in );
			i=input2.nextLine();
		}
		if("1".equals(i)) 
		{
			System.out.println("�ѿ���");
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
			System.out.println("Ŀǰ���Ϊ: $"+a.getBalance()+"Ԫ");
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
		System.out.println("1)����");
		System.out.println("2)���");
		System.out.println("3)���");
		System.out.println("4)Ŀǰ���");
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
			System.out.print("����������Ϸ����֣� ");
			Scanner input2=new Scanner(System.in );
			i=input2.nextLine();
		}
		if("1".equals(i)) 
		{
			a.createAccount(a);
		}
		if("2".equals(i))
		{
			System.out.println("δ����");
			Main();
		}
		if("3".equals(i))
		{
			System.out.println("δ����");
			Main();
		}
		if("4".equals(i))
		{
			System.out.println("δ����");
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
				System.out.println("�������������1000");
				Main();
			}
			else
			{
				balance=money;
				System.out.println("�����ɹ�������$"+balance+"Ԫ!");
			}
		}
		catch(Exception e)
		{
			System.out.println("������Ϸ����");
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
				System.out.println("���ʧ�ܣ�������Ǹ���ֵ");
				Menu(a);
			}
			else{
				a.balance=a.balance+money;
				System.out.println("�ɹ�����"+money+"Ԫ!");
		
			}
		}
		catch(Exception e)
		{
			System.out.println("���ʧ�ܣ��������");
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
				System.out.println("���ʧ�ܣ�������Ǹ���ֵ");
				Menu(a);
			}
			else if(money>a.balance)
			{
				System.out.println("���ʧ�ܣ���������Ŀǰ���");
				Menu(a);
			}
			else
			{
				a.balance=a.balance-money;
				System.out.println("�ɹ����"+money+"Ԫ!");
				
			}
		}
		catch(Exception e)
		{
			System.out.println("���ʧ�ܣ��������");
			Menu(a);
		}
	}
	

}
	
