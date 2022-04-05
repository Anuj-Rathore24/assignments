package java_programming;
//interface


interface motorbike {
    void total_distance();
    int speed=200;
    
}
interface cycle{
    int time=2;
}
class twowheeler implements motorbike,cycle{
    public void total_distance(){
        System.out.print("The total Distance covered is :");
        System.out.print(time*speed);
    }
}

class assignment4ab{
    public static void main(String arg[]){
        twowheeler ride=new twowheeler();
        ride.total_distance();

    }
}