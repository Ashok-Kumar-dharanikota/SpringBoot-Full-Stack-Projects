package com.example.restfulweb.RESTfulwebapp;


public class WebController {


    public SampleResponse Sample(@RequestParam(value = "name",
            defaultValue = "Robot") String name) {
        SampleResponse response = new SampleResponse();
        response.setId(1);
        response.setMessage("Your name is "+name);
        return response;

    }
}
