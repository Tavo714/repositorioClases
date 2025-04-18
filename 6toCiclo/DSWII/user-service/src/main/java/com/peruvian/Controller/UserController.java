package com.peruvian.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import com.peruvian.dto.ResponseDto;
import com.peruvian.entity.User;
import com.peruvian.service.UserService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/users")
public class UserController {
	
	@Autowired
	private UserService userService;
	
	@PostMapping("/agregar")
    public ResponseEntity<?> agregar(@RequestBody User user){
        userService.insert(user);
        return new ResponseEntity<Void>(HttpStatus.CREATED);
    }

    @GetMapping("{id}")
    public ResponseEntity<ResponseDto> getUser(@PathVariable("id") Long userId){
        ResponseDto responseDto = userService.getUser(userId);
        return ResponseEntity.ok(responseDto);
    }

}
