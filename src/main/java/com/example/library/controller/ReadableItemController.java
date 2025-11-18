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

    /*
    getAll si getById
     */
    @GetMapping
    public String getAllReadableItems(Model model) {
        model.addAttribute("readableitems", readableItemService.getAllReadableItems());
        return "readableitems/index";
    }

    @GetMapping("/{id}")
    public String getReadableItemById(@PathVariable String id, Model model) {
        ReadableItem readableItem = readableItemService.getReadableItemById(id);
        if (readableItem == null) {
            return "redirect:/readableitems";
        }

        model.addAttribute("readableitem", readableItem);
        model.addAttribute("statuses", ReadableItemStatus.values());
        return "readableitems/details";
    }


    /*
    addReadableItem
     */
    @GetMapping("/new")
    public String showAddForm(Model model) {
        model.addAttribute("readableitem", new ReadableItem("", "", "", ReadableItemStatus.AVAILABLE));
        model.addAttribute("statuses", ReadableItemStatus.values());
        return "readableitems/form";
    }

    @PostMapping
    public String addReadableItem(@ModelAttribute ReadableItem readableItem) {
        readableItemService.addReadableItem(readableItem);
        return "redirect:/readableitems";
    }


    /*
    updateReadableItem
     */
    @GetMapping("/{id}/edit")
    public String showEditForm(@PathVariable String id, Model model) {
        ReadableItem readableItem = readableItemService.getReadableItemById(id);
        if (readableItem == null) {
            return "redirect:/readableitems";
        }

        model.addAttribute("readableitem", readableItem);
        model.addAttribute("statuses", ReadableItemStatus.values());
        return "readableitems/form";
    }

    @PostMapping("/{id}/edit")
    public String updateReadableItem(@PathVariable String id, @ModelAttribute ReadableItem updatedItem) {
        readableItemService.updateReadableItem(id, updatedItem);
        return "redirect:/readableitems";
    }


    /*
    deleteReadableItem
     */
    @PostMapping("/{id}/delete")
    public String deleteReadableItem(@PathVariable String id) {
        readableItemService.removeReadableItem(id);
        return "redirect:/readableitems";
    }
}