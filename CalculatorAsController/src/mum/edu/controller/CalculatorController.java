package mum.edu.controller;



//import java.io.IOException;
//import java.io.PrintWriter;
//
//import javax.servlet.ServletException;
//import javax.servlet.annotation.WebServlet;
//import javax.servlet.http.HttpServlet;
import mum.edu.domain.Calculator;
import mum.edu.service.CalculatorService;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
 

@Controller
public class CalculatorController {
 
  @Autowired
  CalculatorService calculatorService;
  
  @RequestMapping(value={"/","/Calculator"} , method = RequestMethod.GET)
  public String inputCalc() throws Exception {
  
       return  "CalculatorForm" ;    
   }
   
  @RequestMapping(value= "/Calculator" , method = RequestMethod.POST)
  public String handleCalc(Calculator calculator ) throws Exception {
  
		if (calculator.getAdd1() != null &&
			 calculator.getAdd2() != null)
		     calculatorService.add(calculator);
 
		if (calculator.getMult1() != null &&
				 calculator.getMult2() != null)
			calculatorService.mult(calculator);

       return  "CalculatorView" ; 
   }
   
 
}
