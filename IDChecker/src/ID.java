import java.util.Arrays;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
public class ID {
	static final String letter="ABCDEFGHIJKLMNOPQRSTUVWXYZ";
	static final String[] city={"台北市","台中市","基隆市","台南市","高雄市","台北县","宜兰县"
			,"桃园县","嘉义县","新竹县","苗栗县","台中县","南投县","彰化县","新竹市","云林县"
			,"嘉义县","台南县","高雄县","屏东县","花莲县","台东县","金门县","澎湖县","阳明山管理局","连江县"};
	static final int[] code= {10,11,12,13,14,
			15,16,17,34,18,19,20,21,22,35,23,24
			,25,26,27,28,29,32,30,31,33};
	
	static boolean check(String id)
	{
		char c= id.charAt(0);
		int index=letter.indexOf(c);
//		System.out.println("城市是:"+city[index]);
//		System.out.println("代号是:"+code[index]);
		int g=Integer.parseInt(String.valueOf(id.charAt(1)));
		if(g!=1&&g!=2)
		{
			System.out.println("格式不符");
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
			System.out.println("身份证字号错误");
			return false;
		}
		System.out.println("身份字号正确");
		String gender="";
		if(g==1)
			gender="男";
		else
			gender="女";
		System.out.printf("是位出生在%s的%s性朋友呢",city[index],gender);
		System.out.println("");
		return true;
	}
	static String inputID()
	{
		String regEx="^[QWERTYUIOPLKJHGFDSAZXCVBNM]\\d{9}$";
		Pattern pattern=Pattern.compile(regEx);
		Scanner sc= new Scanner(System.in);
		System.out.print("请输入身份证字号");
		String input=sc.nextLine();
		Matcher matcher=pattern.matcher(input);
		boolean rs=matcher.matches();
		if(!rs)
		{
			System.out.println("格式不符");
			return inputID();
		}
		else{
			return input;	
		}
		
	}
}
