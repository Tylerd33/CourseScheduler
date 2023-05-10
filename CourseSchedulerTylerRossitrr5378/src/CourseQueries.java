
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
public class CourseQueries {
    private static Connection connection;
    private static PreparedStatement getAllCourses;
    private static PreparedStatement addCourse;
    private static PreparedStatement getAllCourseCodes;
    private static PreparedStatement getCourseSeats;
    private static PreparedStatement dropCourse;

        
    private static ResultSet resultSet;

    
    public static ArrayList<courseEntry> getAllCourses(String semester)
    {
        connection = DBConnection.getConnection();
        ArrayList<courseEntry> courses = new ArrayList<courseEntry>();
        try
        {
            getAllCourses = connection.prepareStatement("select * from app.course WHERE semester = ?");
            getAllCourses.setString(1, semester);
            resultSet = getAllCourses.executeQuery();

            
            
            
            
            while(resultSet.next())
            {    
                courses.add(new courseEntry(resultSet.getString(1), resultSet.getString(2),  resultSet.getString(3), resultSet.getInt(4)));
            }
        }
        catch(SQLException sqlException)
        {
            sqlException.printStackTrace();
        }
        return courses;
        
    }
        public static void addCourse(courseEntry course)
    {
        connection = DBConnection.getConnection();
        
        try
        {
            addCourse = connection.prepareStatement("insert into app.course (semester, coursecode, description, seats) values(?, ?, ?, ?)");
            addCourse.setString(1, course.getSemester());
            addCourse.setString(2, course.getCourseCode());
            addCourse.setString(3, course.getCourseDescription());
            addCourse.setInt(4, course.getSeats());
            addCourse.executeUpdate();
            
        }
        catch(SQLException sqlException)
        {
            sqlException.printStackTrace();
        }
        
    }
        public static ArrayList<String> getAllCourseCodes(String semester)
    {
        connection = DBConnection.getConnection();
        ArrayList<String> courseCodes = new ArrayList<String>();

        try
        {
            getAllCourseCodes = connection.prepareStatement("select coursecode from app.course WHERE semester = ?");
            getAllCourseCodes.setString(1, semester);
            resultSet = getAllCourseCodes.executeQuery();
            while(resultSet.next())
            {    
                courseCodes.add(resultSet.getString(1));
            }
        }
        catch(SQLException sqlException)
        {
            sqlException.printStackTrace();
        }
        return courseCodes;
    }
    public static int getCourseSeats(String semester, String courseCode)
    {
        connection = DBConnection.getConnection();
        int ret;
        ret = 0;
        try
        {
            getCourseSeats = connection.prepareStatement("select seats from app.course WHERE semester = ? AND courseCode = ?");
            getCourseSeats.setString(1, semester);
            getCourseSeats.setString(2, courseCode);

            resultSet = getCourseSeats.executeQuery();
            if (resultSet.next() ) {
                ret = resultSet.getInt(1);

            } 
        }
        catch(SQLException sqlException)
        {
            sqlException.printStackTrace();
        }
        return ret;
    }
   public static void dropCourse(String semester, String courseCode)
    {
        connection = DBConnection.getConnection();
        
        try
        {
            dropCourse = connection.prepareStatement("DELETE from app.course WHERE semester = ? AND courseCode = ?");
            dropCourse.setString(1, semester);
            dropCourse.setString(2, courseCode);
            dropCourse.executeUpdate();
            
        }
        catch(SQLException sqlException)
        {
            sqlException.printStackTrace();
        }
        
    }
}
