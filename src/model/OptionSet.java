package model;

import java.io.Serializable;

public class OptionSet implements Serializable {
	
	//declare variables for the name property and the array of options
	private String name;
	private Option opt[];
	
	//generic constructor to create an empty OptionSet object
	OptionSet() {
		name = null;
		opt = null;
	}
	//This constructor is used to populate the name property of the OptionSet (eg. Colors) and create an array of Option objects of the specified size
	OptionSet(String optionName, int size) {
		name = optionName;
		opt = new Option[size];
		//This loop populates the opt array with empty Option objects
		for (int i = 0; i < opt.length; i++) {
			opt[i] = new Option();
		}
	}

	protected String getOptionSetName() {
		return name;
	}
	
	protected Option getOptions(int index) {
		return opt[index];
	}
	protected int getOptionLength() {
		return opt.length;
	}
	protected void setOptionSetName(String optionSetName) {
		this.name = optionSetName;
	}
	protected void deleteOption(int optionIndex) {
		for (int i = optionIndex; i < opt.length - 1; i++) {
			opt[i] = opt[i+1];
		}
	}
	protected void printOptionSet() {
		System.out.println(this.name);
		for (int i = 0; i < opt.length; i++) {
			System.out.println(opt[i].getOptionName());
			System.out.println(opt[i].getOptionPrice());
		}
	}
	
	//not giving an inner class a keyword makes it a protected class, accessible only to classes within its specific package
	class Option implements Serializable {
		
		//name and price properties for an Option object
		private String name;
		private float price;
		
		Option() {
			this.name = null;
			this.price = 0;
		}
		
		protected String getOptionName() {
			return name;
		}
		protected float getOptionPrice() {
			return price;
		}
		protected void setOptionName(String optionName) {
			this.name = optionName;
		}
		protected void setOptionPrice(float optionPrice) {
			this.price = optionPrice;
		}
		protected void printOption() {
			System.out.println(this.name);
			System.out.println(this.price);
		}
		
	}
	
}
