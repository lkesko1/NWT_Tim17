package ba.unsa.etf.nwtcinemaprojections.services;


import ba.unsa.etf.nwtcinemaprojections.models.Role;
import ba.unsa.etf.nwtcinemaprojections.repositories.IRoleRepository;
import org.springframework.stereotype.Service;

@Service
public class RoleService extends BaseService<Role, IRoleRepository> {
    public static final String ROLE_ADMIN = "ROLE_ADMIN";
    public static final String ROLE_DESCRIPTION_ADMIN = "Administrator";

    public static final String ROLE_USER = "ROLE_USER";
    public static final String ROLE_DESCRIPTION_USER = "Basic User";



}
