package com.example.products.controller;


import com.example.products.Model.Product;
import com.example.products.Service.IProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
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
    public String home(@RequestParam(name = "page", defaultValue = "0") int page, Model model) {
        Sort sort = Sort.by("name_product").ascending();
        Page<Product> productList = productService.findAllProduct(PageRequest.of(page, 2, sort));
        model.addAttribute("listProduct", productList);
        model.addAttribute("product", new Product());
        return "/list";
    }

    @GetMapping("/create")
    public String create(Model model) {
        model.addAttribute("listProduct", new Product());
        return "/create";
    }

    @PostMapping("/create")
    public String save(Product product) {
        productService.save(product);
        return "redirect:/list";
    }

    @GetMapping("/{id}/edit")
    public String edit(@PathVariable int id, Model model) {
        model.addAttribute("listProduct", productService.findById(id));
        return "/edit";
    }

    @PostMapping("/edit")
    public String update(Product product) {
        productService.update(product);
        return "redirect:/list";
    }

    @GetMapping("{id}/delete")
    public String delete(@PathVariable("id") int id) {
        productService.remove(id);
        return "/list";
    }

    @GetMapping("/search")
    public String searchByName(@RequestParam(name = "page", defaultValue = "0") int page, String nameProduct, Model model) {
        Sort sort = Sort.by("name_product").ascending();
        Page<Product> productList = productService.findAllProductByName(PageRequest.of(page, 2, sort), nameProduct);
        model.addAttribute("listProduct", productList);
        model.addAttribute("product", new Product());
        return "/list";
    }
}
