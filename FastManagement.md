```
public class Student {
    private int id;
    private String name;
    private int score;

    // Constructors, getters, and setters
}
```
```
import java.util.ArrayList;
import java.util.List;

public class AllStudent {
    private static List<Student> students = new ArrayList<>();

    public List<Student> getAllStudents() {
        return students;
    }

    public void addStudent(Student student) {
        students.add(student);
    }

    public void removeStudent(int id) {
        students.removeIf(student -> student.getId() == id);
    }
}
```
```
import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class AddServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String name = request.getParameter("name");
        int id = Integer.parseInt(request.getParameter("id"));
        int score = Integer.parseInt(request.getParameter("score"));

        Student student = new Student();
        student.setId(id);
        student.setName(name);
        student.setScore(score);

        AllStudent allStudent = new AllStudent();

        if (studentExists(allStudent, id)) {
            // Student already exists
            response.sendRedirect("AddRemoveStudent.jsp?message=Student already exists");
        } else {
            allStudent.addStudent(student);
            response.sendRedirect("AddRemoveStudent.jsp?message=Student added successfully");
        }
    }

    private boolean studentExists(AllStudent allStudent, int id) {
        for (Student student : allStudent.getAllStudents()) {
            if (student.getId() == id) {
                return true;
            }
        }
        return false;
    }
}
```
```
import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class RemoveServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        AllStudent allStudent = new AllStudent();

        if (studentExists(allStudent, id)) {
            allStudent.removeStudent(id);
            response.sendRedirect("AddRemoveStudent.jsp?message=Student removed successfully");
        } else {
            response.sendRedirect("AddRemoveStudent.jsp?message=Student not found");
        }
    }

    private boolean studentExists(AllStudent allStudent, int id) {
        for (Student student : allStudent.getAllStudents()) {
            if (student.getId() == id) {
                return true;
            }
        }
        return false;
    }
}
```
```
<!DOCTYPE html>
<html>
<head>
    <title>Add/Remove Student</title>
</head>
<body>
    <h1>Add/Remove Student</h1>
    <p>${param.message}</p>

    <form action="AddServlet" method="post">
        <input type="text" name="id" placeholder="Student ID" required><br>
        <input type="text" name="name" placeholder="Student Name" required><br>
        <input type="text" name="score" placeholder="Student Score" required><br>
        <input type="submit" value="Add Student">
    </form>

    <form action="RemoveServlet" method="post">
        <input type="text" name="id" placeholder="Student ID to Remove" required><br>
        <input type="submit" value="Remove Student">
    </form>
</body>
</html>
```
```
<!DOCTYPE html>
<html>
<head>
    <title>All Student Data</title>
</head>
<body>
    <h1>All Student Data</h1>
    <table border="1">
        <tr>
            <th>ID</th>
            <th>Name</th>
            <th>Score</th>
            <th>Grade</th>
        </tr>
        <c:forEach items="${students}" var="student">
            <tr>
                <td>${student.id}</td>
                <td>${student.name}</td>
                <td>${student.score}</td>
                <td><c:out value="${student.grade}" /></td>
            </tr>
        </c:forEach>
    </table>
</body>
</html>
```
