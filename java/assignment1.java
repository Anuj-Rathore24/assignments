package java;
//1.Even or odd?

// import java.util.Scanner;

// public class assignment1 {
//     public static void main(String[] args) {
//         Scanner input = new Scanner(System.in);
//         System.out.print("Enter Number :");
//         int n = input.nextInt();
//         String result = (n % 2 == 0) ? "The number is even" : "The number is odd";
//         System.out.println("\n" + result);

//         input.close();
//     }
// }

//2.Bill calculator using nested condition

// import java.util.Scanner;

// public class assignment1_1 {
//     public static void main(String[] args){
//         System.out.println("\t\t\tAmount Discount\n<5000 10%\n>=5000 and <10000 15%\n>=10000 and <20000 20%\n>=20000 50%");
//         System.out.print("\nEnter the Amount :");
//         Scanner input=new Scanner(System.in);
//         double amount=input.nextFloat();

//         if (amount<5000) {
//             amount=amount-amount*0.1;
//         } else if(amount>=5000 && amount<10000) {

//             amount=amount-amount*0.15;
//         }
//         else if(amount>=10000 && amount<20000) {

//             amount=amount-amount*0.2;
//         }
//         else if(amount>=20000) {

//             amount=amount-amount*0.5;
//         }
//         System.out.println("\nThe Bill is :"+String.valueOf(amount));
//         input.close();
//     }
// }

//3.calculator using switch case

// import java.util.Scanner;

// public class assignment1 {
//     public static void main(String[] args) {
//         Scanner input = new Scanner(System.in);
//         while (true) {
//             System.out.print(
//                     "\n\t\t\t\t***Select***\n1)Addition\n2)Substraction\n3)Multiplication\n4)Division\n5)Exit \n:");
//             int key = input.nextInt();
//             if(key==5){
//                 break;
//             }
//             System.out.print("Enter 1st Numbers \n:");
//             float num1 = input.nextFloat();
//             System.out.print("Enter 2nd Number \n:");
//             float num2 = input.nextFloat();
//             switch (key) {
//                 case 1:
//                     System.out.println("The Addition is ");
//                     System.out.println(num1 + num2);

//                     break;
//                 case 2:
//                     System.out.println("The Differnece is ");
//                     System.out.println(num1 - num2);

//                     break;
//                 case 3:
//                     System.out.println("The Product is ");
//                     System.out.println(num1 * num2);

//                     break;
//                 case 4:
//                     if (num2 != 0) {

//                         System.out.println("The Division is ");
//                         System.out.println(num1 / num2);
//                     } else {
//                         System.out.println("Error! Denominator cannot be negative ");
//                     }

//                     break;
//                 default:
//                     break;
//             }
//         }
//         input.close();
//     }
// }

//4.perfect number{using list class}

// import java.util.*;

// public class assignment1{
//     public static void main(String[] args){
//         Scanner input=new Scanner(System.in);
//         int key;
//         while(true){
//             System.out.print("\n\n\t\t\t\t***Select***\n1)Enter new Number\n2)Exit \n:");
//             key=input.nextInt();
//             if(key==2){
//                 break;
//             }
//             List<Integer> factors_list=new ArrayList<Integer>();
//             System.out.print("Number \n:");
//             int number=input.nextInt();
//             int sum=0;
//             if(number%2==0){

//                 for (int i = 1; i < number/2+1; i++) {
//                     if(number%i==0){
//                         factors_list.add(i);
//                     }
//                 }
//             }else{
//                 for (int i = 1; i < ((number+1)/2)+1; i++) {
//                     if(number%i==0){
//                         factors_list.add(i);
//                     }
//                 }

//             }
//             for(Integer n:factors_list){
//                 sum+=n;
//             }
//             String result=(sum==number)?"The Entered Number is Perfect Number":"The Entered Number is not a perfect number";
//             System.out.println(result);
//         }

//         input.close();
//     }
// }



//5. Reverse Number

import java.util.*;
import java.lang.Math;

public class assignment1 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int key;
        while (true) {
            System.out.print("\n\n\t\t\t\t***Select***\n1)Enter new Number\n2)Exit \n:");
            key = input.nextInt();
            if (key == 2) {
                break;
            }
            List<Integer> digit_list = new ArrayList<Integer>();
            System.out.print("Number \n:");
            int number = input.nextInt();
            int temp=number,reverse_number=0;

            int exp=1,digits=0;
            while(temp%((int)Math.pow(10,exp))>1){
                digit_list.add(temp%((int)Math.pow(10,exp)));
                temp-=temp%((int)Math.pow(10,exp));
                System.out.println(temp%((int)Math.pow(10,exp)));
                System.out.println("testing");
                exp++;
                digits++;
            }
            for (int i = 0; i < digits; i++) {
                reverse_number+=digit_list.get(i)*((int)Math.pow(10,exp));
                exp--;
                System.out.println(digit_list.get(i));
                System.out.println(reverse_number);
            }
            
            System.out.print("The reversed number is :");
            System.out.print(reverse_number);

        }
        input.close();
    }
}