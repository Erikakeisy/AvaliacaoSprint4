package LojaCadastro.Swagger;


import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import LojaCadastro.Modelo.Cliente;
import springfox.documentation.builders.ParameterBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.schema.ModelRef;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;


import java.util.Arrays;

@Configuration
@EnableSwagger2
public class SwaggerConfiguracao {
	
	@Bean
	public Docket api()  
	{return new Docket(DocumentationType.SWAGGER_2).select().apis(RequestHandlerSelectors.basePackage("LojaCadastro"))//.paths(regex("/api.*")).build();}
	 .paths(PathSelectors.any())
	 .build()
	 .ignoredParameterTypes(Cliente.class)
     .globalOperationParameters(Arrays.asList(
             new ParameterBuilder()
                     .name("Authorization")
                     .description("Header para usar TOKEN")
                     .modelRef(new ModelRef("string"))
                     .parameterType("header")
                     .required(false)
                     .build()
     ));
				
					
}
}
