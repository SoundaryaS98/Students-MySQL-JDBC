package com.student.repositories;

import com.student.dao.Student;
import com.student.connections.DatabaseConnection;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 * @author Amol Dhekane
 * @version 1.1
 * @since 11/09/20 5:48 PM
 */
public class StudentRepositories {

    /**
     * This method adds new student in the database
     * @param student data access object that contains respective student data
     * @return Result status of query
     * @throws SQLException
     * @throws ClassNotFoundException
     */
    public int registerStudent(Student student) throws SQLException, ClassNotFoundException {
        Connection connection = DatabaseConnection.getDatabaseConnection();

        String query = "INSERT INTO Students(student_id, student_name, student_age, student_course) VALUES (?,?,?,?)";

        PreparedStatement preparedStatement = connection.prepareStatement(query);
        preparedStatement.setInt(1, student.getId());
        preparedStatement.setString(2, student.getName());
        preparedStatement.setInt(3, student.getAge());
        preparedStatement.setString(4, student.getCourse());
        int id = preparedStatement.executeUpdate();
        connection.close();
        return id;
    }


    /**
     * This methods list of registered students
     * @return List of Student Object
     * @throws SQLException
     * @throws ClassNotFoundException
     */
    public List<Student> getAllStudentData() throws SQLException, ClassNotFoundException {
        Connection connection = DatabaseConnection.getDatabaseConnection();

        Statement statement =  connection.createStatement();

        String query = "SELECT * FROM Students";

        ResultSet resultSet = statement.executeQuery(query);

        // ArrayList of Student
        List<Student> studentList = new ArrayList<Student>();

        while(resultSet.next()) {
            // Initiating new Student data object that will carry the particular student data
            Student student = new Student();
            student.setId(resultSet.getInt("student_id"));
            student.setName(resultSet.getString("student_name"));
            student.setAge(resultSet.getInt("student_age"));
            student.setCourse(resultSet.getString("student_course"));

            // Adding the student to the Student Arrray List
            studentList.add(student);
        }
        statement.close();
        connection.close();
        return studentList;
    }

    public List<Student> getStudentData(int studentID) throws SQLException, ClassNotFoundException {
        Connection connection = DatabaseConnection.getDatabaseConnection();

        Statement statement =  connection.createStatement();

        String query = "SELECT * FROM Students WHERE student_id = " + studentID;

        ResultSet resultSet = statement.executeQuery(query);

        // ArrayList of Student
        List<Student> studentList = new ArrayList<Student>();

        while(resultSet.next()) {
            // Initiating new Student data object that will carry the particular student data
            Student student = new Student();
            student.setId(resultSet.getInt("student_id"));
            student.setName(resultSet.getString("student_name"));
            student.setAge(resultSet.getInt("student_age"));
            student.setCourse(resultSet.getString("student_course"));

            // Adding the student to the Student Array List
            studentList.add(student);
        }
        statement.close();
        connection.close();
        return studentList;
    }

    public void deleteStudent(int studentID) throws SQLException, ClassNotFoundException  {
        Connection connection = DatabaseConnection.getDatabaseConnection();

        Statement statement =  connection.createStatement();

        String query = "DELETE FROM Students WHERE student_id = " + studentID;

        statement.executeUpdate(query);

        statement.close();
        connection.close();
    }
}
