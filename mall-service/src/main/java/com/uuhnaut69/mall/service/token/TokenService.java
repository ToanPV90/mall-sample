package com.uuhnaut69.mall.service.token;

import com.uuhnaut69.mall.domain.model.User;

/**
 * @author uuhnaut
 * @project mall
 */
public interface TokenService {
    /**
     * Generate token
     *
     * @param user {@link User}
     * @return Token
     */
    String generateToken(User user);

    /**
     * Confirm verify token
     *
     * @param token Confirm token
     */
    void confirmVerifyToken(String token);
}
