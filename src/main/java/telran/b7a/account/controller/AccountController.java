package telran.b7a.account.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import telran.b7a.account.dto.LoginUserDto;
import telran.b7a.account.dto.RegisterUserDto;
import telran.b7a.account.dto.UserDto;
import telran.b7a.account.dto.RolesDto;
import telran.b7a.account.dto.updateUserDto;
import telran.b7a.account.service.AccountService;

@RestController
@RequestMapping("/account")
public class AccountController {

	AccountService service;
	@Autowired
	public AccountController(AccountService accountServise) {
		super();
		this.service = accountServise;
	}
	
	@PostMapping("/register")
	public UserDto Register(@RequestBody RegisterUserDto newUser) {
		return service.Register(newUser);
		
	}
	@PostMapping("/login")
	public UserDto Login(@RequestBody LoginUserDto loginUser) {
		return service.Login(loginUser);
		
	}
	@DeleteMapping("/user/{user}")
	public UserDto DeleteUser(@PathVariable String user) {
		return service.DeleteUser(user);
		
	}
	@PutMapping("/user/{user}")
	public UserDto UpdateUser(@RequestBody updateUserDto updateUser,@PathVariable String user) {
		return service.UpdateUser(updateUser, user);
		
	}
	@PutMapping("/user/{user}/role/{role}")
	public RolesDto AddRole(@PathVariable   String user,@PathVariable   String role) {
		return service.AddRole(user, role);
		
	}
	@DeleteMapping("/user/{user}/role/{role}")
	public RolesDto DeleteRole(@PathVariable  String login,@PathVariable  String role) {
		return service.DeleteRole(login, role);
		
	}
	@PutMapping("/password")
	public UserDto ChangePassword(@RequestBody LoginUserDto changePassword) {
		return null;
	
		
	}
}
