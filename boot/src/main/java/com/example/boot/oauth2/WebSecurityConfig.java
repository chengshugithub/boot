package com.example.boot.oauth2;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.annotation.Order;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

/**
 * spring security配置<br>
 * Order -> 指定优先级别  值越低，优先级越高。值越高，优先级越低<br>
 * EnableGlobalMethodSecurity 启用全局方法安全，启用pre注解
 * @author 淮南King
 */
@Configuration
@Order(10)
@EnableGlobalMethodSecurity(securedEnabled = true, prePostEnabled = true)
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

    /**
     * 密码编码器
     */
    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    /**
     * 认证管理器
     * @return
     * @throws Exception
     */
    @Bean
    @Override
    public AuthenticationManager authenticationManagerBean() throws Exception {
        return super.authenticationManagerBean();
    }
    /**
     * 安全拦截机制
     * @param http
     * @throws Exception
     */
    @Override
    protected void configure(HttpSecurity http) throws Exception {
        //关闭跨域伪造请求拦截
        http.csrf().disable();
        //开启授权配置
        http.authorizeRequests()
                //允许访问授权接口
                .antMatchers("/login/**","/oauth/**").permitAll()
                //其他所有请求直接放行，权限验证在资源服务器中进行
                .anyRequest().permitAll();
        //允许表单登录
        http.formLogin().permitAll();
    }
}

