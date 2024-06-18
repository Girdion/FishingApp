import java.util.Random;

public class Rod {
	String name, brand;
	int length, successRate;
	
	public Rod(String name, String brand, int length, int successRate) {
		super();
		this.name = name;
		this.brand = brand;
		this.length = length;
		this.successRate = successRate;
	}
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getBrand() {
		return brand;
	}
	public void setBrand(String brand) {
		this.brand = brand;
	}
	public int getLength() {
		return length;
	}
	public void setLength(int length) {
		this.length = length;
	}
	public int getSuccessRate() {
		return successRate;
	}
	public void setSuccessRate(int successRate) {
		this.successRate = successRate;
	}
	public int randomizeSuccessRate() {
		Random random = new Random();
		return random.nextInt(50) + 1;
	}
	


	
	
}
