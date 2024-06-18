
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
}
