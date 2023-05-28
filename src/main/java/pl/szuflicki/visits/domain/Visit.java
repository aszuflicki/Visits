package pl.szuflicki.visits.domain;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.time.LocalDate;

@Entity
public class Visit {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;

    @Basic
    @NotNull
    private LocalDate date;
    @Basic(optional = false)
    @NotNull
    private String ip;

    public Visit(LocalDate date, String ip) {
        this.date = date;
        this.ip = ip;
    }

    public Long getId() {
        return id;
    }

    public LocalDate getDate() {
        return date;
    }

    public String getIp() {
        return ip;
    }
}
