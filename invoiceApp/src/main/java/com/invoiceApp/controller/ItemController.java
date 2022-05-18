package com.invoiceApp.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.invoiceApp.entity.Item;
import com.invoiceApp.service.ItemService;

@RestController
@RequestMapping("/items")
public class ItemController {
	
	@Autowired
	ItemService itemService;

	@GetMapping("/list/{invoiceName}")
	public List<Item> findItems(@PathVariable String invoiceName){
		return itemService.findItems(invoiceName);
	}
	
}
