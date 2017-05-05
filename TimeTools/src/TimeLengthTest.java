import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class TimeLengthTest {

	public static void main(String[] args) {
		TimeLength tl = new TimeLength(0);
		while (true) {
			System.out.println("***Convert Length of Time***");
			System.out.println("1) Set a length of time");
			System.out.println("2) Adjust the length of time");
			System.out.println("3) Show the length of time in different units.");
			System.out.println("0) Exit");
			System.out.println("Please enter a number in [1,2,3,0]");
			Scanner sc = new Scanner(System.in);
			String op = sc.nextLine();
			if (op.equals("1")) {
				String regEx1 = "^-?[0-9]{1,20}$";
				String regEx2 = "^-?\\d{2}:\\d{2}:\\d{2}$";
				Pattern pattern2 = Pattern.compile(regEx2);
				Pattern pattern1 = Pattern.compile(regEx1);
				String i;
				Scanner in = new Scanner(System.in);
				System.out.println("Please enter a time<seconds or hh:mm:ss>: ");
				i = in.nextLine();
				Matcher matcher2 = pattern2.matcher(i);
				Matcher matcher1 = pattern1.matcher(i);
				boolean rs1 = matcher1.matches();
				boolean rs2 = matcher2.matches();
				if (rs1) {
					tl = new TimeLength(Integer.parseInt(i));
				} else if (rs2) {
					if (String.valueOf((i.charAt(0))).equals("-")) {
						String[] h = (i.substring(1)).split(":");
					System.out.println(i.substring(1));
						tl = new TimeLength(h, false);
					} else {
 
						String[] h = i.split(":");
						tl = new TimeLength(h, true);
					}
				} else {
					System.out.println("输入错误");
					continue;
				}
			} else if (op.equals("2")) {
				if (tl.equals(null)) {
					System.out.println("尚未设置时间，请先设置");
					continue;
				}
				String regEx1 = "^-?[0-9]{1,20}$";
				String regEx2 = "^-?\\d{2}:\\d{2}:\\d{2}$";
				Pattern pattern2 = Pattern.compile(regEx2);
				Pattern pattern1 = Pattern.compile(regEx1);
				String i;
				Scanner in = new Scanner(System.in);
				System.out.println("Please enter a time<seconds or hh:mm:ss>: ");
				i = in.nextLine();
				Matcher matcher2 = pattern2.matcher(i);
				Matcher matcher1 = pattern1.matcher(i);
				boolean rs1 = matcher1.matches();
				boolean rs2 = matcher2.matches();
				if (rs1) {
					tl.adjustSec(Integer.parseInt(i));
				} else if (rs2) {
					
					
					if (String.valueOf((i.charAt(0))).equals("-")) {
						String[] h = (i.substring(1)).split(":");
						tl.adjustHMS(h, false);
					} else {

						String[] h = i.split(":");
						tl.adjustHMS(h, true);
					}
					
					
					
				} else {
					System.out.println("输入错误");
					continue;
				}
			} else if (op.equals("3")) {
				if (tl.equals(null)) {
					System.out.println("尚未设置时间，请先设置");
					continue;
				}
				System.out.println("The current lenth of time<sec>:" + tl.getSeconds());
				System.out.println("The current lenth of time<hh:mm:ss>:" + tl.getHMS());
				System.out.println("");
			} else if (op.equals("0")) {
				System.exit(0);
			} else {
				System.out.println("输入有误");
				continue;
			}
		}
	}

}
