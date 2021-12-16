package telran.b7a.account.dao;

import org.springframework.data.mongodb.repository.MongoRepository;

import telran.b7a.account.model.User;

public interface AccountMongoRepository extends MongoRepository<User, String>{

}
