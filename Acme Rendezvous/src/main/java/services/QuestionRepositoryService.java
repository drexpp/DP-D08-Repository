package services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.Assert;

import domain.Question;
import domain.User;

import repositories.QuestionRepository;

@Service
@Transactional
public class QuestionRepositoryService {

	
	// Managed Repository
	@Autowired
	private QuestionRepository	questionRepository;
	
	// Supporting Repository
	@Autowired
	private UserService	userService;
	
		
	// Constructors
	public QuestionRepositoryService(){
		super();
	}
	
	// Simple CRUD methods
	public Question create(){
		User principal;
		Question question;
		
		principal = this.userService.findByPrincipal();
		Assert.notNull(principal);
		
		question = new Question();
		
		return question;
	}
	
	
	public Question save(final Question question){
		User principal;
		Question result;
		
		Assert.notNull(question);
		
		principal = this.userService.findByPrincipal();
		
		Assert.notNull(principal);
		
		result = this.questionRepository.save(question);
		
		
		return result;
	}
	
	public void delete(final Question question){
		User principal;
		Assert.notNull(question);
		
		principal = this.userService.findByPrincipal();
		Assert.notNull(principal);
		
		this.questionRepository.delete(question);
	}
	
	
	
	
		
		
}
