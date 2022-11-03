package com.hansontech.knowldgeBase;
import com.hansontech.knowldgeBase.entity.Comments;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
@SpringBootApplication
public class KnowldgeBaseApplication {
	public static void main(String[] args){
		SpringApplication.run(KnowldgeBaseApplication.class, args);
		Comments comments = new Comments();
		System.out.println(comments.getDate());
	}
}

