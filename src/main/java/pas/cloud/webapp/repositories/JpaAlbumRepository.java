package pas.cloud.webapp.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import pas.cloud.webapp.domain.Album;

import java.util.List;

public interface JpaAlbumRepository extends JpaRepository<Album, String>
{
    @Query("select a from Album a where a.title like %?1%")
    List<Album> findByTitleContains(String title);

    Album findByReleaseYear(String releaseYear);
}
