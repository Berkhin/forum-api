package telran.b7a.account.service;

import java.util.List;

import telran.b7a.account.dto.LoginUserDto;
import telran.b7a.account.dto.RolesDto;
import telran.b7a.account.dto.UserDto;
import telran.b7a.account.dto.updateUserDto;

public interface AccountService {
	UserDto Register(UserDto newUser);

	UserDto Login(LoginUserDto loginUser);

	UserDto DeleteUser(String user);

	UserDto UpdateUser(updateUserDto updateUser, String user);

	RolesDto AddRole(String user, List<RolesDto> roles);

	RolesDto DeleteRole(String user, List<RolesDto> roles);

	void ChangePassword(LoginUserDto changePassword);
	
}
