
// import java.util.Scanner;

// class Even extends Thread {
//     int range;

//     Even(int _range) {
//         super();
//         range = _range;
//     }

//     public void run() {
//         for (int i = 0; i < range; i += 2) {
//             System.out.println("Thread Even : " + i);
//         }
//     }
// }

// class Odd extends Thread {
//     int range;

//     Odd(int _range) {
//         super();
//         range = _range;
//     }

//     public void run() {
//         for (int i = 1; i < range; i += 2) {
//             System.out.println("Thread Odd :" + i);
//         }
//     }
// }

// public class assignment6 {
//     public static void main(String[] args) {
//         Scanner scanf = new Scanner(System.in);
//         System.out.print("\nEnter Range : ");
//         int range = scanf.nextInt();
//         Even ev = new Even(range);
//         Odd od = new Odd(range);
//         ev.start();
//         try {
//             ev.join();
//         } catch (InterruptedException e) {
//             e.printStackTrace();
//         }
//         od.start();
//         scanf.close();
//     }
// }

import java.util.*;

class calc_add extends Thread {
    public void run(int a, int b) {
        System.out.println("Sum: " + (a + b));
    }
}

class calc_sub extends Thread {
    public void run(int a, int b) {
        System.out.println("Difference: " + (a - b));
    }
}

class calc_mul extends Thread {
    public void run(int a, int b) {
        System.out.println("Multiply: " + (a * b));
    }
}

class calc_div extends Thread {
    public void run(int a, int b) {
        System.out.println("Divide: ");
        try {
            System.out.print((a / b));
        } catch (Exception e) {
            System.out.println("Exception-->" + e);
        }
    }
}

public class assignment6 {
    public static void main(String[] args) {
        calc_add add = new calc_add();
        calc_sub sub = new calc_sub();
        calc_mul mul = new calc_mul();
        calc_div div = new calc_div();
        Scanner sc = new Scanner(System.in);
        int a, b;
        System.out.println("Enter 2 integers: ");
        System.out.print("a: ");
        a = sc.nextInt();
        System.out.print("\t\t\t\tb: ");
        b = sc.nextInt();
        add.run(a, b);
        try {
            add.join();
        } catch (InterruptedException ie) {
        }
        sub.run(a, b);
        try {
            sub.join();
        } catch (InterruptedException ie) {
        }
        mul.run(a, b);
        try {
            mul.join();
        } catch (InterruptedException ie) {
        }
        div.run(a, b);
        try {
            div.join();
        } catch (InterruptedException ie) {
        }
    }
}
