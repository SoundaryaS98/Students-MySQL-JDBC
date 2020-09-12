package com.student.services;

import com.student.dao.Student;
import com.student.repositories.StudentRepositories;

import java.sql.SQLException;
import java.util.List;
import java.util.Scanner;

/**
 * @author Amol Dhekane
 * @version 1.1
 * @since 11/09/20 6:54 PM
 */
public class StudentServices {
    private StudentRepositories studentRepositories = new StudentRepositories();

    /**
     * This methods handles the user interactivity of adding the new student
     */
    public void registerStudent(){
        Scanner scanner = new Scanner(System.in);

        System.out.println("<< Add new student >>");

        Student student = new Student();
        System.out.printf("ID: ");
        student.setId(scanner.nextInt());
        scanner.nextLine();
        System.out.printf("Name: ");
        student.setName(scanner.nextLine());
        System.out.printf("Course: ");
        student.setCourse(scanner.nextLine());
        System.out.printf("Age: ");
        student.setAge(scanner.nextInt());

        System.out.println("Please wait...");

        try {
            int result = studentRepositories.registerStudent(student);
            if (result == 1){
                System.out.println("Success! New student added.");
            }
            else{
                System.out.println("Err! Failed to register new student.");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    /**
     * This methods handles the user interactivity of listing all the registered students
     */
    public void listStudents(){
        try {
            System.out.println("Please wait...");
            List<Student> studentList = studentRepositories.getAllStudentData();
            if(studentList.isEmpty()){
                System.out.println("<< No student records >>");
            }
            else{
                System.out.println("<< List of registered student >>");
                System.out.println("<<*>>");
                for(Student student : studentList){
                    System.out.println("Id: " + student.getId());
                    System.out.println("Name: " + student.getName());
                    System.out.println("Age: " + student.getAge());
                    System.out.println("Course: " + student.getCourse());
                    System.out.println("<<*>>");
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    /**
     * This methods handles the user interactivity of listing the student needed
     */
    public void retrieveStudent(){
        Scanner scanner =  new Scanner(System.in);
        try {
            System.out.println("Please wait...");
            System.out.print("Enter the ID if the student: ");
            int studentID = scanner.nextInt();
            Student studentData = studentRepositories.getStudentData(studentID);
            if(studentData == null){
                System.out.println("<< No student with ID " + studentID + " >>");
            }
            else{
                System.out.println("<< Details of student with ID >>" + studentID);
                System.out.println("<<*>>");
                System.out.println("Id: " + studentData.getId());
                System.out.println("Name: " + studentData.getName());
                System.out.println("Age: " + studentData.getAge());
                System.out.println("Course: " + studentData.getCourse());
                System.out.println("<<*>>");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    /**
     * This methods handles the user interactivity of deleting a student record
     */
    public void deleteStudent(){
        Scanner scanner =  new Scanner(System.in);
        try {
            System.out.println("Please wait...");
            System.out.print("Enter the ID if the student to be deleted: ");
            int studentID = scanner.nextInt();
            Student studentData = studentRepositories.getStudentData(studentID);

            if(studentData == null){
                System.out.println("<< No student with ID " + studentID + " >>");
            }
            else{
                studentRepositories.deleteStudent(studentID);
                System.out.println("Student deleted.");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

}
