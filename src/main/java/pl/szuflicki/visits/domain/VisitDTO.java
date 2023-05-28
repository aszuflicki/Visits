package pl.szuflicki.visits.domain;

import io.swagger.annotations.ApiModelProperty;
import org.springframework.validation.annotation.Validated;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import java.time.LocalDate;

public class VisitDTO {
    @ApiModelProperty(notes = "Date of visit", example = "2023-05-28", required = true)
    @NotNull(message = "Missing date field")
    private LocalDate date;
    @ApiModelProperty(notes = "IP", example = "212.158.1.38", required = true)
    @NotNull(message = "Missing IP field")
    @Pattern(regexp = "^(?!0)(?!.*\\.$)((1?\\d?\\d|25[0-5]|2[0-4]\\d)(\\.|$)){4}$",
    message = "Incorrect format of IP address")
    private String ip;

    public LocalDate getDate() {
        return date;
    }

    public String getIp() {
        return ip;
    }
}
