import java.util.Scanner;
public class Checker {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
//		Scanner sc=new Scanner(System.in);
//		String[] a=new String[9];
//		for(int i=0;i<=8;i++)
//		{
//			a[i]=sc.nextLine();
//		}
//		for(int i=0;i<=8;i++)
//		{
//			System.out.println(a[i]);
//		}
		Sudoku sdk=new Sudoku();
		sdk.keyinBoard();
		sdk.showBoard();
		System.out.println(sdk.checkBoard());
	}

}
