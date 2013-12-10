Converter App
============

- How it works
	The Converter Application is a simple Java awt Frame application which provide the conversion of
	Celsius to Fahrenheit and the FizzBuzz. The application provides a first selection window where you
	can choose between the converters available. Once you have selected the converter the application
	opens its window above the first one and you can start using the converter. The selection window
	remain active and you can open at the same time other converters.

- Design:
	The application has been developed using emergent design, OOP, continuous refactoring and 
	Design Patterns. 
	I used the assignment as an opportunity to create a flexible, maintainable and readable
	application which aims to the highest code quality and at the same time embraces the change.
	I strongly used OOP in order to avoid if else statements which lead to increase
	the Cyclomatic Complexity of the code. In order to monitor the metrics values I used the plugin 
	metrics for eclipse (you can find the xml export of the metrics in the metricsTree file).
	I decided to do not use any framework (Spring could find a place here) and develop everything 
	almost from the scratch. JUnit for testing.
	
	
- Structure
core:
	contains ConverterManager which maintains the converters and exposes their methods.
	So far I've developed two converters: CelsiusToFahrenheitConverter and FizzBuzzConverter.
	[Note]
	Before the last refactoring there was a Converter Interface which had to be implemented 
	by all the components in order to be managed by the ConverterManager. The Converters were 
	added to the manager which were storing them into an HashMap<String, Converter>. In that way
	I could call the converter using the name (Converter Interface had the name() method).
	I decided to remove that implementation in order to avoid overprovisioning, and to have less
	code to maintain.
main: 
	Application: is the main class which initialize the components and starts the frame.
	ConverterAdapter: used to adapt core to the frame takes the converterManager and it is
	passed to the ConverterFrameFactory.
test:
	(do it better)
	Tests are just covering the results produced by the converters. 
	The application is linear, the only conditional statements are used for implementing the 
	fizzBuzz function. A maximum cyclomatic complexity of 3 (mean: 1.122; std. dev.:0.395; 
	max:3) and the linear structure of the code let me to have a robust and error safe app without
	using TDD or implementing a huge amount of tests.
ui: 
	The user interface has been developed to be fully independent from the core classes.
	The ConverterFrameFactory takes the ConverterAdapter, maintain and initializes 
	(passing the adapter) the ConverterFrames, and start the ConverterSelectionFrame with itself as
	parameter.
	The ConverterSelectionFrame takes the ConverterFrameFactory as constructor parameter, and display 
	to the user a simple graphic interface which let the user to select the converter he wants to start.
	The ConverterFrame class is the base class for the converter frames, it extends the Frame class and 
	it is responsible for the setup (graphic) of the frames.
	Every converter frame has to extend the ConverterFrame class in order to be managed by the
	ConverterFrameFactory (it is more or less the same logic which was in place for the older version 
	of the core classes).

Future Improvements:
	Add new features, you can create and add any kind of converter. The app has been developed thinking
	of new and also unpredicted feature.
	Create different interfaces, it could be a either a terminal than a web one. 
