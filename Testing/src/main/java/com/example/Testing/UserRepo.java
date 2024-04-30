package com.example.Testing;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.Date;
import java.util.List;
import java.util.Map;

public interface UserRepo extends JpaRepository<User,Long> {

    @Query("SELECT u.userFullName AS fullName, u.email AS email FROM User u WHERE MONTH(u.dob) = MONTH(:date) AND DAY(u.dob) = DAY(:date) AND u.isActive = true")
    List<Map<String, Object>> findActiveUsersByBirthday(@Param("date") Date date);

    @Query("SELECT u.userFullName AS fullname, u.email AS email, YEAR(:date) - YEAR(e.dateOfJoining) AS anniversaryYear " +
            "FROM Employee e " +
            "JOIN User u ON e.user_id = u.id " +
            "WHERE MONTH(e.dateOfJoining) = MONTH(:date) AND DAY(e.dateOfJoining) = DAY(:date)")
    List<Map<String, Object>> findEmployeesWithAnniversaryByDate(@Param("date") Date date);


}
