package mba.react.controller;

import mba.react.model.db.Notification;
import mba.react.model.view.NotificationView;
import mba.react.service.NotificationService;
import mba.react.utilities.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import javax.validation.Valid;

@RestController("/notifications")
public class NotificationController {

	private final NotificationService notificationService;
	private final ModelMapper modelMapper;

	@Autowired
	public NotificationController(NotificationService notificationService, ModelMapper modelMapper) {
		this.notificationService = notificationService;
		this.modelMapper = modelMapper;
	}

	@PostMapping
	public Mono<NotificationView> create(@RequestBody @Valid NotificationView notificationView) {
		return notificationService
				.add(modelMapper.convertToModel(notificationView, Notification.class))
				.map(n -> modelMapper.convertToView(n, NotificationView.class));
	}

	@GetMapping(produces = MediaType.TEXT_EVENT_STREAM_VALUE)
	Flux<NotificationView> getAll() {
		return notificationService
				.getAll()
				.map(n -> modelMapper.convertToView(n, NotificationView.class));
	}
}
