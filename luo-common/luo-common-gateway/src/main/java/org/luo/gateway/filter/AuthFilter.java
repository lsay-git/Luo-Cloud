//package org.luo.gateway.filter;
//
//import org.luo.core.tool.utils.StringUtils;
//import org.luo.redis.service.RedisService;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.cloud.gateway.filter.GatewayFilterChain;
//import org.springframework.cloud.gateway.filter.GlobalFilter;
//import org.springframework.core.Ordered;
//import org.springframework.http.server.reactive.ServerHttpRequest;
//import org.springframework.http.server.reactive.ServerHttpResponse;
//import org.springframework.stereotype.Component;
//import org.springframework.web.server.ServerWebExchange;
//import reactor.core.publisher.Mono;
//
///**
// * @Date 10:06 2021/5/10
// * @Description {
// *   网关鉴权
// * }
// * @Author lsay
// **/
//@Component
//public class AuthFilter implements GlobalFilter, Ordered {
//
//    @Autowired
//    private RedisService redisService;
//
//    @Override
//    public Mono<Void> filter(ServerWebExchange exchange, GatewayFilterChain chain) {
//        //其中ServerWebExchange是Spring封装了javaweb中的相关的对象比如request和response,session等对象
//        //获取http请求对象
//        ServerHttpRequest request = exchange.getRequest();
//        //获取请求的url
//        String path = request.getURI().getPath();
//        //静态资源访问,接口通过判断url中是否含有指定的字符来判断是否放行,在这里设置url的白名单
//        if(StringUtils.inStringIgnoreCase(path, FilterConstants.whites)){
//            return chain.filter(exchange);
//        }
//        return chain.filter(exchange);
//    }
//
//    @Override
//    public int getOrder() {
//        return 0;
//    }
//}
