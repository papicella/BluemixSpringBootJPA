package pas.cloud.webapp.controllers;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import pas.cloud.webapp.repositories.JpaAlbumRepository;

@Controller
public class WelcomeController
{
    private static final Logger logger = LoggerFactory.getLogger(AlbumController.class);
    private JpaAlbumRepository repository;

    @Autowired
    public WelcomeController(JpaAlbumRepository repository)
    {
        this.repository = repository;
    }

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String welcome(Model model)
    {
        model.addAttribute("count", repository.findAll().size());
        return "welcome";
    }

    @RequestMapping(value = "/killme", method = RequestMethod.GET)
    public String properties(Model model) throws Exception
    {
        Runtime.getRuntime().halt(-1);
        return "welcome";
    }

}
