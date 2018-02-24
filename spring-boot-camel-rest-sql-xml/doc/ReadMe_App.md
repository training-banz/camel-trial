# アプリケーションの構成

ディレクトリ構成


設定ファイル(src/main/resources配下)

* application.yml
* schema.sql

設定ファイル(src/main/fabric8配下)

* deployment.yml
* route.yml

※ログ設定ファイル および 指定しなかった場合のデフォルトの挙動

使用ポート

* 8080 アプリ用
* 8081 管理用

ビルド方法



実行方法

実行もMaven起動構成を用いて行う

ローカルPCで実行

# 確認用URL


	http://localhost:8080/camel-rest-sql-xml/books
	http://localhost:8080/camel-rest-sql-xml/books/order/3
	http://localhost:8080/camel-rest-sql-xml/api-doc
	http://localhost:8080/webjars/swagger-ui/index.html?url=/camel-rest-sql-xml/api-doc/swagger.json&validatorUrl=
	http://localhost:8080/swagger-ui/

	http://localhost:8081/health
	
	
	http://spring-boot-camel-rest-sql-xml-akohno-test1.7e14.starter-us-west-2.openshiftapps.com/camel-rest-sql-xml/books
	http://spring-boot-camel-rest-sql-xml-akohno-test1.7e14.starter-us-west-2.openshiftapps.com/camel-rest-sql-xml/books/order/3
	http://spring-boot-camel-rest-sql-xml-akohno-test1.7e14.starter-us-west-2.openshiftapps.com/camel-rest-sql-xml/api-doc
	http://spring-boot-camel-rest-sql-xml-akohno-test1.7e14.starter-us-west-2.openshiftapps.com/webjars/swagger-ui/index.html?url=/camel-rest-sql-xml/api-doc/swagger.json&validatorUrl=
	http://spring-boot-camel-rest-sql-xml-akohno-test1.7e14.starter-us-west-2.openshiftapps.com/swagger-ui

# TODO

* swagger-uiの組み込み(webpack)
* spring dslによるREST定義
* Mavenアーキタイプ(ひな型の作成)

# 参考

	Remote Fetch URL	https://github.com/fabric8-quickstarts/spring-boot-camel-rest-sql.git


 The following service(s) have been created in your project: mysql.
     
            Username: user81H
            Password: XXXXXXXXX
       Database Name: sampledb
      Connection URL: mysql://mysql:3306/

	akohnomininoMacBook-puro:bin akohnomini$ oc get route
	NAME      HOST/PORT                                                     PATH      SERVICES   PORT      TERMINATION   WILDCARD
	mysql     mysql-akohno-test1.7e14.starter-us-west-2.openshiftapps.com             mysql      mysql                   None




	-Dfabric8.deploy.createExternalUrls=true 
	
ocコマンド

	oc login https://console.starter-us-west-2.openshift.com
	oc get pods -w

	