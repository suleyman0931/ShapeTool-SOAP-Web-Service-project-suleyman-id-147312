package ShapeTool.ShapeTool;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ApplicationContext;
import org.springframework.ws.wsdl.wsdl11.Wsdl11Definition;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
class ShapeToolApplicationTests {

    @Autowired
    private ApplicationContext context;

    @Test
    void contextLoads() {
    }

    @Test
    void wsdlBeanIsPresent() {
        assertThat(context.containsBean("calculator")).isTrue();
        Object wsdlBean = context.getBean("calculator");
        assertThat(wsdlBean).isInstanceOf(Wsdl11Definition.class);
    }

}
