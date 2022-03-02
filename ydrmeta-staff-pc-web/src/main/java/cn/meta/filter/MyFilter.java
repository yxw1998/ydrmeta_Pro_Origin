package cn.meta.filter;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import javax.servlet.*;
import java.io.IOException;

/**
 * @author YangXw
 * @date 2022/01/07 9:29
 */
@Component
@Slf4j
public class MyFilter implements Filter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        log.info("init Filter--->{} 执行了");
    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {

        log.info("filter --->{} ");
        filterChain.doFilter(servletRequest,servletResponse);

    }

    @Override
    public void destroy() {
        Filter.super.destroy();
    }
}
