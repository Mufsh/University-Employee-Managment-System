
import java.util.ArrayList;

class StoreEmployees {
    ArrayList<Employee> eList = new ArrayList<>();

    public void addEmployee(Employee e) {
        eList.add(e);
    }

    public int checkEmployee(String empcode) {

        Employee e;
        for (int i = 0; i < eList.size(); i++) {
            e = eList.get(i);
            if (e.getEmpCode().equals(empcode))
                return i;
        }
        return -1;
    }

    public Employee getEmployee(int index) {
        return eList.get(index);
    }
}
