package ba.unsa.etf.nwtcinemaprojections.configuration;

import feign.RequestInterceptor;
import feign.RequestTemplate;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;

@SuppressWarnings("Duplicates")
@Component
class FeignInterceptor implements RequestInterceptor {

    @Override
    public void apply(RequestTemplate requestTemplate) {
        ServletRequestAttributes requestAttributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
        if (requestAttributes == null) {
            return;
        }
        HttpServletRequest request = requestAttributes.getRequest();
        if (request == null) {
            return;
        }
        try {
            String token = request.getHeader("Authorization");
            if (token != null) {
                requestTemplate.header("Authorization", token);
            }
        }
        catch (Exception e) {
            System.out.println(e.getLocalizedMessage());
        }

    }
}
