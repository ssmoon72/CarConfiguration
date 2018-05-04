package carutil;

//import the java.io package to access FileReader and BufferedReader
import java.io.*;
//import the Automotive class to access methods from that class
import model.Automotive;

public class FileIO {
	
	//method buildAutoObject receives an empty Automotive object then reads the "car" text file, populates the object and returns it
	public Automotive buildAutoObject(String filename, Automotive a1) {
		
		try {
			//instantiate new FileReader class using the filename passed through method
			FileReader file = new FileReader(filename);
			//instantiate BufferedReader class using the FileReader class that was just instantiated
			BufferedReader buff = new BufferedReader(file);
			//this boolean will be used to determine the end of the text file
			boolean eof = false;

			
			//this loop executes until the file is completed
			while(!eof) {
				//read the next line and assign it to variable "line"
				String line = buff.readLine();
				//if there is no line, switch eof bool to true and terminate the loop
				if (line == null) {
					eof = true;
				}
				else {
					//create a string array from the text file with. separate each index by "," in the text file
					String[] vehicleComponents = line.split(",");
					//Set name, price, and size of the option set of the Automotive object since they will always be at index 0, 1, and 2
					a1.setName(vehicleComponents[0]);
					a1.setPrice(Float.parseFloat(vehicleComponents[1]));
					//Parse the string to an integer and store in a variable for readability
					int optionSetSize = Integer.parseInt(vehicleComponents[2]);
					a1.setOpsetSize(optionSetSize);
					
					/* This variable will be used to iterate through the text file and assign the options to the Option objects. The "3" comes from the third index
					 * which is the name of the first Option Set. optionSetSize is the length of the OptionSet array we just made. Multiply it by 2 because the way 
					 * my Text file is set up, you have the 5 names of the OptionSets followed by the 5 sizes of the Option arrays within each OptionSet. This should
					 * work with any number of OptionSet objects. For 5 OptionSet elements, this variable equals to 13. vehicleComponents[13] is the first Color option name.
					 * For 6 OptionSet elements, this variable would equal to 15 which wouldstill be the first Color Option name.
					 *  The indexPointer variable is the same for now, but will change later. */
					int nextVehicleComponentIndex = 3 + (optionSetSize * 2);
					int indexPointer = 3 + (optionSetSize * 2);
					
					//I want this loop to execute once for each OptionSet that is created, in this example, 5
					for (int i = 0; i < optionSetSize; i++) {
						/* The OptionSet names are lined up in the text file one right after the other starting at index 3. Add i to get the index of the next 
						 * OptionSet name */
						String optionSetName = vehicleComponents[3+i];
						/* parse the String into an integer variable for readability. Index 3 + the option set size + the number of times looped will result
						   in the index of each OptionSet's Option array size */
						int optionArraySize = Integer.parseInt(vehicleComponents[3+optionSetSize+i]);
						//Pass the name, OptionSet index, and size of the Option array at that OptionSet index to the setOpSet method.
						a1.setOpSet(optionSetName, i, optionArraySize);
						
						//Establish a variable to keep track of the index of the Option array.
						int optionIndex = 0;
						
						/* set the nextVehicleComponentIndex variable equal to the indexPointer. the first iteration of the outer loop they will be
						 * the same but this matters for future iterations */
						nextVehicleComponentIndex = indexPointer;
						
						/* This inner for loop populates the Option array at opset[i] in the Automotive object. The loop starts at nextVehicleComponentIndex
						 * and iterates through the next (optionArraySize * 2) indices by increments of 2. What that means is, for example, the Color 
						 * OptionSet has an Option array size of 10. nextVehicleComponentIndex is 13 for 5 OptionSets. You multiply the Array size by 2
						 * because each option has a price associated with it. On the first iteration of the outer loop, this inner loop goes from index 13
						 * to index 33, incrementing by 2 every time because every odd index will be the name and every even index will be the price */
						for (int j = nextVehicleComponentIndex; j < nextVehicleComponentIndex + (optionArraySize *2); j+=2) {
							String optionName = vehicleComponents[j];
							float optionPrice = Float.parseFloat(vehicleComponents[j+1]);
							//Pass the name, Option Set index, optionIndex, and optionPrice to the setOption method to create the Option object
							a1.setOption(optionName, i, optionIndex, optionPrice);
							//increment the optionIndex by 1 to populate the next option object on the next iteration of the loop
							optionIndex++;
							/* at the end of loop, set the indexPointer to the index of the next Option name. For example: on the first iteration of the 
							 * outer loop and the last iteration of this inner loop, j ends up equaling 31. Add 2 to that and you get vehicleComponents[33]
							 * which is the name of the first Transmission option. When you set nextVehicleComponentIndex to indexPointer on the second iteration
							 * of the outer loop, it means the next inner loop will start at index 33 and run until index 37 */
							indexPointer = j + 2;
						}
					}
				}
			} 
			//close the buffered reader once the end of file is reached
			buff.close();
		}
		//If there is an exception with the filereader (file not found, etc.) catch here and print error message
		catch(IOException e) {
			System.out.println("Error -- " + e.toString());
		}
		//return Automotive object that was passed through to the method, now populated.
		return a1;
	}
	
	public void serializeAuto(Automotive a1) {
		try {
			FileOutputStream automobileFile = new FileOutputStream("auto.dat");
			ObjectOutputStream out = new ObjectOutputStream(automobileFile);
			
			out.writeObject(a1);
			
			out.close();
			automobileFile.close();
			
			System.out.println("********************************");
			System.out.println("object serialized successfully");
			System.out.println("********************************");
			
		} 
		catch (Exception e) {
			System.out.println("Error: " + e);
		}	
	}
	
	public Automotive deserializeAuto() {
		
		Automotive a1 = new Automotive();
		
		try {
			FileInputStream automobileFile = new FileInputStream("auto.dat");
			ObjectInputStream in = new ObjectInputStream(automobileFile);
			
			a1 = (Automotive)in.readObject();
			
			in.close();
			automobileFile.close();
			
			System.out.println("********************************");
			System.out.println("object deserialized successfully");
			System.out.println("********************************");
			
			return a1;
		}
		catch (Exception e) {
			System.out.println("Error: " + e);
		}
		return a1;
	}

}
