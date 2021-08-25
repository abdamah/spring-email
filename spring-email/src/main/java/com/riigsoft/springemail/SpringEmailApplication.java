package com.riigsoft.springemail;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/***
 * @author Abdallah
 * Spring mail api
 */
@SpringBootApplication
public class SpringEmailApplication {

	// You can use this with out controller to test
	// Implementing CommandLineRunners interface or @EventListener(ApplicationReadyEvent.class)
	/*@Autowired
	private IEmailSenderService service;*/

	public static void main(String[] args) {
		SpringApplication.run(SpringEmailApplication.class, args);
	}

/*	@Override
	public void run(String... args) throws Exception {

		service.sendSimpleMessage("test@gmail.com",
				"This is Email Body with Attachment...",
				"Email With Attachment"
		);
	}*/


	/*@EventListener(ApplicationReadyEvent.class)
	public void triggerMail() throws MessagingException {

		service.sendSimpleMessage("test@gmail.com",
				"This is Email Body with Attachment...",
				"Email With Attachment"
		);

	}*/
}

