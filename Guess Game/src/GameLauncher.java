public class GameLauncher {

	public static void main(String[] args) 
	{
		// TODO Auto-generated method stub
		
		while(true)
		{
		int s=0;
		int max,min,t,num;
		System.out.println("********��������Ϸ********");
		System.out.print("�����ַ�Χ��Сֵ�� ");
		min= Guess.inputNum();
		System.out.print("�����ַ�Χ���ֵ�� ");
		max= Guess.inputNum();
		System.out.print("�����ִ������ƣ� ");
		t= Guess.inputNum();
		Guess g= new Guess(min,max,t);
		System.out.println("********��Ϸ��ʼ��********");
		System.out.println("��1��,���������µ�����: ");
		num=Guess.inputNum();
		g.checkNum(num);
		System.out.println("********��Ϸ������********");
		System.out.println("����"+(g.getTimes()-1)+"��");
		for(int i=2;i<=g.getTimes();i++){
			System.out.println("��"+(i-1)+"��: "+g.getN()[i-1]);
		}
		System.out.println("------");
		System.out.println("����������"+t+"��");
		System.out.println("���ܹ�����"+(g.getTimes()-1)+"��");
		System.out.println("��ȷ���֣�"+ g.getNum());
		System.out.println("********����һ��<Y/N>>********");
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
