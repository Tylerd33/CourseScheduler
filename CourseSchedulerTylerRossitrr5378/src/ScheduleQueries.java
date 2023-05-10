
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Other/File.java to edit this template
 */

/**
 *
 * @author sampe
 */
public class ScheduleQueries {

    private static Connection connection;
    private static PreparedStatement addScheduleEntry;
    private static PreparedStatement getScheduleByStudent;
    private static PreparedStatement getScheduledStudentCount;
    private static ResultSet resultSet;
    private static PreparedStatement getScheduledStudentByCourse;
    private static PreparedStatement getWaitlistedStudentByCourse;
    private static PreparedStatement dropStudentScheduleByCourse;
    private static PreparedStatement dropScheduleByCourse;
    private static PreparedStatement updateScheduleEntry;
    private static PreparedStatement getStatusOfCourse;
    

    
    public static void addScheduleEntry(ScheduleEntry entry)
    {
        connection = DBConnection.getConnection();
        
        try
        {
            addScheduleEntry = connection.prepareStatement("insert into app.schedule (semester, studentid, coursecode, status, timestamp) values(?, ?, ?, ?, ?)");
            addScheduleEntry.setString(1, entry.getSemester());
            addScheduleEntry.setString(2, entry.getStudentID());
            addScheduleEntry.setString(3, entry.getCourseCode());
            addScheduleEntry.setString(4, entry.getStatus());
            addScheduleEntry.setTimestamp(5, entry.getTime());

            addScheduleEntry.executeUpdate();
        }
        catch(SQLException sqlException)
        {
            sqlException.printStackTrace();
        }
        
    }
    public static ArrayList<ScheduleEntry> getScheduleByStudent(String givenSemester, String givenStudentID)
    {
        connection = DBConnection.getConnection();
        ArrayList<ScheduleEntry> schedules = new ArrayList<>();
        try
        {

            getScheduleByStudent = connection.prepareStatement("select * from app.schedule WHERE semester = ? and studentid = ? ORDER by status");
            
            getScheduleByStudent.setString(1, givenSemester);
            getScheduleByStudent.setString(2, givenStudentID); 
            resultSet = getScheduleByStudent.executeQuery();

            while(resultSet.next())
            {    
                schedules.add(new ScheduleEntry(resultSet.getString(1), resultSet.getString(2), resultSet.getString(3), resultSet.getString(4), resultSet.getTimestamp(5)));


            }
        }
        catch(SQLException sqlException)
        {
            sqlException.printStackTrace();
        }
        
        return schedules;
        
    }
    
