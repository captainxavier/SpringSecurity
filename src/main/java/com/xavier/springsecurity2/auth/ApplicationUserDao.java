package com.xavier.springsecurity2.auth;

import java.util.Optional;



public interface ApplicationUserDao {

    Optional<ApplicationUser> selectApplicationUserByUserName(String username);


}
