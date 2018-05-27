package ba.unsa.etf.nwtcinemareservations.configuration;

import feign.RequestInterceptor;
import feign.RequestTemplate;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;

@Component
class FeignInterceptor implements RequestInterceptor {

    @Override
    public void apply(RequestTemplate requestTemplate) {
        System.out.println("USAO U FEIGN INTERCEPTOR");
        ServletRequestAttributes requestAttributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
        if (requestAttributes == null) {
            return;
        }
        HttpServletRequest request = requestAttributes.getRequest();
        if (request == null) {
            return;
        }
        requestTemplate.header("Authorization", request.getHeader("Authorization"));
        System.out.println("IZLAZIM IZ FEIGN INTERCEPTORA:");
        System.out.println(requestTemplate.headers().toString());

    }
}
