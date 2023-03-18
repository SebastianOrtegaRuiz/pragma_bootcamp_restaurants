package com.pragma.restaurant.application.mapper.feign;

import feign.RequestInterceptor;
import feign.RequestTemplate;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class SecurityFeignRequestInterceptor implements RequestInterceptor {

    private static final String AUTHENTICATION_HEADER = "Authorization";

    @Override
    public void apply(RequestTemplate template) {
        propagateAuthorizationHeader(template);
    }

    private void propagateAuthorizationHeader(RequestTemplate template) {
        if (template.headers().containsKey(AUTHENTICATION_HEADER)) {
            System.out.println("the authorization {} token has been already set");
        } else {
            System.out.println("setting the authorization token {}");
            template.header(AUTHENTICATION_HEADER, "Bearer eyJhbGciOiJIUzI1NiJ9.eyJzdWIiOiJzb29hbHExQGdtYWlsLmNvbSIsImV4cCI6MTY4MTQwNTY4OCwibmFtZSI6Ik1hcmlhbmEiLCJhdXRob3JpdGllcyI6IlBST1BJRVRBUklPIn0.TlZQKsjgAqm0R3uuTCaQXMovRvmT787GyqK6M9qvlUw");
        }
    }

}
