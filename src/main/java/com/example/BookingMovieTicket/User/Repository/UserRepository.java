package com.example.BookingMovieTicket.User.Repository;
import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;


import com.example.BookingMovieTicket.User.Dto.UserDto;
import com.example.BookingMovieTicket.User.Entity.User;
@Repository
public interface UserRepository extends JpaRepository<User,Long>  {
	@Query(value= "SELECT * FROM users u",nativeQuery=true)
	List<UserDto> findAllUserDto();
	
	@Modifying
	@Transactional
	@Query("UPDATE User u SET u.username=:username,u.password=:password,u.email=:email WHERE u.id=:id ")
	void update(@Param("id") Long id,@Param("username") String username,@Param("password") String password,@Param("email") String email);
	
	@Query("SELECT u AS name FROM User u  WHERE u.username = ?1")
	Optional<User> findByUsernameAndRole( String username);
	
	
	
	
}
