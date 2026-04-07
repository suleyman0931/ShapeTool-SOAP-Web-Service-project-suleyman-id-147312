package ShapeTool.ShapeTool;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages = {"ShapeTool.ShapeTool", "com.shapetool"})
public class ShapeToolApplication {

	public static void main(String[] args) {
		SpringApplication.run(ShapeToolApplication.class, args);
	}

}
