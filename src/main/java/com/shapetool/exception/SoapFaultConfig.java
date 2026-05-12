package com.shapetool.exception;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.ws.soap.server.endpoint.SoapFaultDefinition;
import org.springframework.ws.soap.server.endpoint.SoapFaultMappingExceptionResolver;
import org.springframework.ws.soap.SoapFault;
import org.springframework.ws.soap.SoapFaultDetail;
import org.springframework.ws.soap.SoapFaultDetailElement;

import javax.xml.namespace.QName;
import java.util.Properties;

/**
 * Configuration for SOAP Fault handling.
 * This class customizes how exceptions are converted to SOAP Faults.
 */
@Configuration
public class SoapFaultConfig {

    @Bean
    public SoapFaultMappingExceptionResolver exceptionResolver() {

        SoapFaultMappingExceptionResolver resolver = new SoapFaultMappingExceptionResolver() {
            @Override
            protected void customizeFault(Object endpoint, Exception ex, SoapFault fault) {
                if (ex instanceof ShapeValidationException) {
                    ShapeValidationException validationEx = (ShapeValidationException) ex;
                    
                    // Add detailed information to fault detail element
                    SoapFaultDetail detail = fault.addFaultDetail();
                    SoapFaultDetailElement fieldElement = detail.addFaultDetailElement(
                        new QName("http://www.shapetool.com/gen", "field")
                    );
                    fieldElement.addText(validationEx.getField());
                    
                    SoapFaultDetailElement messageElement = detail.addFaultDetailElement(
                        new QName("http://www.shapetool.com/gen", "errorMessage")
                    );
                    messageElement.addText(validationEx.getMessage());
                }
            }
        };

        // Map ShapeValidationException to CLIENT fault (client's fault, not server)
        Properties mappings = new Properties();
        mappings.setProperty(
                ShapeValidationException.class.getName(),
                SoapFaultDefinition.CLIENT.toString()
        );

        resolver.setExceptionMappings(mappings);

        // Default fault for unmapped exceptions
        SoapFaultDefinition defaultFault = new SoapFaultDefinition();
        defaultFault.setFaultCode(SoapFaultDefinition.SERVER);

        resolver.setDefaultFault(defaultFault);
        resolver.setOrder(1); // High priority

        return resolver;
    }
}
