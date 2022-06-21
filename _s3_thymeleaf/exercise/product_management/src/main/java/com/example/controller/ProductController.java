package com.example.controller;

import com.example.model.Product;
import com.example.service.IProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;


@Controller
public class ProductController {

    @Autowired
    private IProductService productService;

    @GetMapping("/list")
    public String listProduct(Model model) {
        List<Product> product = productService.listProduct();
        model.addAttribute("listProduct", product);
        return "/list";
    }

    @GetMapping("/create")
    public String createProduct(Model model) {
        model.addAttribute("listProduct", new Product());
        return "/create";
    }

    @GetMapping("/search")
    public String search(String nameProduct, Model model) {
        model.addAttribute("listProduct", productService.search(nameProduct));
        return "/list";
    }

    @PostMapping("/create")
    public String save(Product product) {
        productService.create(product);
        return "redirect:/list";
    }

    @GetMapping("{id}/delete")
    public String view(@PathVariable("id") int id) {
        productService.remove(id);
        return "/list";
    }

    @GetMapping("{id}/edit")
    public String formEdit(@PathVariable int id, Model model) {
        model.addAttribute("listProduct", productService.searchId(id));
        return "/edit";
    }

    @PostMapping("/edit")
    public String editProduct(Product product) {
        productService.update(product);
        return "redirect:/list";
    }
}
