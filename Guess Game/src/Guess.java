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
	public boolean checkRange(int input)//������������Ƿ������ַ�Χ��
	{
		if(input>=min&&input<=max)
			return true;
		else			
			return false;
	}
	public boolean checkTimes(int times)//�������ִ����Ƿ񳬹�����
	{
		if(times<=t)
			return true;
		else
		{
			System.out.println("�Ѵﵽ�����ִ�������");
			return false;
		}
	}	
	public int getNum()//������ɵ������
	{
		return num;
	}
	public int checkNum(int input)//������ֲµĴ�С
	{
		
		if(!checkRange(input))
		{
			n[times]=input;
			System.out.println("�´��ˣ����µ����ֳ����𰸷�Χ");
			System.out.println("���ַ�Χ: "+min+"~"+max);
			times++;
			if(checkTimes(times))
			{
				System.out.println("��"+(times)+"��,"+"���������µ�����: ");
				return checkNum(inputNum());
			}
			else
				return 0;
		}
		if(input>num)
		{
			n[times]=input;
			times++;
			System.out.println("�´��ˣ����µ����ֱȴ𰸴�");
			max=input;
			System.out.println("���ַ�Χ: "+min+"~"+max);
			if(checkTimes(times))
			{	
				System.out.println("��"+(times)+"��,"+"���������µ�����: ");
				return checkNum(inputNum());
			}
			else
				return 0;
		}
		else if(input<num)
		{
			n[times]=input;
			times++;
			System.out.println("�´��ˣ����µ����ֱȴ�С��");
			min=input;
			System.out.println("���ַ�Χ: "+min+"~"+max);
			if(checkTimes(times))
			{
				System.out.println("��"+(times)+"��,"+"���������µ�����: ");
				return checkNum(inputNum());
			}
			else
				return 0;
		}
		else
		{
			n[times]=input;
			times++;
			System.out.println("��ϲ���¶��ˣ�");
			System.out.println("��������"+times+"��");
			return 0;
		}
	}
	public static int inputNum()//����µ�����
	{
		s = new Scanner(System.in);
		int input=0;
		try
		{
		input=s.nextInt();
		}
		catch(Exception e)
		{
			System.out.println("������Ϸ�����");
			return inputNum();
		}
		return input;
	}
	public int[] getN()//���ÿһ�����µ�����
	{
		return n;
	}
	public int getTimes(){//��òµĴ���
		return times;
	}
	public static boolean Again()//�ж��Ƿ�Ҫ����������Ϸ
	{
		String k=s.nextLine();
//		System.out.println("y/n=:"+k);
		if(k.equals("y")||k.equals("Y"))
			return true;
		else if(k.equals("n")||k.equals("N"))
			return false;
		else 
		{
			System.out.println("������Y/N");
			return Again();
		}
	}
}
