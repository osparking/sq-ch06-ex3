package main;

import java.util.logging.Logger;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import config.ProjectConfig;
import model.Comment;
import services.CommentService;
import space.jbpark.utility.MyUtil;

public class Main {
	private static Logger logger = MyUtil.getLogger(Main.class.getName());

	public static void main(String[] args) {
		var ctx = new AnnotationConfigApplicationContext(ProjectConfig.class);
		var service = ctx.getBean("commentService", CommentService.class);
		var cmt = new Comment();
		cmt.setAuthor("톨스토이");
		cmt.setText("전쟁과 평화");
		var result = service.publishComment(cmt);
		logger.info("결과: " + result);
				
	}

}
