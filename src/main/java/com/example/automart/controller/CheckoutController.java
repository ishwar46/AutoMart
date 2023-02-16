package com.example.automart.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class CheckoutController {

    @GetMapping("/checkout")
    public String showCheckoutPage(Model model) {

        return "checkout";
    }

    @PostMapping("/checkout")
    public String processCheckout(Model model) {

        return "confirmation";
    }

}

