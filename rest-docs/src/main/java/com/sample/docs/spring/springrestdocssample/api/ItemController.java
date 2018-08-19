package com.sample.docs.spring.springrestdocssample.api;

import com.sample.docs.spring.springrestdocssample.dto.Item;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/item")
public class ItemController {

    @GetMapping(path = "/{id}")
    public Item fetchItem(@PathVariable("id") String id) {
        Item item = new Item();
        item.setId("id");
        item.setName("name");
        item.setDateTime(LocalDateTime.now());
        return item;
    }

    @GetMapping(path = "/list", params = "{year, month}")
    public List<Item> fetchItemList(String year, String month) {

        return new ArrayList<>();
    }

}
