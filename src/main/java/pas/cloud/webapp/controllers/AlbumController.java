package pas.cloud.webapp.controllers;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import pas.cloud.webapp.domain.Album;
import pas.cloud.webapp.repositories.JpaAlbumRepository;

import java.util.List;

@Controller
public class AlbumController
{
    private static final Logger logger = LoggerFactory.getLogger(AlbumController.class);
    private JpaAlbumRepository repository;

    @Autowired
    public AlbumController(JpaAlbumRepository repository)
    {
        this.repository = repository;
    }

    @RequestMapping(value = "/albumsslow", method = RequestMethod.GET)
    public String listProductsSlow(Model model) throws Exception
    {
        List<Album> albums = (List<Album>) repository.findAll();

        // Sleep for 6 seconds before returning to simulate slow page
        Thread.sleep(6000);

        model.addAttribute("albums", albums);
        model.addAttribute("countStr", String.format("Total of %s albums", albums.size()));
        return "albums";
    }

    @RequestMapping(value = "/albums", method = RequestMethod.GET)
    public String listProducts(Model model)
    {
        List<Album> albums = (List<Album>) repository.findAll();

        model.addAttribute("albums", albums);
        model.addAttribute("countStr", String.format("Total of %s albums", albums.size()));
        return "albums";
    }

    @RequestMapping(value = "/deletealbum", method = RequestMethod.GET)
    public String deleteAlbum(@RequestParam("id") String id, Model model)
    {
        repository.delete(id);
        String actionStr = String.format("Album [%s] successfully deleted", id);

        List<Album> albums = repository.findAll();

        model.addAttribute("actionStr", actionStr);
        model.addAttribute("albums", albums);
        model.addAttribute("countStr", String.format("Total of %s albums", albums.size()));
        return "albums";
    }

    @RequestMapping(value = "/addnew", method = RequestMethod.GET)
    public String addNewAlbum(Model model)
    {
        Album album = new Album();
        model.addAttribute("album", album);
        return "newalbum";
    }

    @RequestMapping(value = "/editalbum", method = RequestMethod.GET)
    public String editAlbum(@RequestParam(value="id", required=true) String id, Model model)
    {
        Album album = repository.findOne(id);
        model.addAttribute("album", album);
        return "editalbum";
    }

    @RequestMapping(value="/searchAlbums", method = RequestMethod.POST)
    public String searchAlbums(@RequestParam(value="title") String title, Model model)
    {
        List<Album> albums = repository.findByTitleContains(title);
        model.addAttribute("title", title);
        model.addAttribute("albums", albums);
        model.addAttribute("countStr", String.format("Total of %s albums", albums.size()));

        return "albums";
    }

    @RequestMapping(value="/addAlbum", method = RequestMethod.POST)
    public String addAlbum
    (@RequestParam(value="title") String title,
     @RequestParam(value="artist") String artist,
     @RequestParam(value="releaseYear") String releaseYear,
     Model model)
    {

        Album album = new Album(title, artist, releaseYear);
        repository.save(album);

        String actionStr = "Album successfully added";

        List<Album> albums = repository.findAll();
        model.addAttribute("actionStr", actionStr);
        model.addAttribute("albums", albums);
        model.addAttribute("countStr", String.format("Total of %s albums", albums.size()));

        return "albums";
    }

    @RequestMapping(value="/editAlbum", method = RequestMethod.POST)
    public String editAlbum
            (@RequestParam(value="title") String title,
             @RequestParam(value="artist") String artist,
             @RequestParam(value="releaseYear") String releaseYear,
             @RequestParam(value="id", required=true) String id,
             Model model)
    {

        Album album = new Album(title, artist, releaseYear);
        album.setId(id);
        repository.save(album);

        String actionStr = String.format("Album [%s] successfully edited", id);

        List<Album> albums = repository.findAll();
        model.addAttribute("actionStr", actionStr);
        model.addAttribute("albums", albums);
        model.addAttribute("countStr", String.format("Total of %s albums", albums.size()));

        return "albums";
    }
}
