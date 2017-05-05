import java.util.Scanner;
public class StudentTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//Create a student one
		Student a= new Student("张思驰","F10509005" , "资管三");
		System.out.println("Name: "+a.getName()+" \n学号:"+a.getNum()+" \n班级:"+a.getClasses());
		Scanner input = new Scanner( System.in );
		System.out.println("请依次输入姓名、学号、班级，按Enter继续");
		//Input a new student info
		String stuName=input.next();
		String stuNum=input.next();
		String stuClasses=input.next();
		//Display two students' info
		System.out.println("-----------Student 1------------");
		System.out.println("Name: "+stuName+" \n 学号:"+stuNum+" \n班级:"+stuClasses);
		System.out.println("-----------Student 2------------");
		System.out.println("Name: "+a.getName()+" \n学号:"+a.getNum()+" \n班级:"+a.getClasses());
	}

}
