import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class VendingMachine {
	private ArrayList al = new ArrayList();
	int award = 0;

	void addDrink() {
		this.showDrinks();
		addCheck();
		System.out.println("refill successfully!!");
		this.saveDrinks();
	}

	boolean addCheck() {
		Scanner sc = new Scanner(System.in);
		System.out.println("Please enter the id of the drink");
		String id = sc.nextLine();
		System.out.println("Please enter the quantity you refilled");
		String quantity = sc.nextLine();
		int iD, quaNtity;
		try {
			iD = Integer.parseInt(id);
			quaNtity = Integer.parseInt(quantity);
		} catch (Exception e) {
			System.out.println("");
			System.out.println("input error");
			System.out.println("");
			return addCheck();
		}
		if (iD < 1 || iD > 7) {
			System.out.println("");
			System.out.println("input error");
			System.out.println("");
			return addCheck();
		}
		if (quaNtity < 1) {
			System.out.println("");
			System.out.println("input error");
			System.out.println("");
			return addCheck();
		}
		((Drink) (al.get(iD - 1))).setQuantity(((Drink) (al.get(iD - 1))).getQuantity() + quaNtity);
		return true;
	}

	void buyDrink() {
		this.showDrinks();
		System.out.println("Thank you, the change is " + buyCheck());
		this.saveDrinks();

	}

	void buyDrinkA(int award) {
		this.showDrinks();
		buyCheckA(award);
		this.saveDrinks();
		System.out.println("Thank you very much");

	}

	int buyCheckA(int award) {
		Scanner sc = new Scanner(System.in);
		System.out.println("Please enter the id of the drink");
		String id = sc.nextLine();
		int iD;
		try {
			iD = Integer.parseInt(id);
		} catch (Exception e) {
			System.out.println("");
			System.out.println("input error");
			System.out.println("");
			return buyCheckA(award);
		}
		if (iD < 1 || iD > 7) {
			System.out.println("");
			System.out.println("input error");
			System.out.println("");
			return buyCheckA(award);
		}
		if (((Drink) (al.get(iD - 1))).getPrice() > award) {
			System.out.println("");
			System.out.println("No enough money");
			System.out.println("");
			return buyCheckA(award);
		}
		if (((Drink) (al.get(iD - 1))).getQuantity() == 0) {
			System.out.println("");
			System.out.println("Sold out");
			System.out.println("");
			return buyCheckA(award);
		}
		((Drink) (al.get(iD - 1))).setQuantity(((Drink) (al.get(iD - 1))).getQuantity() - 1);
		return 0;
	}

	int buyCheck() {
		Scanner sc = new Scanner(System.in);
		System.out.println("Please enter the id of the drink");
		String id = sc.nextLine();
		System.out.println("Please enter the money you paid");
		String money = sc.nextLine();
		int iD, moNey;
		try {
			iD = Integer.parseInt(id);
			moNey = Integer.parseInt(money);
		} catch (Exception e) {
			System.out.println("");
			System.out.println("input error");
			System.out.println("");
			return buyCheck();
		}
		if (iD < 1 || iD > 7) {
			System.out.println("");
			System.out.println("input error");
			System.out.println("");
			return buyCheck();
		}
		if (((Drink) (al.get(iD - 1))).getPrice() > moNey) {
			System.out.println("");
			System.out.println("Excuse me???");
			System.out.println("");
			return buyCheck();
		}
		if (((Drink) (al.get(iD - 1))).getQuantity() == 0) {
			System.out.println("");
			System.out.println("Sold out");
			System.out.println("");
			return buyCheck();
		}
		((Drink) (al.get(iD - 1))).setQuantity(((Drink) (al.get(iD - 1))).getQuantity() - 1);
		return moNey - ((Drink) (al.get(iD - 1))).getPrice();
	}

	void showDrinks() {
		System.out.println("***********************");
		int i = 1;
		for (Object a : al) {
			System.out.println(i + ". " + ((Drink) a).getName() + "\t" + ((Drink) a).getPrice() + "yuan "
					+ ((Drink) a).getQuantity() + "left");
			i++;
		}
	}

	void loadDrinks() {
		ArrayList al = new ArrayList<>();
		try {
			File file = new File("drinks.txt");
			FileReader fr = new FileReader(file);
			BufferedReader br = new BufferedReader(fr);
			String line = null;
			br.readLine();
			while ((line = br.readLine()) != null) {
				String[] s = line.split(",");
				Drink d = new Drink(s[0], s[1], Integer.parseInt(s[2]), Integer.parseInt(s[3]));
				al.add(d);
			}
			br.close();
			fr.close();

		} catch (Exception e) {
			// TODO Auto-generated catch block
			System.out.println("can't not find the file");
		}
		this.al = al;
	}

	void saveDrinks() {

		try {
			File file = new File("drinks.txt");
			FileWriter fw = new FileWriter(file);
			BufferedWriter bw = new BufferedWriter(fw);
			bw.write("7");
			bw.newLine();
			for (Object a : al) {
				Drink d = (Drink) a;
				bw.write(d.getName() + "," + d.getManufacturer() + "," + d.getQuantity() + "," + d.getPrice());
				bw.newLine();
			}
			bw.close();
			fw.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	int playGuessGame() {
		int t = 1;
		int min = 1, max = 200;
		int num = (int) (Math.random() * (max - min + 1) + min);
		int gnum;
		System.out.println("num:" + num);
		while (t <= 5) {
			System.out.println("No." + t + "   " + min + "~" + max + " Please enter your number:");
			gnum = numberCheck(min, max);
			if (gnum < num) {
				min = gnum;
			} else if (gnum > num) {
				max = gnum;
			} else {
				System.out.println("");
				System.out.println("Congratulations! You win" + (6 - t) * 10 + "yuan");
				
				buyDrinkA((6 - t) * 10);
				return (6 - t) * 10;
			}
			t++;
		}
		System.out.println("");
		System.out.println("Sorry, game over, you can try it again");
		return 0;
	}

	int numberCheck(int min, int max) {
		Scanner s = new Scanner(System.in);
		String l = s.nextLine();
		int num;
		try {
			num = Integer.parseInt(l);
		} catch (Exception e) {
			System.out.println("Input error");
			return numberCheck(min, max);
		}
		if (num < min || num > max) {
			System.out.println("Input error");
			return numberCheck(min, max);
		}
		return num;
	}
}
