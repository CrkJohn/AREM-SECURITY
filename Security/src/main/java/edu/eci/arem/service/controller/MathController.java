package edu.eci.arem.service.controller;

import org.springframework.core.env.Environment;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.net.URI;


/**
 * A class used to represent the caculator, this class makes the petition to the other api
 */
@RestController
@RequestMapping(value="/math")
public class MathController {

    @Autowired
    RestTemplate restTemplate;

    @Autowired
    Environment env;

    /**
     *
     * @return  a string that implies that the client is working
     */
    @RequestMapping(value = "/data", method = RequestMethod.GET)
    public String getData() {
        System.out.println("Returning data from client own data method");
        return "Hello from client data method";
    }


    /**
     *
     * @param n1 num1 to add
     * @param n2 num2 to add
     * @return returns a string that is the calculation of adding two numbers
     */
    @RequestMapping(value = "/data/server/{n1}/{n2}", method = RequestMethod.GET)
    public String getServerData(@PathVariable int n1, @PathVariable int n2) {
        System.out.println("Got inside server data method");
        try {
            String Endpoint = env.getProperty("endpoint.serverData");
            System.out.println("MS Endpoint name : [" + Endpoint + "]");

            return restTemplate.getForObject(new URI(Endpoint+"/sum/"+n1+"/"+n2+""), String.class);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return "Exception occurred.. so, returning default data";
    }
}
