package com.shanil.ts;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;



import java.util.ArrayList;  
import java.util.List; 


@Service
public class LoginService {
	
	
	@Autowired
	LoginRepository repo;
	
	
	public List<User> getAllusers()   
	{  
	List<User> user = new ArrayList<User>();  
	repo.findAll().forEach(users1 -> user.add(users1));  
	return user;  
	}
	public User fetchUser(String email, String password){
		return repo.findByEmailIdAndPassword(email, password);
	}
	public User saveUser(User user) {
		return repo.save(user);
	}
	
	public User fetchUserByEmailId(String email) {
		return repo.findByEmailId(email);
	}
	public void delete(int id)   
	{  
	repo.deleteById(id);  
	} 
	public void saveOrUpdate(User user) {
		repo.save(user);
	}
}
