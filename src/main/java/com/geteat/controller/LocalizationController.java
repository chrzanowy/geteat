package com.geteat.controller;

import com.geteat.dto.LocalizationDto;
import com.geteat.dto.ShortLocationDto;
import com.geteat.service.LocalizationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by Kuba on 2017-03-22.
 */
@RestController
public class LocalizationController {

    @Autowired
    private LocalizationService localizationService;

    @RequestMapping(value = "/localization", method = RequestMethod.GET)
    public ShortLocationDto getLocalization(@RequestParam("latitude") String latitude, @RequestParam("longitude") String longitude) {
        LocalizationDto localizationForLatitudeAndLongitude = localizationService.getLocalizationForLatitudeAndLongitude(latitude, longitude);
        return new ShortLocationDto(localizationForLatitudeAndLongitude);
    }


    @RequestMapping("/")
    public String welcome() {
        return "welcome";
    }

}
