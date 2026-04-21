package com.practice.customermanagement.controller;

import com.practice.customermanagement.entity.Customer;
import com.practice.customermanagement.service.ICustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import java.util.List;

@Controller
public class CustomerController {

    @Autowired
    ICustomerService customerService;

    @GetMapping("/getallcustomers")
    public String getallcustomers(Model model) {
        List<Customer> customers = customerService.getAllCustomers();
        model.addAttribute("customers", customers);
        return "customerlist";
    }

    @GetMapping("/showcustomerform")
    public String showcustomerform(@ModelAttribute("customer") Customer customer) {
        return "customerform";
    }

    @PostMapping("/registercustomer")
    public String registercustomer(@ModelAttribute Customer customer) {
        customerService.registerCustomer(customer);
        return "redirect:/getallcustomers";
    }

    @GetMapping("/deletecustomer/{id}")
    public String deleteCustomer(@PathVariable("id") int id) {
        customerService.deleteCustomer(id);
        return "redirect:/getallcustomers";
    }

    @GetMapping("/updateform/{id}")
    public String  updateform(@PathVariable("id") int id,Model model) {
        Customer customer = customerService.getCustomerById(id);
        model.addAttribute("customer", customer);
        return "customerform";
    }

    @PostMapping("/updatecustomer")
    public String updatecustomer(@ModelAttribute Customer customer) {
        customerService.updateCustomer(customer);
        return "redirect:/getallcustomers";
    }

}
