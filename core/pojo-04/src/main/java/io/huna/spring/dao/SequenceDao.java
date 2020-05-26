package io.huna.spring.dao;

import io.huna.spring.domain.Sequence;

public interface SequenceDao {

    Sequence getSequence(String sequenceId);

    int getNextValue(String sequenceId);

}