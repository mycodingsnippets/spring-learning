package com.thenerdyaditya.testing.Controllers;

import com.thenerdyaditya.testing.Dao.BlogJdbcDao;
import com.thenerdyaditya.testing.Models.Blog;
import com.thenerdyaditya.testing.Repository.BlogRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;
import java.util.Optional;

@RestController
public class BlogController {

    @Autowired
    BlogRepository blogRepository;

    @Autowired
    BlogJdbcDao blogJdbcDao;

    @GetMapping("/blog")
    public List<Blog> index(){
        return blogRepository.findAll();
    }

    @GetMapping("/blog-jdbc")
    public List<Blog> jdbcIndex(){
        return blogJdbcDao.findAll();
    }

    @GetMapping("/blog/{id}")
    public Optional<Blog> show(@PathVariable String id){
        int blogId = Integer.parseInt(id);
        return blogRepository.findById(blogId);
    }

    @GetMapping("/blog-jdbc/{id}")
    public Blog jdbcShow(@PathVariable String id){
        int blogId = Integer.parseInt(id);
        return blogJdbcDao.findById(blogId);
    }

    @PostMapping("/blog")
    public Blog create(@RequestBody Map<String, String> body){
        String title = body.get("title");
        String content = body.get("content");
        return blogRepository.save(new Blog(title, content));
    }

    @PostMapping("/blog-jdbc")
    public int jdbcCreate(@RequestBody Blog blog){
        return blogJdbcDao.insert(blog);
    }

    @PutMapping("/blog/{id}")
    public Blog update(@PathVariable String id, @RequestBody Map<String, String> body){
        int blogId = Integer.parseInt(id);
        Optional<Blog> blog = blogRepository.findById(blogId);
        if(blog.isPresent()) {
            blog.get().setTitle(body.get("title"));
            blog.get().setContent(body.get("content"));
            return blogRepository.save(blog.get());
        }
        return null;
    }

    @PutMapping("/blog-jdbc")
    public int jdbcUpdate(@RequestBody Blog blog){
        return blogJdbcDao.update(blog);
    }

    @DeleteMapping("/blog/{id}")
    public boolean delete(@PathVariable String id){
        int blogId = Integer.parseInt(id);
        blogRepository.deleteById(blogId);
        return true;
    }

    @DeleteMapping("/blog-jdbc/{id}")
    public int jdbcDelete(@PathVariable String id){
        int blogId = Integer.parseInt(id);
        return blogJdbcDao.deleteById(blogId);
    }

    @PostMapping("/blog/search")
    public List<Blog> search(@RequestBody Map<String, String> body){
        String searchTerm = body.get("text");
        return blogRepository.findByTitleContainingOrContentContaining(searchTerm, searchTerm);
    }

    @DeleteMapping("/blog-jdbc")
    public int delete(){
        return blogJdbcDao.delete();
    }
}
