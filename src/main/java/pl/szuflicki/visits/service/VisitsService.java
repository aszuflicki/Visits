package pl.szuflicki.visits.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import pl.szuflicki.visits.config.ResourceException;
import pl.szuflicki.visits.domain.Visit;
import pl.szuflicki.visits.domain.VisitDTO;
import pl.szuflicki.visits.domain.VisitsInADay;
import pl.szuflicki.visits.repository.VisitsRepository;

import java.util.List;
import java.util.regex.Pattern;

@Service
public class VisitsService {
    private VisitsRepository visitsRepository;
    @Autowired
    public VisitsService(VisitsRepository visitsRepository) {
        this.visitsRepository = visitsRepository;
    }

    public Visit registerVisit(VisitDTO visit) {
        return visitsRepository.save(new Visit(visit.getDate(), visit.getIp()));
    }

    public List<VisitsInADay> getStatistics() {
        return visitsRepository.getStatistics();
    }
}
