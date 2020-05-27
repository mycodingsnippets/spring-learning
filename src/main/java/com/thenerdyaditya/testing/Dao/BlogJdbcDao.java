package com.thenerdyaditya.testing.Dao;

import com.thenerdyaditya.testing.Models.Blog;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class BlogJdbcDao {

    @Autowired
    JdbcTemplate jdbcTemplate;

    public List<Blog> findAll(){
        return jdbcTemplate.query("select * from blog", new BeanPropertyRowMapper<Blog>(Blog.class));
    }

    public Blog findById(int id){
        return jdbcTemplate.queryForObject("select * from blog where id=?", new Object[]{id}, new BeanPropertyRowMapper<Blog>(Blog.class));
    }

    public int insert(Blog blog){
        return jdbcTemplate.update("insert into blog(id, title, content) values(?,?,?)", new Object[]{blog.getId(), blog.getTitle(), blog.getContent()});
    }

    public int update(Blog blog){
        return jdbcTemplate.update("update blog set title=?, content=? where id = ?", new Object[]{blog.getTitle(), blog.getContent(), blog.getId()});
    }

    public int deleteById(int id){
        return jdbcTemplate.update("delete from blog where id=?", new Object[]{id});
    }

    public int delete(){
        return jdbcTemplate.update("delete from blog");
    }
}
