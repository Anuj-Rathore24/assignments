package java;
import java.util.*;

class stud {
    int roll_no, sub1, sub2, sub3, sub4, sub5, percentage;
    String name, grade;
    static List<stud> list_of_obects = new ArrayList<stud>();

    stud(int R, String N, int s1, int s2, int s3, int s4, int s5) {
        this.roll_no = R;
        this.name = N;
        this.sub1 = s1;
        this.sub2 = s2;
        this.sub3 = s3;
        this.sub4 = s4;
        this.sub5 = s5;
        this.percentage = (s1 + s2 + s3 + s4 + s5) / 5;

        if (percentage >= 90) {
            this.grade = "A";
        } else if (percentage >= 70 && percentage < 90) {
            this.grade = "B";
        } else {
            this.grade = "C";
        }

        list_of_obects.add(this);
    }

    stud() {

    }

    void display() {
        System.out.println("\n\nName\t\tRoll No\t Sub1 \tSub2 \tSub3 \tSub4 \tSub5 \tPercentage \t\tGrade");
        for (stud stud : list_of_obects) {

            System.out.print("\n");
            System.out.print(stud.name);
            System.out.print("\t\t");
            System.out.print(stud.roll_no);
            System.out.print("\t");
            System.out.print(stud.sub1);
            System.out.print("\t");
            System.out.print(stud.sub2);
            System.out.print("\t");
            System.out.print(stud.sub3);
            System.out.print("\t");
            System.out.print(stud.sub4);
            System.out.print("\t");
            System.out.print(stud.sub5);
            System.out.print("\t");
            System.out.print(stud.percentage);
            System.out.print("\t\t\t");
            System.out.print(stud.grade);

        }
    }
}

public class assignment2 {

    public static void main(String arg[]) {
        Scanner input = new Scanner(System.in);
        int choice = 0;
        while (choice != 3) {
            System.out.println("\n\t\t\t\t\t***Menu***");
            System.out.print("1)Enter New Entry\n2)Show all records\n3)Exit\n-:");
            choice = input.nextInt();
            switch (choice) {
                case 1: {
                    int roll_no, sub1, sub2, sub3, sub4, sub5;
                    String name;
                    System.out.println("\n\t\tEnter Information--:");
                    System.out.print("Name :");
                    name = input.next();
                    System.out.print("Roll Number :");
                    roll_no = input.nextInt();
                    System.out.print("Subject 1 :");
                    sub1 = input.nextInt();
                    System.out.print("Subject 2 :");
                    sub2 = input.nextInt();
                    System.out.print("subject 3 :");
                    sub3 = input.nextInt();
                    System.out.print("Subject 4 :");
                    sub4 = input.nextInt();
                    System.out.print("Subject 5 :");
                    sub5 = input.nextInt();
                    stud new_stud = new stud(roll_no, name, sub1, sub2, sub3, sub4, sub5);
                    break;
                }
                case 2: {

                    stud new_stud = new stud();
                    new_stud.display();
                    break;
                }

                default:
                    break;
            }
        }
        input.close();
    }
}
