package com.example.product.controller;

import com.example.product.Model.Product;
import com.example.product.Service.IProductService;
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
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

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

    @PostMapping("/save")
    public String save(Product product) {
        productService.save(product);
        return "redirect:/product";
    }

    @GetMapping("/{id}/edit")
    public String edit(@PathVariable int id, Model model) {
        model.addAttribute("listProduct", productService.findById(id));
        return "/edit";
    }

    @PostMapping("/update")
    public String update(Product product) {
        productService.update(product);
        return "redirect:/product";
    }

    @GetMapping("/{id}/delete")
    public String delete(@PathVariable int id, Model model) {
        model.addAttribute("product", productService.findById(id));
        return "/delete";
    }

    @PostMapping("/delete")
    public String delete(Product product, RedirectAttributes redirect) {
        productService.remove(product);
        redirect.addFlashAttribute("success", "Removed product successfully!");
        return "redirect:/product";
    }


    @GetMapping("/search")
    public String searchByName(@RequestParam(name = "page", defaultValue = "0") int page, Product product, Model model) {
        Sort sort = Sort.by("name_product").ascending();
        Page<Product> productList = productService.findAllProductByName(PageRequest.of(page, 2, sort), product);
        model.addAttribute("listProduct", productList);
        model.addAttribute("product", new Product());
        return "/list";
    }
}
