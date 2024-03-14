package org.example.mapper;

import org.example.domain.Blog;

import java.util.List;

public interface BlogMapper {
    List<Blog> selectBlog(Integer id);

}
