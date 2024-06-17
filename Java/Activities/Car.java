package activities;

public class Car {
    //Class Member Variables
    String color;
    int make;
    String transmission;
    int tyres;
    int doors;
    float weight;
   
	
    //Constructor
    Car() {
	tyres = 4;
	doors = 4;
	weight = (float) 1200.01;

    }

    //Class Methods
    public void displayCharacterstics(){
	System.out.println("Color of the Car: " + color);
	System.out.println("Make of the Car: " + make);
	System.out.println("Transmission of the Car: " + transmission);
	System.out.println("Number of doors on the car: " + doors);
    System.out.println("Number of tyres on the car: " + tyres);
    System.out.println("Weight of the car: "+ weight);
    }

    public void accelerate() {
	System.out.println("Car is moving forward.");
    }
	
    public void brake() {
	System.out.println("Car has stopped.");
    }
}