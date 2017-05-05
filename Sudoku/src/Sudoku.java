import java.util.Scanner;
public class Sudoku 
{
	private int[][] board;
	String[] a=new String[9];
	Scanner sc=new Scanner(System.in);
	public Sudoku()
	{
		board = new int[9][9];
	}
	void keyinBoard()
	{
		
		for(int i=0;i<=8;i++)
			{
				a[i]=sc.nextLine();
			}
		System.out.println("");
		for(int i=0;i<=8;i++)
		{
			for(int j=0;j<=8;j++)
			{ 
				board[i][j]=Integer.parseInt(String.valueOf(a[i].charAt(j*2)));
			}
		}
	}
	void showBoard()
	{
		for(int i=0;i<=8;i++)
		{
			for(int j=0;j<=8;j++)
			{
				if(j!=8)
					System.out.print(board[i][j]+" ");
				else
				{
					System.out.print(board[i][j]);
					System.out.println("");
				}
			}
		}
			
	}
	boolean checkBoard()
	{
		int[] freRow=new int[9];
		int[] freCol=new int[9];
		int[] freBlock=new int[9];
		for(int i=0;i<=8;i++)
		{
			for(int j=0;j<=8;j++)
			{
				freCol[board[i][j]-1]++;
			}
			for(int q=0;q<=8;q++)
			{
				if(freCol[q]!=1)
					return false;
				freCol[q]=0;
			}
		}
		
		
		
		for(int i=0;i<=8;i++)
		{
			for(int j=0;j<=8;j++)
			{
				freCol[board[j][i]-1]++;
			}
			for(int q=0;q<=8;q++)
			{
				if(freCol[q]!=1)
					return false;
				freCol[q]=0;
			}
		}
		
		
		for(int i=0;i<=8;i=i+3)
		{
			for(int j=0;j<=8;j=j+3)
			{
				for(int p=i;p<=i+2;p++)
				{
					for(int q=j;q<=j+2;q++)
					{
						freBlock[board[p][q]-1]++;
					}
				}
				for(int s=0;s<=8;s++)
				{
					if(freBlock[s]!=1)
						return false;
					freBlock[s]=0;					
				}
			}
		}
		return true;
	}
}
