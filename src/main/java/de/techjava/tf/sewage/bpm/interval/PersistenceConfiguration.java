package de.techjava.tf.sewage.bpm.interval;

import javax.sql.DataSource;

import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.jdbc.DataSourceBuilder;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Primary;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@EnableAutoConfiguration
@EnableJpaRepositories
public class PersistenceConfiguration {

    @Bean
    @Primary
    @ConfigurationProperties(prefix = "bpm.datasource")
    public DataSource primaryDataSource() {
        return DataSourceBuilder.create().build();
    }
}
