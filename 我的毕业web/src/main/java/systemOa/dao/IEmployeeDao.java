package systemOa.dao;

import systemOa.bean.Employee;

import java.util.List;

public interface IEmployeeDao {
    Employee LoginCheck(String employeeId);

    List<Employee> selectAllEmployees();

    int insertEmployee(Employee employee);

    int deleteEmployee(String employeeId);

}
