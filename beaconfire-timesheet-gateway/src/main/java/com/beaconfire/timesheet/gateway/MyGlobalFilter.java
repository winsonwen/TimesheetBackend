package com.beaconfire.timesheet.gateway;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.gateway.filter.GatewayFilterChain;
import org.springframework.cloud.gateway.filter.GlobalFilter;

import org.springframework.stereotype.Component;
import org.springframework.web.server.ServerWebExchange;
import reactor.core.publisher.Mono;

import java.util.List;


@Component
public class MyGlobalFilter implements GlobalFilter {
    Logger logger = LoggerFactory.getLogger(MyGlobalFilter.class);
    JwtUtils jwtUtils;
    @Autowired
    public MyGlobalFilter(JwtUtils jwtUtils) {this.jwtUtils = jwtUtils;}
    @Override
    public Mono<Void> filter(ServerWebExchange exchange, GatewayFilterChain chain) {
        logger.info(exchange.getRequest().getPath().toString());
        if (exchange.getRequest().getURI().toString().endsWith("/login/getToken")) return chain.filter(exchange);
        List<String> stringList = exchange.getRequest().getHeaders().get("Authorization");
        if (stringList == null || stringList.isEmpty()) return null;
        else {
            String token = stringList.get(0);
            if (!token.startsWith("Bearer ")) return null;
            else if (jwtUtils.validateToken(token.substring(7))){
                return chain.filter(exchange);
            } else return null;
        }
//        return chain.filter(exchange);
    }

}
