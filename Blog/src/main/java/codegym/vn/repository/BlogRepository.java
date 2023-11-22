package codegym.vn.repository;

import codegym.vn.entity.Blog;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface BlogRepository extends JpaRepository<Blog, Integer> {
    public List<Blog> findAllByAuthorContaining(String author);
    @Query("From Blog p where p.author like :author")
    public List<Blog> search(@Param("author") String author);

}
