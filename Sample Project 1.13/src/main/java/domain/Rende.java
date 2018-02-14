
package domain;

import java.util.Collection;
import java.util.Date;

import javax.persistence.Access;
import javax.persistence.AccessType;
import javax.persistence.Entity;

import org.aspectj.weaver.patterns.TypePatternQuestions.Question;

@Entity
@Access(AccessType.PROPERTY)
public class Rende extends DomainEntity {

	private String						name;
	private String						description;
	private Date						moment;
	private String						picture;
	private Location					coordenates;
	private Collection<User>			attendants;
	private Boolean						isDraft;
	private Boolean						adultOnly;
	private Boolean						RSVP;
	private Collection<Rende>			linked;
	private Collection<Announcement>	announcements;
	private Collection<Comment>			comments;
	private Collection<Question>		questions;
	private User						user;


	public User getUser() {
		return this.user;
	}

	public void setUser(final User user) {
		this.user = user;
	}

	public String getName() {
		return this.name;
	}

	public void setName(final String name) {
		this.name = name;
	}

	public String getDescription() {
		return this.description;
	}

	public void setDescription(final String description) {
		this.description = description;
	}

	public Date getMoment() {
		return this.moment;
	}

	public void setMoment(final Date moment) {
		this.moment = moment;
	}

	public String getPicture() {
		return this.picture;
	}

	public void setPicture(final String picture) {
		this.picture = picture;
	}

	public Location getCoordenates() {
		return this.coordenates;
	}

	public void setCoordenates(final Location coordenates) {
		this.coordenates = coordenates;
	}

	public Collection<User> getAttendants() {
		return this.attendants;
	}

	public void setAttendants(final Collection<User> attendants) {
		this.attendants = attendants;
	}

	public Boolean getIsDraft() {
		return this.isDraft;
	}

	public void setIsDraft(final Boolean isDraft) {
		this.isDraft = isDraft;
	}

	public Boolean getAdultOnly() {
		return this.adultOnly;
	}

	public void setAdultOnly(final Boolean adultOnly) {
		this.adultOnly = adultOnly;
	}

	public Boolean getRSVP() {
		return this.RSVP;
	}

	public void setRSVP(final Boolean rSVP) {
		this.RSVP = rSVP;
	}

	public Collection<Rende> getLinked() {
		return this.linked;
	}

	public void setLinked(final Collection<Rende> linked) {
		this.linked = linked;
	}

	public Collection<Announcement> getAnnouncements() {
		return this.announcements;
	}

	public void setAnnouncements(final Collection<Announcement> announcements) {
		this.announcements = announcements;
	}

	public Collection<Comment> getComments() {
		return this.comments;
	}

	public void setComments(final Collection<Comment> comments) {
		this.comments = comments;
	}

	public Collection<Question> getQuestions() {
		return this.questions;
	}

	public void setQuestions(final Collection<Question> questions) {
		this.questions = questions;
	}

}
