package Activities;

public class Activity3 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		double sec = 1000000000;

        double EarthSeconds = 31557600;
        double MercurySeconds = 0.2408467;
        double VenusSeconds = 0.61519726;
        double MarsSeconds = 1.8808158;
        double JupiterSeconds = 11.862615;
        double SaturnSeconds = 29.447498;
        double UranusSeconds = 84.016846;
        double NeptuneSeconds = 164.79132;
        
        System.out.println("Age on Mercury: " + sec / EarthSeconds / MercurySeconds);
        System.out.println("Age on Venus: " + sec / EarthSeconds / VenusSeconds);
        System.out.println("Age on Earth: " + sec / EarthSeconds);
        System.out.println("Age on Mars: " + sec / EarthSeconds / MarsSeconds);
        System.out.println("Age on Jupiter: " + sec / EarthSeconds / JupiterSeconds);
        System.out.println("Age on Saturn: " + sec / EarthSeconds / SaturnSeconds);
        System.out.println("Age on Uranus: " + sec / EarthSeconds / UranusSeconds);
        System.out.println("Age on Neptune: " + sec / EarthSeconds / NeptuneSeconds);
	}

}
