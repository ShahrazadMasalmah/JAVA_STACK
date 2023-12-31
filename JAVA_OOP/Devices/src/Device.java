//Create a Device class with a battery attribute and status method
public class Device {
	private int battery;
	
	public Device() {
		this.battery = 100;
	}

	public int getBattery() {
		return this.battery;
	}

	public void setBattery(int battery) {
		this.battery = battery;
	}
	
	public void status() {
		System.out.println("Battery remaining: " + getBattery());
	}
}
