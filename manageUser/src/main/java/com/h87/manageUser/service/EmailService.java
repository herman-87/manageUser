package com.h87.manageUser.service;

import com.h87.manageUser.domain.EmailTemplateName;
import com.h87.manageUser.exception.InternalServerError;
import com.h87.manageUser.utils.ManageUserErrorCode;
import jakarta.mail.MessagingException;
import jakarta.mail.internet.MimeMessage;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;
import org.thymeleaf.context.Context;
import org.thymeleaf.spring6.SpringTemplateEngine;

import java.nio.charset.StandardCharsets;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

@Slf4j
@Service
@RequiredArgsConstructor
public class EmailService {
    private final JavaMailSender mailSender;
    private final SpringTemplateEngine templateEngine;
    private final String activationCodeEmailAddressSender;

    @Async
    public void sendEmail(
            String to,
            String userFullName,
            EmailTemplateName emailTemplate,
            String confirmationUrl,
            String activationCode,
            String subject
    ) throws InternalServerError {
        String templateName = Objects.isNull(emailTemplate) ? "confirm-email" : emailTemplate.name();
        MimeMessage mimeMessage = mailSender.createMimeMessage();
        try {
            MimeMessageHelper mimeMessageHelper = new MimeMessageHelper(
                    mimeMessage,
                    MimeMessageHelper.MULTIPART_MODE_MIXED,
                    StandardCharsets.UTF_8.name()
            );
            Map<String, Object> properties = new HashMap<>();
            properties.put("userFullName", userFullName);
            properties.put("confirmationUrl", confirmationUrl);
            properties.put("activationCode", activationCode);

            Context context = new Context();
            context.setVariables(properties);

            mimeMessageHelper.setFrom(activationCodeEmailAddressSender);
            mimeMessageHelper.setTo(to);
            mimeMessageHelper.setSubject(subject);

            String template = templateEngine.process(templateName, context);

            mimeMessageHelper.setText(template, true);
            mailSender.send(mimeMessage);
        } catch (MessagingException e) {
            log.warn("Failed to send email to {}", userFullName);
            e.printStackTrace();
            throw new InternalServerError(ManageUserErrorCode.EMAIL_SEND_ERROR);
        }
    }
}
