package producer.example;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
public class Controller {

	private final KafkaTopic topico;
	private int Cnt = 0;

	@GetMapping("/")
	public ResponseEntity<String> get() {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss");
        String datetimeString = LocalDateTime.now().format(formatter);

		String message = datetimeString;
		topico.send("Count:" + Cnt++ + " : " + message);
		
		return ResponseEntity.status(HttpStatus.OK).body("Message: " + message + " - new record: " + Cnt);
		
	}

	
}
