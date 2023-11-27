package codegym.vn.service;

import codegym.vn.entity.Blog;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Slice;

import java.util.List;

public interface BlogService extends Service<Blog> {
    List<Blog> findAllByTitle(String title);
    Page<Blog> findAllAndPaging(Pageable pageable);
    Slice<Blog> findAllSlice(Pageable pageable);

}
