package me.imatveev.graphqldemo.storage;

import me.imatveev.graphqldemo.domain.entity.Show;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface ShowRepository extends JpaRepository<Show, String> {
    @Query("select show from Show show where show.title like concat('%', :filter, '%')")
    List<Show> findAllByTitleContains(@Param("filter") String titleFilter);
}
