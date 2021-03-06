package org.alex.railway.tickets.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.ui.context.support.ResourceBundleThemeSource;
import org.springframework.web.servlet.config.annotation.*;
import org.springframework.web.servlet.theme.CookieThemeResolver;
import org.springframework.web.servlet.theme.ThemeChangeInterceptor;
import org.springframework.web.servlet.view.InternalResourceViewResolver;
import org.springframework.web.servlet.view.JstlView;



    @Configuration
    @EnableWebMvc
    @EnableTransactionManagement
    @ComponentScan(basePackages = "org.alex.railway.tickets")
    public class WebConfig implements WebMvcConfigurer {

        @Bean
        public InternalResourceViewResolver viewResolver() {
            InternalResourceViewResolver resolver = new InternalResourceViewResolver();
            resolver.setViewClass(JstlView.class);
            resolver.setPrefix("/WEB-INF/view/");
            resolver.setSuffix(".jsp");
//        resolver.setSuffix(".jspx");
            return resolver;
        }

        @Override
        public void addResourceHandlers(ResourceHandlerRegistry registry) {

            registry.addResourceHandler("/WEB-INF/view/**").addResourceLocations("/view/");

            registry.addResourceHandler("/resources/**").addResourceLocations("classpath:/resources");

            registry.addResourceHandler("/resources/**").addResourceLocations("/resources/");

        }

        @Override
        public void configureDefaultServletHandling(DefaultServletHandlerConfigurer configurer) {
            configurer.enable();
        }

        @Override
        public void addInterceptors(InterceptorRegistry registry) {
            registry.addInterceptor(themeChangeInterceptor());
        }

        @Bean
        ResourceBundleThemeSource themeSource() {
            return new ResourceBundleThemeSource();
        }


        @Bean
        ThemeChangeInterceptor themeChangeInterceptor () {
            return new ThemeChangeInterceptor();
        }


        @Bean
        CookieThemeResolver themeResolver() {
            CookieThemeResolver cookieThemeResolver = new CookieThemeResolver();
            cookieThemeResolver.setDefaultThemeName("railway");
            cookieThemeResolver.setCookieMaxAge(3600);
            cookieThemeResolver.setCookieName("railway");
            return cookieThemeResolver;
        }


    }

