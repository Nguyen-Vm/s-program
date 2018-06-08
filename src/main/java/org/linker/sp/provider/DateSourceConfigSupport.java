package org.linker.sp.provider;

import com.mchange.v2.c3p0.ComboPooledDataSource;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.springframework.context.annotation.Bean;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;

/**
 * @author RWM
 * @date 2018/6/8
 */
public abstract class DateSourceConfigSupport {

    private static final String url = "jdbc:mysql://localhost:3306/ds_sprograme?user=root&password=Ruochu123&useUnicode=true&characterEncoding=utf8&useSSL=false";
    private static final String mybatisConfigFilePath = "mybatis-config.xml";
    private static final String mapperPath = "classpath*:/mapper/**.xml";
    private static final String entityPackage = "org.linker.sp.entity";


    @Bean(name = "dataSource")
    public ComboPooledDataSource createDateSource() throws Exception {
        ComboPooledDataSource dataSource = new ComboPooledDataSource();
        dataSource.setDriverClass("com.mysql.jdbc.Driver");
        dataSource.setJdbcUrl(url);
        // 关闭连接后不自动commit
        dataSource.setAutoCommitOnClose(false);
        return dataSource;
    }

    @Bean(name = "sqlSessionFactory")
    public SqlSessionFactoryBean createSqlSessionFactoryBean() throws Exception {
        SqlSessionFactoryBean sqlSessionFactoryBean = new SqlSessionFactoryBean();
        sqlSessionFactoryBean.setConfigLocation(new ClassPathResource(mybatisConfigFilePath));
        PathMatchingResourcePatternResolver resolver = new PathMatchingResourcePatternResolver();
        sqlSessionFactoryBean.setMapperLocations(resolver.getResources(mapperPath));
        sqlSessionFactoryBean.setDataSource(createDateSource());
        sqlSessionFactoryBean.setTypeAliasesPackage(entityPackage);
        return sqlSessionFactoryBean;
    }
}
