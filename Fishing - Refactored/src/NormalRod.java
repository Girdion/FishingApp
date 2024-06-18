
public class NormalRod extends Rod{

	public NormalRod(String name, String brand, int length, int successRate) {
		super(name, brand, length, successRate);
	}
	
	public void printNormalRod() {
		System.out.println("Name: " + this.getName());
        System.out.println("Brand: " + this.getBrand());
        System.out.println("Length: " + this.getLength());
        System.out.println("Rate: " + this.getSuccessRate());
	}
	
}
