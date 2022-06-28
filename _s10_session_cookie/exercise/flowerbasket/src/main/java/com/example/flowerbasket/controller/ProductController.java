package com.example.flowerbasket.controller;

import com.example.flowerbasket.model.Cart;
import com.example.flowerbasket.model.Product;
import com.example.flowerbasket.service.IProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.Optional;

@Controller
@SessionAttributes("cart")
public class ProductController {
    @Autowired
    private IProductService productService;

    @ModelAttribute("cart")
    public Cart createTalkList() {
        return new Cart();
    }

    @GetMapping("/shop")
    public ModelAndView showShop() {
        ModelAndView modelAndView = new ModelAndView("/shop");
        modelAndView.addObject("products", productService.findAll());
        return modelAndView;
    }

    @GetMapping("/add/{id}")
    public String addToCart(@PathVariable Long id, @ModelAttribute Cart cart, @RequestParam("action") String action,
                            RedirectAttributes redirectAttributes) {
        Optional<Product> productOptional = productService.findById(id);
        if (!productOptional.isPresent()) {
            return "/error";
        }
        if (action.equals("minus")) {
            cart.minusProduct(productOptional.get());
            return "redirect:/shopping-cart";
        }
        if (action.equals("show")) {
            cart.addProduct(productOptional.get());
            return "redirect:/shopping-cart";
        }
        cart.addProduct(productOptional.get());
        redirectAttributes.addFlashAttribute("message", "Thêm vào giở hàng thành công");
        return "redirect:/shop";
    }

    @GetMapping("/pay")
    public String pay(Cart cart, RedirectAttributes redirectAttributes) {
        cart.getProducts().clear();
        redirectAttributes.addFlashAttribute("message", "Thanh toán thành công");
        return "redirect:/shop";
    }
}
