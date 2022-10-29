package sumo.desktop_server.Vendors.SumoWebServer.Conectivity;

import org.apache.http.client.config.CookieSpecs;
import org.apache.http.client.config.RequestConfig;
import org.apache.http.impl.client.HttpClientBuilder;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.oxm.jaxb.Jaxb2Marshaller;
import org.springframework.ws.client.core.WebServiceMessageCallback;
import org.springframework.ws.client.core.WebServiceTemplate;
import org.springframework.ws.client.support.interceptor.ClientInterceptor;
import org.springframework.ws.soap.saaj.SaajSoapMessageFactory;
import org.springframework.ws.transport.http.HttpComponentsMessageSender;

import org.apache.http.client.HttpClient;
import sumo.desktop_server.Vendors.SumoWebServer.Schema.ObjectFactory;

@Configuration
public class SumoWebServerConfig {

//    @Bean
//    SumoWebServerConnector sumoWebServerConnector(WebServiceMessageCallback sumoWebServerTokenAdder, WebServiceTemplate webServiceTemplate) {
//        return new SumoWebServerConnector(webServiceTemplate, sumoWebServerTokenAdder);
//    }

    @Bean
    WebServiceMessageCallback tokenizerSoapHeadersFactory() {
        return new TokenizerSoapHeadersFactory();
    }

    @Bean
    public Jaxb2Marshaller sumoServerMarshaller() {
        Jaxb2Marshaller marshaller = new Jaxb2Marshaller();
        marshaller.setContextPaths(ObjectFactory.class.getPackage().getName());
        return marshaller;
    }

    @Bean
    public WebServiceTemplate webServiceTemplate() {
//        WebServiceTemplate webServiceTemplate = new WebServiceTemplate();
//        webServiceTemplate.setMarshaller(sumoServerMarshaller);
//        webServiceTemplate.setUnmarshaller(sumoServerMarshaller);
//        webServiceTemplate.setMessageSender(tokenizerProxiedMessageSender(sumoServerHttpClient));
//        webServiceTemplate.setDefaultUri("http://localhost:8090/api/login");
//        webServiceTemplate.setMessageFactory();

        //        Jaxb2Marshaller jaxb2Marshaller = new Jaxb2Marshaller();
////        jaxb2Marshaller.setClassesToBeBound(UserIdRequest.class, UserResponse.class, User.class);
//        webServiceTemplate.setMarshaller(jaxb2Marshaller);
//        webServiceTemplate.setUnmarshaller(jaxb2Marshaller);

        return new WebServiceTemplate();
    }

    @Bean
    public HttpComponentsMessageSender tokenizerProxiedMessageSender(HttpClient sumoServerHttpClient) {
        HttpComponentsMessageSender httpComponentsMessageSender = new HttpComponentsMessageSender();
        httpComponentsMessageSender.setHttpClient(sumoServerHttpClient);
        httpComponentsMessageSender
        return httpComponentsMessageSender;
    }

    @Bean
    public HttpClient sumoServerHttpClient() {
        return HttpClientBuilder
            .create()
            .setDefaultRequestConfig(RequestConfig
                .custom()
                .setCookieSpec(CookieSpecs.IGNORE_COOKIES)
                .build())
            .disableCookieManagement()
            .addInterceptorFirst(new HttpComponentsMessageSender.RemoveSoapHeadersInterceptor())
            .build();
    }

}
