package com.example.aplicacionsoap.Configuracion;

import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.ClassPathResource;
import org.springframework.ws.config.annotation.EnableWs;
import org.springframework.ws.transport.http.MessageDispatcherServlet;
import org.springframework.ws.wsdl.wsdl11.DefaultWsdl11Definition;
import org.springframework.xml.xsd.SimpleXsdSchema;
import org.springframework.xml.xsd.XsdSchema;

@EnableWs
@Configuration
public class Configurar {

    @Bean
    public ServletRegistrationBean<MessageDispatcherServlet> mensaje(ApplicationContext ac){
        MessageDispatcherServlet ob= new MessageDispatcherServlet();
        ob.setApplicationContext(ac);
        ob.setTransformWsdlLocations(true);
        return new ServletRegistrationBean<>(ob, "/sw/*");
    }

    @Bean (name="producto")
    public DefaultWsdl11Definition definirservicios(XsdSchema esquema){
        DefaultWsdl11Definition ob= new DefaultWsdl11Definition();
        ob.setPortTypeName("ProductoPort");
        ob.setLocationUri("/sw");
        ob.setTargetNamespace("http://comercio.com/sw");
        ob.setSchema(esquema);
        return ob;
    }

    @Bean
    public XsdSchema esquema(){
        return new SimpleXsdSchema(new ClassPathResource("Esquema.xsd"));
    }

}
