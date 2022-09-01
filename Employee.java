
class Employee {
    private String empcode;
    private String name;
    private String basicSalary;
    private String grade;
    private int deptCode;

    public Employee(String empcode, String name, String basicSalary, String grade, int deptCode) {
        this.empcode = empcode;
        this.name = name;
        this.basicSalary = basicSalary;
        this.grade = grade;
        this.deptCode = deptCode;
    }

    public String getEmpcode() {
        return empcode;
    }

    public String getName() {
        return name;
    }

    public String getBasicSalary() {
        return basicSalary;
    }

    public String getGrade() {
        return grade;
    }

    public int getDeptCode() {
        return deptCode;
    }

    public String getEmpCode() {
        return empcode;
    }

    @Override
    public String toString() {
        return "Basic Salary= " + basicSalary + ", Dept. Code= " + deptCode + ", Employee Code= " + empcode
                + ", Grade= "
                + grade + ", Name= " + name;
    }
}
