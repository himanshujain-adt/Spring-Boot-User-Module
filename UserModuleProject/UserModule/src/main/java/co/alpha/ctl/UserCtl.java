package co.alpha.ctl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import co.alpha.common.BaseCtl;
import co.alpha.common.ORSResponse;
import co.alpha.dto.UserDTO;
import co.alpha.form.UserForm;
import co.alpha.service.UserServiceInt;
import jakarta.validation.Valid;

@RestController
@RequestMapping(value = "User")
public class UserCtl extends BaseCtl<UserForm, UserDTO, UserServiceInt> {

	@PostMapping("/createMultipel")
	public ORSResponse createMultiple(@RequestBody List<UserForm> usersForms) {
		ORSResponse res = new ORSResponse(true);
		List<Long> idsList = new ArrayList<>();

		for (UserForm userForm : usersForms) {
			UserDTO createDto = (UserDTO) userForm.getDto();

			if (createDto == null) {
				res.addMessage("UserDTO is null for one of the entries");
				continue;
			}

			Long rollNo = createDto.getRollNo();
			UserDTO rollDto = baseService.findByRollNo(rollNo);

			System.out.println("createDto==>>>>" + createDto.getRollNo());

			if (rollDto != null) {
				System.out.println("rollDto ==>>>>" + rollDto.getRollNo());

				if (createDto.getId() != null) {
					baseService.update(createDto);
					res.addMessage("Data updated for ID: " + createDto.getId());
				} else {
					res.addMessage("Roll number already exists, please provide an ID to update.");
				}
			} else {

				if (rollNo != null) {
					Long ids = baseService.add(createDto);
					idsList.add(ids);
					res.addResult("Added Data", idsList);
					res.addMessage("User added with roll number: " + rollNo);
				} else {
					res.addMessage("rollNo is required for new entries");
				}
			}
		}

		return res;
	}

	@PostMapping("save")
	public ORSResponse save(@RequestBody @Valid UserForm form, BindingResult bindingResult) {
		System.out.println("Controller calling");

		ORSResponse res = validate(bindingResult);
		if (!res.isSuccess()) {
			return res;
		}
		UserDTO dto = (UserDTO) form.getDto();

		/*
		 * System.out.println(dto.getFirstName() + " " + dto.getLastName() + "  " +
		 * dto.getLoginId() + " " + dto.getPassword() + "  " + dto.getMobileNo());
		 */
		if (dto.getId() > 0) {
			System.out.println("Id is if condition= " + dto.getId());
			baseService.update(dto);
			res.addMessage("Data Updated!!...");

		} else {
			System.out.println("Id is else condition =" + dto.getId());
			Long id = baseService.add(dto);
			res.addMessage("Data Added Successfully");
			res.addData(id);
		}

		return res;
	}

	@GetMapping("get/{id}")
	public ResponseEntity<ORSResponse> get(@PathVariable long id) {
		System.out.println("Id is :" + id);
		UserDTO dto = baseService.findById(id);
		ORSResponse res = new ORSResponse(true);
		// res.setSuccess(true);
		res.addData(dto);

		return new ResponseEntity<ORSResponse>(res, HttpStatus.OK);
	}

	@GetMapping("delete/{id}")
	public ORSResponse delete(@PathVariable Long id) {
		System.out.println("Id of delete is" + id);
		baseService.delete(id);
		ORSResponse res = new ORSResponse(true);
		res.addMessage(id + " =id deleted successfully....!!!!!");
		return res;
	}

	@Value("${page.size}")
	protected int pageSize;

	@RequestMapping(value = "search", method = { RequestMethod.GET, RequestMethod.POST })
	public ORSResponse search(@RequestBody UserForm form, @RequestParam int pageNo) {
		System.out.println("pageNo is: " + pageNo);
		ORSResponse res = new ORSResponse(true);
		UserDTO dto = (UserDTO) form.getDto();
		List list = baseService.search(dto, pageNo, pageSize);
		if (list.size() == 0) {
			res.addMessage("No Record Found");

		} else {
			res.addData(list);
		}

		return res;
	}

//	@GetMapping("getRollNo/{rollNo}")
//	public ResponseEntity<ORSResponse> getRollNo(@PathVariable long rollNo) {
//		System.out.println("RollNo is :" + rollNo);
//		UserDTO dto = baseService.findByRollNo(rollNo);
//		ORSResponse res = new ORSResponse(true);
//		// res.setSuccess(true);
//		res.addData(dto);
//
//		return new ResponseEntity<ORSResponse>(res, HttpStatus.OK);
//	}

}
