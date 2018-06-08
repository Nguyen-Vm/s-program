package org.linker.sp.config.web;

import org.linker.foun.web.WebConfigureSupport;
import org.linker.sp.provider.DateSourceConfigSupport;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Configuration;

/**
 * @author RWM
 * @date 2018/6/7
 */
@Configuration
public class ApplicationConfiguration {

    @Configuration
    public static class WebConfigure extends WebConfigureSupport {

    }

    @Configuration
    @MapperScan("org.linker.sp.dao")
    public static class DataSourceConfiguration extends DateSourceConfigSupport {

    }
}
