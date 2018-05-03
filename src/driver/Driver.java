package driver;

//import the Automotive class from the model package and the FileIO class from the carutil package to access methods
import carutil.FileIO;
import model.Automotive;
import java.io.*;

public class Driver {
	
	public static void main(String [] args) {
		
		//instantiate a new, empty Automotive object named testCar
		Automotive testCar = new Automotive();
		//instantiate a new, empty FileIO object named file
		FileIO file = new FileIO();
		//pass the path of the text file you want to read and an empty Automotive object to the method buildAutoObject to populate testCar with data
		file.buildAutoObject("src/car", testCar);
		//print the name and baseprice property of the, now populated, testCar object
		System.out.println("Before serializing object");
		testCar.printAuto();
		
		file.serializeAuto(testCar);
		
		Automotive testCar2 = file.deserializeAuto();
		
		System.out.println("After Deserializing new object");
		testCar2.printAuto();
	}
	
}
