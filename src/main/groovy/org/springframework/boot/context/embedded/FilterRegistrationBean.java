package org.springframework.boot.context.embedded;

import org.springframework.boot.web.servlet.ServletRegistrationBean;

import javax.servlet.Filter;

// https://github.com/bluesliverx/grails-spring-security-oauth2-provider/issues/140
public class FilterRegistrationBean extends org.springframework.boot.web.servlet.FilterRegistrationBean {

    public FilterRegistrationBean() {
    }

    public FilterRegistrationBean(Filter filter, ServletRegistrationBean... servletRegistrationBeans) {
        super(filter, servletRegistrationBeans);
    }
}