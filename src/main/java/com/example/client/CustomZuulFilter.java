package com.example.client;
import com.netflix.zuul.context.RequestContext;
import org.springframework.stereotype.Component;
import com.netflix.zuul.ZuulFilter;

import javax.servlet.http.HttpServletResponse;

import static org.springframework.cloud.netflix.zuul.filters.support.FilterConstants.POST_TYPE;

@Component
public class CustomZuulFilter extends ZuulFilter {
    @Override
    public Object run() {
        final RequestContext ctx = RequestContext.getCurrentContext();
        HttpServletResponse servletResponse = ctx.getResponse();
        servletResponse.addHeader("Test", "TestSample");
        return null;
    }
    @Override
    public boolean shouldFilter() {
        return true;
    }

    @Override
    public String filterType() {
        return POST_TYPE;
    }

    @Override
    public int filterOrder() {
        return 0;
    }

}