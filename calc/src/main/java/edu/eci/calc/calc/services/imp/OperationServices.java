package edu.eci.calc.calc.services.imp;

import edu.eci.calc.calc.services.IOperationServices;
import org.springframework.stereotype.Component;


@Component(value = "operationServices")
public class OperationServices implements IOperationServices {
    @Override
    public double makeOperation(double num1, double num2, String op) throws Exception {
        double res = 0.0;
        if(op.charAt(0) == '+'){
            res = num1 + num2;
        }

        if(op.charAt(0) == '-'){
            res = num1 - num2;
        }

        if(op.charAt(0) == '*'){
            res = num1 * num2;
        }

        if(op.charAt(0) == '/'){
            if(num2!=0){
                res = num1 / num2;
            }else{
                throw new Exception("cann't be divide by 0");
            }
        }
        return res;
    }
}
