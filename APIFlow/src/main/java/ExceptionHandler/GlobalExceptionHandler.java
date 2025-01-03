package ExceptionHandler;
import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;

import CustomException.EmployeeNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GlobalExceptionHandler {
    @ExceptionHandler(EmployeeNotFoundException.class)
    public ResponseEntity<Object>handleEmployeeNotFoundException(EmployeeNotFoundException ex)
    {
        HashMap<String,Object> errorDetails=new HashMap<>();
        errorDetails.put("Timestamp", LocalDateTime.now());
        errorDetails.put("message" ,ex.getMessage());
        errorDetails.put("status" , HttpStatus.NOT_FOUND.value());

        return new ResponseEntity<>(errorDetails,HttpStatus.NOT_FOUND);
    }
    @ExceptionHandler(Exception.class)
    public ResponseEntity<Object> handleGenericException(Exception ex){
            Map<String, Object> errorDetails;
            errorDetails = new HashMap<>();
            errorDetails.put("TimeStamp:", LocalDateTime.now());
            errorDetails.put("message", "An unexpected error occur");
            errorDetails.put("details", ex.getMessage());
            errorDetails.put("status", HttpStatus.INTERNAL_SERVER_ERROR.value());
        return new ResponseEntity<>(errorDetails, HttpStatus.INTERNAL_SERVER_ERROR);
    }
}
