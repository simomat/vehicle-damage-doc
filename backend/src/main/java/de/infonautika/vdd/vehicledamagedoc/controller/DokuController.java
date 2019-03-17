package de.infonautika.vdd.vehicledamagedoc.controller;

import de.infonautika.vdd.vehicledamagedoc.domain.Doku;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import static org.springframework.http.HttpStatus.OK;

@RestController
@RequestMapping(value = "/api/v1", consumes = {MediaType.APPLICATION_JSON_VALUE})
public class DokuController {


    @PostMapping(value = "/vehicles")
    @ResponseStatus(OK)
    public void receiveDoku(@RequestBody Doku doku) {
        System.out.println(doku.toString());
    }

}
