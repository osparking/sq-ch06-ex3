package services;
import java.util.logging.Logger;

import org.springframework.stereotype.Service;

import model.Comment;
import space.jbpark.utility.MyUtil;

@Service
public class CommentService {
	private Logger logger = MyUtil.getLogger(CommentService.class.getName());
	public String publishComment(Comment comment) {
		logger.info("출판된 코맨트 텍스트: " + comment.getText());
		return "성공";
	}

}
