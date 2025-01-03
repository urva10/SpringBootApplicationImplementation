package Controller;

import CustomException.EmployeeNotFoundException;
import Model.Employee;
import Service.EmployeeService;
import ThirdPartyApiService.ApiService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@RestController
@RequestMapping("/api/employees")
public class EmployeeController {


    private final ApiService apiService;
    public EmployeeController(ApiService apiService){
        this.apiService=apiService;
    }

    @Autowired
    private EmployeeService employeeService;

    @GetMapping
    public List<Employee> getAllEmployee(){
        return employeeService.getAllEmployee();
    }


    @GetMapping("{/id}")
    public Employee findEmployeeById(@PathVariable  Long id){
        if(id==null){
            throw new EmployeeNotFoundException("Employee with id" +id+ "not found");
        }
        return employeeService.findEmployeeById(id);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.BAD_GATEWAY)
    public Employee createEmployee(@RequestBody Employee employee){
        return employeeService.createEmployee(employee);
    }

    @GetMapping("department/{department}")
    public List<Employee> getEmployeeByDepartment(@PathVariable String department){
        return employeeService.getEmployeeByDepartment(department);
    }

    @GetMapping("/salary/{salary}")
    public List<Employee> getAllBySalary(@PathVariable double salary){
        return employeeService.getAllBySalary(salary);
    }

    @DeleteMapping("/delete/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteEmployeeById(@PathVariable Long id){
         employeeService.deleteEmployeeById(id);
    }

    @GetMapping("/fetchthirdpartydata")
    public String fetchdata(){
        String apiUrl = "https://api.example.com/data";
        return apiService.callThirdPartyApi(apiUrl);
    }
}
