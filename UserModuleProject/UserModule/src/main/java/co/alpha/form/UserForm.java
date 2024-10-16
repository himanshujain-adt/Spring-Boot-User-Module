package co.alpha.form;

import co.alpha.common.BaseDTO;
import co.alpha.common.BaseForm;
import co.alpha.dto.UserDTO;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class UserForm extends BaseForm {

	@NotNull(message = "please enter first name")
	@Pattern(regexp = "^[a-zA-Z]+$", message = "first name can only contain letters")
	private String firstName = null;

	@NotNull(message = "please enter last name")
//	@Pattern(regexp = "^[a-zA-Z]+$", message = "last name can only contain letters")
	private String lastName = null;

	@NotEmpty(message = "please enter mobile no")
	private String mobileNo = null;

	@NotEmpty(message = "please enter loginId")
	private String loginId = null;

	@NotEmpty(message = "please enter password")
	private String password = null;

	
	private Long rollNo;

	@Override
	public BaseDTO getDto() {
		UserDTO dto = initDTO(new UserDTO());
		dto.setFirstName(firstName);
		dto.setLastName(lastName);
		dto.setMobileNo(mobileNo);
		dto.setLoginId(loginId);
		dto.setPassword(password);
		dto.setRollNo(rollNo);
		return dto;
	}

}
