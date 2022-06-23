package com.example.product_plus.controller;

import com.example.product_plus.model.Product;
import com.example.product_plus.service.IProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;


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
        model.addAttribute("ListCreate", new Product());
        return "/create";
    }

    @PostMapping("/create")
    public String save(@Valid @ModelAttribute("ListCreate") Product listProduct, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return "/create";
        }
        productService.create(listProduct);
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
