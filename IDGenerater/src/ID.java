import java.util.Arrays;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
public class ID {
	static final String letter="ABCDEFGHIJKLMNOPQRSTUVWXYZ";
	static final String[] city={"̨����","̨����","��¡��","̨����","������","̨����","������"
			,"��԰��","������","������","������","̨����","��Ͷ��","�û���","������","������"
			,"������","̨����","������","������","������","̨����","������","�����","����ɽ","������"};
	String xs,gender;
	static final int[] code= {10,11,12,13,14,
			15,16,17,34,18,19,20,21,22,35,23,24
			,25,26,27,28,29,32,30,31,33};
	static String generate(String c,String g)
	{
		String id;
		int[] num={(int)(Math.random()*10),(int)(Math.random()*10),(int)(Math.random()*10),(int)(Math.random()*10),(int)(Math.random()*10),(int)(Math.random()*10),(int)(Math.random()*10),(int)(Math.random()*10)};
		int index=0;
		for(int t=0;t<=city.length;t++)
		{
			if(c.equals(city[t]))
			{
				index=t;
				break;
			}
		}
		char l=letter.charAt(index);
		int gender;
		if(g.equals("��"))
			gender=1;
		else
			gender=2;
		int sum=0;
		int initSum=code[index]/10+(code[index]%10)*9+gender*8;
		int t=0;
		while(true)
		{
			sum=initSum;
			for(int i=0;i<=6;i++)
			{
				sum=sum+num[i]*(7-i);
			}
			sum=sum+num[7];
			if(sum%10==0)
			{
				break;
			}
				else
			{
				if(t==7&&num[t]==9)
				{
					t=0;
					num[t]=0;
				}
				if(num[t]<9)
					num[t]++;
				else
				{
					if(t<7)
					t++;
					else
					t=0;
				}
				
			}
		}
		id=""+l+gender;
		for(int j=0;j<=7;j++)
			id=id+String.valueOf(num[j]);
		return id;
	}
	static boolean check(String id)
	{
		char c= id.charAt(0);
		int index=letter.indexOf(c);
//		System.out.println("������:"+city[index]);
//		System.out.println("������:"+code[index]);
		int g=Integer.parseInt(String.valueOf(id.charAt(1)));
		if(g!=1&&g!=2)
		{
			System.out.println("��ʽ����");
			return false;
		}
		int sum=code[index]/10
				+(code[index]%10)*9+
				Integer.parseInt(String.valueOf(id.charAt(1)))*8
				+Integer.parseInt(String.valueOf(id.charAt(2)))*7
				+Integer.parseInt(String.valueOf(id.charAt(3)))*6
				+Integer.parseInt(String.valueOf(id.charAt(4)))*5
				+Integer.parseInt(String.valueOf(id.charAt(5)))*4
				+Integer.parseInt(String.valueOf(id.charAt(6)))*3
				+Integer.parseInt(String.valueOf(id.charAt(7)))*2
				+Integer.parseInt(String.valueOf(id.charAt(8)))*1
		+Integer.parseInt(String.valueOf(id.charAt(9)))*1;
		if(sum%10!=0)
		{
			System.out.println("���֤�ֺŴ���");
			return false;
		}
		System.out.println("����ֺ���ȷ");
		String gender="";
		if(g==1)
			gender="��";
		else
			gender="Ů";
		System.out.printf("��λ������%s��%s��������",city[index],gender);
		System.out.println("");
		return true;
	}
	static String inputID()
	{
		String regEx="^[QWERTYUIOPLKJHGFDSAZXCVBNM]\\d{9}$";
		Pattern pattern=Pattern.compile(regEx);
		Scanner sc= new Scanner(System.in);
		System.out.print("���������֤�ֺ�");
		String input=sc.nextLine();
		Matcher matcher=pattern.matcher(input);
		boolean rs=matcher.matches();
		if(!rs)
		{
			System.out.println("��ʽ����");
			return inputID();
		}
		else{
			return input;	
		}
		
	}
	boolean inputInfo()
	{
		Scanner sc= new Scanner(System.in);
		System.out.print("����������:");
		String xs=sc.next();
		System.out.print("�������Ա�:");
		String g=sc.next();
		 int t=0;
			for(String s : city)
			{
		        if(s.equals(xs))
		        {
		        	t=1;
		        	break;
		        }
			}
			if(t==1)
			{
				this.xs=xs;
			}
			else
			{
				System.out.println("���д���");
				return inputInfo();
			}
			if(!g.equals("��")&&!g.equals("Ů"))
			{
				System.out.println("�Ա����");
				return inputInfo();
			}
			else
			{
				this.gender=g;
				return true;
			}

		}	
}
