
public class SpecialRod extends Rod{
	String power;

	public SpecialRod(String name, String brand, int length, int successRate, String power) {
		super(name, brand, length, successRate);
		this.power = power;
	}

	public String getPower() {
		return power;
	}

	public void setPower(String power) {
		this.power = power;
	}
	
	public void printSpecialRod() {
		System.out.println("Name: " + this.getName());
        System.out.println("Brand: " + this.getBrand());
        System.out.println("Length: " + this.getLength());
        System.out.println("Rate: " + this.getSuccessRate());
        System.out.println("Power: " + this.getPower());
	}
}
