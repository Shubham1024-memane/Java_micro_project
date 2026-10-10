import java.util.ArrayList;
import java.util.Scanner;

interface Gym {
    void display();
}

class Member {
    int id;
    String name;
    int age;

    Member(int id, String name, int age) {
        this.id = id;
        this.name = name;
        this.age = age;
    }
}

class GymMember extends Member implements Gym {

    String plan;

    GymMember(int id, String name, int age, String plan) {
        super(id, name, age);
        this.plan = plan;
    }

    public void display() {
        System.out.println(
            id + "  " + name + "  " + age + "  " + plan
        );
    }

    void fee() {
        if (plan.equals("Monthly"))
            System.out.println("Fee: Rs.1000");
        else if (plan.equals("Quarterly"))
            System.out.println("Fee: Rs.2500");
        else
            System.out.println("Fee: Rs.8000");
    }
}

public class GymManagement {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        ArrayList<GymMember> members = new ArrayList<>();

        int choice;

        do {
            System.out.println("\n--- GYM MANAGEMENT SYSTEM ---");
            System.out.println("1. Add Member");
            System.out.println("2. Display Members");
            System.out.println("3. Search Member");
            System.out.println("4. Exit");
            System.out.print("Enter choice: ");

            choice = sc.nextInt();

            try {

                if (choice == 1) {

                    System.out.print("Enter ID: ");
                    int id = sc.nextInt();

                    sc.nextLine();

                    System.out.print("Enter Name: ");
                    String name = sc.nextLine();

                    System.out.print("Enter Age: ");
                    int age = sc.nextInt();

                    sc.nextLine();

                    System.out.print(
                        "Enter Plan (Monthly/Quarterly/Yearly): "
                    );
                    String plan = sc.nextLine();

                    GymMember m =
                        new GymMember(id, name, age, plan);

                    members.add(m);

                    System.out.println("Member added!");

                } else if (choice == 2) {

                    System.out.println("\nID  Name  Age  Plan");

                    for (GymMember m : members) {
                        m.display();
                        m.fee();
                    }

                } else if (choice == 3) {

                    System.out.print("Enter ID: ");
                    int id = sc.nextInt();

                    boolean found = false;

                    for (GymMember m : members) {

                        if (m.id == id) {
                            m.display();
                            m.fee();
                            found = true;
                        }
                    }

                    if (!found)
                        System.out.println("Member not found.");

                } else if (choice == 4) {
                    System.out.println("Thank you!");
                } else {
                    System.out.println("Invalid choice!");
                }

            } catch (Exception e) {
                System.out.println("Invalid input!");
                sc.nextLine();
            }

        } while (choice != 4);

        sc.close();
    }
}
