class my_thread_function extends Thread {
    my_thread_function(String order){
        super(order);
    }
    public void run() {
        System.out.println("Order ->"+this.getName());
    }
}

public class testing {
    public static void main(String args[]){
        my_thread_function first=new my_thread_function("First Thread");
        first.run();
        my_thread_function Second=new my_thread_function("Second Thread");
        Second.run();
        my_thread_function Third=new my_thread_function("Third Thread");
        Third.run();
    }
}
