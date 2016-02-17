package de.techjava.tf.sewage.bpm;

import javax.sql.DataSource;

import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.jdbc.DataSourceBuilder;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.transaction.PlatformTransactionManager;

import de.techjava.tf.sewage.bpm.delegate.IntervalTimer;
import de.techjava.tf.sewage.bpm.interval.IntervalService;

@Configuration
@EnableAutoConfiguration
//@EnableJpaRepositories(basePackageClasses = IntervalService.class, entityManagerFactoryRef = "intervalEMFactory", transactionManagerRef = "intervalTxManager")
@ComponentScan(basePackageClasses = IntervalTimer.class)
public class CamundaStarterConfiguration {

    @Bean
    @Primary
    @ConfigurationProperties(prefix = "bpm.datasource")
    public DataSource primaryDataSource() {
        return DataSourceBuilder.create().build();
    }

    @Bean
    @ConfigurationProperties(prefix = "interval.datasource")
    DataSource intervalDataSource() {
        return DataSourceBuilder.create().build();
    }

    @Bean
    PlatformTransactionManager intervalTxManager() {
        return new JpaTransactionManager(intervalEMFactory().getObject());
    }

    @Bean
    LocalContainerEntityManagerFactoryBean intervalEMFactory() {
        final HibernateJpaVendorAdapter jpaVendorAdapter = new HibernateJpaVendorAdapter();
        jpaVendorAdapter.setGenerateDdl(true);
        final LocalContainerEntityManagerFactoryBean factoryBean = new LocalContainerEntityManagerFactoryBean();
        factoryBean.setDataSource(intervalDataSource());
        factoryBean.setJpaVendorAdapter(jpaVendorAdapter);
        factoryBean.setPackagesToScan(IntervalService.class.getPackage().getName());
        return factoryBean;
    }
}
