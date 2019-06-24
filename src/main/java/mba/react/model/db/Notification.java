package mba.react.model.db;

import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.Id;

import java.time.LocalDateTime;


@Setter
@Getter
public class Notification {
	@Id
	private String id;
	private String message;
	@CreatedDate
	private LocalDateTime generationTime;
}
