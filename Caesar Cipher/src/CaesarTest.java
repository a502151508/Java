import java.util.Scanner;
public class CaesarTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int key;
		String plainText;
		Scanner input=new Scanner(System.in );
		System.out.println("请依次输入明文和秘钥");
		//input
		plainText=input.next();
		key=input.nextInt();
		// to lower case
		System.out.println("Plaintext:"+plainText);
		plainText=plainText.toLowerCase();
		Caesar c= new Caesar(plainText, key);
		//display
		System.out.println("Key:"+key);	
		System.out.println("Ciphertext："+c.getCipherText());
	}

}
