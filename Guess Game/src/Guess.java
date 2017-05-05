import java.util.Scanner;
public class Guess
{
	private int min,max,t;
	private int num ,times=1;
	private static Scanner s;
	private int[] n;
	Guess(int min, int max, int t)
	{
		this.min=min;
		this.max=max;
		this.t=t;
		this.num=(int)(Math.random()*(max-min+1)+min);
		this.n=new int[t+1];
		
	}
	public boolean checkRange(int input)//检查输入数字是否在数字范围内
	{
		if(input>=min&&input<=max)
			return true;
		else			
			return false;
	}
	public boolean checkTimes(int times)//检查猜数字次数是否超过限制
	{
		if(times<=t)
			return true;
		else
		{
			System.out.println("已达到猜数字次数上限");
			return false;
		}
	}	
	public int getNum()//获得生成的随机数
	{
		return num;
	}
	public int checkNum(int input)//检查数字猜的大小
	{
		
		if(!checkRange(input))
		{
			n[times]=input;
			System.out.println("猜错了！您猜的数字超出答案范围");
			System.out.println("数字范围: "+min+"~"+max);
			times++;
			if(checkTimes(times))
			{
				System.out.println("第"+(times)+"猜,"+"请输入您猜的数字: ");
				return checkNum(inputNum());
			}
			else
				return 0;
		}
		if(input>num)
		{
			n[times]=input;
			times++;
			System.out.println("猜错了！您猜的数字比答案大！");
			max=input;
			System.out.println("数字范围: "+min+"~"+max);
			if(checkTimes(times))
			{	
				System.out.println("第"+(times)+"猜,"+"请输入您猜的数字: ");
				return checkNum(inputNum());
			}
			else
				return 0;
		}
		else if(input<num)
		{
			n[times]=input;
			times++;
			System.out.println("猜错了！您猜的数字比答案小！");
			min=input;
			System.out.println("数字范围: "+min+"~"+max);
			if(checkTimes(times))
			{
				System.out.println("第"+(times)+"猜,"+"请输入您猜的数字: ");
				return checkNum(inputNum());
			}
			else
				return 0;
		}
		else
		{
			n[times]=input;
			times++;
			System.out.println("恭喜您猜对了！");
			System.out.println("您共猜了"+times+"次");
			return 0;
		}
	}
	public static int inputNum()//输入猜的数字
	{
		s = new Scanner(System.in);
		int input=0;
		try
		{
		input=s.nextInt();
		}
		catch(Exception e)
		{
			System.out.println("请输入合法数字");
			return inputNum();
		}
		return input;
	}
	public int[] getN()//获得每一次所猜的数字
	{
		return n;
	}
	public int getTimes(){//获得猜的次数
		return times;
	}
	public static boolean Again()//判断是否要继续进行游戏
	{
		String k=s.nextLine();
//		System.out.println("y/n=:"+k);
		if(k.equals("y")||k.equals("Y"))
			return true;
		else if(k.equals("n")||k.equals("N"))
			return false;
		else 
		{
			System.out.println("请输入Y/N");
			return Again();
		}
	}
}
