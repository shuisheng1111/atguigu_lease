package com.atguigu.lease.common.MinioConfig;

import io.minio.MinioClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationPropertiesScan;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.security.spec.EdDSAParameterSpec;

@Configuration
@EnableConfigurationProperties(MinioProperties.class)
//@ConfigurationPropertiesScan("com.atguigu.lease.common.MinioConfig")
public class MinioConfiguration {

    // 手动读取yaml配置文件中的endpoint属性值
    @Value("${minio.endpoint}")
    String endpoint;

    // 创建配置文件类MinioProperties，并使用@ConfigurationProperties注解绑定配置文件中的属性
    @Autowired
    MinioProperties minioProperties;

    @Bean
    public MinioClient minioClient() {
        return MinioClient
                .builder()
                .endpoint(endpoint)
                .credentials(minioProperties.getAccessKey(), minioProperties.getSecretKey())
                .build();
    }
}
