package pl.szuflicki.visits.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import pl.szuflicki.visits.domain.Visit;
import pl.szuflicki.visits.domain.VisitsInADay;

import java.util.List;

public interface VisitsRepository extends JpaRepository<Visit, Long> {

    @Query("SELECT new pl.szuflicki.visits.domain.VisitsInADay(date,  COUNT(id)) FROM Visit GROUP BY date ORDER BY date")
    List<VisitsInADay> getStatistics();
}
