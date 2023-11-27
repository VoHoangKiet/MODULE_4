package codegym.vn.repository;

import codegym.vn.entity.Blog;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface BlogRepository extends JpaRepository<Blog, Integer> {
    public List<Blog> findAllByTitleContaining(String title);
    @Query("From Blog p where p.title like :title")
    public List<Blog> search(@Param("title") String title);

}
