import java.util.ArrayList;
import java.util.Scanner;
import java.util.Random;

public class Main {
	private static Random random = new Random();
	private static Scanner input = new Scanner(System.in);

	public static void main(String[] args) {
		run();
	}
	
	public static void run() {
		int choice = 0;
		ArrayList<Rod> Rod = new ArrayList<>();
		
		while(true) {
			printMenu();
			choice = input.nextInt();
			switch(choice) {
			case 1:
				addNewRod(Rod);
				break;
			case 2:
				viewRod(Rod);
				break;
			case 3:
				goFishing(Rod);
				break;
			case 4:
				input.close();
				System.exit(0);
				break;
			}
		}
	}
	
	private static void addNewRod(ArrayList<Rod> Rod) {
		String name = null, brand = null, power = null;
		int length = 0, successRate = 0;
		int choose = 0;
		pickRod();
		choose = input.nextInt();
		input.nextLine();
		switch(choose) {
		case 1:
			addNormalRod(name, brand, length, successRate, Rod);
			break;
		case 2:
			addSpecialRod(name, brand, power, length, successRate, Rod);
			break;
		}
	}
	
	private static void addNormalRod(String name, String brand, int length, int successRate, ArrayList<Rod> Rod) {
		name = inputName();
		brand = inputBrand();
		length = inputLength();
		
		NormalRod rods = new NormalRod(name, brand, length, successRate);
		successRate = rods.randomizeSuccessRate();
		rods.setSuccessRate(successRate);
		Rod.add(rods);
		printRod(name, brand, length, successRate);
	}
	
	private static void addSpecialRod(String name, String brand, String power, int length, int successRate, ArrayList<Rod> Rod) {
		name = inputName();
		brand = inputBrand();
		length = inputLength();
		power = inputPower();
		
		SpecialRod specrod = new SpecialRod(name, brand, length, successRate, power);
		successRate = specrod.randomizeSuccessRate();
		powerAlgorithm(power, successRate);
		specrod.setSuccessRate(successRate);
		Rod.add(specrod);
		printRod(name, brand, length, successRate, power);
	}
	
	private static String inputName() {
		String name;
		while(true) {
			System.out.println("Enter Rod Name [3-20 Character]: ");
			name = input.nextLine();
			if(name.length() >= 3 && name.length() <= 20) {
				break;
			}
		}
		return name;
	}
	
	private static String inputBrand() {
		String brand;
		while(true) {
			System.out.println("Enter Rod Brand [must be alphanumeric]:");
			brand = input.next();
			if(brand != "0") {
				break;
			}
		}
		return brand;
	}
	
	private static int inputLength() {
		int length;
		while(true) {
			System.out.println("Enter Rod Length [100 .. 250] : ");
			length = input.nextInt();
			if(length >= 100 && length <= 250) {
				break;
			}
		}
		input.nextLine();
		return length;
	}
	
	private static String inputPower() {
		String power;
		while(true) {
			System.out.println("Enter rod power [Ultra Light | Light | Medium | Heavy]: ");
			power = input.nextLine();
			if(power.equals("Ultra Light") || power.equals("Light") || power.equals("Medium") || power.equals("Heavy")) {
				break;
			}
		}
		return power;
	}
	
	private static void powerAlgorithm(String power, int successRate) {
		if(power.equals("Ultra Light")) {
			successRate += 10;
		}
		else if(power.equals("Light")) {
			successRate += 20;
		}
		else if(power.equals("Medium")) {
			successRate += 30;
		}
		else if(power.equals("Heavy")) {
			successRate += 40;
		}
	}
	
	private static void viewRod(ArrayList<Rod> Rod) {
		if(Rod.isEmpty()) {
			System.out.println("No rods available!");
		} else {
			int view = 0;
			pickRod();
			view = input.nextInt();
			input.nextLine();
			displayRods(Rod, view);
		}
	}
	
	private static void goFishing(ArrayList<Rod> Rod) {
		int view = 0;
		int choice = 0;
		pickRod();
		view = input.nextInt();
		input.nextLine();
		
		displayRods(Rod , view);
			
		System.out.print("Choose rod [1 - " + Rod.size() + "]: " );
		choice = input.nextInt();
		Rod rod = Rod.get(choice-1);
		int Getrate = random.nextInt(100) + 1;
		if(Getrate <= rod.getSuccessRate()) {
			System.out.println("Congrats! You got a fish!");
		} else {
			System.out.println("Too bad. You didn't catch anything.");
		}
		
	}
	
	
	
	private static void printMenu() {
		System.out.println("Menu");
		System.out.println("===========");
		System.out.println("1. Add New Rod");
		System.out.println("2. View Rod");
		System.out.println("3. Go Fishing");
		System.out.println("4. Exit");
		System.out.print(">> ");
	}
	
	private static void displayRods(ArrayList<Rod> rods, int view) {
		int flag = 0;
		for(int i = 0; i < rods.size(); i++) {
			Rod rod = rods.get(i);
			if((view == 1 && rod instanceof NormalRod)) {
				flag = 1;
				 System.out.println("No. " + (i+1));
                 ((NormalRod) rod).printNormalRod();
			}
			else if((view == 2 && rod instanceof SpecialRod)) {
				flag = 1;
				 System.out.println("No. " + (i+1));
                ((SpecialRod) rod).printSpecialRod();
			}
		}
		if(flag == 0 ) {
			System.out.println("No " + (view == 1 ? "normal" : "special") + " rod available");
		}
	}
	private static void printRod(String name, String brand, int length, int successRate) {
		System.out.println("Insert new normal rod success!");
		System.out.println("Rod Name: " + name);
		System.out.println("Rod Brand: " + brand);
		System.out.println("Rod Length: " + length);
		System.out.println("Rod rate: " + successRate);
	}
	private static void printRod(String name, String brand, int length, int successRate, String power) {
		printRod(name, brand, length, successRate);
		System.out.println("Rod power: " + power);
	}
	private static void pickRod() {
		System.out.println("Pick a rod!");
		System.out.println("1. Normal Rod");
		System.out.println("2. Special Rod");
		System.out.print(">>");
	}

}
