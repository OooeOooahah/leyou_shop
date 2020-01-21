package com.leyou.controller;

import com.leyou.service.CategoryService;
import leyou.item.pojo.Category;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.util.CollectionUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
@RequestMapping("category")
public class CategoryController {

    @Autowired
    private CategoryService categoryService;

    @RequestMapping("list")
    public ResponseEntity<List<Category>> queryCategoryListByParentId(@RequestParam(value = "pid", defaultValue = "0") Long pid) {
        try {
            if (pid == null || pid.longValue() < 0) {
                return ResponseEntity.badRequest().build();
            }
            List<Category> _res = this.categoryService.queryCategoryListByParentId(pid);
            if (CollectionUtils.isEmpty(_res)){
                return  ResponseEntity.badRequest().build();
            }
            return ResponseEntity.ok(_res);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
    }
}
