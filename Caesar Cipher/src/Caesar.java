
public class Caesar
{
	private String plainText;
	private int key;
	private String cipherText="";
	private String dictionary="qwertyuiopasdfghjklzxcvbnm";
	Caesar(String plainText,int key)
	{
		this.plainText=plainText;
		this.key=key;
	}
	Caesar(String plainText)
	{
		this.plainText=plainText;
		this.key=3;
	}
	//transform
	public String getCipherText()
	{
		
		for(int i=0;i<=(plainText.length()-1);i++)
		{
			char t=plainText.charAt(i);
			int s= dictionary.indexOf(t);
			s=s+key;
			if(s>=26)
			{
				s=s-26;
			}
			t=dictionary.charAt(s);
			cipherText=cipherText+t;
		}
		return cipherText;
	}
	public void setDictionary(String d){
		dictionary=d;
	}
}
