package Repository;

import Model.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.web.servlet.tags.form.SelectTag;

import java.util.List;

public interface EmployeeRepository extends JpaRepository<Employee,Long> {

    @Query("SELECT e from Employee e where e.department=:department" )
    List<Employee> findByDepartment(@Param("department") String department);

    @Query("SELECT e from Employee e where e.salary=:salary")
    List<Employee> findBySalaryGreaterThan(@Param("salary") double salary);
}
