package com.olehpodolin.spring5mvcrest.api.v1.mapper;

import com.olehpodolin.spring5mvcrest.api.v1.model.CategoryDTO;
import com.olehpodolin.spring5mvcrest.domain.Category;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface CategoryMapper {

    CategoryMapper INSTANCE = Mappers.getMapper(CategoryMapper.class);

    CategoryDTO categoryToCategoryDTO(Category category);
}
