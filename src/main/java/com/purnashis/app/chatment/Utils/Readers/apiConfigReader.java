package com.purnashis.app.chatment.Utils.Readers;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

//@ConfigurationProperties(prefix = "myapp")
@Configuration("apiConfigReader")
public class apiConfigReader {
    @Value("${myapp.cat_api_url}")
    private String cat_api_url;

    @Value("${myapp.dog_api_url}")
    private String dog_api_url;

    public String getCat_api_url(){
        return this.cat_api_url;
    }

    public String getDog_api_url(){
        return this.dog_api_url;
    }
}
