package com.limyel.hammer.modules.security.service;

import com.limyel.hammer.modules.security.dto.LoginDTO;

public interface LoginService {

    String doLogin(LoginDTO loginDTO);

}
