package co.alpha.form;

import co.alpha.common.BaseDTO;
import co.alpha.common.BaseForm;
import co.alpha.dto.UserDTO;
import jakarta.validation.constraints.NotEmpty;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class UserForm extends BaseForm {

	@NotEmpty(message = "please enter first name")
	private String firstName = null;

	@NotEmpty(message = "please enter last name")
	private String lastName = null;

	@NotEmpty(message = "please enter mobile no")
	private String mobileNo = null;

	@NotEmpty(message = "please enter loginId")
	private String loginId = null;

	@NotEmpty(message = "please enter password")
	private String password = null;

	@Override
	public BaseDTO getDto() {
		UserDTO dto = initDTO(new UserDTO());
		dto.setFirstName(firstName);
		dto.setLastName(lastName);
		dto.setMobileNo(mobileNo);
		dto.setLoginId(loginId);
		dto.setPassword(password);
		return dto;
	}

}
