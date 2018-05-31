package ba.unsa.etf.nwtcinemaauth.configuration.security;


import ba.unsa.etf.nwtcinemaauth.repositories.IUserRepository;
import io.jsonwebtoken.Jwts;
import org.springframework.stereotype.Service;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Date;

import static io.jsonwebtoken.SignatureAlgorithm.HS512;

@Service
public class TokenAuthenticationService {
    private static IUserRepository accountRepository;

    static final long EXPIRATION_TIME = 864_000_000; // 10 days
    static final String SECRET = "nwt-cinema-secret-key";
    static final String TOKEN_PREFIX = "Bearer";
    static final String HEADER_STRING = "Authorization";

    public static void addAuthentication(HttpServletRequest req, HttpServletResponse res, String username) {
        ServletContext servletContext = req.getServletContext();
        WebApplicationContext webApplicationContext = WebApplicationContextUtils.getWebApplicationContext(servletContext);
        accountRepository = webApplicationContext.getBean(IUserRepository.class);

        String JWT = Jwts.builder()
                .setSubject(username)
                .setExpiration(new Date(System.currentTimeMillis() + EXPIRATION_TIME))
                .signWith(HS512, SECRET)
                .compact();
        res.addHeader(HEADER_STRING, TOKEN_PREFIX + " " + JWT);
    }
}
