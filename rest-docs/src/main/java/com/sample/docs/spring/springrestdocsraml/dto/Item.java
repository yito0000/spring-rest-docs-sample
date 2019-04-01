package com.sample.docs.spring.springrestdocsraml.dto;

import lombok.Builder;
import lombok.Data;

import java.time.LocalDateTime;

@Data
@Builder
public class Item {

    private String id;

    private String name;

    private LocalDateTime dateTime;
}
