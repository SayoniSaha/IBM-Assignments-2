package entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "course")
@NoArgsConstructor
@AllArgsConstructor
@Data
public class CourseEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int courseId;
	private String course;
	private String price;
	public CourseEntity(String course, String price) {
		super();
		this.course = course;
		this.price = price;
	}	
}
