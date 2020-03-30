package com.uuhnaut69.mall.rabbitmq;

import com.uuhnaut69.mall.constant.RabbitMqConstant;
import com.uuhnaut69.mall.domain.model.User;
import com.uuhnaut69.mall.service.mail.MailService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.annotation.EnableRabbit;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

/**
 * @author uuhnaut
 * @project mall
 */
@Slf4j
@Component
@EnableRabbit
public class MailTopicConsumer {

    private final MailService mailService;

    public MailTopicConsumer(MailService mailService) {
        this.mailService = mailService;
    }

    @RabbitListener(queues = RabbitMqConstant.SEND_ACTIVATE_MAIL_TOPIC)
    private void mailTopicConsumer(User user) {
        try {
            mailService.sendMail(user);
        } catch (Exception e) {
            log.error(e.getMessage());
        }
    }
}