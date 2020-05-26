package io.huna.spring.sequence;

import lombok.Setter;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import javax.inject.Inject;
import java.util.concurrent.atomic.AtomicInteger;

@Setter
@Component
public class SequenceGenerator {

//    @Resource
    @Inject
    private PrefixGenerator prefixGenerator;

    private String suffix;

    private int initial;

    private final AtomicInteger counter = new AtomicInteger();

    public String getSequence() {
        StringBuilder builder = new StringBuilder();
        builder.append(prefixGenerator.getPrefix())
                .append(initial)
                .append(counter.getAndIncrement())
                .append(suffix);
        return builder.toString();
    }

}
