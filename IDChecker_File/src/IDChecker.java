import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class IDChecker {

	public static void main(String[] args)
	{
		// TODO Auto-generated method stub
	ArrayList al=new ArrayList();
	try {
		File file =new File("input.txt");
		FileReader fr=new FileReader(file);
		BufferedReader br=new BufferedReader(fr);
		String line=null;
		while((line=br.readLine())!=null)
		{
		al.add(line);	
		}
		br.close();
		fr.close();
		File correct=new File("correct.txt");
		correct.createNewFile();
		File error=new File("error.txt");
		error.createNewFile();
		FileWriter corW=new FileWriter(correct);
		BufferedWriter corBW=new BufferedWriter(corW);
		FileWriter errW=new FileWriter(error);
		BufferedWriter errBW=new BufferedWriter(errW);
		for(Object a : al)
		{
			ID id=new ID((String)a);
			if(id.verify)
			{
				corBW.write(id.result());
				corBW.newLine();
			}
			else
			{
				errBW.write(id.result());
				errBW.newLine();
			}
		}

		corBW.close();
		corW.close();
		errBW.close();
		errW.close();
		System.out.println("处理完成");
	} catch (Exception e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	
	}
	

}
