import java.util.Scanner;

public class Menu {

    public static void showMenu() {

        Scanner sc = new Scanner(System.in);
        StudentDAO dao = new StudentDAO();

        while (true) {

            System.out.println("\n==============================");
            System.out.println("   STUDENT MANAGEMENT SYSTEM");
            System.out.println("==============================");
            System.out.println("1. Add Student");
            System.out.println("2. View Students");
            System.out.println("3. Update Student");
            System.out.println("4. Delete Student");
            System.out.println("5. Search Student");
            System.out.println("6. Exit");

            System.out.print("Enter your choice: ");

            int choice = sc.nextInt();
            sc.nextLine();

            switch (choice) {

                case 1:

                    System.out.print("Enter Name: ");
                    String name = sc.nextLine();

                    System.out.print("Enter Age: ");
                    int age = sc.nextInt();
                    sc.nextLine();

                    System.out.print("Enter Gender: ");
                    String gender = sc.nextLine();

                    System.out.print("Enter Course: ");
                    String course = sc.nextLine();

                    System.out.print("Enter Email: ");
                    String email = sc.nextLine();

                    System.out.print("Enter Phone: ");
                    String phone = sc.nextLine();

                    Student student = new Student(
                            name,
                            age,
                            gender,
                            course,
                            email,
                            phone);

                    dao.addStudent(student);
                    break;

                case 2:

                    dao.viewStudents();
                    break;

                case 3:

                    System.out.print("Enter Student ID: ");
                    int id = sc.nextInt();
                    sc.nextLine();

                    System.out.print("New Name: ");
                    name = sc.nextLine();

                    System.out.print("New Age: ");
                    age = sc.nextInt();
                    sc.nextLine();

                    System.out.print("New Gender: ");
                    gender = sc.nextLine();

                    System.out.print("New Course: ");
                    course = sc.nextLine();

                    System.out.print("New Email: ");
                    email = sc.nextLine();

                    System.out.print("New Phone: ");
                    phone = sc.nextLine();

                    Student updatedStudent = new Student(
                            id,
                            name,
                            age,
                            gender,
                            course,
                            email,
                            phone);

                    dao.updateStudent(updatedStudent);
                    break;

                case 4:

    System.out.print("Enter Student ID to Delete: ");

    int deleteId = sc.nextInt();

    dao.deleteStudent(deleteId);

    break;

                case 5:

                    System.out.print("Enter Student ID: ");
                    id = sc.nextInt();

                    dao.searchStudent(id);
                    break;

                case 6:

                    System.out.println("Thank You!");
                    sc.close();
                    return;

                default:

                    System.out.println("Invalid Choice!");

            }
        }
    }
}