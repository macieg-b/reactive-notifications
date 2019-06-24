package mba.react.service;

import lombok.extern.slf4j.Slf4j;
import mba.react.model.db.Notification;
import mba.react.repository.NotificationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.time.LocalDateTime;


@Service
@Slf4j
public class NotificationService {
    private final NotificationRepository notificationRepository;

    @Autowired
    public NotificationService(NotificationRepository notificationRepository) {
        this.notificationRepository = notificationRepository;
    }


    public Flux<Notification> getAll() {
        return notificationRepository.findBy();
    }

    public Mono<Notification> add(Notification notification) {
        return notificationRepository.save(notification);
    }
}
