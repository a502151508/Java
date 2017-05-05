import java.util.Date;
public class TimeTool {
	static final int N=1900;
	public static void showCurrentTime()
	{
		Date now =new Date();
		System.out.println(now);
	}
	public static boolean isLeapYear(int year)
	{
		boolean isLeapYear=false;
		if((year%4)==0&&(year%100)!=0||(year%400)==0)
			isLeapYear=true;
		return isLeapYear;
	}
	public static void showCalendar(int Year, int Month) 
	{
		// TODO Auto-generated method stub
		int n = 1;//1900��1��1�� ������һ  
        int month[] = {0,31,28,31,30,31,30,31,31,30,31,30,31}; //�����洢�·ݵ�����  
        int year[] = new int[1001];  //�����洢ÿ��1��1�������ڼ�  
        year[0] = n;  
        for(int i=1;i<year.length;i++)
        {  
            int days = 365;  
            if(isLeapYear(i+N-1)){//�������ǰһ������������Ҫ��366  
                days = 366;  
                year[i] = (year[i-1] + days)%7;  
            }  
            else{  
                year[i] = (year[i-1] + days)%7;  
            }  
        }        
        System.out.println("������     " +"����һ     "+"���ڶ�    "+"������     "+"������     "+"������     "+"������   ");  
        System.out.println();  
        if(isLeapYear(Year))
        { //���������,2�¸�Ϊ29��  
            month[2] = 29;  
        }  
        int day=0; //������¼��ǰ�µ�һ���ǽ���ĵڼ���  
        for(int i=1;i<Month;i++)
        {  
            day = day + month[i];  
        }  
          
        day = (year[Year-N]+day)%7;  
        for(int i=0;i<7;i++)
        {//�������  
            if(day == i)
            {  
                System.out.print("  " + 1 + "   ");  
                if(day == 6)
                {  
                    System.out.println();  
                }  
                break;  
            }  
            else
            {  
                System.out.print("      ");  
            }  
        }  
        for(int i=2;i<=month[Month];i++)
        {  
            if(i<10)
            {  
                System.out.print("  " + i + "   ");  
            }  
            else
            {  
                System.out.print(" " + i + "   ");  
            }  
            if((day+i-1)%7 == 6)
            {  
                System.out.println();  
            }  
        }  
    }  
}













