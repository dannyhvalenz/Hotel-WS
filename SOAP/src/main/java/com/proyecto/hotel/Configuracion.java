package com.proyecto.hotel;

import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.ws.config.annotation.EnableWs;
import org.springframework.ws.config.annotation.WsConfigurerAdapter;
import org.springframework.ws.transport.http.MessageDispatcherServlet;
import org.springframework.ws.wsdl.wsdl11.DefaultWsdl11Definition;
import org.springframework.xml.xsd.SimpleXsdSchema;
import org.springframework.xml.xsd.XsdSchema;
import org.springframework.core.io.ClassPathResource;

@EnableWs
@Configuration
@ComponentScan
public class Configuracion extends WsConfigurerAdapter {

	@Bean
	public ServletRegistrationBean messageDispatcherServlet(ApplicationContext applicationContext) {
		MessageDispatcherServlet servlet = new MessageDispatcherServlet();
		servlet.setApplicationContext(applicationContext);
		servlet.setTransformWsdlLocations(true);
		return new ServletRegistrationBean(servlet, "/*");
	}

	@Bean(name = "hotel")
	public DefaultWsdl11Definition defaultWsdl11Definition(XsdSchema hotelSchema) {
		DefaultWsdl11Definition wsdl11Definition = new DefaultWsdl11Definition();
		wsdl11Definition.setPortTypeName("hotelPort");
		wsdl11Definition.setLocationUri("/hotel");
		wsdl11Definition.setTargetNamespace("http://proyectoSW.com/Hotel");
		wsdl11Definition.setSchema(hotelSchema);
		return wsdl11Definition;
	}

	@Bean
	public XsdSchema hotelSchema() {
		return new SimpleXsdSchema(new ClassPathResource("Hotel.xsd"));
	}

}

