package systemOa.service;

import systemOa.bean.Employee;

import java.util.List;

public interface IEmployeeService {

    public Employee LoginCheck(String id,String password);

    public List<Employee> selectAllEmployees();

    public int insertEmployee(Employee employee);

    public int deleteEmployee(String id);
}
