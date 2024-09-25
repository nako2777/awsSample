### # application.ymlで必要の変数を設定するまたはdocker fileから注入する

#### # application.ymlでRDSの変数は正しく設定しないとき、AwsStudySampleBendApplication.javaで下記のアノテーションを付けてください

@SpringBootApplication(exclude = { DataSourceAutoConfiguration.class})

###### 