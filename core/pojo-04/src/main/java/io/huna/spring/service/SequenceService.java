package io.huna.spring.service;

import io.huna.spring.dao.SequenceDao;
import io.huna.spring.domain.Sequence;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import org.springframework.stereotype.Component;

@Setter
@Component
@RequiredArgsConstructor
public class SequenceService {

    // @Autowired is defined as implicit
    private final SequenceDao sequenceDao;

    public String generate(String sequenceId) {
        Sequence sequence = sequenceDao.getSequence(sequenceId);
        int value = sequenceDao.getNextValue(sequenceId);
        return sequence.getPrefix() + value + sequence.getPrefix();
    }

}
