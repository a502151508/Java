import java.util.Scanner;
public class ABGuess {
	private int a,b,c,d;
	private static Scanner s;
	private int times=0;
	private String[] sep,answer;
	private int A=0,B=0;
	public ABGuess()
	{
		a=(int)(Math.random()*(10));
		b=(int)(Math.random()*(10));
		c=(int)(Math.random()*(10));
		d=(int)(Math.random()*(10));
		while(a==b)
			b=(int)(Math.random()*(10));
		while(c==a||c==b)
			c=(int)(Math.random()*(10));
		while(d==a||d==b||d==c)
			d=(int)(Math.random()*(10));
		this.answer = new String[4];
		this.answer[0]=Integer.toString(a);
		this.answer[1]=Integer.toString(b);
		this.answer[2]=Integer.toString(c);
		this.answer[3]=Integer.toString(d);
		System.out.println("��ȷ��:"+a+b+c+d);
	}
	public String[] inputNum()//����µ�����
	{
		s=new Scanner(System.in);
		String input="";
		input=s.nextLine();
		try
		{
		    int a = Integer.parseInt(input);
		}
		catch (Exception e)
		{
			System.out.println("�������ָ�ʽ���ԣ��������������֡�");
			times++;
			return inputNum();
		}
		if(input.length()!=4)
		{
			System.out.println("��������λ�����ԣ�����������4λ����");
			times++;
			return inputNum();
		}
		
		this.sep=getSep(input);
		if(sep[0].equals(sep[1])||sep[0].equals(sep[2])||sep[0].equals(sep[3])
				||sep[1].equals(sep[2])||sep[1].equals(sep[3])||sep[2].equals(sep[3]))
		{
			System.out.println("������4�����ظ������֣�");
			times++;
			return inputNum();
		}
		times++;
		return sep;
	}
	
	public void checkNum()
	{
		while(A!=4){
			A=0;B=0;
			System.out.println("���������µ�����");
			sep=inputNum();
		for(int j=0;j<=3;j++)
		{
			if(sep[j].equals(answer[j]))
				A++;
		}
		for(int j=0;j<=3;j++)
		{
			for(int k=0;k<=3;k++)
			{
				if(j==k)
					continue;
				else if(sep[j].equals(answer[k]))
					B++;
			}
		}
		System.out.println(" "+A+"A"+B+"B");
		}
		System.out.println("��ϲ������ˣ�");
	}
	public int getTimes()
	{
		return times;
	}
	public static boolean Again()//�ж��Ƿ�Ҫ����������Ϸ
	{
		s=new Scanner(System.in);
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
	public static String[] getSep(String input)//�з�����
	{
		String[] s=input.split("");
		return s;
	}
}
		

