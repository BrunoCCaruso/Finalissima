package com.hardcode.playgym.service;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class EmailService {

    private final JavaMailSender sender;

    @Value("${spring.mail.username}")
    private String from;

    private static final String SUBJECT = "BIENVENIDO A PLAYGYM 👑🦾";
    private static final String TEXT = "Gracias por unirte a PlayGym!";

    @Async
    public void send(String to) {
        SimpleMailMessage message = new SimpleMailMessage();
        message.setTo(to);
        message.setFrom(from);
        message.setSubject(SUBJECT);
        message.setText(TEXT);
        sender.send(message);

    }

    @Async
    public void sendCliente(String to) {
        SimpleMailMessage message = new SimpleMailMessage();
        message.setTo(to);
        message.setFrom(from);
        message.setSubject(SUBJECT);
        message.setText("Te registrate como Cliente! Ahora elije el Entrenador que mejor se adapte a vos y comenzá tu entrenamiento!");
        sender.send(message);

    }

    @Async
    public void sendAsesor(String to) {
        SimpleMailMessage message = new SimpleMailMessage();
        message.setTo(to);
        message.setFrom(from);
        message.setSubject(SUBJECT);
        message.setText("Te Registrate como Entrenador, ahora empieza a armar tus rutinas!");
        sender.send(message);

    }
}
