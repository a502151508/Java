
public class ABGuessLauncher {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		while(true){
		int a=0,b=0,c=0,d=0;
		System.out.println("********��������Ϸ********");
		ABGuess abg=new ABGuess();
		System.out.println("******** ��Ϸ��ʼ  ********");
		abg.checkNum();
		System.out.println("******** ��Ϸ���� ********");
		System.out.println("��������"+abg.getTimes()+"�Σ�");
		System.out.println("********����һ��(Y/N)��********");
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