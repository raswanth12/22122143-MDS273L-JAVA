This Java program calculates summary statistics for a dataset of Iris flowers. The program reads a CSV file containing the data and outputs overall summary statistics as well as summary statistics by species.

To run the program, modify the file path in the main method of the pointsummary class to match the location of the Iris CSV file on your system. Then simply run the pointsummary class.

The program uses the OpenCSV library to read the CSV file and the Java Streams API to calculate the summary statistics.

Overall summary statistics calculated include the sum, mean, median, mode, minimum, and maximum for each attribute (sepal length, sepal width, petal length, and petal width) across all records.

Summary statistics by species calculated include the mean, median, mode, minimum, and maximum for each attribute for each species of Iris.
