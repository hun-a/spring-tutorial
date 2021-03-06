package io.huna.spring.config;

import io.huna.spring.sequence.PrefixGenerator;
import io.huna.spring.sequence.SequenceGenerator;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

import javax.annotation.Resource;

@Configuration
@Import(DatePrefixConfiguration.class)
public class SequenceConfiguration {

    private PrefixGenerator prefixGenerator;

    @Bean
    public SequenceGenerator getSequenceGenerator() {
        SequenceGenerator sequence = new SequenceGenerator();
        sequence.setSuffix("A");
        sequence.setInitial(100000);
        sequence.setPrefixGenerator(prefixGenerator);
        return sequence;
    }
}
