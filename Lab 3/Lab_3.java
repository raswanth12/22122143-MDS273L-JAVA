
import java.util.*;

public class Lab_3 {
    
    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)) {
            // Collect array from user
            System.out.print("Enter the size of the array: ");
            int size = scanner.nextInt();
            int[] arr = new int[size];
            System.out.println("Enter the array elements:");
            for (int i = 0; i < size; i++) {
                arr[i] = scanner.nextInt();
            }

            // Display menu and get user's choice
            System.out.println("\nMenu:");
            System.out.println("To find the Mean Value(1)");
            System.out.println("To find the Median Value(2)");
            System.out.println("To find the Mode Value(3)");
            System.out.print("Enter your choice of (1/2/3): ");
            int choice = scanner.nextInt();

            // Compute and display the result based on the user's choice
            switch (choice) {
                case 1:
                    double mean = computeMean(arr);
                    System.out.println("The mean value is: " + mean);
                    break;
                case 2:
                    double median = computeMedian(arr);
                    System.out.println("The median value is: " + median);
                    break;
                case 3:
                    int mode = computeMode(arr);
                    System.out.println("The mode value is: " + mode);
                    break;
                default:
                    System.out.println("Invalid choice.");
                    break;
            }
        }
    }

    // Function to compute the mean value
    public static double computeMean(int[] arr) {
        int sum = 0;
        for (int i = 0; i < arr.length; i++) {
            sum += arr[i];
        }
        return (double) sum / arr.length;
    }

    // Function to compute the median value
    public static double computeMedian(int[] arr) {
        Arrays.sort(arr);
        if (arr.length % 2 == 0) {
            int mid = arr.length / 2;
            return (double) (arr[mid - 1] + arr[mid]) / 2;
        } else {
            int mid = arr.length / 2;
            return arr[mid];
        }
    }

    // Function to compute the mode value
    public static int computeMode(int[] arr) {
        int mode = arr[0];
        int maxCount = 1;
        for (int i = 0; i < arr.length; i++) {
            int count = 0;
            for (int j = 0; j < arr.length; j++) {
                if (arr[j] == arr[i]) {
                    count++;
                }
            }
            if (count > maxCount) {
                mode = arr[i];
                maxCount = count;
            }
        }
        return mode;
    }
}
