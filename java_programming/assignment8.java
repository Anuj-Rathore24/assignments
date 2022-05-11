import java.util.InputMismatchException;
import java.util.Scanner;

// public class assignment8 {

//     public static void main(String[] args) {
//         Scanner sc = new Scanner(System.in);
//         int arr[] = new int[5];
//         try {
//             for (int i = 0; i < 6; i++) {
//                 System.out.println("Enter a number:");
//                 arr[i] = sc.nextInt();
//             }
//         } catch (IndexOutOfBoundsException e) {
//             System.out.println("Array Index Out of Bounds");
//         } catch (InputMismatchException ex) {
//             System.out.println("Input Mismatch");
//         } catch (Exception e) {
//             System.out.println("Exception Handled!");
//         } finally {
//             System.out.println("Try catch executed successfully.");
//             sc.close();
//         }
//     }
// }

public class assignment8 {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter two integer numbers");
        // Read two integers
        int num1 = sc.nextInt();
        int num2 = sc.nextInt();
        try {
            System.out.println(num1 + "/" + num2 + "="
                    + (num1 / num2));
        } catch (ArithmeticException e)
        // multiple catch statement
        {
            System.out.println("Divide by 0");
        } catch (Exception e)
        // superclass
        {
            System.out.println("divide by 0");
        } finally {
            System.out.println("The 'try catch' is finalised.");
        }
        int arr[] = new int[5];
        try {
            for (int i = 0; i < 6; i++) {
                System.out.println("Enter a number:");
                arr[i] = sc.nextInt();
            }
        } catch (IndexOutOfBoundsException e) {
            System.out.println("Array Index Out of Bounds");
        } catch (InputMismatchException ex) {
            System.out.println("Input Mismatch");
        } catch (Exception e) {
            System.out.println("Exception Handled!");
        } finally {
            System.out.println("Finally block!");
        }
    }
}
