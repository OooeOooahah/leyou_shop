package com.leyou.service.impl;

import leyou.item.pojo.Category;

import java.util.List;

public interface CategoryService {
    List<Category> queryCategoryListByParentId(Long id);
}
