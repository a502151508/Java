import java.util.Scanner;

public class VendingMachineTest {
	public static String menuOption() {
		Scanner sc = new Scanner(System.in);
		String op = sc.nextLine();
		if (!op.equals("1") && !op.equals("2") && !op.equals("3") && !op.equals("0")) {
			System.out.println("input error!!");
			System.out.println("");
			System.out.println("Please select a number:");

			return menuOption();
		} else
			return op;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		VendingMachine vm= new VendingMachine();
		while (true) {
			vm.loadDrinks();
			System.out.println("******************************");
			System.out.println("\tVending machine");
			System.out.println("\tNow on service");
			System.out.println("");
			System.out.println("\t1.Buy drinks");
			System.out.println("\t2.Refill drinks");
			System.out.println("\t3.Games");
			System.out.println("\t0.Exit");
			System.out.println("");
			System.out.println("******************************");
			System.out.println("Please select a number:");
			String op = menuOption();
			if (op.equals("1")) {
				vm.buyDrink();
				
			} else if (op.equals("2")) {
				vm.addDrink();
			
			} else if (op.equals("3")) {
				vm.playGuessGame();
			} else if (op.equals("0")) {
				System.exit(0);
			}
		}
	}

}
