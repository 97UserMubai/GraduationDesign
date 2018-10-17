package systemOa.dao;

import systemOa.bean.Employee;

import java.util.List;

public interface IEmployeeDao {
    Employee LoginCheck(String id);

    List<Employee> selectAllEmployees();

    int insertEmployee(Employee employee);

    int deleteEmployee(String id);

}
