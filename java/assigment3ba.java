package java;
import java.util.*;                                                                                                                         
abstract class instrument{
   abstract String play();
}

class piano extends instrument{
    String play(){
        return "Piano is playing tan tan tan";
    }
}
class guitar extends instrument{
    String play(){
        return "Piano is playing tin tin tin";
    }

}
class flute extends instrument{
    String play(){
        return "Piano is playing toot toot toot";
    }
}


public class assigment3ba {
    public static void main(String arg[]) {
        Scanner input = new Scanner(System.in);
        piano new_piano=new piano();
        guitar new_guitar=new guitar();
        flute new_flute=new flute();
        System.out.println("\n***1st Instrument***\n>>"+new_piano.play());
        System.out.println("\n***2st Instrument***\n>>"+new_guitar.play());
        System.out.println("\n***3st Instrument***\n>>"+new_flute.play());
        input.close();
    }
}
