import java.util.ArrayList;
import java.util.Scanner;
import java.util.Random;

public class Main {

	public static void main(String[] args) {
		String name, brand, power;
		int length, successRate;
		int choice = 0;
		Random random = new Random();
		Scanner input = new Scanner(System.in);
		ArrayList<Rod> Rod = new ArrayList<>();
		while(true) {
			System.out.println("1. Add New Rod");
			System.out.println("2. View Rod");
			System.out.println("3. Go Fishing");
			System.out.println("4. Exit");
			System.out.print(">> ");
			choice = input.nextInt();
			switch(choice) {
			case 1:
				int choose = 0;
				System.out.println("Pick a rod!");
				System.out.println("1. Normal Rod");
				System.out.println("2. Special Rod");
				System.out.print(">>");
				choose = input.nextInt();
				input.nextLine();
				switch(choose) {
				case 1:
					while(true) {
						System.out.println("Enter Rod Name [3-20 Character]: ");
						name = input.nextLine();
						if(name.length() >= 3 && name.length() <= 20) {
							break;
						}
					}
					while(true) {
						System.out.println("Enter Rod Brand [must be alphanumeric]:");
						brand = input.next();
						if(brand != "0") {
							break;
						}
					}
					while(true) {
						System.out.println("Enter Rod Length [100 .. 250] : ");
						length = input.nextInt();
						if(length >= 100 && length <= 250) {
							break;
						}
					}
					successRate = random.nextInt(50) + 1;
					NormalRod rods = new NormalRod(name, brand, length, successRate);
					Rod.add(rods);
					System.out.println("Insert new normal rod success!");
					System.out.println("Rod Name: " + name);
					System.out.println("Rod Brand: " + brand);
					System.out.println("Rod Length: " + length);
					System.out.println("Rod rate: " + successRate);
					break;
				case 2:
					while(true) {
						System.out.println("Enter Rod Name [3-20 Character]: ");
						name = input.nextLine();
						if(name.length() >= 3 && name.length() <= 20) {
							break;
						}
					}
					while(true) {
						System.out.println("Enter Rod Brand [must be alphanumeric]:");
						brand = input.next();
						if(brand != "0") {
							break;
						}
					}
					while(true) {
						System.out.println("Enter Rod Length [100 .. 250] : ");
						length = input.nextInt();
						if(length >= 100 && length <= 250) {
							break;
						}
					}
					input.nextLine();
					while(true) {
						System.out.println("Enter rod power [Ultra Light | Light | Medium | Heavy]: ");
						power = input.nextLine();
						if(power.equals("Ultra Light") || power.equals("Light") || power.equals("Medium") || power.equals("Heavy")) {
							break;
						}
					}
					successRate = random.nextInt(50) + 1;
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
					SpecialRod specrod = new SpecialRod(name, brand, length, successRate, power);
					Rod.add(specrod);
					System.out.println("Insert new normal rod success!");
					System.out.println("Rod Name: " + name);
					System.out.println("Rod Brand: " + brand);
					System.out.println("Rod Length: " + length);
					System.out.println("Rod rate: " + successRate);
					System.out.println("Rod power: " + power);
					break;
				}
				break;
			case 2:
				if(Rod.isEmpty()) {
					System.out.println("No rods available!");
				} else {
					int view = 0;
					System.out.println("Pick a rod!");
					System.out.println("1. Normal Rod");
					System.out.println("2. Special Rod");
					System.out.print(">>");
					view = input.nextInt();
					input.nextLine();
					switch(view) {
					case 1:
						int flag = 0;
						for(int i = 0; i < Rod.size(); i++) {
							Rod rod = Rod.get(i);
							if(rod instanceof NormalRod) {
								flag = 1;
								System.out.println("No. " + i+1);
								System.out.println("Name: " + rod.getName());
								System.out.println("Brand: " + rod.getBrand());
								System.out.println("Length: " + rod.getLength());
								System.out.println("Rate: " + rod.getSuccessRate());
							}
						}
						if(flag == 0) {
							System.out.println("No normal rod available!");
						}
						break;
					case 2:
						int specialFlag = 0;
						for(int i = 0; i < Rod.size(); i++) {
							Rod rod = Rod.get(i);
							if(rod instanceof SpecialRod) {
								specialFlag = 1;
								SpecialRod special = (SpecialRod) rod;
								System.out.println("No. " + (i + 1));
					            System.out.println("Name: " + special.getName());
					            System.out.println("Brand: " + special.getBrand());
					            System.out.println("Length: " + special.getLength());
					            System.out.println("Rate: " + special.getSuccessRate());
					            System.out.println("Power: " + special.getPower());
							}
						}
						if(specialFlag == 0) {
							System.out.println("No special rod available!");
						}
						break;
					}
				}
				break;
			case 3:
				int view = 0;
				System.out.println("Pick a rod!");
				System.out.println("1. Normal Rod");
				System.out.println("2. Special Rod");
				System.out.print(">>");
				view = input.nextInt();
				input.nextLine();
				switch(view) {
				case 1:
					int flag = 0;
					for(int i = 0; i < Rod.size(); i++) {
						Rod rod = Rod.get(i);
						if(rod instanceof NormalRod) {
							flag = 1;
							break;
						}
					}
					if(flag == 0) {
						System.out.println("No normal rod available!");
					} else {
						for(int i = 0; i < Rod.size(); i++) {
							Rod rod = Rod.get(i);
							if(rod instanceof NormalRod) {
								System.out.println("No. " + i+1);
								System.out.println("Name: " + rod.getName());
								System.out.println("Brand: " + rod.getBrand());
								System.out.println("Length: " + rod.getLength());
								System.out.println("Rate: " + rod.getSuccessRate());
							}
						}
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
					break;
				case 2:
					flag = 0;
					for(int i = 0; i < Rod.size(); i++) {
						Rod rod = Rod.get(i);
						if(rod instanceof SpecialRod) {
							flag = 1;
							break;
						}
					}
					if(flag == 0) {
						System.out.println("No special rod available!");
					} else {
						for(int i = 0; i < Rod.size(); i++) {
							Rod rod = Rod.get(i);
							if(rod instanceof SpecialRod) {
								SpecialRod bad = (SpecialRod) rod;
								System.out.println("No. " + i+1);
								System.out.println("Name: " + bad.getName());
								System.out.println("Brand: " + bad.getBrand());
								System.out.println("Length: " + bad.getLength());
								System.out.println("Rate: " + bad.getSuccessRate());
							}
						}
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
					break;
				}
				
				break;
			case 4:
				input.close();
				System.exit(0);
				break;
			}
		}
	}

}
