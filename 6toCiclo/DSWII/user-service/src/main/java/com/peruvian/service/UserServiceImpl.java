package com.peruvian.service;

import com.peruvian.dto.DepartmentDto;
import com.peruvian.dto.ResponseDto;
import com.peruvian.dto.UserDto;
import com.peruvian.entity.User;
import com.peruvian.repository.UserRepository;
import com.peruvian.service.UserService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.client.RestTemplate;

@Service
public class UserServiceImpl implements UserService{
	
	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private RestTemplate restTemplate;
	
	@Override
    @Transactional
    public void insert(User user) {
        userRepository.save(user);
    }

    @Override
    public ResponseDto getUser(Long userId) {

        ResponseDto responseDto = new ResponseDto();
        User user = userRepository.findById(userId).get();
        UserDto userDto = mapToUser(user);

    /*    ResponseEntity<DepartmentDto> responseEntity = restTemplate
                .getForEntity("http://localhost:8082/api/departments/listar/" + user.getDepartmentId(),
                DepartmentDto.class); */
        
            ResponseEntity<DepartmentDto> responseEntity = restTemplate
        .getForEntity("http://DEPARTMENT-SERVICE/api/departments/listar/" + user.getDepartmentId(),
        DepartmentDto.class); 

        DepartmentDto departmentDto = responseEntity.getBody();

        System.out.println(responseEntity.getStatusCode());

        responseDto.setUser(userDto);
        responseDto.setDepartment(departmentDto);

        return responseDto;
    }

    private UserDto mapToUser(User user){
        UserDto userDto = new UserDto();
        userDto.setId(user.getId());
        userDto.setFirstName(user.getFirstName());
        userDto.setLastName(user.getLastName());
        userDto.setEmail(user.getEmail());
        return userDto;
    }
	

}
