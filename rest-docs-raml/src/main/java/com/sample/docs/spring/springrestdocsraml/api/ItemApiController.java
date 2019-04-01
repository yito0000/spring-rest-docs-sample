package com.sample.docs.spring.springrestdocsraml.api;

import com.sample.docs.spring.springrestdocsraml.dto.Item;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import static org.springframework.hateoas.mvc.ControllerLinkBuilder.linkTo;

@RestController
public class ItemApiController {

    @GetMapping(path = "/item/{id}")
    public Item fetchItem(@PathVariable("id") String id) {
        Item item = Item.builder()
                .id("0001")
                .name("name")
                .dateTime(LocalDateTime.now()).build();

        return item;
    }

    @GetMapping(path = "/item/list")
    public List<Item> fetchItemList() {

        List<Item> response = new ArrayList<>();
        response.add(Item.builder()
                .id("0001")
                .name("item1")
                .dateTime(LocalDateTime.now()).build()
        );

        response.add(Item.builder()
                .id("0002")
                .name("item2")
                .dateTime(LocalDateTime.now()).build()
        );

        response.add(Item.builder()
                .id("0003")
                .name("item3")
                .dateTime(LocalDateTime.now()).build()
        );

        return response;
    }

    @PostMapping(path = "/item")
    public Item post(@RequestBody Item item) {
        Item response = Item.builder()
                .id(item.getId())
                .name(item.getName())
                .dateTime(LocalDateTime.now()).build();
        return response;
    }

}
