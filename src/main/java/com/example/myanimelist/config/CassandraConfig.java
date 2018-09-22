package com.example.myanimelist.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.cassandra.config.AbstractCassandraConfiguration;
import org.springframework.data.cassandra.config.CassandraClusterFactoryBean;
import org.springframework.data.cassandra.config.SchemaAction;
import org.springframework.data.cassandra.core.mapping.CassandraMappingContext;
import org.springframework.data.cassandra.repository.config.EnableCassandraRepositories;

import java.util.Arrays;
import java.util.List;

@Configuration
@EnableCassandraRepositories(basePackages = "com.example.myanimelist.repository")
public class CassandraConfig extends AbstractCassandraConfiguration {

    private static final String KEYSPACE = "myanimelist";

    @Override
    protected String getKeyspaceName() {
        return KEYSPACE;
    }


    @Override
    public SchemaAction getSchemaAction() {
        return SchemaAction.CREATE_IF_NOT_EXISTS;
    }

    @Override
    public String[] getEntityBasePackages() {
        return new String[]{"com.example.myanimelist"};
    }

    @Bean
    public CassandraClusterFactoryBean cluster() {
        return new CassandraClusterFactoryBean() {{
            setContactPoints("127.0.0.1");
            setPort(9042);
        }};
    }

    @Override
    protected List<String> getStartupScripts() {
        final String script =
                "CREATE KEYSPACE IF NOT EXISTS "
                        + KEYSPACE
                        + " WITH durable_writes = true"
                        + " AND replication = {'class' : 'SimpleStrategy', 'replication_factor' : 1};";
        return Arrays.asList(script);
    }

    @Bean
    public CassandraMappingContext cassandraMappingContext() {
        return new CassandraMappingContext();
    }
}