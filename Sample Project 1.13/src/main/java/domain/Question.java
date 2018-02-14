
package domain;

import javax.persistence.Access;
import javax.persistence.AccessType;
import javax.persistence.Entity;

@Entity
@Access(AccessType.PROPERTY)
public class Question extends DomainEntity {

	private String			question;
	private ReplyQuestion	replyQuestion;


	public String getQuestion() {
		return this.question;
	}

	public void setQuestion(final String question) {
		this.question = question;
	}

	public ReplyQuestion getReplyQuestion() {
		return this.replyQuestion;
	}

	public void setReplyQuestion(final ReplyQuestion replyQuestion) {
		this.replyQuestion = replyQuestion;
	}

}
