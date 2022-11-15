package tiina.mybookshelf.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
public class Collection {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String title, author, readstatus;
	@Column(name = "publishing_year")
	private int year;
	@ManyToOne
	@JsonIgnoreProperties("books")
	@JoinColumn(name = "categoryid")
	private Category category;

	// konstruktorit
	public Collection() {
		this.title = null;
		this.author = null;
		this.year = 0;
		this.category = null;
		this.readstatus = null;
	}

	public Collection(String title, String author, int year, Category category, String readstatus) {
		super();
		this.title = title;
		this.author = author;
		this.year = year;
		this.category = category;
		this.readstatus = readstatus;
	}

	// Getters and Setters
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public String getReadstatus() {
		return readstatus;
	}

	public void setReadstatus(String readstatus) {
		this.readstatus = readstatus;
	}

	public int getYear() {
		return year;
	}

	public void setYear(int year) {
		this.year = year;
	}

	public Category getCategory() {
		return category;
	}

	public void setCategory(Category category) {
		this.category = category;
	}

	// toString
	@Override
	public String toString() {
		if (this.category != null)
			return "Book [title=" + title + ", author=" + author + ", year=" + year + ", category=" + category
					+ ", readstatus=" + readstatus + "]";
		else
			return "Book [title=" + title + ", author=" + author + ", year=" + year
					+ ", readstatus=\" + readstatus + ]";
	}

}
