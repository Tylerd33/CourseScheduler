
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Base64;
import java.util.Calendar;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author acv
 */
public class MainFrame extends javax.swing.JFrame {

    /**
     * Creates new form MainFrame
     */
    private String currentSemester;
    private String author;
    private String project;
    private String currentStudentID;
    private String currentStudentName;
    private String currentCourse;
    private java.awt.event.ActionEvent nullEvent;

    public MainFrame() {
        initComponents();
        checkData();
        rebuildAllComboBoxes();
        nullEvent = null;
        
    }
    public void rebuildAllComboBoxes(){
        rebuildSemesterComboBoxes();
        rebuildCourseCodeComboBoxes();
        rebuildStudentNameComboBoxes();
        rebuildAllTables();
    }
    public void rebuildAllTables(){
        displayAllStudentsForCourseActionPerformed(nullEvent);
        displayStudentButtonActionPerformed(nullEvent);
        displayCourseButtonActionPerformed(nullEvent);
    }

    public void rebuildSemesterComboBoxes() {
        ArrayList<String> semesters = SemesterQueries.getSemesterList();
        Integer currentInd = currentSemesterComboBox.getSelectedIndex(); 
        currentSemesterComboBox.setModel(new javax.swing.DefaultComboBoxModel(semesters.toArray()));
        if (semesters.size() > 0) {
            currentSemesterComboBox.setSelectedIndex(currentInd);
            currentSemesterLabel.setText(String.valueOf(currentSemesterComboBox.getSelectedItem()));
            currentSemester = String.valueOf(currentSemesterComboBox.getSelectedItem());
            if (String.valueOf(currentSemesterComboBox.getSelectedItem()).equals("null")){
                currentSemesterComboBox.setSelectedIndex(0);
                currentSemesterLabel.setText(String.valueOf(currentSemesterComboBox.getSelectedItem()));
            }
        } else {
            currentSemesterLabel.setText("None, add a semester.");
            currentSemester = "None";
        }
    }
    public void rebuildStudentIDComboBoxes() {
        ArrayList<StudentEntry> StudentIDs = StudentQueries.getAllStudents();
        ArrayList<String> StudentIDsRaw = new ArrayList();
        int count = 0;
        while (StudentIDs.size() > count) {
	 StudentIDsRaw.add(StudentIDs.get(count).getStudentID());
         count++;
        }
    }
    public void rebuildStudentNameComboBoxes() {
        ArrayList<StudentEntry> students = StudentQueries.getAllStudents();
        ArrayList<String> StudentName = new ArrayList();
        Integer currentInd = -1;
        if (students.size() > 0){
            currentInd = currentStudentComboBox.getSelectedIndex(); 
        }
        else{
            currentStudentLabel.setText("None, add a Student");
        }
        if((students.size() > 0) && (students.size() < currentInd+1)){
            currentInd = 0;
        }
        int count = 0;
        while (students.size() > count) {
         StudentName.add(students.get(count).getFirstName() + " " + students.get(count).getLastName());
         count++;
        }
        currentStudentComboBox.setModel(new javax.swing.DefaultComboBoxModel(StudentName.toArray()));
        adminDropStudentComboBox.setModel(new javax.swing.DefaultComboBoxModel(StudentName.toArray()));
        if (currentInd > -1){
            currentStudentComboBox.setSelectedIndex(currentInd);
            adminDropStudentComboBox.setSelectedIndex(currentInd);
            currentStudentLabel.setText(String.valueOf(currentStudentComboBox.getSelectedItem()));
            if (currentStudentComboBox.getSelectedIndex() >= 0){
                currentStudentID = students.get(currentStudentComboBox.getSelectedIndex()).getStudentID();
            }
            else{
                currentStudentID = students.get(currentStudentComboBox.getSelectedIndex()).getStudentID();
            }
            currentStudentName = String.valueOf(currentStudentComboBox.getSelectedItem());
        }
        
    }
    public void rebuildCourseCodeComboBoxes() {
        ArrayList<String> courseCodes = CourseQueries.getAllCourseCodes(currentSemester);
        couseCodeComboBox2.setModel(new javax.swing.DefaultComboBoxModel(courseCodes.toArray()));
        couseCodeComboBox3.setModel(new javax.swing.DefaultComboBoxModel(courseCodes.toArray()));
        adminDropCourseComboBox.setModel(new javax.swing.DefaultComboBoxModel(courseCodes.toArray()));
        studentDropCourseComboBox.setModel(new javax.swing.DefaultComboBoxModel(courseCodes.toArray()));
        currentCourse = String.valueOf(couseCodeComboBox3.getSelectedItem());
        
        
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane2 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jLabel17 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jTabbedPane1 = new javax.swing.JTabbedPane();
        jPanel1 = new javax.swing.JPanel();
        jTabbedPane2 = new javax.swing.JTabbedPane();
        jPanel3 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        addSemesterTextfield = new javax.swing.JTextField();
        addSemesterSubmitButton = new javax.swing.JButton();
        addSemesterStatusLabel = new javax.swing.JLabel();
        jPanel4 = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        courseCodeTextfield = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        courseDescriptionTextfield = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        addCourseButton = new javax.swing.JButton();
        courseSeatSpinner = new javax.swing.JSpinner();
        courseLabel = new javax.swing.JLabel();
        jPanel5 = new javax.swing.JPanel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        studentIDTextfield = new javax.swing.JTextField();
        firstNameTextfield = new javax.swing.JTextField();
        lastNameTextfield = new javax.swing.JTextField();
        addStudentButton = new javax.swing.JButton();
        jLabel10 = new javax.swing.JLabel();
        studentLabel = new javax.swing.JLabel();
        jPanel9 = new javax.swing.JPanel();
        selectCourseLabel = new javax.swing.JLabel();
        couseCodeComboBox3 = new javax.swing.JComboBox<>();
        displayAllStudentsForCourse = new javax.swing.JButton();
        jScrollPane4 = new javax.swing.JScrollPane();
        ScheduledStudentsTable = new javax.swing.JTable();
        jLabel16 = new javax.swing.JLabel();
        jLabel18 = new javax.swing.JLabel();
        jScrollPane5 = new javax.swing.JScrollPane();
        WaitlistedStudentsTable = new javax.swing.JTable();
        jPanel10 = new javax.swing.JPanel();
        dropStudentButton = new javax.swing.JButton();
        jScrollPane6 = new javax.swing.JScrollPane();
        dropStudentTextArea = new javax.swing.JTextArea();
        adminDropStudentComboBox = new javax.swing.JComboBox<>();
        jLabel14 = new javax.swing.JLabel();
        jPanel11 = new javax.swing.JPanel();
        adminDropCourseButton = new javax.swing.JButton();
        jScrollPane7 = new javax.swing.JScrollPane();
        adminDropCourseTextArea = new javax.swing.JTextArea();
        jLabel12 = new javax.swing.JLabel();
        adminDropCourseComboBox = new javax.swing.JComboBox<>();
        jPanel2 = new javax.swing.JPanel();
        jTabbedPane3 = new javax.swing.JTabbedPane();
        jPanel6 = new javax.swing.JPanel();
        displayCourseButton = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        displayCoursesTable = new javax.swing.JTable();
        jPanel7 = new javax.swing.JPanel();
        couseCodeComboBox2 = new javax.swing.JComboBox<>();
        jLabel11 = new javax.swing.JLabel();
        scheduleCoursesSumbitButton = new javax.swing.JButton();
        ScheduleCoursesLabel = new javax.swing.JLabel();
        jPanel8 = new javax.swing.JPanel();
        displayStudentButton = new javax.swing.JButton();
        jScrollPane3 = new javax.swing.JScrollPane();
        displayScheduleTable = new javax.swing.JTable();
        jPanel12 = new javax.swing.JPanel();
        jLabel13 = new javax.swing.JLabel();
        studentDropCourseComboBox = new javax.swing.JComboBox<>();
        studentDropCourseButton = new javax.swing.JButton();
        jScrollPane8 = new javax.swing.JScrollPane();
        studentDropCourseTextArea = new javax.swing.JTextArea();
        jLabel20 = new javax.swing.JLabel();
        currentStudentComboBox = new javax.swing.JComboBox<>();
        currentStudentLabel = new javax.swing.JLabel();
        changeStudentButton = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        currentSemesterLabel = new javax.swing.JLabel();
        currentSemesterComboBox = new javax.swing.JComboBox<>();
        changeSemesterButton = new javax.swing.JButton();
        aboutButton = new javax.swing.JButton();

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane2.setViewportView(jTable1);

        jLabel17.setText("jLabel17");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setFont(new java.awt.Font("Comic Sans MS", 1, 30)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(0, 153, 153));
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Course Scheduler");

        jLabel3.setText("Semester Name:");

        addSemesterTextfield.setColumns(20);

        addSemesterSubmitButton.setText("Submit");
        addSemesterSubmitButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addSemesterSubmitButtonActionPerformed(evt);
            }
        });

        addSemesterStatusLabel.setText("                                                   ");

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(addSemesterTextfield, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(87, 87, 87)
                        .addComponent(addSemesterSubmitButton))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(addSemesterStatusLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 361, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(417, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(addSemesterTextfield, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(addSemesterSubmitButton)
                .addGap(18, 18, 18)
                .addComponent(addSemesterStatusLabel)
                .addContainerGap(329, Short.MAX_VALUE))
        );

        jTabbedPane2.addTab("Add Semester", jPanel3);

        jLabel4.setText("Course Code:");

        courseCodeTextfield.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                courseCodeTextfieldActionPerformed(evt);
            }
        });

        jLabel5.setText("Course Description:");

        courseDescriptionTextfield.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                courseDescriptionTextfieldActionPerformed(evt);
            }
        });

        jLabel6.setText("Course Seats:");

        addCourseButton.setText("Sumbit");
        addCourseButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addCourseButtonActionPerformed(evt);
            }
        });

        courseLabel.setText(" ");

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(jPanel4Layout.createSequentialGroup()
                                .addComponent(jLabel4)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(courseCodeTextfield, javax.swing.GroupLayout.PREFERRED_SIZE, 101, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel4Layout.createSequentialGroup()
                                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel5)
                                    .addComponent(jLabel6))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel4Layout.createSequentialGroup()
                                        .addComponent(courseSeatSpinner, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(7, 7, 7))
                                    .addComponent(courseDescriptionTextfield, javax.swing.GroupLayout.DEFAULT_SIZE, 101, Short.MAX_VALUE)))))
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGap(131, 131, 131)
                        .addComponent(courseLabel))
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGap(100, 100, 100)
                        .addComponent(addCourseButton)))
                .addContainerGap(562, Short.MAX_VALUE))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(courseCodeTextfield, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(courseDescriptionTextfield, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(16, 16, 16)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(courseSeatSpinner, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(addCourseButton)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(courseLabel)
                .addContainerGap(269, Short.MAX_VALUE))
        );

        jTabbedPane2.addTab("Add Course", jPanel4);

        jLabel7.setText("Student ID:");

        jLabel8.setText("First Name:");

        jLabel9.setText("Last Name:");

        studentIDTextfield.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                studentIDTextfieldActionPerformed(evt);
            }
        });

        addStudentButton.setText("Sumbit");
        addStudentButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addStudentButtonActionPerformed(evt);
            }
        });

        studentLabel.setText("                  ");

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addGap(122, 122, 122)
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(studentLabel)
                            .addComponent(jLabel10)))
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addGap(98, 98, 98)
                        .addComponent(addStudentButton))
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel7)
                            .addComponent(jLabel8)
                            .addComponent(jLabel9))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(firstNameTextfield, javax.swing.GroupLayout.DEFAULT_SIZE, 105, Short.MAX_VALUE)
                                .addComponent(studentIDTextfield))
                            .addComponent(lastNameTextfield, javax.swing.GroupLayout.PREFERRED_SIZE, 105, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(602, Short.MAX_VALUE))
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7)
                    .addComponent(studentIDTextfield, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel8)
                    .addComponent(firstNameTextfield, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel9)
                    .addComponent(lastNameTextfield, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(addStudentButton)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel10)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(studentLabel)
                .addContainerGap(249, Short.MAX_VALUE))
        );

        jTabbedPane2.addTab("Add Student", jPanel5);

        selectCourseLabel.setText("Select Course: ");

        couseCodeComboBox3.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        displayAllStudentsForCourse.setText("Display");
        displayAllStudentsForCourse.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                displayAllStudentsForCourseActionPerformed(evt);
            }
        });

        ScheduledStudentsTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null}
            },
            new String [] {
                "Last Name", "First Name", "StudentID"
            }
        ));
        jScrollPane4.setViewportView(ScheduledStudentsTable);

        jLabel16.setText("Scheduled Students");

        jLabel18.setText("Waitlisted Students");

        WaitlistedStudentsTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null}
            },
            new String [] {
                "Last Name", "Firat Name", "StudentID"
            }
        ));
        jScrollPane5.setViewportView(WaitlistedStudentsTable);

        javax.swing.GroupLayout jPanel9Layout = new javax.swing.GroupLayout(jPanel9);
        jPanel9.setLayout(jPanel9Layout);
        jPanel9Layout.setHorizontalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel9Layout.createSequentialGroup()
                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel9Layout.createSequentialGroup()
                        .addGap(17, 17, 17)
                        .addComponent(selectCourseLabel)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(couseCodeComboBox3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(40, 40, 40)
                        .addComponent(displayAllStudentsForCourse))
                    .addGroup(jPanel9Layout.createSequentialGroup()
                        .addGap(12, 12, 12)
                        .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel16)
                            .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 274, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel18)
                            .addComponent(jScrollPane5, javax.swing.GroupLayout.PREFERRED_SIZE, 267, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(213, Short.MAX_VALUE))
        );
        jPanel9Layout.setVerticalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel9Layout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(selectCourseLabel)
                    .addComponent(couseCodeComboBox3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(displayAllStudentsForCourse))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel16)
                    .addComponent(jLabel18))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jScrollPane5, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                    .addComponent(jScrollPane4, javax.swing.GroupLayout.DEFAULT_SIZE, 239, Short.MAX_VALUE))
                .addContainerGap(117, Short.MAX_VALUE))
        );

        jTabbedPane2.addTab("Display Course List of Students", jPanel9);

        dropStudentButton.setText("Drop Student");
        dropStudentButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                dropStudentButtonActionPerformed(evt);
            }
        });

        dropStudentTextArea.setColumns(20);
        dropStudentTextArea.setRows(5);
        jScrollPane6.setViewportView(dropStudentTextArea);

        adminDropStudentComboBox.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        adminDropStudentComboBox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                adminDropStudentComboBoxActionPerformed(evt);
            }
        });

        jLabel14.setText("Student:");

        javax.swing.GroupLayout jPanel10Layout = new javax.swing.GroupLayout(jPanel10);
        jPanel10.setLayout(jPanel10Layout);
        jPanel10Layout.setHorizontalGroup(
            jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel10Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane6, javax.swing.GroupLayout.PREFERRED_SIZE, 535, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel10Layout.createSequentialGroup()
                        .addComponent(jLabel14)
                        .addGap(39, 39, 39)
                        .addComponent(adminDropStudentComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(52, 52, 52)
                        .addComponent(dropStudentButton)))
                .addContainerGap(243, Short.MAX_VALUE))
        );
        jPanel10Layout.setVerticalGroup(
            jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel10Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(dropStudentButton)
                    .addComponent(adminDropStudentComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel14))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane6, javax.swing.GroupLayout.PREFERRED_SIZE, 213, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(178, Short.MAX_VALUE))
        );

        jTabbedPane2.addTab("Drop Student", jPanel10);

        adminDropCourseButton.setText("Drop Course");
        adminDropCourseButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                adminDropCourseButtonActionPerformed(evt);
            }
        });

        adminDropCourseTextArea.setColumns(20);
        adminDropCourseTextArea.setRows(5);
        jScrollPane7.setViewportView(adminDropCourseTextArea);

        jLabel12.setText("Course: ");

        adminDropCourseComboBox.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        javax.swing.GroupLayout jPanel11Layout = new javax.swing.GroupLayout(jPanel11);
        jPanel11.setLayout(jPanel11Layout);
        jPanel11Layout.setHorizontalGroup(
            jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel11Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane7, javax.swing.GroupLayout.PREFERRED_SIZE, 540, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel11Layout.createSequentialGroup()
                        .addComponent(jLabel12)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(adminDropCourseComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(84, 84, 84)
                        .addComponent(adminDropCourseButton)))
                .addContainerGap(238, Short.MAX_VALUE))
        );
        jPanel11Layout.setVerticalGroup(
            jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel11Layout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addGroup(jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(adminDropCourseButton)
                    .addComponent(jLabel12)
                    .addComponent(adminDropCourseComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane7, javax.swing.GroupLayout.PREFERRED_SIZE, 208, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(175, Short.MAX_VALUE))
        );

        jTabbedPane2.addTab("Drop Course", jPanel11);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jTabbedPane2)
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addComponent(jTabbedPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 464, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("Admin", jPanel1);

        displayCourseButton.setText("Display Courses");
        displayCourseButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                displayCourseButtonActionPerformed(evt);
            }
        });

        displayCoursesTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null}
            },
            new String [] {
                "Course Code", "Description", "Seats"
            }
        ));
        jScrollPane1.setViewportView(displayCoursesTable);

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addGap(16, 16, 16)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(displayCourseButton))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addComponent(displayCourseButton)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jTabbedPane3.addTab("Display Courses", jPanel6);

        couseCodeComboBox2.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        couseCodeComboBox2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                couseCodeComboBox2ActionPerformed(evt);
            }
        });

        jLabel11.setText("Course Code: ");

        scheduleCoursesSumbitButton.setText("Sumbit");
        scheduleCoursesSumbitButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                scheduleCoursesSumbitButtonActionPerformed(evt);
            }
        });

        ScheduleCoursesLabel.setText(" ");

        javax.swing.GroupLayout jPanel7Layout = new javax.swing.GroupLayout(jPanel7);
        jPanel7.setLayout(jPanel7Layout);
        jPanel7Layout.setHorizontalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel7Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel11)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(couseCodeComboBox2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel7Layout.createSequentialGroup()
                        .addGap(60, 60, 60)
                        .addComponent(scheduleCoursesSumbitButton)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(ScheduleCoursesLabel)))
                .addContainerGap(512, Short.MAX_VALUE))
        );
        jPanel7Layout.setVerticalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addGap(17, 17, 17)
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel11)
                    .addComponent(couseCodeComboBox2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(44, 44, 44)
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(ScheduleCoursesLabel)
                    .addComponent(scheduleCoursesSumbitButton))
                .addContainerGap(149, Short.MAX_VALUE))
        );

        jTabbedPane3.addTab("Schedule Courses", jPanel7);

        displayStudentButton.setText("Display Schedule");
        displayStudentButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                displayStudentButtonActionPerformed(evt);
            }
        });

        displayScheduleTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null},
                {null, null},
                {null, null},
                {null, null}
            },
            new String [] {
                "Course Code", "Status"
            }
        ));
        jScrollPane3.setViewportView(displayScheduleTable);

        javax.swing.GroupLayout jPanel8Layout = new javax.swing.GroupLayout(jPanel8);
        jPanel8.setLayout(jPanel8Layout);
        jPanel8Layout.setHorizontalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel8Layout.createSequentialGroup()
                .addGap(16, 16, 16)
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(displayStudentButton)
                    .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(202, Short.MAX_VALUE))
        );
        jPanel8Layout.setVerticalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel8Layout.createSequentialGroup()
                .addGap(9, 9, 9)
                .addComponent(displayStudentButton)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jTabbedPane3.addTab("Display Schedule", jPanel8);

        jLabel13.setText("Drop Course: ");

        studentDropCourseComboBox.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        studentDropCourseComboBox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                studentDropCourseComboBoxActionPerformed(evt);
            }
        });

        studentDropCourseButton.setText("Drop Course");
        studentDropCourseButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                studentDropCourseButtonActionPerformed(evt);
            }
        });

        studentDropCourseTextArea.setColumns(20);
        studentDropCourseTextArea.setRows(5);
        jScrollPane8.setViewportView(studentDropCourseTextArea);

        javax.swing.GroupLayout jPanel12Layout = new javax.swing.GroupLayout(jPanel12);
        jPanel12.setLayout(jPanel12Layout);
        jPanel12Layout.setHorizontalGroup(
            jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel12Layout.createSequentialGroup()
                .addGap(17, 17, 17)
                .addGroup(jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane8, javax.swing.GroupLayout.PREFERRED_SIZE, 420, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel12Layout.createSequentialGroup()
                        .addComponent(jLabel13)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(studentDropCourseComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(55, 55, 55)
                        .addComponent(studentDropCourseButton)))
                .addContainerGap(233, Short.MAX_VALUE))
        );
        jPanel12Layout.setVerticalGroup(
            jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel12Layout.createSequentialGroup()
                .addGap(16, 16, 16)
                .addGroup(jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel13)
                    .addComponent(studentDropCourseComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(studentDropCourseButton))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane8, javax.swing.GroupLayout.PREFERRED_SIZE, 184, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(14, Short.MAX_VALUE))
        );

        jTabbedPane3.addTab("Drop Course", jPanel12);

        jLabel20.setText("Current Student:");

        currentStudentComboBox.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        currentStudentLabel.setText("None");

        changeStudentButton.setText("Change Student");
        changeStudentButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                changeStudentButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addComponent(jTabbedPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 670, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 126, Short.MAX_VALUE))
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel20)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(currentStudentLabel)
                .addGap(59, 59, 59)
                .addComponent(currentStudentComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(changeStudentButton)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel20)
                    .addComponent(currentStudentComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(currentStudentLabel)
                    .addComponent(changeStudentButton))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jTabbedPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 287, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("Student", jPanel2);

        jLabel2.setFont(new java.awt.Font("Comic Sans MS", 1, 16)); // NOI18N
        jLabel2.setText("Current Semester: ");

        currentSemesterLabel.setFont(new java.awt.Font("Comic Sans MS", 0, 16)); // NOI18N
        currentSemesterLabel.setText("           ");

        currentSemesterComboBox.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        currentSemesterComboBox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                currentSemesterComboBoxActionPerformed(evt);
            }
        });

        changeSemesterButton.setText("Change Semester");
        changeSemesterButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                changeSemesterButtonActionPerformed(evt);
            }
        });

        aboutButton.setText("About");
        aboutButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                aboutButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jTabbedPane1)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(10, 10, 10)
                                .addComponent(jLabel2)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(currentSemesterLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 195, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(currentSemesterComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(changeSemesterButton)
                                .addGap(31, 31, 31)
                                .addComponent(aboutButton)
                                .addGap(0, 0, Short.MAX_VALUE)))))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(currentSemesterLabel)
                    .addComponent(currentSemesterComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(changeSemesterButton)
                    .addComponent(aboutButton))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 64, Short.MAX_VALUE)
                .addComponent(jTabbedPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 318, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void aboutButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_aboutButtonActionPerformed
        // TODO add your handling code here:
        // display about information.
        JOptionPane.showMessageDialog(null, "Author: Tyler Rossi" + " Project: " + project);
    }//GEN-LAST:event_aboutButtonActionPerformed

    private void changeSemesterButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_changeSemesterButtonActionPerformed
        // TODO add your handling code here:       
        currentSemesterLabel.setText(String.valueOf(currentSemesterComboBox.getSelectedItem()));
        currentSemester = String.valueOf(currentSemesterComboBox.getSelectedItem());
        rebuildAllComboBoxes();
    }//GEN-LAST:event_changeSemesterButtonActionPerformed

    private void currentSemesterComboBoxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_currentSemesterComboBoxActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_currentSemesterComboBoxActionPerformed

    private void displayAllStudentsForCourseActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_displayAllStudentsForCourseActionPerformed
        // TODO add your handling code here:
        ArrayList<ScheduleEntry> students = ScheduleQueries.getScheduledStudentByCourse(currentSemester, String.valueOf(couseCodeComboBox3.getSelectedItem()));
        DefaultTableModel displayScheduledStudentsTableModel = (DefaultTableModel)ScheduledStudentsTable.getModel();
        displayScheduledStudentsTableModel.setNumRows(0);
        Object[] rowData = new Object[3];
        for (ScheduleEntry student : students){
            String temp = student.getStudentID();
            StudentEntry student2 = StudentQueries.getStudent(temp);
            rowData[0] = student2.getLastName();
            rowData[1] = student2.getFirstName();
            rowData[2] = student.getStudentID();
            displayScheduledStudentsTableModel.addRow(rowData);
        }
        ArrayList<ScheduleEntry> waitlistedStudents = ScheduleQueries.getWaitlistedStudentByCourse(currentSemester, String.valueOf(couseCodeComboBox3.getSelectedItem()));
        DefaultTableModel displayWaitlistedStudentsTableModel = (DefaultTableModel)WaitlistedStudentsTable.getModel();
        displayWaitlistedStudentsTableModel.setNumRows(0);
        Object[] rowData2 = new Object[3];
        for (ScheduleEntry student3 : waitlistedStudents){
            String temp2 = student3.getStudentID();
            StudentEntry student2 = StudentQueries.getStudent(temp2);
            rowData2[0] = student2.getLastName();
            rowData2[1] = student2.getFirstName();
            rowData2[2] = student3.getStudentID();

            displayWaitlistedStudentsTableModel.addRow(rowData2);
        }
    }//GEN-LAST:event_displayAllStudentsForCourseActionPerformed

    private void addStudentButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addStudentButtonActionPerformed
        // TODO add your handling code here:
        StudentEntry NewStudent = new StudentEntry(studentIDTextfield.getText(),firstNameTextfield.getText() ,lastNameTextfield.getText() );
        StudentQueries.addStudent(NewStudent);
        studentLabel.setText("Student " + NewStudent.getFirstName() +" " + NewStudent.getLastName() + " has been added.");
        rebuildAllComboBoxes();
        rebuildAllComboBoxes();
    }//GEN-LAST:event_addStudentButtonActionPerformed

    private void studentIDTextfieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_studentIDTextfieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_studentIDTextfieldActionPerformed

    private void addCourseButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addCourseButtonActionPerformed
        // TODO add your handling code here:

        courseEntry NewCourse = new courseEntry(currentSemester, courseCodeTextfield.getText(), courseDescriptionTextfield.getText(),(Integer)courseSeatSpinner.getValue());
        CourseQueries.addCourse(NewCourse);

        courseLabel.setText("Course " + NewCourse.getCourseCode() + " has been added to semester "+currentSemester);
        rebuildAllComboBoxes();
    }//GEN-LAST:event_addCourseButtonActionPerformed

    private void courseDescriptionTextfieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_courseDescriptionTextfieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_courseDescriptionTextfieldActionPerformed

    private void courseCodeTextfieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_courseCodeTextfieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_courseCodeTextfieldActionPerformed

    private void addSemesterSubmitButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addSemesterSubmitButtonActionPerformed
        String semester = addSemesterTextfield.getText();
        SemesterQueries.addSemester(semester);
        addSemesterStatusLabel.setText("Semester " + semester + " has been added.");
        rebuildAllComboBoxes();
    }//GEN-LAST:event_addSemesterSubmitButtonActionPerformed

    private void dropStudentButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_dropStudentButtonActionPerformed
        // TODO add your handling code here:
        //Deletes student from "student" database
        //changeStudentButtonActionPerformed(nullEvent);
        dropStudentTextArea.append("Student  "+String.valueOf(currentStudentName) + " has been dropped from the list of students\n");
        String cStudentID = currentStudentID;
        StudentEntry exStudent = StudentQueries.getStudent(cStudentID);
        String cStudentName = exStudent.getFirstName() + " " + exStudent.getLastName();
        StudentQueries.dropStudent(currentStudentID);
        //Gets Every semester
        ArrayList<String> allSemesters = SemesterQueries.getSemesterList();
        for(String semester : allSemesters){
            ArrayList<ScheduleEntry> schedules = ScheduleQueries.getScheduleByStudent(semester, cStudentID);
            dropStudentTextArea.append("\nFor Semester: "+semester+"\n");
            for(ScheduleEntry schedule : schedules){
                ArrayList<ScheduleEntry> waitlistedSchedules = ScheduleQueries.getWaitlistedStudentByCourse(semester, schedule.getCourseCode());
                
                String status = ScheduleQueries.getStatusOfCourse(semester, cStudentID, schedule.getCourseCode());
                if (status.equals("S")){
                    dropStudentTextArea.append(cStudentName+" ID: " +cStudentID+" has been dropped from "+schedule.getCourseCode()+"\n");
                    if(waitlistedSchedules.size() > 0){
                        ScheduleEntry firstScheduleEntry = waitlistedSchedules.get(0);
                        ScheduleQueries.updateScheduleEntry(semester, firstScheduleEntry);
                        StudentEntry firstStudent = StudentQueries.getStudent(firstScheduleEntry.getStudentID());
                        dropStudentTextArea.append(firstStudent.getFirstName()+" "+firstStudent.getLastName()+" ID: "+firstStudent.getStudentID()+" has been Scheduled to "+firstScheduleEntry.getCourseCode()+"\n");
                    }
                }
                if (status.equals("W")){
                    dropStudentTextArea.append(cStudentName+" ID: " +cStudentID+" has been dropped from the waitlist for "+schedule.getCourseCode()+"\n");
                }
                //Update first wait listed student
                ScheduleQueries.dropStudentScheduleByCourse(semester, cStudentID, schedule.getCourseCode());
                
            }
        }
        rebuildAllComboBoxes();
        
    }//GEN-LAST:event_dropStudentButtonActionPerformed

    private void changeStudentButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_changeStudentButtonActionPerformed
        // TODO add your handling code here:
        currentStudentLabel.setText(String.valueOf(currentStudentComboBox.getSelectedItem()));
        rebuildAllComboBoxes();
    }//GEN-LAST:event_changeStudentButtonActionPerformed

    private void adminDropCourseButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_adminDropCourseButtonActionPerformed
        // TODO add your handling code here:
        
        ArrayList<ScheduleEntry> schedules = ScheduleQueries.getScheduledStudentByCourse(currentSemester, currentCourse);
        ArrayList<ScheduleEntry> waitlistedSchedules = ScheduleQueries.getWaitlistedStudentByCourse(currentSemester, currentCourse);
        adminDropCourseTextArea.append("\nScheduled students dropped from the course: \n");
        for (ScheduleEntry schedule : schedules){
            String studentID = schedule.getStudentID();
            StudentEntry student = StudentQueries.getStudent(studentID);
            String studentName = student.getFirstName() + " " + student.getLastName();
            adminDropCourseTextArea.append(studentName+" ID: "+studentID+"\n");
            if(waitlistedSchedules.size() > 0){
                ScheduleEntry firstScheduleEntry = waitlistedSchedules.get(0);
                ScheduleQueries.updateScheduleEntry(currentSemester, firstScheduleEntry);
                StudentEntry firstStudent = StudentQueries.getStudent(firstScheduleEntry.getStudentID());
                dropStudentTextArea.append(firstStudent.getFirstName()+" "+firstStudent.getLastName()+" ID: "+firstStudent.getStudentID()+" has been Scheduled to "+firstScheduleEntry.getCourseCode()+"\n");
                    }
        }
        adminDropCourseTextArea.append("\nWaitlisted students dropped from the course: \n");
        for (ScheduleEntry schedule : waitlistedSchedules){
            String studentID = schedule.getStudentID();
            StudentEntry student = StudentQueries.getStudent(studentID);
            String studentName = student.getFirstName() + " " + student.getLastName();
            adminDropCourseTextArea.append("Waitlisted student "+ studentName+" has been dropped from "+currentCourse+"\n");
        }
        
        
        
        
        //Changes Database
        CourseQueries.dropCourse(currentSemester, currentCourse);
        ScheduleQueries.dropScheduleByCourse(currentSemester, currentCourse);
        dropStudentTextArea.append("");
        
        
        rebuildAllComboBoxes();
    }//GEN-LAST:event_adminDropCourseButtonActionPerformed

    private void displayStudentButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_displayStudentButtonActionPerformed
        // TODO add your handling code here:
        ArrayList<ScheduleEntry> courses = ScheduleQueries.getScheduleByStudent(currentSemester, currentStudentID);
        DefaultTableModel displayCoursesTableModel = (DefaultTableModel)displayScheduleTable.getModel();
        displayCoursesTableModel.setNumRows(0);
        Object[] rowData = new Object[2];
        for (ScheduleEntry course : courses){
            rowData[0] = course.getCourseCode();
            rowData[1] = course.getStatus();
            displayCoursesTableModel.addRow(rowData);
        }
    }//GEN-LAST:event_displayStudentButtonActionPerformed

    private void scheduleCoursesSumbitButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_scheduleCoursesSumbitButtonActionPerformed
        // TODO add your handling code here:
        String status = "W";
        java.sql.Timestamp currentTimestamp = new java.sql.Timestamp(Calendar.getInstance().getTime().getTime());

        if (ScheduleQueries.getScheduledStudentCount(currentSemester, (String)couseCodeComboBox2.getSelectedItem())<CourseQueries.getCourseSeats(currentSemester, (String)couseCodeComboBox2.getSelectedItem())){
            status = "S";
        }

        ScheduleEntry newSchedule = new ScheduleEntry(currentSemester, currentStudentID, (String)couseCodeComboBox2.getSelectedItem(), status, currentTimestamp);

        if (status == "S"){
            ScheduleCoursesLabel.setText("Course "+(String)couseCodeComboBox2.getSelectedItem()+" has been added for "+ currentStudentName);
        }
        else{
            ScheduleCoursesLabel.setText("Course "+(String)couseCodeComboBox2.getSelectedItem()+" has been waitlisted for "+ currentStudentName);
        }
        ScheduleQueries.addScheduleEntry(newSchedule);
        rebuildAllTables();
    }//GEN-LAST:event_scheduleCoursesSumbitButtonActionPerformed

    private void couseCodeComboBox2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_couseCodeComboBox2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_couseCodeComboBox2ActionPerformed

    private void displayCourseButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_displayCourseButtonActionPerformed
        // TODO add your handling code here:
        ArrayList<courseEntry> courses = CourseQueries.getAllCourses(currentSemester);
        DefaultTableModel displayCoursesTableModel = (DefaultTableModel)displayCoursesTable.getModel();
        displayCoursesTableModel.setNumRows(0);
        Object[] rowData = new Object[3];
        for (courseEntry course : courses){
            rowData[0] = course.getCourseCode();
            rowData[1] = course.getCourseDescription();
            rowData[2] = course.getSeats();
            displayCoursesTableModel.addRow(rowData);
        }
    }//GEN-LAST:event_displayCourseButtonActionPerformed

    private void studentDropCourseComboBoxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_studentDropCourseComboBoxActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_studentDropCourseComboBoxActionPerformed

    private void studentDropCourseButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_studentDropCourseButtonActionPerformed
        // TODO add your handling code here:
        String status = ScheduleQueries.getStatusOfCourse(currentSemester, currentStudentID, currentCourse);
        if(status.equals("S")){
            studentDropCourseTextArea.append("Scheduled course "+currentCourse+" has been dropped from "+currentStudentName+"'s schedule\n");
            if(ScheduleQueries.getWaitlistedStudentByCourse(currentSemester, currentCourse).size() > 0){
                ArrayList<ScheduleEntry> waitlistedSchedules = ScheduleQueries.getWaitlistedStudentByCourse(currentSemester, currentCourse);
                ScheduleEntry firstScheduleEntry = waitlistedSchedules.get(0);
                ScheduleQueries.updateScheduleEntry(currentSemester, firstScheduleEntry);
                //Get waitlisted student name
                String studentID = firstScheduleEntry.getStudentID();
                StudentEntry student = StudentQueries.getStudent(studentID);
                String name = student.getFirstName() + " " + student.getLastName();
                studentDropCourseTextArea.append("Student "+name+" has been scheduled to "+currentCourse+"\n");
            }
        }
        else if(status.equals("W")){
            studentDropCourseTextArea.append("Waitlisted course "+currentCourse+" has been dropped from "+currentStudentName+"'s schedule\n");
        }

        ScheduleQueries.dropStudentScheduleByCourse(currentSemester, currentStudentID, currentCourse);
        rebuildAllComboBoxes();
    }//GEN-LAST:event_studentDropCourseButtonActionPerformed

    private void adminDropStudentComboBoxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_adminDropStudentComboBoxActionPerformed
        // TODO add your handling code here:
        currentStudentComboBox.setSelectedIndex(adminDropStudentComboBox.getSelectedIndex());
        rebuildAllComboBoxes();
    }//GEN-LAST:event_adminDropStudentComboBoxActionPerformed

    private void checkData() {
        try {
            FileReader reader = new FileReader("xzq789yy.txt");
            BufferedReader breader = new BufferedReader(reader);

            String encodedAuthor = breader.readLine();
            String encodedProject = breader.readLine();
            byte[] decodedAuthor = Base64.getDecoder().decode(encodedAuthor);
            author = new String(decodedAuthor);
            byte[] decodedProject = Base64.getDecoder().decode(encodedProject);
            project = new String(decodedProject);
            reader.close();

        } catch (FileNotFoundException e) {
            //get user info and create file
            author = JOptionPane.showInputDialog("Enter your first and last name.");
            project = "Course Scheduler Spring 2023";

            //write data to the data file.
            try {
                FileWriter writer = new FileWriter("xzq789yy.txt", true);
                BufferedWriter bufferedWriter = new BufferedWriter(writer);

                // encode the output data.
                String encodedAuthor = Base64.getEncoder().encodeToString(author.getBytes());

                bufferedWriter.write(encodedAuthor);
                bufferedWriter.newLine();

                String encodedProject = Base64.getEncoder().encodeToString(project.getBytes());
                bufferedWriter.write(encodedProject);

                bufferedWriter.close();
            } catch (IOException ioe) {
                ioe.printStackTrace();
                System.exit(1);
            }

        } catch (IOException e) {
            e.printStackTrace();
            System.exit(1);
        }

    }

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(MainFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(MainFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(MainFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(MainFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new MainFrame().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel ScheduleCoursesLabel;
    private javax.swing.JTable ScheduledStudentsTable;
    private javax.swing.JTable WaitlistedStudentsTable;
    private javax.swing.JButton aboutButton;
    private javax.swing.JButton addCourseButton;
    private javax.swing.JLabel addSemesterStatusLabel;
    private javax.swing.JButton addSemesterSubmitButton;
    private javax.swing.JTextField addSemesterTextfield;
    private javax.swing.JButton addStudentButton;
    private javax.swing.JButton adminDropCourseButton;
    private javax.swing.JComboBox<String> adminDropCourseComboBox;
    private javax.swing.JTextArea adminDropCourseTextArea;
    private javax.swing.JComboBox<String> adminDropStudentComboBox;
    private javax.swing.JButton changeSemesterButton;
    private javax.swing.JButton changeStudentButton;
    private javax.swing.JTextField courseCodeTextfield;
    private javax.swing.JTextField courseDescriptionTextfield;
    private javax.swing.JLabel courseLabel;
    private javax.swing.JSpinner courseSeatSpinner;
    private javax.swing.JComboBox<String> couseCodeComboBox2;
    private javax.swing.JComboBox<String> couseCodeComboBox3;
    private javax.swing.JComboBox<String> currentSemesterComboBox;
    private javax.swing.JLabel currentSemesterLabel;
    private javax.swing.JComboBox<String> currentStudentComboBox;
    private javax.swing.JLabel currentStudentLabel;
    private javax.swing.JButton displayAllStudentsForCourse;
    private javax.swing.JButton displayCourseButton;
    private javax.swing.JTable displayCoursesTable;
    private javax.swing.JTable displayScheduleTable;
    private javax.swing.JButton displayStudentButton;
    private javax.swing.JButton dropStudentButton;
    private javax.swing.JTextArea dropStudentTextArea;
    private javax.swing.JTextField firstNameTextfield;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel10;
    private javax.swing.JPanel jPanel11;
    private javax.swing.JPanel jPanel12;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JPanel jPanel8;
    private javax.swing.JPanel jPanel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JScrollPane jScrollPane5;
    private javax.swing.JScrollPane jScrollPane6;
    private javax.swing.JScrollPane jScrollPane7;
    private javax.swing.JScrollPane jScrollPane8;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JTabbedPane jTabbedPane2;
    private javax.swing.JTabbedPane jTabbedPane3;
    private javax.swing.JTable jTable1;
    private javax.swing.JTextField lastNameTextfield;
    private javax.swing.JButton scheduleCoursesSumbitButton;
    private javax.swing.JLabel selectCourseLabel;
    private javax.swing.JButton studentDropCourseButton;
    private javax.swing.JComboBox<String> studentDropCourseComboBox;
    private javax.swing.JTextArea studentDropCourseTextArea;
    private javax.swing.JTextField studentIDTextfield;
    private javax.swing.JLabel studentLabel;
    // End of variables declaration//GEN-END:variables
}
