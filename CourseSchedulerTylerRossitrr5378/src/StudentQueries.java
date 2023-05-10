
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author sampe
 */

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author acv
 */
public class StudentQueries {
    private static Connection connection;
    private static PreparedStatement addStudent;
    private static PreparedStatement getAllStudents;
    private static ResultSet resultSet;
    private static PreparedStatement getStudent;
    private static PreparedStatement dropStudent;
    private static PreparedStatement getStudentID;
    
    public static void addStudent(StudentEntry student)
    {
        connection = DBConnection.getConnection();
        
        try
        {
            addStudent = connection.prepareStatement("insert into app.student (studentid, firstname, lastname) values(?, ?, ?)");
            addStudent.setString(1, student.getStudentID());
            addStudent.setString(2, student.getFirstName());
            addStudent.setString(3, student.getLastName());
            addStudent.executeUpdate();
            
        }
        catch(SQLException sqlException)
        {
            sqlException.printStackTrace();
        }
        
    }
    public static ArrayList<StudentEntry> getAllStudents()
    {
        connection = DBConnection.getConnection();
        ArrayList<StudentEntry> students = new ArrayList<StudentEntry>();
        try
        {
            getAllStudents = connection.prepareStatement("select * from app.student order by studentid");
            resultSet = getAllStudents.executeQuery();

            
            
            
            
            while(resultSet.next())
            {    
                students.add(new StudentEntry(resultSet.getString(1), resultSet.getString(2),  resultSet.getString(3)));
            }
        }
        catch(SQLException sqlException)
        {
            sqlException.printStackTrace();
        }
        return students;
        
    }
   public static StudentEntry getStudent(String studentID)
    {
        connection = DBConnection.getConnection();
        StudentEntry student = null;
        try
        {
            getStudent = connection.prepareStatement("select * from app.student where studentid = ?");
            getStudent.setString(1, studentID);
            resultSet = getStudent.executeQuery();
            
            
            
            
            while(resultSet.next())
            {    
            student = new StudentEntry(resultSet.getString(1), resultSet.getString(2),  resultSet.getString(3));
            }
            
        }
        catch(SQLException sqlException)
        {
            sqlException.printStackTrace();
        }
        return student;
        
    }
   public static String getStudentID(String firstName, String lastName)
    {
        connection = DBConnection.getConnection();
        String studentID = null;
        try
        {
            getStudentID = connection.prepareStatement("select studentID from app.student where firstName = ? and lastName = ?");
            getStudentID.setString(1, firstName);
            getStudentID.setString(2, lastName);
            resultSet = getStudentID.executeQuery();
            
            
            
            
            while(resultSet.next())
            {    
            studentID = resultSet.getString(1);
            }
            
        }
        catch(SQLException sqlException)
        {
            sqlException.printStackTrace();
        }
        return studentID;
        
    }
    public static void dropStudent(String studentID)
    {
        connection = DBConnection.getConnection();
        
        try
        {
            dropStudent = connection.prepareStatement("DELETE from app.student WHERE studentID = ?");
            dropStudent.setString(1, studentID);
            dropStudent.executeUpdate();

            
        }
        catch(SQLException sqlException)
        {
            sqlException.printStackTrace();
        }
        
    }
    
}
