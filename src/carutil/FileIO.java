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
			//opsetIndex determines index within the opset array in the Automotive class
			int opsetIndex = 0;
			//optionIndex determines index within the opt array in the Option class
			int optionIndex = 0;
			
			//this loop executes until the file is completed
			while(!eof) {
				//read the next line and assign it to variable "line"
				String line = buff.readLine();
				//if there is no line, switch eof bool to true and terminate the loop
				if (line == null) {
					eof = true;
				}
				else {
					//set up array of strings in variable "tokenize" where each element is determined by a "," character
					String[] tokenize =  line.split(",");
					
					//set the name of the car model. in this case: Ford Wagon ZTW
					String tempName = tokenize[0];
					a1.setName(tempName);
					
					//set the base price of the car
					float tempPrice = Float.parseFloat(tokenize[1]);
					a1.setPrice(tempPrice);
					
					//set the size of the OptionSet array
					int tempSize = Integer.parseInt(tokenize[2]);
					a1.setOpsetSize(tempSize);
					
					//Set the name of the OptionSet element (color, brakes, etc.) and how many options are within the opt array
					String tempOpsetName = tokenize[3];
					int tempOptionQty = Integer.parseInt(tokenize[4]);
					a1.setOpSet(tempOpsetName, opsetIndex, tempOptionQty);
					
					/*this code block goes through the text file line by line to populate the Colors option set with the different options
					 TODO: Find a way to make a loop algorithm work when populating OptionSet and Options. Too much repeated code.*/
					String tempOptionName = tokenize[5];
					float tempOptionPrice = Float.parseFloat(tokenize[6]);
					a1.setOption(tempOptionName, opsetIndex, optionIndex, tempOptionPrice);
					//increment optionIndex to populate the next option
					optionIndex++;
					tempOptionName = tokenize[7];
					tempOptionPrice = Float.parseFloat(tokenize[8]);
					a1.setOption(tempOptionName, opsetIndex, optionIndex, tempOptionPrice);
					optionIndex++;
					tempOptionName = tokenize[9];
					tempOptionPrice = Float.parseFloat(tokenize[10]);
					a1.setOption(tempOptionName, opsetIndex, optionIndex, tempOptionPrice);
					optionIndex++;
					tempOptionName = tokenize[11];
					tempOptionPrice = Float.parseFloat(tokenize[12]);
					a1.setOption(tempOptionName, opsetIndex, optionIndex, tempOptionPrice);
					optionIndex++;
					tempOptionName = tokenize[13];
					tempOptionPrice = Float.parseFloat(tokenize[14]);
					a1.setOption(tempOptionName, opsetIndex, optionIndex, tempOptionPrice);
					optionIndex++;
					tempOptionName = tokenize[15];
					tempOptionPrice = Float.parseFloat(tokenize[16]);
					a1.setOption(tempOptionName, opsetIndex, optionIndex, tempOptionPrice);
					optionIndex++;
					tempOptionName = tokenize[17];
					tempOptionPrice = Float.parseFloat(tokenize[18]);
					a1.setOption(tempOptionName, opsetIndex, optionIndex, tempOptionPrice);
					optionIndex++;
					tempOptionName = tokenize[19];
					tempOptionPrice = Float.parseFloat(tokenize[20]);
					a1.setOption(tempOptionName, opsetIndex, optionIndex, tempOptionPrice);
					optionIndex++;
					tempOptionName = tokenize[21];
					tempOptionPrice = Float.parseFloat(tokenize[22]);
					a1.setOption(tempOptionName, opsetIndex, optionIndex, tempOptionPrice);
					optionIndex++;
					tempOptionName = tokenize[23];
					tempOptionPrice = Float.parseFloat(tokenize[24]);
					a1.setOption(tempOptionName, opsetIndex, optionIndex, tempOptionPrice);
					
					//reset the optionIndex and increment the opsetIndex
					optionIndex = 0;
					opsetIndex++;
					
					//this code block is for populating the Transmissiion OptionSet
					tempOpsetName = tokenize[25];
					tempOptionQty = Integer.parseInt(tokenize[26]);
					a1.setOpSet(tempOpsetName, opsetIndex, tempOptionQty);
					tempOptionName = tokenize[27];
					tempOptionPrice = Float.parseFloat(tokenize[28]);
					a1.setOption(tempOptionName, opsetIndex, optionIndex, tempOptionPrice);
					optionIndex++;
					tempOptionName = tokenize[29];
					tempOptionPrice = Float.parseFloat(tokenize[30]);
					a1.setOption(tempOptionName, opsetIndex, optionIndex, tempOptionPrice);
					
					optionIndex = 0;
					opsetIndex++;
					
					//populate the Brakes OptionSet
					tempOpsetName = tokenize[31];
					tempOptionQty = Integer.parseInt(tokenize[32]);
					a1.setOpSet(tempOpsetName, opsetIndex, tempOptionQty);
					tempOptionName = tokenize[33];
					tempOptionPrice = Float.parseFloat(tokenize[34]);
					a1.setOption(tempOptionName, opsetIndex, optionIndex, tempOptionPrice);
					optionIndex++;
					tempOptionName = tokenize[35];
					tempOptionPrice = Float.parseFloat(tokenize[36]);
					a1.setOption(tempOptionName, opsetIndex, optionIndex, tempOptionPrice);
					tempOptionName = tokenize[37];
					optionIndex++;
					tempOptionPrice = Float.parseFloat(tokenize[38]);
					a1.setOption(tempOptionName, opsetIndex, optionIndex, tempOptionPrice);
					
					optionIndex = 0;
					opsetIndex++;
					
					//Populate the airbag OptionSet
					tempOpsetName = tokenize[39];
					tempOptionQty = Integer.parseInt(tokenize[40]);
					a1.setOpSet(tempOpsetName, opsetIndex, tempOptionQty);
					tempOptionName = tokenize[41];
					tempOptionPrice = Float.parseFloat(tokenize[42]);
					a1.setOption(tempOptionName, opsetIndex, optionIndex, tempOptionPrice);
					optionIndex++;
					tempOptionName = tokenize[43];
					tempOptionPrice = Float.parseFloat(tokenize[44]);
					a1.setOption(tempOptionName, opsetIndex, optionIndex, tempOptionPrice);
					
					optionIndex = 0;
					opsetIndex++;
					
					//populate the moonroof OptionSet
					tempOpsetName = tokenize[45];
					tempOptionQty = Integer.parseInt(tokenize[46]);
					a1.setOpSet(tempOpsetName, opsetIndex, tempOptionQty);
					tempOptionName = tokenize[47];
					tempOptionPrice = Float.parseFloat(tokenize[48]);
					a1.setOption(tempOptionName, opsetIndex, optionIndex, tempOptionPrice);
					optionIndex++;
					tempOptionName = tokenize[49];
					tempOptionPrice = Float.parseFloat(tokenize[50]);
					a1.setOption(tempOptionName, opsetIndex, optionIndex, tempOptionPrice);
					
					optionIndex = 0;
					opsetIndex++;
					
					
					
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
