package java_programming;
import java.util.*;

class employee {
    String name, type;
    double base_sal, total_salary;
    int emp_id;
    static List<employee> list_of_emp = new ArrayList<employee>();

    void add_emp(){
        list_of_emp.add(this);
    }
    void display() {
        System.out.println("\n\t\t\t\t****Employee List****");
        System.out.println("Name\tEmployee id\t\tType\t\tBase Salary\tTotal Salary");
        for (employee emp : list_of_emp) {
            System.out.print("\n");
            System.out.print(emp.name + "\t");
            System.out.print(emp.emp_id);
            System.out.print("\t\t");
            System.out.print(emp.type);
            System.out.print("\t\t");
            System.out.print(emp.base_sal);
            System.out.print("\t\t");
            System.out.print(emp.total_salary);
            System.out.print("\t");
        }
    }
}

class full_time_emp extends employee {
    double calc() {
        return this.base_sal + (this.base_sal * 0.5);
    }
}

class intern_emp extends employee {
    double calc() {
        return this.base_sal + (this.base_sal * 0.25);
    }
}

public class assignment3a {
    public static void main(String arg[]) {
        Scanner input = new Scanner(System.in);
        int choice = 0;
        while (choice != 3) {
            System.out.println("\n\t\t\t\t\t***Menu***");
            System.out.print("1)Enter Employee\n2)Diplay All Employee\n3)Exit\n-:");
            choice = input.nextInt();
            switch (choice) {

                case 1: 
                {
                    int ty;
                    System.out.print("\n\n1)Full Time Employee\n2)Intern\n-:");
                    ty = input.nextInt();
                    
                    switch (ty) {
                        case 1:
                        {
                            System.out.println("\n___Full Time Employee___");
                            full_time_emp new_emp=new full_time_emp();
                            
                            new_emp.type="FullTi Employee";

                            System.out.print("Enter Name :");
                            new_emp.name=input.next();
                            
                            System.out.print("Enter Employee Id :");
                            new_emp.emp_id=input.nextInt();
                            
                            System.out.print("Enter Base Salary :");
                            new_emp.base_sal=input.nextDouble();

                            new_emp.total_salary=new_emp.calc();
                            new_emp.add_emp();
                            break;
                            }
                        case 2:
                        {
                            System.out.println("\n___Intern___");
                            intern_emp new_emp=new intern_emp();

                            new_emp.type="Intern Employee";

                            System.out.print("Enter Name :");
                            new_emp.name=input.next();
                            
                            System.out.print("Enter Employee Id :");
                            new_emp.emp_id=input.nextInt();
                            
                            System.out.print("Enter Base Salary :");
                            new_emp.base_sal=input.nextDouble();

                            new_emp.total_salary=new_emp.calc();
                            new_emp.add_emp();
                            break;
                            }
                    
                        default:
                            break;
                    }
                    break;
                }
                case 2: {
                    {
                        employee new_emp=new employee();
                        new_emp.display();
                        break;
                    }
                }
                default:
                    break;
            }
        }

        input.close();
    }
}
