
package domain;

import java.util.Collection;
import java.util.Date;

import javax.persistence.Access;
import javax.persistence.AccessType;
import javax.persistence.Entity;

@Entity
@Access(AccessType.PROPERTY)
public class Comment extends DomainEntity {

	private Date						moment;
	private String						text;
	private Collection<String>			pictures;
	private Rende						rende;
	private Collection<ReplyComment>	repliesComments;
	private User						user;


	public Date getMoment() {
		return this.moment;
	}

	public void setMoment(final Date moment) {
		this.moment = moment;
	}

	public String getText() {
		return this.text;
	}

	public void setText(final String text) {
		this.text = text;
	}

	public Collection<String> getPictures() {
		return this.pictures;
	}

	public void setPictures(final Collection<String> pictures) {
		this.pictures = pictures;
	}

	public Rende getRende() {
		return this.rende;
	}

	public void setRende(final Rende rende) {
		this.rende = rende;
	}

	public Collection<ReplyComment> getRepliesComments() {
		return this.repliesComments;
	}

	public void setRepliesComments(final Collection<ReplyComment> repliesComments) {
		this.repliesComments = repliesComments;
	}

	public User getUser() {
		return this.user;
	}

	public void setUser(final User user) {
		this.user = user;
	}

}
