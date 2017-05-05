
public class Student 
{
	private String stuName;
	private String stuNum;
	private String classes;
	public Student(String stuName,String stuNum, String classes )
	{
		this.stuName=stuName;
		this.stuNum=stuNum;
		this.classes=classes;	
	}
	//set student name
	public void setName(String stuName)
	{
		this.stuName=stuName;	
	}
	//set student number
	public void setNum(String stuNum )
	{
		this.stuNum=stuNum;
	}
	//set student class
	public void setclasses( String classes )
	{
		this.classes=classes;	
	}
	//get name
	public String getName()
	{
		return stuName;		
	}
	//get number
	public String getNum()
	{
		return stuNum;		
	}
	//get class
	public String getClasses()
	{
		return classes;		
	}
}
