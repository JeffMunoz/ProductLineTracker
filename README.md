# ProductLineTracker
OOP Project which aims to put into practice all of the concepts and practices learned in class. It does this by allowing users to input the name, manufacturer, and type of different products utilizing a GUI. This project was developed by Jeffry Munoz independently with guidance provided by Professor Vanselow. This project was developed throughout the fall 2019 semester, this project helped me greatly increase my skills as a developer. This project was made as a part of an assignment for COP-3003 Objected Oriented Programming at Florida Gulf Coast University. 

## Demonstration
 ![Alt text](https://raw.githubusercontent.com/JeffMunoz/ProductLineTracker/master/ProductionDemo.gif) 
## Documentation
Documentation available through [Javadoc](https://jeffmunoz.github.io/ProductLineTracker/). 

## Diagrams
Class Diagrams:
![Class Diagram](https://raw.githubusercontent.com/JeffMunoz/ProductLineTracker/master/PackageProductLine.png)

Database Visualization:
![Database](https://raw.githubusercontent.com/JeffMunoz/ProductLineTracker/master/ProductionDB.png)
## Getting Started
Add a product by simply providing the specified information and the click "Add Product." The the contents of the table will be displayed. 
## Built With
- Created with JavaFx version 1.8 and H2 as a database.
- CSS 3 is used for style effects.
- Using the IntelliJ Idea 2019.2 as the IDE.

## Contributing
Collaboration can be achieved through the use of a pull request.
## Author
Jeffry Munoz
## License
This project is licensed under the MIT License.
## Acknowledgments
Useful information about data base connections and usage provided by tutorialspoint.
Special thanks to Professor Vanselow for his guidance.

## History
- Version 1.0

	- Date: 9/16/19

	- Changes: Initial commit and all buttons added to GUI

- Version 1.1

	- Date: 9/23/19

	- Changes: Linked to DB and added and linked a query to a button click.

- Version 1.2

	- Date: 9/26/19

	- Changes: Added ability to read user input from GUI to add products

- Version 1.2.1

	- Date: 9/28/16

	- Changes: Added documentation through Javadocs and class diagrams. Also CSS file was added with minor style changes.

- Version 1.3

	- Date: 9/30/19

	- Changes: Added enum class to allow users to select product types.

- Version 1.4

	- Date: 10/02/19

	- Changes: Added a choice box to select the product types and DB updates with that choice.

- Version 1.4.1

	- Date: 10/04/19

	- Changes: changed string to prepared statement for SQL use.

- Version 1.5

	- Date: 10/06/19

	- Changes: Added a table view that displays the contents of the product table in the DB.

- Version 1.5.1

	- Date: 10/08/19

	- Changes: TableView Populates when items are added

- Version 1.5.2

	- Date: 10/21/19

	- Changes: Added a list view that contains all products and their information

- Version 1.5.3

	- Date: 10/28/19

	- Changes: Added the creation of unique serial numbers for products produced

- Version 1.6

	- Date: 11/04/19

	- Changes: Added the ability to delete products from the GUI via the table view

- Version 1.6.1

	- Date: 12/02/19

	- Changes: Added a database password with a properties file

## Key Programming Concepts Utilized
This project uses the major concepts learned in class sush as:
- The use of connections to databases and the setting up a GUI. 
- Used the concept of enums to restrict product type choices to the approved types. 
- The use of inheritance to create a product superclass which contained attributes that other subclasses would need to implement differently. 
- Another concept used was polymorphism which aided with the creation of serial numbers based on the type of the product.  
- Heavy use of Arrays and Lists to allow the updating of the table view and list view which also allowed the user to select products to perform other operations. 
- Used recursion to help with security by reversing strings that were used as passwords before storage.  
