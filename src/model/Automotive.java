package model;

import java.io.Serializable;

//the Automotive class represents the model of vehicle. Ford Wagon ZTW in this case
public class Automotive implements Serializable {

	//declare variables for properties of the Automotive class
	private String name;
	private float baseprice;
	private OptionSet opset[];
	
	//generic constructor to create empty Automotive object
	public Automotive() {
		name = null;
		baseprice = 0;
	}
	
	//constructor to be used once the model name, base price, and amount of OptionSets are read from the text file
	public Automotive(String modelName, float price) {
		name = modelName;
		baseprice = price;
		for (int i=0; i < opset.length; i++) {
			opset[i] = new OptionSet();
		}
	}
	//get the name of the object
	public String getName() {
		return name;	
	}
	//get the base price of the object
	public float getPrice() {
		return baseprice;
	}
	//return how many OptionSets are in the array opset. used to loop through the object and print in the Driver class
	public int getOptionSetLength() {
		return opset.length;
	}
	/* pass the index of the OptionSet through this method and return the length of the Option array within the OptionSet object at the specified index
	 determines how many options the program has to loop through (eg: 10 options within the Color OptionSet */
	public int getOptionLength(int opsetIndex) {
		return opset[opsetIndex].getOptionLength();
	}
	//get the name property of the OptionSet
	public String getOpsetName(int opsetIndex) {
		return opset[opsetIndex].getOptionSetName();
	}
	//get the name property of an Option object
	public String getOptionName(int opsetIndex, int optionIndex) {
		return opset[opsetIndex].getOptions(optionIndex).getOptionName();
	}
	//get the price property of an Option object
	public float getOptionPrice(int opsetIndex, int optionIndex) {
		return opset[opsetIndex].getOptions(optionIndex).getOptionPrice();
	}
	//set the name property of the Automotive object
	public void setName(String newName) {
		this.name = newName;
	}
	//set the base price of an Automotive object
	public void setPrice(float newPrice) {
		this.baseprice = newPrice;
	}
	//Set the size of the opset array of OptionSets
	public void setOpsetSize(int newSize) {
		this.opset = new OptionSet[newSize];
	}
	/*create a new OptionSet object at the specified index position.
	  Use the OptionSet constructor to set name property of the OptionSet object and how many options it has*/
	public void setOpSet(String opsetName, int opsetIndex, int optionQty) {
		opset[opsetIndex] = new OptionSet(opsetName, optionQty);
	}
	//sets the name and price properties of an Option object at the specified index of the Option array within the OptionSet array at the specified index
	public void setOption(String optionName, int opsetIndex, int optionIndex, float optionPrice) {
		opset[opsetIndex].getOptions(optionIndex).setOptionName(optionName);
		opset[opsetIndex].getOptions(optionIndex).setOptionPrice(optionPrice);	
	}
	
	//Iterate through the opset array to find if an opset with a matching name exists. if not found, returns a string to be printed saying it could not be found
	public String findOptionSet(String name) {
		for (int i = 0; i < opset.length; i++) {
			if (opset[i].getOptionSetName().equals(name)) {
				return opset[i].getOptionSetName() + " found at index " + i;
			}
		}
		return "object not found";
	}
	//iterates through the opset array, then the options array looking for an option with a matching name passed through to the method. if not found, return string saying so.
	public String findOption(String name) {
		for (int i = 0; i < opset.length; i++) {
			for (int j = 0; j < opset[i].getOptionLength(); j++) {
				if (opset[i].getOptions(j).getOptionName().equals(name)) {
					return opset[i].getOptions(j).getOptionName() + " found in OptionSet " + opset[i].getOptionSetName() + " at Option array index " + j;
				}
			}
		}
		return "option not found";
	}
	
	//delete option set at the index passed to the method, the reconfigure the array
	public void deleteOptionSet(int index) {
		for (int i = index; i < opset.length - 1; i++) {
			opset[i] = opset [i+1];
		}
	}
	//delete option at the opsetindex and optionindex passed through to the method
	public void deleteOption(int opsetIndex, int optionIndex) {
		opset[opsetIndex].deleteOption(optionIndex);
	}
	//sets a new name for the specified option set
	public void updateOptionSet(int opsetIndex, String newOpsetName) {
		opset[opsetIndex].setOptionSetName(newOpsetName);
	}
	//sets a new name and price for the specified option in the specified option set
	public void updateOption(int opsetIndex, int optionIndex, String newOptionName, float newOptionPrice) {
		opset[opsetIndex].getOptions(optionIndex).setOptionName(newOptionName);
		opset[opsetIndex].getOptions(optionIndex).setOptionPrice(newOptionPrice);
	}
	
	//prints the properties of the Automotive object
	public void printAuto() {
		
		System.out.println(name);
		System.out.println(baseprice);
		/* Outer loop iterates through the OptionSet array opset within the testCar object and prints the name of each OptionSet object.
		  Inner loop iterates through the Option array within an OptionSet object and prints the name and price of each Option object */
		for(int i = 0; i < opset.length; i++) {
			System.out.println("************************");
			System.out.println(opset[i].getOptionSetName());
			System.out.println("************************");
			for (int j = 0; j < opset[i].getOptionLength(); j++) {
				System.out.println(opset[i].getOptions(j).getOptionName());
				System.out.println(opset[i].getOptions(j).getOptionPrice());
			}
		}
	}
	
	
	
}
