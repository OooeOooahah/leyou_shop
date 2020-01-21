package com.leyou.mapper;


import leyou.item.pojo.Category;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;


import java.util.List;

/**
 * @author whb
 * @date now
 */
@Repository
public interface CategoryMapper {
    List<Category> findParentById(@Param(value = "id")Long id);
}
