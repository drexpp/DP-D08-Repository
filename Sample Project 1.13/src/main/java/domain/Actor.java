
package domain;

import java.util.Collection;
import java.util.Date;

import javax.persistence.Access;
import javax.persistence.AccessType;
import javax.persistence.Entity;

@Entity
@Access(AccessType.PROPERTY)
public class Actor extends DomainEntity {

	private String				name;
	private String				surname;
	private Collection<String>	emails;
	private Collection<String>	phones;
	private Collection<String>	addresses;
	private Date				dateBirth;


	public Date getDateBirth() {
		return this.dateBirth;
	}

	public void setDateBirth(final Date dateBirth) {
		this.dateBirth = dateBirth;
	}

	public String getName() {
		return this.name;
	}

	public void setName(final String name) {
		this.name = name;
	}

	public String getSurname() {
		return this.surname;
	}

	public void setSurname(final String surname) {
		this.surname = surname;
	}

	public Collection<String> getEmails() {
		return this.emails;
	}

	public void setEmails(final Collection<String> emails) {
		this.emails = emails;
	}

	public Collection<String> getPhones() {
		return this.phones;
	}

	public void setPhones(final Collection<String> phones) {
		this.phones = phones;
	}

	public Collection<String> getAddresses() {
		return this.addresses;
	}

	public void setAddresses(final Collection<String> addresses) {
		this.addresses = addresses;
	}

}
