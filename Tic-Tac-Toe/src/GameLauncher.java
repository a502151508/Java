public class GameLauncher {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("********** Game Start **********");
		TicTacToe ttt=new TicTacToe();
		while(true){
			int s=0;
			if(!ttt.x.getResult())
			{
				while(true){
					ttt.setChess(ttt.x);
					if(ttt.checkChess(ttt.x))
					{	
						break;
					}
					ttt.setChess(ttt.o);
					if(ttt.checkChess(ttt.o))
					{
						break;
					}
				}
					
			}
			else
			{
				while(true){
					ttt.setChess(ttt.o);
					if(ttt.checkChess(ttt.o))
						break;
					ttt.setChess(ttt.x);
					if(ttt.checkChess(ttt.x))
						break;
					
				}
			}
		System.out.println("********‘ŸÕÊ“ª¥Œ<Y/N>>********");
			if(!TicTacToe.Again()){
				s=1;
				
			}
			else{
				System.out.println();
				System.out.println();
				System.out.println();
				for(int i=0;i<=2;i++)
					for(int j=0;j<=2;j++)
					{
						ttt.getBoard()[i][j]="";
					}
						
			}
			if(s==1)
				break;
		}
	}

}
