package com.example.book.controller;

import com.example.book.model.Book;
import com.example.book.model.BorrowBooks;
import com.example.book.service.IBookService;
import com.example.book.service.IBorrowBooksService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;

@Controller
public class BookController {
    @Autowired
    private IBookService bookService;
    @Autowired
    private IBorrowBooksService borrowBooksService;
    int code = (int) (Math.random() * 1000);

    @GetMapping("/list")
    public String list(Model model) {
        model.addAttribute("listBook", bookService.listBook());
        model.addAttribute("listBorrow", borrowBooksService.list());
        return "/list";
    }

    @GetMapping("{id}/borrow")
    public String formBorrow(@PathVariable("id") int id, Model model) {
        model.addAttribute("formEdit", bookService.findId(id));
        return "/borrow";
    }

    @PostMapping("/borrow")
    public String Borrow(BorrowBooks borrowBooks, RedirectAttributes redirectAttributes) {
        borrowBooks.setCodeBorrowBooks(code);
        borrowBooksService.save(borrowBooks);
        redirectAttributes.addFlashAttribute("code", code);
        return "redirect:/list";
    }

    @GetMapping("/return")
    public String form(Model model) {
        model.addAttribute("form", new Book());
        return "/return";
    }

    @PostMapping("/return")
    public String returnBook(Book book, @RequestParam("codeBorrowBooks") int codeBorrowBooks, @RequestParam("id") int id) {
        List<BorrowBooks> list = borrowBooksService.list();
        for (BorrowBooks items : list) {
            if (items.getCodeBorrowBooks() == codeBorrowBooks) {
                borrowBooksService.remove(items);
                borrowBooksService.listCode(book.getBorrowBooks().getCodeBorrowBooks());
                bookService.returnBook(book.getNumberOfBooks(), book.getIdBook());
                bookService.save(book);
                return "redirect:/list";
            }
        }
        return "redirect:/list";
    }

    @ExceptionHandler(Exception.class)
    public String handleException() {
        return "/error";
    }
}
