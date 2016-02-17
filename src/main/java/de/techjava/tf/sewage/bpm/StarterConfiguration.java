package de.techjava.tf.sewage.bpm;

import javax.sql.DataSource;

import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.jdbc.DataSourceBuilder;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

@Configuration
@EnableAutoConfiguration
public class StarterConfiguration {

    @Bean
    @Primary
    @ConfigurationProperties(prefix = "bpm.datasource")
    public DataSource primaryDataSource() {
        return DataSourceBuilder.create().build();
    }
}
