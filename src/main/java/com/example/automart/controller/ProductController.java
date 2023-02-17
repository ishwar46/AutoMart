package  com.example.automart.controller;

import  com.example.automart.entity.Product;
import  com.example.automart.service.CategoryService;
import  com.example.automart.service.ProductService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class ProductController {
    private static final Logger logger = LoggerFactory.getLogger(ProductController.class);
    private final ProductService productService;
    private final  com.example.automart.validator.ProductValidator productValidator;
    private final CategoryService categoryService;

    @Autowired
    public ProductController(ProductService productService,  com.example.automart.validator.ProductValidator productValidator, CategoryService categoryService) {
        this.productService = productService;
        this.productValidator = productValidator;
        this.categoryService = categoryService;
    }

    @GetMapping("/product/new")
    public String newProduct(Model model) {
        model.addAttribute("productForm", new Product());
        model.addAttribute("method", "new");
        model.addAttribute("categories", categoryService.findAll());
        return "product";
    }

    @PostMapping("/product/new")
    public String newProduct(@ModelAttribute("productForm") Product productForm, BindingResult bindingResult, Model model) {
        productValidator.validate(productForm, bindingResult);

        if (bindingResult.hasErrors()) {
            logger.error(String.valueOf(bindingResult.getFieldError()));
            model.addAttribute("method", "new");
            return "product";
        }
        productService.save(productForm);
        logger.debug(String.format("Product with id: %s successfully created.", productForm.getId()));

        return "redirect:/home";
    }

    @GetMapping("/product/edit/{id}")
    public String editProduct(@PathVariable("id") long productId, Model model){
        Product product = productService.findById(productId);
        if (product != null){
            model.addAttribute("productForm", product);
            model.addAttribute("method", "edit");
            return "product";
        }else {
            return "error/404";
        }
    }

    @PostMapping("/product/edit/{id}")
        public String editProduct(@PathVariable("id") long productId, @ModelAttribute("productForm") Product productForm, BindingResult bindingResult, Model model){
        productValidator.validate(productForm, bindingResult);

        if (bindingResult.hasErrors()) {
            logger.error(String.valueOf(bindingResult.getFieldError()));
            model.addAttribute("method", "edit");
            return "product";
        }
        productService.edit(productId, productForm);
        logger.debug(String.format("Product with id: %s has been successfully edited.", productId));

        return "redirect:/home";
    }

//    @GetMapping("/product/delete/{id}")
//    public String deleteProduct(@PathVariable("id") long productId){
//        Product product = productService.findById(productId);
//        if (product != null){
//           productService.delete(productId);
//           logger.debug(String.format("Product with id: %s successfully deleted.", product.getId()));
//           return "redirect:/home";
//        }else {
//            return "error/404";
//        }
//    }
@GetMapping("/product/delete/{id}")
public String deleteProduct(@PathVariable("id") long productId, Model model){
    Product product = productService.findById(productId);
    if (product != null){
        productService.delete(productId);
        logger.debug(String.format("Product with id: %s successfully deleted.", product.getId()));
        model.addAttribute("message", "Product deleted successfully");
        model.addAttribute("showModal", true);
        return "redirect:/home";
    } else {
        return "error/404";
    }
}


}
