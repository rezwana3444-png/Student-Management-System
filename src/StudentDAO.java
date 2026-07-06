import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class StudentDAO {

    // ADD STUDENT
    public void addStudent(Student student) {

        String sql = "INSERT INTO student(name, age, gender, course, email, phone) VALUES (?, ?, ?, ?, ?, ?)";

        try {

            Connection con = DBConnection.getConnection();

            PreparedStatement ps = con.prepareStatement(sql);

            ps.setString(1, student.getName());
            ps.setInt(2, student.getAge());
            ps.setString(3, student.getGender());
            ps.setString(4, student.getCourse());
            ps.setString(5, student.getEmail());
            ps.setString(6, student.getPhone());

            ps.executeUpdate();

            System.out.println("\n✅ Student Added Successfully!");

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // VIEW ALL STUDENTS
    public void viewStudents() {

        String sql = "SELECT * FROM student";

        try {

            Connection con = DBConnection.getConnection();

            PreparedStatement ps = con.prepareStatement(sql);

            ResultSet rs = ps.executeQuery();

            System.out.println("\n================================================================================================================");
            System.out.printf("%-5s %-15s %-5s %-10s %-12s %-25s %-15s%n",
                    "ID", "NAME", "AGE", "GENDER", "COURSE", "EMAIL", "PHONE");
            System.out.println("================================================================================================================");

            while (rs.next()) {

                System.out.printf("%-5d %-15s %-5d %-10s %-12s %-25s %-15s%n",
                        rs.getInt("id"),
                        rs.getString("name"),
                        rs.getInt("age"),
                        rs.getString("gender"),
                        rs.getString("course"),
                        rs.getString("email"),
                        rs.getString("phone"));
            }

            System.out.println("================================================================================================================");

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // SEARCH STUDENT
    public void searchStudent(int id) {

        String sql = "SELECT * FROM student WHERE id=?";

        try {

            Connection con = DBConnection.getConnection();

            PreparedStatement ps = con.prepareStatement(sql);

            ps.setInt(1, id);

            ResultSet rs = ps.executeQuery();

            if (rs.next()) {

                System.out.println("\n========== STUDENT DETAILS ==========");
                System.out.println("ID      : " + rs.getInt("id"));
                System.out.println("Name    : " + rs.getString("name"));
                System.out.println("Age     : " + rs.getInt("age"));
                System.out.println("Gender  : " + rs.getString("gender"));
                System.out.println("Course  : " + rs.getString("course"));
                System.out.println("Email   : " + rs.getString("email"));
                System.out.println("Phone   : " + rs.getString("phone"));

            } else {

                System.out.println("❌ Student Not Found!");

            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // UPDATE STUDENT
    public void updateStudent(Student student) {

        String sql = "UPDATE student SET name=?, age=?, gender=?, course=?, email=?, phone=? WHERE id=?";

        try {

            Connection con = DBConnection.getConnection();

            PreparedStatement ps = con.prepareStatement(sql);

            ps.setString(1, student.getName());
            ps.setInt(2, student.getAge());
            ps.setString(3, student.getGender());
            ps.setString(4, student.getCourse());
            ps.setString(5, student.getEmail());
            ps.setString(6, student.getPhone());
            ps.setInt(7, student.getId());

            int rows = ps.executeUpdate();

            if (rows > 0) {

                System.out.println("✅ Student Updated Successfully!");

            } else {

                System.out.println("❌ Student ID Not Found!");

            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    } // DELETE STUDENT
public void deleteStudent(int id) {

    String sql = "DELETE FROM student WHERE id=?";

    try {

        Connection con = DBConnection.getConnection();

        PreparedStatement ps = con.prepareStatement(sql);

        ps.setInt(1, id);

        int rows = ps.executeUpdate();

        if (rows > 0) {

            System.out.println("✅ Student Deleted Successfully!");

        } else {

            System.out.println("❌ Student ID Not Found!");

        }

    } catch (Exception e) {

        e.printStackTrace();

    }
}
}