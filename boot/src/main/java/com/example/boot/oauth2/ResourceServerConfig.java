package com.example.boot.oauth2;


import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.annotation.Order;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableResourceServer;
import org.springframework.security.oauth2.config.annotation.web.configuration.ResourceServerConfigurerAdapter;
import org.springframework.security.oauth2.config.annotation.web.configurers.ResourceServerSecurityConfigurer;
import org.springframework.security.oauth2.provider.error.OAuth2AccessDeniedHandler;
import org.springframework.security.oauth2.provider.token.RemoteTokenServices;
import org.springframework.security.oauth2.provider.token.ResourceServerTokenServices;

/**
 * 资源服务器
 *
 * @author 淮南King
 * @date 2020-08-04
 */
@Configuration
@Order(2)
@EnableResourceServer
public class ResourceServerConfig extends ResourceServerConfigurerAdapter {

    public static final String RESOURCE_ID = "res1";

    /**
     * 资源服务令牌解析服务
     * @return
     */
    @Bean
    public ResourceServerTokenServices resourceTokenService() {
        //使用远程服务请求授权服务器校验token,必须指定校验token 的url、client_id，client_secret
        RemoteTokenServices service=new RemoteTokenServices();
        service.setCheckTokenEndpointUrl("http://localhost:8081/oauth/check_token");
        service.setClientId("c1");
        service.setClientSecret("secret");
        return service;
    }

    @Override
    public void configure(ResourceServerSecurityConfigurer resources) {
        resources.resourceId(RESOURCE_ID)
                .tokenServices(resourceTokenService())
                .stateless(true);
    }

    /**
     * 资源访问安全配置
     * @param http
     * @throws Exception
     */
    @Override
    public void configure(HttpSecurity http) throws Exception {
        //关闭跨站请求防护
        http.csrf().disable();
        http
                .authorizeRequests()
                // '/oauth/token' 请求进行直接放行
                .antMatchers("/oauth/token").permitAll()
                //  '/resource/**' 资源需要有all 范围
//                .antMatchers("/resource/**").access("#oauth2.hasScope('all')")
                // 其他的资源进行放行
                .anyRequest().permitAll();

        //指定要使用的访问拒绝处理程序  OAuth2发送403
        http.exceptionHandling().accessDeniedHandler(new OAuth2AccessDeniedHandler());
    }
}
