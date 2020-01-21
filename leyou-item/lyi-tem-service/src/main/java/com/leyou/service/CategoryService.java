package com.leyou.service;

import com.leyou.mapper.CategoryMapper;
import leyou.item.pojo.Category;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoryService implements com.leyou.service.impl.CategoryService {

    @Autowired
    private CategoryMapper mapper;

    /**
     *
     * @param id 入参id
     * @return 返回List
     */
    public List<Category> queryCategoryListByParentId(Long id) {
        Category category=new Category();
        category.setParentId(id);
        return this.mapper.findParentById(id);
    }
}
