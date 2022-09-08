/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.lazarev.spring.mvc_hibernate_aop.service;

import com.lazarev.spring.mvc_hibernate_aop.entity.Employee;
import java.util.List;

/**
 *
 * @author User
 */
public interface EmployeeService {
    public List<Employee> getAllEmployees();
    public void saveEmployee(Employee employee);
    
    public Employee getEmployee(int id);
    
    public void deleteEmployee(int id);
}
