package  com.example.automart.controller;

import  com.example.automart.entity.Product;
import  com.example.automart.service.CategoryService;
import  com.example.automart.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
public class HomeController {
    private final ProductService productService;

    @Autowired
    private CategoryService categoryService;

    @Autowired
    public HomeController(ProductService productService) {
        this.productService = productService;
    }

    @GetMapping(value = {"/","/index","/home"})
    public String home(Model model){
        model.addAttribute("products", getAllProducts());
        model.addAttribute("productsCount", productsCount());
        model.addAttribute("categories", categoryService.findAll());
        return "home";
    }

    @GetMapping("/shipping")
    public String getShippingPage() {
        return "shipping";
    }

    @GetMapping("/tasks")
    public String getTasksPage() {
        return "tasks";
    }

    @RequestMapping("/searchByCategory")
    public String homePost(@RequestParam("categoryId") long categoryId, Model model){
        model.addAttribute("books", productService.findAllByCategoryId(categoryId));
        model.addAttribute("booksCount", productService.count());
        model.addAttribute("categories", categoryService.findAll());
        return "home";
    }

    @GetMapping("/about")
    public String about(){
        return "about";
    }

    private List<Product> getAllProducts(){
        return productService.findAllByOrderByIdAsc();
    }

    private long productsCount(){
        return productService.count();
    }
}
