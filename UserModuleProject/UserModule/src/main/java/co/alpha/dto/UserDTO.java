package co.alpha.dto;

import co.alpha.common.BaseDTO;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "ST_USER")

@Setter
@Getter
public class UserDTO extends BaseDTO {

	@Column(name = "FIRST_NMAE", length = 10)
	private String firstName = null;

	@Column(name = "LAST_NAME", length = 10)
	private String lastName = null;

	@Column(name = "MOBILE_NO", length = 10)
	private String mobileNo = null;

	@Column(name = "LOGIN_ID", length = 100)
	private String loginId = null;

	@Column(name = "PASSWORD", length = 20)
	private String password = null;

}
