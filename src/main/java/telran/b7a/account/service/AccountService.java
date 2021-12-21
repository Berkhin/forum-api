package telran.b7a.account.service;

import java.util.List;

import telran.b7a.account.dto.RegisterUserDto;
import telran.b7a.account.dto.RolesDto;
import telran.b7a.account.dto.UserDto;
import telran.b7a.account.dto.chengePassDto;
import telran.b7a.account.dto.UpdateUserDto;

public interface AccountService {
	UserDto register(RegisterUserDto newUser);

	UserDto login(String login);

	UserDto deleteUser(String user);

	UserDto updateUser(UpdateUserDto updateUser, String user);

	RolesDto addRole(String user, String roles);

	RolesDto deleteRole(String user, String roles);

	void changePassword(String user, String password);
	
}
