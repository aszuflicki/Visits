package pl.szuflicki.visits.controler;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.support.DefaultMessageSourceResolvable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.*;
import pl.szuflicki.visits.domain.Visit;
import pl.szuflicki.visits.domain.VisitDTO;
import pl.szuflicki.visits.domain.VisitsInADay;
import pl.szuflicki.visits.service.VisitsService;

import javax.validation.ConstraintViolationException;
import javax.validation.Valid;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;

@RestController
@RequestMapping("/api/visit")
@Validated
public class VisitsControler {

    @Autowired
    private VisitsService visitsService;

    @PostMapping()
    @ApiOperation(value = "Register visit to a webiste", notes = "Returns a id of a visit")
    @ApiResponses(value = {
            @ApiResponse(code = 201, message = "Successfully added"),
            @ApiResponse(code = 400, message = "There was an issue with input data")
    })
    public ResponseEntity<Visit> registerVisit(@Valid @RequestBody VisitDTO newVisit) throws URISyntaxException {
        var savedVisit =  visitsService.registerVisit(newVisit);
        return ResponseEntity.created(new URI("/" + savedVisit.getId())).build();
    }

    @GetMapping("/statistics")
    @ApiOperation(value = "Register visit to a webiste", notes = "Returns a id of a visit")
    @ApiResponses(value = {
            @ApiResponse(code = 201, message = "Successfully added"),
            @ApiResponse(code = 400, message = "There was an issue with input data")
    })
    public List<VisitsInADay> getStats() {
         return visitsService.getStatistics();
    }

    @PostMapping("*")
    public String xd() {
        return "xd";
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    ResponseEntity<String> handleConstraintViolationException(MethodArgumentNotValidException e) {
        var list = e.getFieldErrors().stream().map(DefaultMessageSourceResolvable::getDefaultMessage).toList();
        return new ResponseEntity<>("not valid due to validation error(s): " + list, HttpStatus.BAD_REQUEST);
    }
}
