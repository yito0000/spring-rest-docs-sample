package com.sample.docs.spring.springrestdocsraml.api;

import com.sample.docs.spring.springrestdocsraml.dto.Item;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/item")
public class ItemApiController {

    @GetMapping(path = "/{id}")
    public Item fetchItem(@PathVariable("id") String id) {
        Item item = Item.builder()
                .id("id")
                .name("name")
                .dateTime(LocalDateTime.now()).build();
        return item;
    }

    @GetMapping(path = "/list", params = "{year, month}")
    public List<Item> fetchItemList(String year, String month) {

        return new ArrayList<>();
    }

}
