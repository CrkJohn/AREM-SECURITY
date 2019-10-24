package edu.eci.calc.calc.services;


/**
 * A interface used to represent a abstract form of how it do operation math
 */
public interface IOperationServices {

    /**
     *
     * @param num1 value numeric for make a operation math
     * @param num2 value numeric for make a operation math
     * @param op operation math
     * @return the result of operation math
     * @throws Exception
     */
    public double makeOperation(double num1 , double num2 , String op) throws Exception;
}
