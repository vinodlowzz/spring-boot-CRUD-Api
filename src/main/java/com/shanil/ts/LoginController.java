package com.shanil.ts;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;



import java.util.List;  

@RestController
public class LoginController {
	@Autowired
	LoginService service;

	
	@GetMapping("/user")
	@CrossOrigin(origins="http://localhost:4200")
	private List<User> getAllusers()   
	{  
	return service.getAllusers();  
	}
	
	@PostMapping("/login")
	@CrossOrigin(origins="http://localhost:4200")
	public User loginUser(@RequestBody User user) throws Exception {
		String tempEmailId=user.getEmailId();
		String tempPass = user.getPassword();
		User userobj=null;
		if(tempEmailId != null && tempPass != null) {
			userobj = service.fetchUser(tempEmailId, tempPass);
			
		}
		if(userobj==null) {
			throw new Exception("user is not exist");
		}
		return userobj;
		
		
		
	}
	@PostMapping("/registeruser")
	@CrossOrigin(origins="http://localhost:4200")
	public User registerUser(@RequestBody User user) throws Exception {
		
		String tempEmailId = user.getEmailId();
		if (tempEmailId != null && !"".equals(tempEmailId)) {
			User userobj = service.fetchUserByEmailId(tempEmailId);
			if (userobj != null) {
				throw new Exception("user with" + tempEmailId + "is already exist");
			}
		}
		User userObj = null;
		userObj=service.saveUser(user);
		return userObj;
	}
	@DeleteMapping("/deleteuser/{id}")
	@CrossOrigin(origins="http://localhost:4200")
	public void deleteUser(@PathVariable("id") int id) {
		service.delete(id);
	}
	
	@PutMapping("/update/{id}")
	@CrossOrigin(origins="http://localhost:4200")
	public User update(@RequestBody User user) {
		service.saveOrUpdate(user);
		return user;
	}
		
}