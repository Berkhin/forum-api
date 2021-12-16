package telran.b7a.account.service;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import telran.b7a.account.dao.AccountMongoRepository;
import telran.b7a.account.dto.LoginUserDto;
import telran.b7a.account.dto.RegisterUserDto;
import telran.b7a.account.dto.UserDto;
import telran.b7a.account.dto.RolesDto;
import telran.b7a.account.dto.updateUserDto;
import telran.b7a.account.exception.MyAccountNotFoundExcrption;
import telran.b7a.account.model.User;

@Component
public class AccountServiceImpl implements AccountService {

	AccountMongoRepository accountRepository;

	ModelMapper modelMapper;

	@Autowired
	public AccountServiceImpl(AccountMongoRepository accountRepository, ModelMapper modelMapper) {
		this.accountRepository = accountRepository;
		this.modelMapper = modelMapper;
	}

	@Override
	public UserDto Register(RegisterUserDto newUser) {
		User user = modelMapper.map(newUser, User.class);
		accountRepository.save(user);
		return modelMapper.map(user, UserDto.class);
	}

	@Override
	public UserDto Login(LoginUserDto loginUser) {
		User user = accountRepository.findById(loginUser.getLogin())
				.orElseThrow(() -> new MyAccountNotFoundExcrption(loginUser.getLogin()));
		return modelMapper.map(user, UserDto.class);
	}

	@Override
	public UserDto DeleteUser(String user) {
		User findUser = accountRepository.findById(user).orElseThrow(() -> new MyAccountNotFoundExcrption(user));
		accountRepository.delete(findUser);
		return modelMapper.map(findUser, UserDto.class);
	}

	@Override
	public UserDto UpdateUser(updateUserDto updateUser, String user) {
		User findUser = accountRepository.findById(user).orElseThrow(() -> new MyAccountNotFoundExcrption(user));
		String firstName = updateUser.getFirstName();
		if (firstName != null) {
			findUser.setFirstName(firstName);
		}
		String lastName = updateUser.getLastName();
		if (lastName != null) {
			findUser.setLastName(lastName);
		}
		accountRepository.save(findUser);
		return modelMapper.map(findUser, UserDto.class);
	}


	@Override
	public RolesDto AddRole(String user, String roles) {
		User findUser = accountRepository.findById(user).orElseThrow(() -> new MyAccountNotFoundExcrption(user));
		findUser.getRoles().add(roles);
		accountRepository.save(findUser);
		return modelMapper.map(findUser, RolesDto.class);
	}

	@Override
	public RolesDto DeleteRole(String user, String roles) {
		User findUser = accountRepository.findById(user).orElseThrow(() -> new MyAccountNotFoundExcrption(user));
		findUser.getRoles().remove(roles);
		accountRepository.save(findUser);
		return modelMapper.map(findUser, RolesDto.class);
	}

	@Override
	public void ChangePassword(LoginUserDto changePassword) {
		User user = accountRepository.findById(changePassword.getLogin())
				.orElseThrow(() -> new MyAccountNotFoundExcrption(changePassword.getLogin()));
		user.setPassword(changePassword.getPassword());
		accountRepository.save(user);
		
	}

}
