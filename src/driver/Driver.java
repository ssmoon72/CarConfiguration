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
		System.out.println(testCar.getName());
		System.out.println(testCar.getPrice());
		
		/* Outer loop iterates through the OptionSet array opset within the testCar object and prints the name of each OptionSet object.
		  Inner loop iterates through the Option array within an OptionSet object and prints the name and price of each Option object */
		for(int i = 0; i < testCar.getOptionSetLength(); i++) {
			System.out.println("************************");
			System.out.println(testCar.getOpsetName(i));
			System.out.println("************************");
			for (int j = 0; j < testCar.getOptionLength(i); j++) {
				System.out.println(testCar.getOptionName(i,j));
				System.out.println(testCar.getOptionPrice(i,j));
			}
		}
		
		try {
			FileOutputStream automobileFile = new FileOutputStream("auto.dat");
			ObjectOutputStream out = new ObjectOutputStream(automobileFile);
			
			out.writeObject(testCar);
			
			out.close();
			automobileFile.close();
			
			System.out.println("********************************");
			System.out.println("object serialized successfully");
			System.out.println("********************************");
			
		} 
		catch (Exception e) {
			System.out.println("Error: " + e);
		}
		
		Automotive testCar2 = null;
		
		try {
			FileInputStream automobileFile = new FileInputStream("auto.dat");
			ObjectInputStream in = new ObjectInputStream(automobileFile);
			
			testCar2 = (Automotive)in.readObject();
			
			in.close();
			automobileFile.close();
			
			System.out.println("********************************");
			System.out.println("object deserialized successfully");
			System.out.println("********************************");
			
			System.out.println(testCar2.getName());
			System.out.println(testCar2.getPrice());
			
			/* Outer loop iterates through the OptionSet array opset within the testCar object and prints the name of each OptionSet object.
			  Inner loop iterates through the Option array within an OptionSet object and prints the name and price of each Option object */
			for(int i = 0; i < testCar2.getOptionSetLength(); i++) {
				System.out.println("************************");
				System.out.println(testCar2.getOpsetName(i));
				System.out.println("************************");
				for (int j = 0; j < testCar2.getOptionLength(i); j++) {
					System.out.println(testCar2.getOptionName(i,j));
					System.out.println(testCar2.getOptionPrice(i,j));
				}
			}
			
		}
		catch (Exception e) {
			System.out.println("Error: " + e);
		}
		
		
		//testing CRUD operations
//		System.out.println(testCar.findOptionSet("Brakes"));
//		System.out.println(testCar.findOption("ABS"));
//		testCar.deleteOption(2, 1);
//		System.out.println(testCar.findOption("ABS with Advanced Trac"));
//		System.out.println(testCar.findOptionSet("Color"));
//		testCar.updateOptionSet(0, "colour");
//		System.out.println(testCar.getOpsetName(0));
//		System.out.println(testCar.findOptionSet("colour"));
//		System.out.println(testCar.findOption("Fort Knox Gold Clearcoat Metallic"));
//		testCar.updateOption(0,0,"blue", 2);
//		System.out.println(testCar.getOptionName(0, 0));
//		System.out.println(testCar.getOptionPrice(0, 0));
	}
	
}
