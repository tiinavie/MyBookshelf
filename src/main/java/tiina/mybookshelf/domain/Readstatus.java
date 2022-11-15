package tiina.mybookshelf.domain;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
public class Readstatus {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long statusid;
	private String name;
	@OneToMany(cascade = CascadeType.ALL, mappedBy = "category")
	@JsonIgnoreProperties("readstatus")
	private List<Collection> books;

	// konstruktorit
	public Readstatus() {
		this.name = null;
	}

	public Readstatus(String name) {
		this.name = name;
	}

	// getters and setters
	public Long getStatusid() {
		return statusid;
	}

	public void setStatusid(Long statusid) {
		this.statusid = statusid;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<Collection> getBooks() {
		return books;
	}

	public void setBooks(List<Collection> books) {
		this.books = books;
	}

	// toString
	@Override
	public String toString() {
		return "Readstatus [id=" + statusid + ", name=" + name + "]";
	}
}
