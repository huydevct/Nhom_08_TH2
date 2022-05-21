package com.example.manageproduct.controller;

import com.example.manageproduct.entity.Product;
import com.example.manageproduct.service.ProductService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
@AllArgsConstructor
public class ProductController {
    private ProductService productService;
    @GetMapping("/")
    public String showIndex(){
        return "index";
    }

    @GetMapping("/products")
    public String listProducts(Model model){
        model.addAttribute("products",productService.getAllProducts());
        return "home_product";
    }

    @GetMapping("/products/add-new")
    public String createProductForm(Model model){
        Product product = new Product();
        model.addAttribute("product", product);
        return "add_product";
    }
    @PostMapping("/products")
    public String saveProduct(@ModelAttribute("product") Product product){
        productService.saveProduct(product);
        return "redirect:/products";
    }

    @GetMapping("/products/update/{id}")
    public String editProductForm(@PathVariable Long id, Model model){
        model.addAttribute("product",productService.getProductById(id));
        return "update_product";
    }

    @PostMapping("/products/{id}")
    public String updateProduct(@PathVariable Long id,@ModelAttribute("product") Product product,Model model){
        Product oldProduct = productService.getProductById(id);
        oldProduct.setId(id);
        oldProduct.setCode(product.getCode());
        oldProduct.setDescription(product.getDescription());
        oldProduct.setPrice(product.getPrice());

        productService.updateProduct(oldProduct);
        return "redirect:/products";
    }

    @GetMapping("/products/{id}")
    public String deleteProduct(@PathVariable Long id){
        productService.deleteProductById(id);
        return "redirect:/products";
    }
}
