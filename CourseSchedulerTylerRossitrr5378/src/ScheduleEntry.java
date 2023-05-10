
import java.sql.Timestamp;



/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author sampe
 */
public class ScheduleEntry {
    private String semester;
    private String courseCode;
    private String studentID;
    private String status;
    private Timestamp time;

    public ScheduleEntry(String semester, String studentID, String courseCode, String status, Timestamp time) {
        this.semester = semester;
        this.courseCode = courseCode;
        this.studentID = studentID;
        this.status = status;
        this.time = time;
    }

    public String getSemester() {
        return semester;
    }

    public String getCourseCode() {
        return courseCode;
    }

    public String getStudentID() {
        return studentID;
    }

    public String getStatus() {
        return status;
    }

    public Timestamp getTime() {
        return time;
    }

    public void setSemester(String semester) {
        this.semester = semester;
    }

    public void setCourseCode(String courseCode) {
        this.courseCode = courseCode;
    }

    public void setStudentID(String studentID) {
        this.studentID = studentID;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public void setTime(Timestamp time) {
        this.time = time;
    }
    
}
