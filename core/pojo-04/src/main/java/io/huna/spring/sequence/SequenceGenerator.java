package io.huna.spring.sequence;

import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

import java.util.concurrent.atomic.AtomicInteger;

@Setter
@NoArgsConstructor
public class SequenceGenerator {

    private PrefixGenerator prefixGenerator;

    private String suffix;

    private int initial;

    private final AtomicInteger counter = new AtomicInteger();

    @Autowired(required = false)
    @Qualifier("datePrefixGenerator")   // Indicate explicitly that the 'datePrefixGenerator' will be injected
    public void setPrefixGenerator(/*@Qualifier("datePrefixGenerator")*/ PrefixGenerator prefixGenerator) {
        this.prefixGenerator = prefixGenerator;
    }

    @Autowired(required = false)
    public void myOwnCustomInjectionName(PrefixGenerator prefixGenerator) {
        this.prefixGenerator = prefixGenerator;
    }

    public String getSequence() {
        StringBuilder builder = new StringBuilder();
        builder.append(prefixGenerator.getPrefix())
                .append(initial)
                .append(counter.getAndIncrement())
                .append(suffix);
        return builder.toString();
    }

}
