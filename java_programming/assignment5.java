
// class area {
//     double rad, ar, len, wid, a;

//     area(double r) {
//         rad = r;
//         ar = 3.14 * rad * rad;
//     }

//     area() {
//         int a = 10;
//         ar = a * a;
//     }

//     area(double len, double wid) {
//         ar = 2 * len * wid;
//     }

//     double cal() {
//         return ar;
//     }
// }

// class assignment5 {
//     public static void main(String args[]) {
//         area rectangle = new area(10, 20);
//         area square = new area();
//         area circle = new area(7);
//         double c;
//         c = rectangle.cal();
//         System.out.println("area of rectangle is " + c);
//         c = square.cal();
//         System.out.println("area of square is " + c);
//         c = circle.cal();
//         System.out.println("area of circle is " + c);
//     }
// }

class Hillstation {
    void location() {
        System.out.println("\n\nLocation not known.");
    }

    void famousfor() {
        System.out.println("Famous for the scenic spots, peace that they give.\n\n");
    }
}

class Gulmarg extends Hillstation {
    void location() {
        System.out.println("\nLocated on the Pir Panjal Range which is the part of western himalayas in Kashmir.");
    }

    void famousfor() {
        System.out.println("Gulmarg is famous for its skiing scenes in India.\n\n");
    }
}

class MountAbu extends Hillstation {
    void location() {
        System.out.println("\nLocated on the Aravalli Range in the state of Rajasthan.");
    }

    void famousfor() {
        System.out.println("Mount Abu is well-known for its Dilwara Jain Temples & the Nakki Lake.\n\n");
    }
}

class Munnar extends Hillstation {
    void location() {
        System.out.println("Located on the Western Ghats mountain ranges in the Kerala.");
    }

    void famousfor() {
        System.out.println("Munnar is famous for its tea plantations and scenic waterfalls");
    }
}

public class assignment5 {
    public static void main(String[] args) {
        Hillstation h = new Hillstation();
        Gulmarg g = new Gulmarg();
        MountAbu ma = new MountAbu();
        Munnar m = new Munnar();
        Hillstation hsref;
        hsref = g;
        hsref.location();
        hsref.famousfor();
        hsref = ma;
        hsref.location();
        hsref.famousfor();
        hsref = m;
        hsref.location();
        hsref.famousfor();
    }
}
