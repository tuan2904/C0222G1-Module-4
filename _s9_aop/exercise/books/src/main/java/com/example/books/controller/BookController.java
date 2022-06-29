package com.example.books.controller;

import com.example.books.model.Book;
import com.example.books.model.BorrowBooks;
import com.example.books.service.IBookService;
import com.example.books.service.IBorrowBooksService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;


@Controller
public class BookController {
    @Autowired
    private IBookService bookService;
    @Autowired
    private IBorrowBooksService borrowBooksService;


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
        int code = (int) (Math.random() * 1000);
        borrowBooks.setCodeBorrowBooks(code);
        borrowBooksService.save(borrowBooks);
        redirectAttributes.addFlashAttribute("code", code);
        return "redirect:/list";
    }

    @PostMapping("/return")
    public String returnBook(Book book, @RequestParam("codeBorrowBooks") int code, @RequestParam("idBook") int id, RedirectAttributes redirectAttributes) {
        List<BorrowBooks> borrowBooks = (List<BorrowBooks>) borrowBooksService.listCode(id);
        for (BorrowBooks items : borrowBooks) {
            if (items.equals(code)) {
                borrowBooksService.remove(items);
                bookService.returnBook(book.getIdBook(), book.getNumberOfBooks());
                redirectAttributes.addFlashAttribute("mess", "Thêm thành công");
                return "redirect:/list";
            }

        }
            return "/error";
        }
    
}