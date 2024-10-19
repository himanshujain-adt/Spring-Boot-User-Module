package co.alpha.dto;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface EmployeeMapper {
	EmployeeMapper INSTANCE = Mappers.getMapper(EmployeeMapper.class);

	EmployeeDTO toDTO(Employee employee);

	Employee toEntity(EmployeeDTO employeeDTO);
	
	

}
