package telran.b7a.account.controller;

import java.io.UnsupportedEncodingException;
import java.security.Principal;
import java.util.Base64;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import telran.b7a.account.dto.RegisterUserDto;
import telran.b7a.account.dto.UserDto;
import telran.b7a.account.dto.chengePassDto;
import telran.b7a.account.dto.RolesDto;
import telran.b7a.account.dto.UpdateUserDto;
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
		return service.register(newUser);
		
	}
	@PostMapping("/login")
	public UserDto Login(Principal principal){
		return service.login(principal.getName());
		
	}
	@DeleteMapping("/user/{user}")
	public UserDto DeleteUser(@PathVariable String user) {
		return service.deleteUser(user);
		
	}
	@PutMapping("/user/{user}")
	public UserDto UpdateUser(@RequestBody UpdateUserDto updateUser,@PathVariable String user) {
		return service.updateUser(updateUser, user);
		
	}
	@PutMapping("/user/{user}/role/{role}")
	public RolesDto AddRole(@PathVariable   String user,@PathVariable   String role) {
		return service.addRole(user, role);
		
	}
	@DeleteMapping("/user/{user}/role/{role}")
	public RolesDto DeleteRole(@PathVariable  String login,@PathVariable  String role) {
		return service.deleteRole(login, role);
		
	}
	@PutMapping("/user/password")
	public void ChangePassword(@RequestBody chengePassDto newPass) {
		service.changePassword(newPass.getLogin(), newPass.getPassword());
	
		
	}
}
