package com.example.demo.config;

import com.example.demo.bean.User;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * 告诉springboot这是一个配置类 == 配置文件 加载bean里面就是给容器注册组件了
 * 配置类本身也是组件
 * proxyBeanMethods 是不是代理bean的方法
 * 保持组件单实例
 * 组件依赖
 */
@Configuration(proxyBeanMethods = true)
public class MyConfig {

    //给容器中添加组件。以方法名作为组件ID,返回类型就是组件类型，返回的值就是组件在容器中的实例

    /**
     * 外部无论对配置类中的这个组件的注册方法调用多少遍都是
     * @return
     */
    @Bean
    public User user01(){
        return new User("张三",18);
    }

    public User user02(){
        return new User("李四",26);
    }

}
