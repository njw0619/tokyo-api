package com.peter.bookstoreapi.config

import org.springframework.beans.factory.annotation.Qualifier
import org.springframework.boot.context.properties.ConfigurationProperties
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.data.jpa.repository.config.EnableJpaAuditing
import org.springframework.data.jpa.repository.config.EnableJpaRepositories
import org.springframework.data.repository.config.BootstrapMode
import org.springframework.orm.jpa.AbstractEntityManagerFactoryBean
import org.springframework.orm.jpa.JpaTransactionManager
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter
import org.springframework.transaction.PlatformTransactionManager
import org.springframework.transaction.annotation.EnableTransactionManagement
import java.util.*
import javax.persistence.EntityManagerFactory
import javax.sql.DataSource

@Configuration
@EnableJpaAuditing
@EnableTransactionManagement
class JPAConfig (){
    @Configuration
    @EnableJpaRepositories(
        basePackages = ["com.peter.bookstoreapi.repository"],
        entityManagerFactoryRef = "entityManagementFactory",
        transactionManagerRef = "transactionManager",
        bootstrapMode = BootstrapMode.LAZY
    )
    @ConfigurationProperties(prefix="spring.jpa")
    internal class PeterStoreJPAConfig() {
        lateinit var properties: Properties

        @Bean
        fun entityManagementFactory(@Qualifier("dataSource") dataSource: DataSource): AbstractEntityManagerFactoryBean {
            return LocalContainerEntityManagerFactoryBean().apply {
                this.dataSource = dataSource
                this.jpaVendorAdapter = HibernateJpaVendorAdapter()
                this.setPackagesToScan("com.peter.bookstoreapi.entity")
            }
        }

        @Bean
        fun transactionManager(entityManagementFactory: EntityManagerFactory): PlatformTransactionManager {
            return JpaTransactionManager().apply {
                this.entityManagerFactory = entityManagerFactory
                this.setJpaProperties(properties)
            }
        }
    }
}