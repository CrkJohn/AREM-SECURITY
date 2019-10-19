package edu.eci.calc.calc.controller;

import edu.eci.calc.calc.services.IOperationServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.annotation.Secured;
import org.springframework.web.bind.annotation.*;


@RestController
//(@CrossOrigin(origins = "https://localhost:8443/")
    @RequestMapping(value = "v1/operation")
public class OperationController {

    @Autowired
    @Qualifier("operationServices")
    IOperationServices operationServices;

    @GetMapping("/sum/{num1}/{num2}")
    public ResponseEntity<?> getSum(@PathVariable double num1 ,@PathVariable double num2){
        try {
            return new ResponseEntity<>(operationServices.makeOperation(num1,num2,"+"),HttpStatus.OK);
        } catch (Exception ex) {
            return new ResponseEntity<>(ex.getMessage(), HttpStatus.NOT_ACCEPTABLE);
        }
    }

    @GetMapping("/rest/{num1}/{num2}")
    public ResponseEntity<?> getRest(@PathVariable double num1 ,@PathVariable double num2){
        try {
            return new ResponseEntity<>(operationServices.makeOperation(num1,num2,"-"),HttpStatus.OK);
        } catch (Exception ex) {
            return new ResponseEntity<>(ex.getMessage(), HttpStatus.NOT_ACCEPTABLE);
        }
    }
    @GetMapping("/multiplication/{num1}/{num2}")
    public ResponseEntity<?> getMultiplication(@PathVariable double num1 ,@PathVariable double num2){
        try {
            return new ResponseEntity<>(operationServices.makeOperation(num1,num2,"*"),HttpStatus.OK);
        } catch (Exception ex) {
            return new ResponseEntity<>(ex.getMessage(), HttpStatus.NOT_ACCEPTABLE);
        }
    }
    @GetMapping("/division/{num1}/{num2}")
    public ResponseEntity<?> getDivision(@PathVariable double num1 ,@PathVariable double num2){
        try {
            return new ResponseEntity<>(operationServices.makeOperation(num1,num2,"/"),HttpStatus.OK);
        } catch (Exception ex) {
            return new ResponseEntity<>(ex.getMessage(), HttpStatus.NOT_ACCEPTABLE);
        }
    }


}
