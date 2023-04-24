package com.spread.libserver.config;

import com.baomidou.mybatisplus.extension.plugins.MybatisPlusInterceptor;
import com.baomidou.mybatisplus.extension.plugins.inner.PaginationInnerInterceptor;
import org.mybatis.spring.batch.MyBatisBatchItemWriter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class MpConfig {
    public MpConfig() {
    }

    @Bean
    public MybatisPlusInterceptor mpInterceeptor(){
        MybatisPlusInterceptor mpInterceeptor = new MybatisPlusInterceptor();

        mpInterceeptor.addInnerInterceptor(new PaginationInnerInterceptor());
        return mpInterceeptor;
    }


}
