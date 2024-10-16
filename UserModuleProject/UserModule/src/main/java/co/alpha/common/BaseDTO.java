package co.alpha.common;

import org.hibernate.annotations.GenericGenerator;

import jakarta.persistence.Column;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.MappedSuperclass;
import lombok.Getter;
import lombok.Setter;

@MappedSuperclass
@Setter
@Getter
public class BaseDTO {

	@Id
	@GeneratedValue(generator = "alphaPk")
	@GenericGenerator(name = "alphaPk", strategy = "native")

	@Column(name = "ID", nullable = false, unique = true)
	private Long id;

}
