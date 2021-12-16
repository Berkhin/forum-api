package telran.b7a.account.service;

import java.util.List;

import org.modelmapper.ModelMapper;

import telran.b7a.account.dao.AccountMongoRepository;
import telran.b7a.account.dto.LoginUserDto;
import telran.b7a.account.dto.UserDto;
import telran.b7a.account.dto.RolesDto;
import telran.b7a.account.dto.updateUserDto;


public class AccountServiceImpl implements AccountService {
	
	AccountMongoRepository accountMongoRepository;
	
	ModelMapper modelMapper;

	@Override
	public UserDto Register(UserDto newUser) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public UserDto Login(LoginUserDto loginUser) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public UserDto DeleteUser(String user) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public UserDto UpdateUser(updateUserDto updateUser, String user) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public RolesDto AddRole(String user, List<RolesDto> roles) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public RolesDto DeleteRole(String user, List<RolesDto> roles) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void ChangePassword(LoginUserDto changePassword) {
		// TODO Auto-generated method stub
	}

}
