package com.uuhnaut69.mall.payment.service;

import com.uuhnaut69.mall.payment.payload.request.CreditCard;

import java.util.UUID;

/**
 * @author uuhnaut
 * @project mall
 */
public interface PaymentService {
    /**
     * Check out
     *
     * @param cartId
     * @param userId
     * @param creditCard
     * @throws Exception
     */
    void checkout(UUID cartId, UUID userId, CreditCard creditCard) throws Exception;

}
