package org.sid.secservice.sec.service;

import org.sid.secservice.sec.entities.AppRole;
import org.sid.secservice.sec.entities.AppUser;
import org.sid.secservice.sec.repository.AppRoleRepository;
import org.sid.secservice.sec.repository.AppUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;


@Service
@Transactional
public class AccountServiceImpl implements AccountService {
    private AppUserRepository appUserRepository;
    private AppRoleRepository appRoleRepository;
    private PasswordEncoder passwordEncoder;

    public AccountServiceImpl(AppUserRepository appUserRepository, AppRoleRepository appRoleRepository, PasswordEncoder passwordEncoder){
        this.appRoleRepository = appRoleRepository;
        this.appUserRepository = appUserRepository;
        this.passwordEncoder = passwordEncoder;
    }
    @Override
    public AppUser addNewUser(AppUser appUser) {
        String pwd = appUser.getPassword();
        appUser.setPassword(passwordEncoder.encode(pwd));
        return this.appUserRepository.save(appUser);
    }

    @Override
    public AppRole addNewRole(AppRole appRole) {
        return this.appRoleRepository.save(appRole);
    }

    @Override
    public void addRoleToUser(String username, String rolename) {
        AppUser appUser = this.appUserRepository.findByUsername(username);
        AppRole appRole = this.appRoleRepository.findByRoleName(rolename);
        appUser.getAppRoles().add(appRole);
        //System.out.println("adding "+ appRole + " TO " + appUser);
    }

    @Override
    public AppUser loadUserByUserName(String username) {
        return this.appUserRepository.findByUsername(username);
    }

    @Override
    public List<AppUser> listUsers() {
        return this.appUserRepository.findAll();
    }
}
