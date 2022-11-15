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
public class Category {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long categoryid;
	private String name;
	@OneToMany(cascade = CascadeType.ALL, mappedBy = "category")
	@JsonIgnoreProperties("category")
	private List<Collection> books;

	// konstruktorit
	public Category() {
		this.name = null;
	}

	public Category(String name) {
		this.name = name;
	}

	// getters and setters
	public Long getCategoryid() {
		return categoryid;
	}

	public void setCategoryid(Long categoryid) {
		this.categoryid = categoryid;
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
		return "Category [id=" + categoryid + ", name=" + name + "]";
	}
}
