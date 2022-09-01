import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import java.awt.*;
import java.awt.event.*;

public class EmployeeManagement implements ListSelectionListener, ActionListener {
    JList<String> deptList;
    String depts[] = { "Computer Science & Engineering", "Mechanical Engineering", "Civil Engineering",
            "Information Technology", "Electrical Engineering", "Production Engineering", "Civil Engineering",
            "Information Technology", "Computer Science & Engineering", "Food and Biotechnology Engineering", "Civil Engineering",
            "Information Technology" };
    JButton submitBtn, searchBtn;
    JScrollPane scrp;
    JLabel deptLabel, empCodeLabel, nameLabel, gradeLabel, salaryLabel, dupCodeLabel, searchLabel, empNameCodeLabel,salaryGradeLabel,deptNameLabel;
    JTextField nameField, empCodeField, salaryField, searchField;
    JRadioButton gradeA, gradeB, gradeC;
    int deptCode;

    EmployeeManagement() {

        JFrame jfrm = new JFrame("Employee");
        jfrm.setLayout(new FlowLayout());
        jfrm.setSize(400, 600);
        jfrm.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        deptLabel = new JLabel("Choose Department");
        empCodeLabel = new JLabel("Enter employee code: ");
        nameLabel = new JLabel("Enter Name: ");
        gradeLabel = new JLabel("Choose Grade: ");
        salaryLabel = new JLabel("Enter Basic Salary: ");
        dupCodeLabel = new JLabel("");
        searchLabel = new JLabel("Enter employee code: ");
        empNameCodeLabel = new JLabel("");
        salaryGradeLabel = new JLabel("");
        deptNameLabel = new JLabel("");
        empCodeField = new JTextField(20);
        nameField = new JTextField(20);
        salaryField = new JTextField(20);
        searchField = new JTextField(20);
        jfrm.add(empCodeLabel);
        jfrm.add(empCodeField);
        jfrm.add(nameLabel);
        jfrm.add(nameField);
        jfrm.add(deptLabel);
        deptList = new JList<>(depts);
        scrp = new JScrollPane(deptList);
        scrp.setPreferredSize(new Dimension(300, 200));
        jfrm.add(scrp);
        gradeA = new JRadioButton("A");
        gradeB = new JRadioButton("B");
        gradeC = new JRadioButton("C");

        ButtonGroup gradeGroup = new ButtonGroup();
        gradeGroup.add(gradeA);
        gradeGroup.add(gradeB);
        gradeGroup.add(gradeC);
        jfrm.add(gradeLabel);
        jfrm.add(gradeA);
        jfrm.add(gradeB);
        jfrm.add(gradeC);

        jfrm.add(salaryLabel);
        jfrm.add(salaryField);
        submitBtn = new JButton("Save");
        searchBtn = new JButton("Search");
        submitBtn.addActionListener(this);
        searchBtn.addActionListener(this);
        jfrm.add(submitBtn);
        jfrm.add(dupCodeLabel);
        jfrm.add(searchLabel);
        jfrm.add(searchField);
        jfrm.add(searchBtn);
        jfrm.add(empNameCodeLabel);
        jfrm.add(salaryGradeLabel);
        jfrm.add(deptNameLabel);

        jfrm.setVisible(true);

    }

    @Override
    public void valueChanged(ListSelectionEvent e) {
        deptCode = deptList.getSelectedIndex();
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        if (ae.getActionCommand().equals("Save")) {
            int res = JOptionPane.showConfirmDialog(null, "Confirm Submission");
           
            if (res == 0) {
                String empCode = empCodeField.getText();
                if (employeeList.checkEmployee(empCode) != -1) {
                    // dupCodeLabel.setText("Employee With employee code: " + empCode + " already exists!");
                    JOptionPane.showMessageDialog(null, "Employee with code: "+empCode+" already exists!");

                } else {
                    String name = nameField.getText();
                    String basicSalary = salaryField.getText();
                    String grade;
                    if (gradeA.isSelected()) {
                        grade = "A";

                    } else if (gradeB.isSelected()) {
                        grade = "B";

                    } else {
                        grade = "C";

                    }
                    Employee employee = new Employee(empCode, name, basicSalary, grade, deptCode);
                    employeeList.addEmployee(employee);
                    nameField.setText("");
                    salaryField.setText("");
                    empCodeField.setText("");
                    dupCodeLabel.setText("");
                    JOptionPane.showMessageDialog(null, "Employee Added Successfully");
                }
            }
        } else {
            String empCode = searchField.getText();
            int index = employeeList.checkEmployee(empCode);
            if (index == -1) {
                empNameCodeLabel.setText("Employee With employee code: " + empCode + " doesn't exist!");
                salaryGradeLabel.setText("");
                deptNameLabel.setText("");
            } else {
                Employee searchedEmp = employeeList.getEmployee(index);
                empNameCodeLabel.setText("Name: "+searchedEmp.getName()+" Employee Code: " +searchedEmp.getEmpCode());
                salaryGradeLabel.setText("Salary: "+searchedEmp.getBasicSalary()+" Grade: "+searchedEmp.getGrade());
                deptNameLabel.setText("Dept: "+depts[searchedEmp.getDeptCode()]);
            }

        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new EmployeeManagement();
            }
        });

    }

    StoreEmployees employeeList = new StoreEmployees();

}

