import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class IDChecker {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		while(true)
		{
			System.out.println("*********************");
			System.out.println("1.   ��֤���֤�ֺ�");
			System.out.println("0.   �뿪");
			System.out.println("*********************");
			System.out.println("��ѡ��");
			Scanner sc = new Scanner(System.in);
			String op= sc.nextLine();
			if(op.equals("1"))
			{
			String input = ID.inputID();
			ID.check(input);
			}
			else if(op.equals("0"))
			{
				System.exit(0);
			}
			else
			{
				System.out.println("��������");
				continue;
			}
		}
	
	}
	

}
