package pl.szuflicki.visits.domain;

import java.time.LocalDate;

public record VisitsInADay(LocalDate date, Long count) {
}
