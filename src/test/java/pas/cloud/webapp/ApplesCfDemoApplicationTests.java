package pas.cloud.webapp;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import pas.cloud.webapp.domain.Album;
import pas.cloud.webapp.repositories.JpaAlbumRepository;

import java.util.List;

import static junit.framework.Assert.assertEquals;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = ApplesCfDemoApplication.class)
@WebAppConfiguration
public class ApplesCfDemoApplicationTests {

    @Autowired
    private JpaAlbumRepository repository;

    /*
    @Test
    public void insertEntries()
    {
        Album album = new Album("Thriller", "Michael Jackson", "1982");
        repository.save(album);
        Album album2 = new Album("Bad", "Michael Jackson", "1987");
        repository.save(album2);
    }
    */

    @Test
    public void invokeFindAll()
    {
        List<Album> albums = (List<Album>) repository.findAll();
        assertEquals(5, albums.size());
    }

    @Test
    public void invokeFindByTitleContains()
    {
        List<Album> albums = repository.findByTitleContains("ller");
        assertEquals(1, albums.size());
    }

    @Test
    public void invokeFindByReleaseYear()
    {
        Album album = repository.findByReleaseYear("1987");
        System.out.println(album);
        assertEquals("Bad", album.getTitle());
    }
}
