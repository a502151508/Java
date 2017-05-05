
public class ABGuessLauncher {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		while(true){
		int a=0,b=0,c=0,d=0;
		System.out.println("********猜数字游戏********");
		ABGuess abg=new ABGuess();
		System.out.println("******** 游戏开始  ********");
		abg.checkNum();
		System.out.println("******** 游戏结束 ********");
		System.out.println("您共猜了"+abg.getTimes()+"次！");
		System.out.println("********再玩一次(Y/N)？********");
		if(!ABGuess.Again()){
			break;
		}
		else{
			System.out.println();
			System.out.println();
			System.out.println();
			}
		}
	}
}