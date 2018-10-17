package systemOa.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import systemOa.bean.Employee;
import systemOa.dao.IEmployeeDao;
import systemOa.service.IEmployeeService;

import java.util.List;

@Service("employeeService")
public class EmployeeServiceImpl implements IEmployeeService {

    @Autowired
    @Qualifier("IEmployeeDao")
    private IEmployeeDao iEmployeeDao;

    public IEmployeeDao getiEmployeeDao() {
        return iEmployeeDao;
    }

    public void setiEmployeeDao(IEmployeeDao iEmployeeDao) {
        this.iEmployeeDao = iEmployeeDao;
    }

    @Override
    public Employee LoginCheck(String id,String password) {
        Employee employee = iEmployeeDao.LoginCheck(id);
        if (employee != null && employee.getPassword().equals(password)) {
            return employee;
        } else {
            return null;
        }
    }

    @Override
    public List<Employee> selectAllEmployees() {
        return iEmployeeDao.selectAllEmployees();
    }

    @Override
    public int insertEmployee(Employee employee) {
        return iEmployeeDao.insertEmployee(employee);
    }

    @Override
    public int deleteEmployee(String id) {
        return iEmployeeDao.deleteEmployee(id);
    }


}
