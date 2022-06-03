import java.io.*;
import java.util.*;

public class assignment4b {
    public static void main(String args[]) {
        Scanner input = new Scanner(System.in);
        String name;
        int roll_no, choice = 0;
        int subs[] = new int[5];

        while (choice != 3) {
            System.out.print("\n\n\t\t\t***Menu***\n1)Enter Record\n2)Show all records\n3)Exit\n-:");
            choice=input.nextInt();
            switch (choice) {
                case 1:

                    System.out.print("Enter Name :");
                    name = input.next();
                    System.out.print("Enter Roll Number :");
                    roll_no = input.nextInt();
                    for (int i = 0; i < subs.length; i++) {

                        System.out.print("Enter Marks :");
                        subs[i] = input.nextInt();
                    }

                    try {

                        FileWriter fr = new FileWriter("data.txt",true);
                        BufferedWriter writer = new BufferedWriter(fr);
                        writer.write("\n"+name+" "+Integer.toString(roll_no)+" ");
    
                        for (int j = 0; j < subs.length; j++) {

                            writer.write(Integer.toString(subs[j]));
                            writer.write("   ");
                        }
                        writer.close();
                    } catch (IOException e) {
                        System.out.println(e);
                    }
                    break;
                case 2:
                try {
                    int temp;
                    System.out.println("Name RollNo Sub1 Sub2 Sub3 Sub4 Sub5");
                    FileReader fr = new FileReader("data.txt");
                    BufferedReader reader = new BufferedReader(fr);
                    while ((temp = reader.read()) != -1) {
                        System.out.print((char) temp);
                    }
                    reader.close();
                } catch (IOException e) {
                    System.out.println(e);
                }
                    break;
                default:
                    break;
            }
        }

        

        input.close();
    }
}