package com.example.demo;

import com.example.demo.bean.User;
import com.example.demo.config.MyConfig;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication
public class DemoApplication {

    public static void main(String[] args) {
        //返回了IOC的容器
        ConfigurableApplicationContext run = SpringApplication.run(DemoApplication.class, args);
        //查看内容器里的组件
        String[] beanDefinitionNames = run.getBeanDefinitionNames();
        System.out.println("111");
        for (String beanDefinitionName : beanDefinitionNames) {
            System.out.println(beanDefinitionName);
        }

        //那么意味着这里是一个单例模式
        User user01 = run.getBean("user01", User.class);
        User user02 = run.getBean("user01", User.class);
        User user03 = run.getBean("user01", User.class);
        System.out.println(user01==user03);

        MyConfig bean = run.getBean(MyConfig.class);
        User user1 = bean.user01();
        User user2 = bean.user01();
        System.out.println(user1==user2);

        User user3 = bean.user02();
        User user4 = bean.user02();
        System.out.println(user3==user4);



    }

}
