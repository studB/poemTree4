package com.test.poemtree4.poem;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class PoemController{


    @RequestMapping(value = "/")
    public String mainRendering(){
        return "note";
    }
}