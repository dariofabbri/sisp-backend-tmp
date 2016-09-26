package it.corteconti.sisp.sample.config;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.sql.DataSource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.autoconfigure.jdbc.DataSourceBuilder;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.Database;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@Configuration
@EnableTransactionManagement
@EnableJpaRepositories(
        entityManagerFactoryRef = "entityManagerFactory",
        transactionManagerRef = "transactionManager",
        basePackages = {"it.corteconti.sisp.sample.dao"})
public class DataConfiguration {
	
	private static final Logger LOG = LoggerFactory.getLogger(DataConfiguration.class);
	
	@Value("${application.data.showSql}")
	private boolean showSql;
	
    @Bean
    @ConfigurationProperties(prefix="datasource.relational")
    public DataSource getDataSource() {
    	
    	LOG.debug("Configurazione del data source.");
    	return DataSourceBuilder.create().build();
    }

    @Bean(name = "entityManager")
    public EntityManager entityManager() {
    	
    	LOG.debug("Creazione dell'entity manager.");
        return entityManagerFactory().createEntityManager();
    }

    @Primary
    @Bean(name = "entityManagerFactory")
    public EntityManagerFactory entityManagerFactory() {

    	LOG.debug("Configurazione del JPA vendor adapter.");
		HibernateJpaVendorAdapter vendorAdapter = new HibernateJpaVendorAdapter();
		vendorAdapter.setGenerateDdl(false);
		vendorAdapter.setShowSql(showSql);
		vendorAdapter.setDatabase(Database.SQL_SERVER);

    	LOG.debug("Configurazione dell'entity manager factory.");
		LocalContainerEntityManagerFactoryBean factory = new LocalContainerEntityManagerFactoryBean();
		factory.setJpaVendorAdapter(vendorAdapter);
		factory.setPackagesToScan("it.corteconti.sisp.sample.model");
		factory.setDataSource(getDataSource());
		factory.afterPropertiesSet();

		return factory.getObject();
    }

    @Bean(name = "transactionManager")
    public PlatformTransactionManager transactionManager() {

    	LOG.debug("Configurazione del transaction manager.");
		JpaTransactionManager txManager = new JpaTransactionManager();
		txManager.setEntityManagerFactory(entityManagerFactory());
		return txManager;
    }
}