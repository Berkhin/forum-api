package telran.b7a.account.service;

import org.mindrot.jbcrypt.BCrypt;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import telran.b7a.account.dao.AccountMongoRepository;
import telran.b7a.account.dto.RegisterUserDto;
import telran.b7a.account.dto.UserDto;
import telran.b7a.account.dto.RolesDto;
import telran.b7a.account.dto.UpdateUserDto;
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
	public UserDto register(RegisterUserDto newUser) {
		if (accountRepository.existsById(newUser.getLogin())) {
			throw new MyAccountNotFoundExcrption(newUser.getLogin());
		}
		User user = modelMapper.map(newUser, User.class);
		String password = BCrypt.hashpw(newUser.getPassword(), BCrypt.gensalt());
		user.setPassword(password);
		accountRepository.save(user);
		return modelMapper.map(user, UserDto.class);
	}

	@Override
	public UserDto login(String login) {
		User user = accountRepository.findById(login)
				.orElseThrow(() -> new MyAccountNotFoundExcrption(login));
		return modelMapper.map(user, UserDto.class);
	}

	@Override
	public UserDto deleteUser(String user) {
		User findUser = accountRepository.findById(user).orElseThrow(() -> new MyAccountNotFoundExcrption(user));
		accountRepository.delete(findUser);
		return modelMapper.map(findUser, UserDto.class);
	}

	@Override
	public UserDto updateUser(UpdateUserDto updateUser, String user) {
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
	public RolesDto addRole(String user, String roles) {
		User findUser = accountRepository.findById(user).orElseThrow(() -> new MyAccountNotFoundExcrption(user));
		findUser.getRoles().add(roles);
		accountRepository.save(findUser);
		return modelMapper.map(findUser, RolesDto.class);
	}

	@Override
	public RolesDto deleteRole(String user, String roles) {
		User findUser = accountRepository.findById(user).orElseThrow(() -> new MyAccountNotFoundExcrption(user));
		findUser.getRoles().remove(roles);
		accountRepository.save(findUser);
		return modelMapper.map(findUser, RolesDto.class);
	}

	@Override
	public void changePassword(String user, String password) {
		User searchUser = accountRepository.findById(user).orElseThrow(() -> new MyAccountNotFoundExcrption(user));
		searchUser.setPassword(BCrypt.hashpw(password, BCrypt.gensalt()));
		accountRepository.save(searchUser);
	}

}
