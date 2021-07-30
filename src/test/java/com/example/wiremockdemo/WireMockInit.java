package com.example.wiremockdemo;


import com.github.tomakehurst.wiremock.WireMockServer;
import com.github.tomakehurst.wiremock.core.WireMockConfiguration;
import org.springframework.boot.test.util.TestPropertyValues;
import org.springframework.context.ApplicationContextInitializer;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.event.ContextClosedEvent;


public class WireMockInit implements ApplicationContextInitializer<ConfigurableApplicationContext> {


    @Override
    public void initialize(ConfigurableApplicationContext applicationContext) {
        WireMockServer wireMockServer = new WireMockServer(new WireMockConfiguration().dynamicPort());
        wireMockServer.start();
        applicationContext.addApplicationListener( applicationEvent ->
                {
                        if(applicationEvent instanceof ContextClosedEvent)
                        {
                            wireMockServer.stop();

                        }

                }

        );
        applicationContext.getBeanFactory().registerSingleton("wireMockServer", wireMockServer);
        TestPropertyValues.of("externalBaseUrl",wireMockServer.baseUrl())
                .applyTo(applicationContext);




    }


}
