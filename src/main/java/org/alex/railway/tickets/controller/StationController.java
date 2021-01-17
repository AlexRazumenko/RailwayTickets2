package org.alex.railway.tickets.controller;

import lombok.extern.slf4j.Slf4j;
import org.alex.railway.tickets.entity.Station;
import org.alex.railway.tickets.entity.User;
import org.alex.railway.tickets.entity.enums.RoleType;
import org.alex.railway.tickets.service.StationService;
import org.alex.railway.tickets.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

@Slf4j
@RestController
//@RequestMapping(value = "/")
@SessionAttributes(value = "currentUser")
public class StationController {

    private final UserService userService;
    private final StationService stationService;

    @Autowired
    public StationController(UserService userService, StationService stationService) {
        this.stationService = stationService;
        this.userService = userService;
    }

    @ModelAttribute("currentUser")
    public User createUser() {
        return new User(0L);
    }

    @GetMapping("/stationsPage")
    public ModelAndView stationsPage (@ModelAttribute("currentUser") User currentUser) {
        if (currentUser.getRole() != RoleType.ROLE_ADMIN)
            return new ModelAndView("index");
        ModelAndView modelAndView = new ModelAndView("stations");
        modelAndView.addObject("allStations", stationService.getAll());
        modelAndView.addObject("newStation", new Station());
        return modelAndView;
    }

    @PostMapping("/addStation")
    public String addStation (@ModelAttribute("newStation") Station station) {
        stationService.save(station);
        return "stations";
    }

    @PostMapping("/deleteStation")
    private String deleteStation (@ModelAttribute("deletedStation") Station station) {
        stationService.delete(station.getName());
        return "stations";
    }



}
