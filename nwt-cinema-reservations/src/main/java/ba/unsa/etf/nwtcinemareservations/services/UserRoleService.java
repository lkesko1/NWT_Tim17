package ba.unsa.etf.nwtcinemareservations.services;

import ba.unsa.etf.nwtcinemareservations.models.UserRole;
import ba.unsa.etf.nwtcinemareservations.repositories.IUserRoleRepository;
import org.springframework.stereotype.Service;

@Service
public class UserRoleService extends BaseService<UserRole, IUserRoleRepository> {
}
