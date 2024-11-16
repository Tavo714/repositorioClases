package com.example.receptorusuario2vmga.Conf;

import org.apache.activemq.ActiveMQConnectionFactory;
import org.springframework.beans.factory.annotation.Value; 
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jms.annotation.EnableJms;
import org.springframework.jms.config.DefaultJmsListenerContainerFactory;
import org.springframework.jms.connection.CachingConnectionFactory;
import org.springframework.jms.support.converter.MappingJackson2MessageConverter;
import org.springframework.jms.support.converter.MessageConverter;
import org.springframework.jms.support.converter.MessageType;

@Configuration
@EnableJms
public class ConfigurarJMS {

    @Value("tcp://localhost:61616") 
    private String broker;

    @Bean
    public DefaultJmsListenerContainerFactory contenedor(){
        DefaultJmsListenerContainerFactory ob=new DefaultJmsListenerContainerFactory();
        ob.setPubSubDomain(true);
        ob.setConnectionFactory(repositorio());
        ob.setMessageConverter(mjson());
        ob.setSubscriptionDurable(true);
        return ob;
    }

    @Bean
    public CachingConnectionFactory repositorio(){
        CachingConnectionFactory ob=new CachingConnectionFactory();
        ActiveMQConnectionFactory mq=new ActiveMQConnectionFactory();
        mq.setBrokerURL(broker);
        ob.setTargetConnectionFactory(mq);
        ob.setClientId("conecta2");
        return ob;
    }

    @Bean
    public MessageConverter mjson(){
        MappingJackson2MessageConverter ob=new MappingJackson2MessageConverter();
        ob.setTargetType(MessageType.TEXT);
        ob.setTypeIdPropertyName("_type");
        return ob;
    }

}