
//Java code for thread creation by extending the Thread class
// class MultithreadingDemo extends Thread {
//     public void run() {
//         try {
//             // Displaying the thread that is running
//             System.out.println("Thread " + Thread.currentThread() + " is running");
//         } catch (Exception e) {

//             System.out.println("Exception is caught");
//         }
//     }
// }

// // main class
// public class assignment7 {
//     public static void main(String args[]) {
//         int n = 8; 
//         for (int i = 0; i < n; i++) {
//             MultithreadingDemo object = new MultithreadingDemo();
//             object.start();
//         }
//     }
// }

// class MultithreadingDemo1
//         implements Runnable {
//     public void run() {
//         try {
//             // Displaying the thread that is running
//             System.out.println("Thread " +
//                     Thread.currentThread() + " is running");
//         } catch (Exception e) {
//             // Throwing an exception
//             System.out.println("Exception is caught");
//         }
//     }
// }

// // main Class
// class assignment7 {
//     public static void main(String[] args) {
//         int n = 8; // Number of Threads
//         for (int i = 0; i < n; i++) {
//             Thread object = new Thread(new MultithreadingDemo1());
//             object.start();
//         }
//     }
// }

class assignment7 extends Thread {
    public void run() {
        try {
            Thread.sleep(300);
            System.out.println("is run() method isAlive " + Thread.currentThread().isAlive());
        } catch (InterruptedException ie) {
        }
    }

    public static void main(String[] args) {
        assignment7 t1 = new assignment7();
        System.out.println("before starting thread isAlive: " + t1.isAlive());
        t1.start();
        System.out.println("after starting thread isAlive: " + t1.isAlive());
    }
}
