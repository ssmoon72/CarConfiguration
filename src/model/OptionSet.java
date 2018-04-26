package model;

import java.io.Serializable;

public class OptionSet implements Serializable {
	
	//declare variables for the name property and the array of options
	String name;
	Option opt[];
	
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
	
	//not giving an inner class a keyword makes it a protected class, accessible only to classes within its specific package
	class Option implements Serializable {
		
		//name and price properties for an Option object
		String name;
		float price;
		
	}
	
}
