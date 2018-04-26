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
		return opset[opsetIndex].opt.length;
	}
	//get the name property of the OptionSet
	public String getOpsetName(int opsetIndex) {
		return opset[opsetIndex].name;
	}
	//get the name property of an Option object
	public String getOptionName(int opsetIndex, int optionIndex) {
		return opset[opsetIndex].opt[optionIndex].name;
	}
	//get the price property of an Option object
	public float getOptionPrice(int opsetIndex, int optionIndex) {
		return opset[opsetIndex].opt[optionIndex].price;
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
		opset[opsetIndex].opt[optionIndex].name = optionName;
		opset[opsetIndex].opt[optionIndex].price = optionPrice;	
	}
	
	public String findOptionSet(String name) {
		for (int i = 0; i < opset.length; i++) {
			if (opset[i].name.equals(name)) {
				return opset[i].name + " found at index " + i;
			}
		}
		return "object not found";
	}
	public String findOption(String name) {
		for (int i = 0; i < opset.length; i++) {
			for (int j = 0; j < opset[i].opt.length; j++) {
				if (opset[i].opt[j].name.equals(name)) {
					return opset[i].opt[j].name + " found in OptionSet " + opset[i].name + " at Option array index " + j;
				}
			}
		}
		return "option not found";
	}
	
	public void deleteOptionSet(int index) {
		for (int i = index; i < opset.length - 1; i++) {
			opset[i] = opset [i+1];
		}
	}
	
	public void deleteOption(int opsetIndex, int optionIndex) {
		for (int i = optionIndex; i < opset[opsetIndex].opt.length - 1; i++) {
			opset[opsetIndex].opt[i] = opset[opsetIndex].opt[i+1];
		}
	}
	
	public void updateOptionSet(int opsetIndex, String newOpsetName) {
		opset[opsetIndex].name = newOpsetName;
	}
	
	public void updateOption(int opsetIndex, int optionIndex, String newOptionName, float newOptionPrice) {
		opset[opsetIndex].opt[optionIndex].name = newOptionName;
		opset[opsetIndex].opt[optionIndex].price = newOptionPrice;
	}
}
