import java.util.Scanner;
public class StudentTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//Create a student one
		Student a= new Student("��˼��","F10509005" , "�ʹ���");
		System.out.println("Name: "+a.getName()+" \nѧ��:"+a.getNum()+" \n�༶:"+a.getClasses());
		Scanner input = new Scanner( System.in );
		System.out.println("����������������ѧ�š��༶����Enter����");
		//Input a new student info
		String stuName=input.next();
		String stuNum=input.next();
		String stuClasses=input.next();
		//Display two students' info
		System.out.println("-----------Student 1------------");
		System.out.println("Name: "+stuName+" \n ѧ��:"+stuNum+" \n�༶:"+stuClasses);
		System.out.println("-----------Student 2------------");
		System.out.println("Name: "+a.getName()+" \nѧ��:"+a.getNum()+" \n�༶:"+a.getClasses());
	}

}
