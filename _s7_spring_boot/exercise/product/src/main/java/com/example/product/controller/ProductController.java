package com.example.product.controller;

import com.example.product.model.Product;
import com.example.product.service.IProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;


@Controller
public class ProductController {

    @Autowired
    private IProductService productService;

    @GetMapping("/list")
    public String listProduct(Model model, @RequestParam(value = "page", defaultValue = "0") int page) {
        Page<Product> product = productService.listProduct(PageRequest.of(page, 2));
        model.addAttribute("listProduct", product);
        return "/list";
    }

    @GetMapping("/create")
    public String createProduct(Model model) {
        model.addAttribute("listProduct", new Product());
        return "/create";
    }

    @PostMapping("/create")
    public String save(Product product) {
        productService.create(product);
        return "redirect:/list";
    }

    @GetMapping("{id}/delete")
    public String view(@PathVariable("id") int id) {
        productService.remove(id);
        return "redirect:/list";
    }

    @GetMapping("{id}/edit")
    public String formEdit(@PathVariable int id, Model model) {
        model.addAttribute("listProductEdit", productService.searchId(id));
        return "/edit";
    }

    @PostMapping("/edit")
    public String editProduct(Product product) {
        productService.update(product);
        return "redirect:/list";
    }

    @GetMapping("/{id}/view")
    public String view(@PathVariable int id, Model model) {
        model.addAttribute("list", productService.searchId(id));
        return "/view";
    }

    @GetMapping("/search")
    public String search(String nameProduct, Model model, @RequestParam(name = "page", defaultValue = "0") int page) {
        model.addAttribute("listProduct", productService.search(nameProduct, PageRequest.of(page, 1)));
        return "/list";
    }
}
