Clashing Spring Property Placeholders with Camels Simple Language
Take notice when using Spring bridging placeholder then the spring ${} syntax clashes with the Simple in Camel, and therefore take care.

Example:

xml<setHeader headerName="Exchange.FILE_NAME"> <simple>{{file.rootdir}}/${in.header.CamelFileName}</simple> </setHeader>
clashes with Spring property placeholders, and you should use $simple{} to indicate using the Simple language in Camel.

xml<setHeader headerName="Exchange.FILE_NAME"> <simple>{{file.rootdir}}/$simple{in.header.CamelFileName}</simple> </setHeader>
An alternative is to configure the PropertyPlaceholderConfigurer with ignoreUnresolvablePlaceholders option to true.


http://camel.apache.org/using-propertyplaceholder.html


# Swagger ui

	http://localhost:8080/webjars/swagger-ui/index.html?url=/camel-rest-sql-xml/api-doc/swagger.json&validatorUrl=
	todo swagger-uiも8080をリッスンできるようにする->済

Swagger-UIのURLをシンプルにするため、Redirect機能追加

	http://localhost:8080/swagger

	#http://localhost:8080/webjars/swagger-ui/index.html?url=/api/swagger&validatorUrl=
	#/camel-rest-sql-xml/api-doc/swagger.json
	
see also

	https://medium.com/@bszeti/swagger-with-spring-boot-and-camel-ac59cca9556e
	
# Compatibility

Compatibility
The OpenAPI Specification has undergone 5 revisions since initial creation in 2010. Compatibility between swagger-ui and the OpenAPI Specification is as follows:

	Swagger UI Version	Release Date	OpenAPI Spec compatibility	Notes
	3.11.0	2018-02-09	2.0, 3.0	tag v3.11.0
	3.0.21	2017-07-26	2.0	tag v3.0.21
	2.2.10	2017-01-04	1.1, 1.2, 2.0	tag v2.2.10
	2.1.5	2016-07-20	1.1, 1.2, 2.0	tag v2.1.5
	2.0.24	2014-09-12	1.1, 1.2	tag v2.0.24
	1.0.13	2013-03-08	1.1, 1.2	tag v1.0.13
	1.0.1	2011-10-11	1.0, 1.1
	
see also
	
	https://github.com/swagger-api/swagger-ui
	
	https://mvnrepository.com/artifact/org.webjars/swagger-ui