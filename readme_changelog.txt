This is the project that all the labs in CIS35B will be modifying.
Log:
Lab 1) Create an autmobile object by reading the text file "car" and populating the object. Serialize object to created file then deserialize file to another object and print properties.
    Changelog:
    1) Removed serialize and deserialize functionality from main method in Driver class and moved to FileIO class
    2) Removed print functionality from the main method in Driver class and moved to the Automotive class.
    2) Made properties of OptionSet and Option class private
    3) added protected getter, setter, and print methods for OptionSet and Option class
    4) Redid buildAuto method in FileIO class. Now uses loops to be able to populate any number of Options and OptionSets.
