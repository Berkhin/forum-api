package telran.b7a.account.service;

import java.util.List;

import telran.b7a.account.dto.LoginUserDto;
import telran.b7a.account.dto.RegisterUserDto;
import telran.b7a.account.dto.RolesDto;
import telran.b7a.account.dto.UserDto;
import telran.b7a.account.dto.updateUserDto;

public interface AccountService {
	UserDto Register(RegisterUserDto newUser);

	UserDto Login(LoginUserDto loginUser);

	UserDto DeleteUser(String user);

	UserDto UpdateUser(updateUserDto updateUser, String user);

	RolesDto AddRole(String user, String roles);

	RolesDto DeleteRole(String user, String roles);

	void ChangePassword(LoginUserDto changePassword);
	
}
