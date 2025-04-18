package com.peruvian.service;

import com.peruvian.entity.User;
import com.peruvian.dto.ResponseDto;

public interface UserService {
	
	public abstract void insert(User user);

	
	ResponseDto getUser(Long userId);
	
    
}
