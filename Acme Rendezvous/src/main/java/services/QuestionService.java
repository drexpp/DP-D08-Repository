
package services;

import java.util.ArrayList;
import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.Assert;

import repositories.QuestionRepository;
import domain.Question;
import domain.ReplyQuestion;
import domain.User;

@Service
@Transactional
public class QuestionService {

	// Managed Repository
	@Autowired
	private QuestionRepository	questionRepository;

	// Supporting Repository
	@Autowired
	private UserService			userService;


	// Constructors
	public QuestionService() {
		super();
	}

	// Simple CRUD methods
	public Question create() {
		User principal;
		Question question;
		final Collection<ReplyQuestion> repliesQuestions = new ArrayList<ReplyQuestion>();
		principal = this.userService.findByPrincipal();
		Assert.notNull(principal);

		question = new Question();
		question.setReplyQuestions(repliesQuestions);

		return question;
	}

	public Question save(final Question question) {
		User principal;
		Question result;

		Assert.notNull(question);

		principal = this.userService.findByPrincipal();

		Assert.notNull(principal);

		result = this.questionRepository.save(question);

		return result;
	}

	public void delete(final Question question) {
		User principal;
		Assert.notNull(question);

		principal = this.userService.findByPrincipal();
		Assert.notNull(principal);

		this.questionRepository.delete(question);
	}

}
