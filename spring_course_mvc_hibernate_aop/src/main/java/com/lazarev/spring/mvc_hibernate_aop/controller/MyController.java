/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.lazarev.spring.mvc_hibernate_aop.controller;

import com.lazarev.spring.mvc_hibernate_aop.dao.EmployeeDAO;
import com.lazarev.spring.mvc_hibernate_aop.entity.Employee;
import com.lazarev.spring.mvc_hibernate_aop.service.EmployeeService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 *
 * @author User
 */
@Controller
public class MyController {
    @Autowired
    private EmployeeService employeeService;
    
    @RequestMapping("/")
    public String showAllEmployess(Model model){
        
       List<Employee> allEmployees= employeeService.getAllEmployees();
        model.addAttribute("allEmps",allEmployees);
        return "all-employees";
    }
    @RequestMapping("/addNewEmployee")
    public String addNewEmployee(Model model){
        
        Employee employee=new Employee();
        model.addAttribute("employee",employee);
        
        return"employee-info";
    }
    @RequestMapping("/saveEmployee")
    public String saveEmployee(@ModelAttribute("employee")Employee employee){
        
        employeeService.saveEmployee(employee);
        
        return "redirect:/";
    }
    @RequestMapping("/updateInfo")
    public String updateEmployee(@RequestParam("empId") int id, Model model){
        
        Employee employee=employeeService.getEmployee(id);
        model.addAttribute("employee" ,employee);
        
        
        return "employee-info";
    }
    @RequestMapping("/deleteEmployee")
    public String deleteEmployee(@RequestParam("empId") int id){
        
        employeeService.deleteEmployee(id);
        
        return "redirect:/";
    }
    
}
