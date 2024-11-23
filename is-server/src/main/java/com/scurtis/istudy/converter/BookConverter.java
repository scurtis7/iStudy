package com.scurtis.istudy.converter;

import com.scurtis.istudy.dto.BookDto;
import com.scurtis.istudy.entity.Book;
import org.springframework.stereotype.Component;

@Component
public class BookConverter {

    public BookDto toDto(Book entity) {
        return new BookDto(entity.getId(), entity.getName(), entity.getCategory(),
            entity.getTestament(), entity.getCreatedDate());
    }

}
