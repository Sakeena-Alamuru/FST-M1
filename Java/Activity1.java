package Activities;

public class Activity1 {

	public static void main(String[] args) {
		
		 Car BMW = new Car();
		 BMW.make = 2014;
		 BMW.colour = "Black";
		 BMW.transmission = "Manual";
		 
		//Using Car class method
	        BMW.displayCharacterstics();
	        BMW.accelerate();
	        BMW.brake();
		 

	}

}
