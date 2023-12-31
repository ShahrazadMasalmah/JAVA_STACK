//Create a Phone class that extends the Device class and has the 
//following three methods: makeCall, playGame, and charge
public class Phone extends Device {
	
	public void makeCall() {
		System.out.println("You make a call.");
		int batteryCall = super.getBattery() - 5;
		super.setBattery(batteryCall);
		super.status();
		//Add a 'battery critical' message to your Phone class that is displayed when the battery falls below 10
		if(super.getBattery() < 10) {
			System.out.println("Battery critical.");
		}
	}
	
	public void playGame() {
		//Don't allow the user to play a game if the battery life is below 25
		if(super.getBattery() > 25) {
		System.out.println("You play a game.");
		int batteryPlayGame = super.getBattery() - 20;
		super.setBattery(batteryPlayGame);
		super.status();
		}
		else {
			System.out.println("You can not play the game because the battery is bellow 25.");
		}
		//Add a 'battery critical' message to your Phone class that is displayed when the battery falls below 10
		if(super.getBattery() < 10) {
			System.out.println("Battery critical.");
		}
	}
	
	
	public void charge() {
		System.out.println("You charge the phone.");
		int batteryCharge = super.getBattery() + 50;
		super.setBattery(batteryCharge);
		super.status();
	}
}
