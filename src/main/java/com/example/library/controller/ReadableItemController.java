package com.example.library.controller;

import com.example.library.model.ReadableItem;
import com.example.library.model.ReadableItemStatus;
import com.example.library.service.ReadableItemService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/readableitems")
public class ReadableItemController {

    private final ReadableItemService readableItemService;

    public ReadableItemController(ReadableItemService readableItemService) {
        this.readableItemService = readableItemService;
    }

    @GetMapping
    public String getAllReadableItems(Model model) {
        model.addAttribute("readableitems", readableItemService.getAllReadableItems());
        return "readableitems/index";
    }

    @GetMapping("/new")
    public String showAddForm(Model model) {
        model.addAttribute("readableitem", new ReadableItem("", "", "", ReadableItemStatus.AVAILABLE));
        return "readableitems/form";
    }

    @PostMapping
    public String addReadableItem(@ModelAttribute ReadableItem readableItem) {
        readableItemService.addReadableItem(readableItem);
        return "redirect:/readableitems";
    }

    @PostMapping("/{id}/delete")
    public String deleteReadableItem(@PathVariable String id) {
        readableItemService.removeReadableItem(id);
        return "redirect:/readableitems";
    }
}