public class GameLauncher {

	public static void main(String[] args) 
	{
		// TODO Auto-generated method stub
		
		while(true)
		{
		int s=0;
		int max,min,t,num;
		System.out.println("********猜数字游戏********");
		System.out.print("猜数字范围最小值： ");
		min= Guess.inputNum();
		System.out.print("猜数字范围最大值： ");
		max= Guess.inputNum();
		System.out.print("猜数字次数限制： ");
		t= Guess.inputNum();
		Guess g= new Guess(min,max,t);
		System.out.println("********游戏开始了********");
		System.out.println("第1猜,请输入您猜的数字: ");
		num=Guess.inputNum();
		g.checkNum(num);
		System.out.println("********游戏结束了********");
		System.out.println("猜了"+(g.getTimes()-1)+"次");
		for(int i=2;i<=g.getTimes();i++){
			System.out.println("第"+(i-1)+"猜: "+g.getN()[i-1]);
		}
		System.out.println("------");
		System.out.println("猜数字限制"+t+"次");
		System.out.println("您总共猜了"+(g.getTimes()-1)+"次");
		System.out.println("正确数字："+ g.getNum());
		System.out.println("********再玩一次<Y/N>>********");
		if(!Guess.Again()){
			s=1;
		}
		else{
			System.out.println();
			System.out.println();
			System.out.println();
		}
		if(s==1)
			break;
		}
	} 
}