    public static int getScheduledStudentCount(String currentSemester, String courseCode)
    {
        connection = DBConnection.getConnection();
        int count;
        count = 0;
        try
        {
            getScheduledStudentCount = connection.prepareStatement("select count(studentID) from app.schedule where semester = ? and courseCode = ?");
            getScheduledStudentCount.setString(1, currentSemester);
            getScheduledStudentCount.setString(2, courseCode);           
            resultSet = getScheduledStudentCount.executeQuery();
            while (resultSet.next()){
            count = resultSet.getInt(1);
        }   
        }
        catch(SQLException sqlException)
        {
            sqlException.printStackTrace();
        }
        return count;
        
    }
    public static ArrayList<ScheduleEntry> getScheduledStudentByCourse(String currentSemester, String courseCode)
    {
        ArrayList<ScheduleEntry> schedules = new ArrayList<>();
        connection = DBConnection.getConnection();
        try
        {
            getScheduledStudentByCourse = connection.prepareStatement("select * from app.schedule where semester = ? and courseCode = ? and status = ?");
            getScheduledStudentByCourse.setString(1, currentSemester);
            getScheduledStudentByCourse.setString(2, courseCode);       
            getScheduledStudentByCourse.setString(3, "S");
            resultSet = getScheduledStudentByCourse.executeQuery();
            while (resultSet.next()){
                schedules.add(new ScheduleEntry(resultSet.getString(1), resultSet.getString(2), resultSet.getString(3), resultSet.getString(4), resultSet.getTimestamp(5)));            }   
            }
        catch(SQLException sqlException)
        {
            sqlException.printStackTrace();
        }
        return schedules;
        
    }
    public static ArrayList<ScheduleEntry> getWaitlistedStudentByCourse(String currentSemester, String courseCode)
    {
        ArrayList<ScheduleEntry> schedules = new ArrayList<>();
        connection = DBConnection.getConnection();
        try
        {
            getWaitlistedStudentByCourse = connection.prepareStatement("select * from app.schedule where semester = ? and courseCode = ? and status = ? order by timestamp");
            getWaitlistedStudentByCourse.setString(1, currentSemester);
            getWaitlistedStudentByCourse.setString(2, courseCode);       
            getWaitlistedStudentByCourse.setString(3, "W");
            resultSet = getWaitlistedStudentByCourse.executeQuery();
            while (resultSet.next()){
                schedules.add(new ScheduleEntry(resultSet.getString(1), resultSet.getString(2), resultSet.getString(3), resultSet.getString(4), resultSet.getTimestamp(5)));            }   
            }
        catch(SQLException sqlException)
        {
            sqlException.printStackTrace();
        }
        return schedules;
        
    }
   public static void dropStudentScheduleByCourse(String semester, String studentID, String courseCode)
    {
        connection = DBConnection.getConnection();
        try
        {
            dropStudentScheduleByCourse = connection.prepareStatement("DELETE from app.schedule WHERE semester = ? AND studentID = ? AND courseCode = ?");
            dropStudentScheduleByCourse.setString(1, semester);
            dropStudentScheduleByCourse.setString(2, studentID);
            dropStudentScheduleByCourse.setString(3, courseCode);
            dropStudentScheduleByCourse.executeUpdate();
        }
        catch(SQLException sqlException)
        {
            sqlException.printStackTrace();
        }        
    }
   public static void dropScheduleByCourse(String semester, String courseCode)
    {
        connection = DBConnection.getConnection();
        try
        {
            dropScheduleByCourse = connection.prepareStatement("DELETE from app.schedule WHERE semester = ? AND courseCode = ?");
            dropScheduleByCourse.setString(1, semester);
            dropScheduleByCourse.setString(2, courseCode);    
            dropScheduleByCourse.executeUpdate();
        }
        catch(SQLException sqlException)
        {
            sqlException.printStackTrace();
        }        
    }
   public static void updateScheduleEntry(String semester, ScheduleEntry entry)
    {
        String status = "S";
        connection = DBConnection.getConnection();
        
        if (ScheduleQueries.getScheduledStudentCount(semester, entry.getCourseCode()) < CourseQueries.getCourseSeats(semester, entry.getCourseCode())){
            status = "S";
        }
        try
        {
            updateScheduleEntry = connection.prepareStatement("update app.schedule set status = ? where semester = ? and studentid = ? and coursecode = ?");
            updateScheduleEntry.setString(2, entry.getSemester());
            updateScheduleEntry.setString(3, entry.getStudentID());
            updateScheduleEntry.setString(4, entry.getCourseCode());
            updateScheduleEntry.setString(1, status);
            updateScheduleEntry.executeUpdate();
        }
        catch(SQLException sqlException)
        {
            sqlException.printStackTrace();
        }
    }
        public static String getStatusOfCourse(String semester, String studentID, String courseCode)
        {
            connection = DBConnection.getConnection();
            String status = null;

            try
            {
                getStatusOfCourse = connection.prepareStatement("select status from app.schedule where semester = ? and studentid = ? and courseCode = ?");
                getStatusOfCourse.setString(1, semester);
                getStatusOfCourse.setString(2, studentID);
                getStatusOfCourse.setString(3, courseCode);
                resultSet = getStatusOfCourse.executeQuery();
                while (resultSet.next()){
                    status = resultSet.getString(1);            
                }        
            }
            catch(SQLException sqlException)
            {
                sqlException.printStackTrace();
            }
            return status;
        }

    
}
