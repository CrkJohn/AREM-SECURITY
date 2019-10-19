package edu.eci.arem.service.controller;

import org.springframework.core.env.Environment;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.net.URI;


@RestController
@RequestMapping(value="/math")
public class MathController {

    @Autowired
    RestTemplate restTemplate;

    @Autowired
    Environment env;


    @RequestMapping(value = "/data", method = RequestMethod.GET)
    public String getData() {
        System.out.println("Returning data from client own data method");
        return "Hello from client data method";
    }

    @RequestMapping(value = "/data/server", method = RequestMethod.GET)
    public String getServerData() {
        System.out.println("Got inside server data method");
        try {
            String Endpoint = env.getProperty("endpoint.serverData");
            System.out.println("MS Endpoint name : [" + Endpoint + "]");

            return restTemplate.getForObject(new URI(Endpoint+"/sum/1/2"), String.class);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return "Exception occurred.. so, returning default data";
    }
}
