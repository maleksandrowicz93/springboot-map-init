package com.github.maleksandrowicz93.springbootmapinit;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class MapController {

    @GetMapping
    public String getMap(Model model) {
        model.addAttribute("point", new Point(51.11, 17.08, "Hello everybody!"));
        return "map";
    }

}
