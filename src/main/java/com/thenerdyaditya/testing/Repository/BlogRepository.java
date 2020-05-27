package com.thenerdyaditya.testing.Repository;

import com.thenerdyaditya.testing.Models.Blog;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface BlogRepository extends JpaRepository<Blog, Integer> {


    //Custom query to search blog post by title or content
    List<Blog> findByTitleContainingOrContentContaining(String text, String textAgain);

    //findBy clause is the main query keyword. What follows is the column name,
    //then query constraint such as Contains, Containing, GreaterThan, LessThan
    //And and Or are used as conjunction to join two or more query criteria.
    //Eg...
    //JPA: findByIdGreaterThan(20) SQL: where id > 20
    //JPA: findByIdGreaterThanAndTitleContaining(20, "google")   SQL: where id>20 AND title LIKE %google%
    //JPA: findByIdGreaterThanEqualOrTitle(5, "google api") SQL: where id>=5 OR title="google api"

}
