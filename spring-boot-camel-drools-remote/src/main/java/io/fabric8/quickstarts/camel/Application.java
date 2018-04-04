/*
 * Copyright 2005-2016 Red Hat, Inc.
 *
 * Red Hat licenses this file to you under the Apache License, version
 * 2.0 (the "License"); you may not use this file except in compliance
 * with the License.  You may obtain a copy of the License at
 *
 *    http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or
 * implied.  See the License for the specific language governing
 * permissions and limitations under the License.
 */
package io.fabric8.quickstarts.camel;

import org.apache.camel.builder.RouteBuilder;
//import org.apache.camel.component.servlet.CamelHttpTransportServlet;
//import org.apache.camel.model.rest.RestBindingMode;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
//import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.boot.web.support.SpringBootServletInitializer;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.ImportResource;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.ImportResource;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@SpringBootApplication
//load regular Spring XML file from the classpath that contains the Camel XML DSL
@ImportResource({"classpath:spring/camel-context.xml"})
public class Application extends SpringBootServletInitializer {

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }

    @Component
    class Backend extends RouteBuilder {

        @Override
        public void configure() {
            // A first route generates some orders and queue them in DB
            from("timer:new-order?delay=1s&period={{quickstart.generateOrderPeriod:60s}}")
                .routeId("generate-order")
                .bean("orderService", "generateOrder")
                .to("sql:insert into orders (id, item, amount, description, processed) values " +
                    "(:#${body.id} , :#${body.item}, :#${body.amount}, :#${body.description}, false)?" +
                    "dataSource=dataSource")
                .log("Inserted new order ${body.id}");

            // A second route polls the DB for new orders and processes them
            from("sql:select * from orders where processed = false?" +
                "consumer.onConsume=update orders set processed = true where id = :#id&" +
                "consumer.delay={{quickstart.processOrderPeriod:60s}}&" +
                "dataSource=dataSource")
                .routeId("process-order")
                .bean("orderService", "rowToOrder")
                .log("Processed order #id ${body.id} with ${body.amount} copies of the «${body.description}» book");
        }
    }
    
    @Configuration
    public class SwaggerUiConfiguratrion {
        @Controller
        class SwaggerWelcome {
            @RequestMapping("/swagger-ui")
            public String redirectToUi() {
                return "redirect:/webjars/swagger-ui/index.html?url=/camel-rest-sql-xml/api-doc/swagger.json&validatorUrl=";
            }
        }
    }
}