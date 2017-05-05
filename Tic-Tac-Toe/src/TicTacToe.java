import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
public class TicTacToe {
	private String[][] board;
	String regEx="^[123],[123]$";
	Pattern pattern=Pattern.compile(regEx);
	Scanner sc=new Scanner(System.in);
	Player x,o;
	Player getOpponent(Player p)
	{
		if(p.equals(x))
				return o;
		else
		{
			return x;
		}
	}
	public TicTacToe()
	{
		board=new String[3][3];
		for(int i=0;i<=2;i++)
			for(int j=0;j<=2;j++)
			{
				board[i][j]="";
			}
				
		x=new Player(true);
		o=new Player(false);
	}
	public void displayBoard()
	{
		Scanner sc=new Scanner(System.in);
		for(int j=0;j<=2;j++)
		{
			for(int k=0;k<=2;k++)
			{
				if(board[j][k]==null)
					System.out.print("\t");	
				else
					System.out.print("\t"+board[j][k]);
				if(k!=2)
					System.out.print("\t|");
			}
			System.out.println("");
			if(j!=2)
			System.out.println("------------------------------------------------");
		}
	}
	public String[][] getBoard()
	{
		return board;
	}
	boolean checkChess(Player p)
	{
		for(int q=0;q<=2;q++)
		{
			if(board[q][0].equals(p.mark)&&board[q][1].equals(p.mark)&&board[q][2].equals(p.mark))
			{
				System.out.println(p.playerName+" is the winner1!");
				p.setResult(true);
				getOpponent(p).setResult(false);
				return true;
			}
		}
		for(int q=0;q<=2;q++)
		{
			if(board[0][q].equals(p.mark)&&board[1][q].equals(p.mark)&&board[2][q].equals(p.mark))
			{
				System.out.println(p.playerName+" is the winner2!");
				p.setResult(true);
				getOpponent(p).setResult(false);
				return true;
			}
		}
		if(board[0][0].equals(p.mark)&&board[1][1].equals(p.mark)&&board[2][2].equals(p.mark))
		{
			System.out.println(p.playerName+" is the winner!3");
			p.setResult(true);
			getOpponent(p).setResult(false);
			return true;
		}
		if(board[0][2].equals(p.mark)&&board[1][1].equals(p.mark)&&board[2][0].equals(p.mark))
		{
			System.out.println(p.playerName+" is the winner!4");
			p.setResult(true);
			getOpponent(p).setResult(false);
			return true;
		}
		for(int j=0;j<=2;j++)
		{
			for(int k=0;k<=2;k++)
			{
				if(board[j][k]=="")
					return false;
			}
				
		}
		System.out.println("It's a Draw!");
		p.setResult(!p.getResult());
		getOpponent(p).setResult(!getOpponent(p).getResult());
		return true;
	}
	public static boolean Again()//判断是否要继续进行游戏
	{
		Scanner sc=new Scanner(System.in);
		String k=sc.nextLine();
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
	boolean setChess(Player p)
	{
		int x,y;
		System.out.println(p.playerName+",enter your "
				+ "move (row[1-3],column[1-3]): ");
		String input=sc.nextLine();
		Matcher matcher=pattern.matcher(input);
		boolean rs=matcher.matches();
		if(!rs)
		{
			System.out.println("The value y"
					+ "ou entered is invalid! Please try agin.");
			return setChess(p);
		}
		else
		{
			x=Integer.parseInt(String.valueOf(input.charAt(0)));
			y=Integer.parseInt(String.valueOf(input.charAt(2)));
		}
		if(board[x-1][y-1].equals(""))
		{
			board[x-1][y-1]=p.mark;
			displayBoard();
			return true;
		}
		else
		{
			System.out.println("The value y"
					+ "ou entered is invalid! Please try agin.");
			return setChess(p);
		}
	}
}

class Chess{
	private int x,y;
	Chess(int x,int y)
	{
		this.x=x;
		this.y=y;
	}
	int getX(){
		return x;
	}
	int getY(){
		return y;
	}
}


class Player{
	String playerName;
	String mark;
	boolean result=false;
	Player(boolean t)
	{
		if(t)
		{
			this.playerName="Player-X";
			mark="X";
		}
			
		else
		{
			this.playerName="Player-O";
			mark="O";
		}
	}
	void setResult(boolean result)
	{
		this.result=result;
	}
	boolean getResult(){
		return result;
	}
}