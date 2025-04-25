package wiki.chenxun.ai.code.review.boot.config;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.info.License;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author: chenxun
 * @date: 2025/4/24
 * @version: 1.0
 * @desc
 **/
@Configuration
public class SwaggerConfig {

    @Bean
    public OpenAPI createRestApi() {
        return new OpenAPI()
                .info(new Info().title("ai code review")
                        .description("ai代码检查")
                        .version("v1")
                        .license(new License().name("MIT").url("https://example.com/license")));
    }



}

