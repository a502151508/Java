import java.util.Scanner;

public class TimeToolTest {

	public static void main(String[] args) 
	{
		// TODO Auto-generated method stub

		String input;
		Scanner scanner=new Scanner(System.in);
		do
		{
			System.out.println("***Main Menu***");
			System.out.println("1) Show The Current Time");
			System.out.println("2) Leap Year");
			System.out.println("3) Show the Calendar");
			System.out.println("0) Exit");			
			System.out.println("");
			System.out.println("Please enter a number in [1,2,3,0]");
			input = scanner.next();
			int num;
			try
			{
			num = Integer.parseInt(input);
			}
			catch(Exception e)
			{
				System.out.println("请输入合法数字");
				continue;
			}
			switch(num)
			{
			case 1:
				TimeTool.showCurrentTime();
				break;
			case 2:
				System.out.print("Please enter the number of year: ");
				int year= scanner.nextInt();
				if(TimeTool.isLeapYear(year))
					System.out.println(year+" is a leap year");
				else
					System.out.println(year+" is not a leap year");
				break;
			case 3:
				System.out.print("Year:");
				int y=inputYear();
				System.out.print("Month:");
				int m=inputMouth();
				TimeTool.showCalendar(y,m);
				System.out.println();
				break;
			case 0:
				System.exit(0);
			default:
				System.out.println("请输入合法数字");
				continue;
			}
		}
		while(true);
	}

	private static int inputMouth() 
	{
		Scanner scanner=new Scanner(System.in);
		int m;
		try{
			m= scanner.nextInt();
			if(m<1||m>12)
			{
				System.out.println("请输入1~12的数字");
				return inputMouth();
			}
		}catch(Exception e){
			System.out.println("请输入正确月份数字");
			return inputMouth();
		}
		return m;
	}

	private static int inputYear() 
	{
		Scanner scanner=new Scanner(System.in);
		int y;
		try{
			y= scanner.nextInt();
			if(y>2900 || y<1900)
			{
				System.out.println("请输入1900~2900之间的年份");
				return inputYear();
			}
		}catch(Exception e){
			System.out.println("请输入正确年份数字");
			return inputYear();
		}
		return y;
	}
}


