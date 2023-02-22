/*Write a Java Program that will collect your basic details that fall into different data types and displays them.
After the details have been displayed, with the help of conditional statements, check if the gender of the user is 'm' or 'f'.
 It should print "MALE" for 'm' and "FEMALE" for 'f'.
Assume that you can divide the states among India into four different regions (North, South, East, and West).
 If you are from the southern part of India;
  with the help of a switch statement, it should display The Student is from the southern states of India", along with the basic details. */

  import java.util.Scanner;

  public class Lab_1 {
     public static void main(String[] args) {

      try (Scanner scan = new Scanner(System.in)) {
        System.out.println("WELCOME YOU ! ");

          System.out.println("Enter your name: ");
          String name = scan.nextLine();

          System.out.println("Enter your age: ");
          int age = scan.nextInt();
          
          System.out.println("Enter your gender (Male=m/Female=f): ");
          char gender = scan.next().charAt(0);

          System.out.println("Enter your state : ");
          String region = scan.next();

          System.out.println("Name: " + name);
          System.out.println("Age: " + age);
          
          if (gender == 'm') {
            System.out.println("Gender: MALE");
        } else {
            System.out.println("Gender: FEMALE");
        }

        switch (region) {
            case "andhra pradesh", "karnataka", "kerala", "tamilnadu", "telangana":
                System.out.println("The student is from the southern states of India.");
                break;

            case "Jammu & Kashmir", "Himachal Pradesh", "Punjab", "Uttarakhand", "Haryana", "Delhi", "Rajasthan", "Uttar Pradesh" ,"UT Chandigarh":
                System.out.println("The student is from the northern states of India.");
                break;

            case "Arunachal Pradesh", "Assam", "Manipur", "Meghalaya", "Mizoram", "Nagaland","Tripura":
                System.out.println("The student is from the eastern states of India.");
                break;

            case "Chhattisgarh", "Odisha", "Sikkim", "West Bengal":
                System.out.println("The student is from the western states of India.");
                break;

            default:
                System.out.println("Invalid region.");
                break;


                
        }
    }

      
    }

  }

