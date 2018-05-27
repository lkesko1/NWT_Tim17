package ba.unsa.etf.nwtcinemamovies.configuration.security;

import io.jsonwebtoken.Jwts;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.stereotype.Service;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;

import static io.jsonwebtoken.SignatureAlgorithm.HS512;

@SuppressWarnings("Duplicates")
@Service
public class JWTAuthenticationService {


//    private static IAccountRepository accountRepository;

    static final long EXPIRATIONTIME = 864_000_000; // 10 days
    static final String SECRET = "netflix-management";
    static final String TOKEN_PREFIX = "Bearer";
    static final String HEADER_STRING = "Authorization";

    public static Authentication getAuthentication(HttpServletRequest request) {

//        ServletContext servletContext = request.getServletContext();
//        WebApplicationContext webApplicationContext = WebApplicationContextUtils.getWebApplicationContext(servletContext);
//        accountRepository = webApplicationContext.getBean(IAccountRepository.class);
//
//        String token = request.getHeader(HEADER_STRING);
//        if (token != null) {
//            // parse the token.
//            String user = Jwts.parser()
//                    .setSigningKey(SECRET)
//                    .parseClaimsJws(token.replace(TOKEN_PREFIX, ""))
//                    .getBody()
//                    .getSubject();
//
//            Account userAccount = accountRepository.findAccountByUsername(user);
//            Collection<GrantedAuthority> authorities = new ArrayList<>();
//            if(userAccount != null) {
//                authorities.add(new SimpleGrantedAuthority(userAccount.getRole().getTitle()));
//            }
//
//            return user != null ?
//                    new UsernamePasswordAuthenticationToken(user, null, authorities) :
//                    null;
//        }
        return null;
    }
}


