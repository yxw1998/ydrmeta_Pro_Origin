package cn.meta.config;

import cn.meta.filter.MyFilter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author YangXw
 * @date 2022/01/07 9:25
 */
@Configuration
public class FilterConfig {

    private MyFilter myFilter;

    private String[] urlPatterns = {"/test/*"};

    @Autowired
    public void setMyFilter(MyFilter myFilter) {
        this.myFilter = myFilter;
    }

    @Bean
    public FilterRegistrationBean registerFilter() {
        FilterRegistrationBean filterRegistrationBean = new FilterRegistrationBean();
        filterRegistrationBean.setFilter(myFilter);
        filterRegistrationBean.addUrlPatterns(urlPatterns);
        filterRegistrationBean.setName("myFilter");
        filterRegistrationBean.setOrder(1);
        return filterRegistrationBean;
    }
}
