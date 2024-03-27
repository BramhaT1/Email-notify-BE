package com.example.Testing;
import com.example.Testing.UserDTO;
import org.apache.xmlbeans.impl.xb.xmlconfig.Extensionconfig;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.Date;
import java.util.List;

public interface UserRepo extends JpaRepository<User,Long> {

//    @Query("SELECT u FROM User u WHERE DAY(u.dob) = DAY(:currentDate) AND MONTH(u.dob) = MONTH(:currentDate) AND u.isactive = true")
//    List<User> findActiveEmployeesWithBirthdayToday(@Param("currentDate") Date currentDate);

//        @Query(value="SELECT CONCAT(u.firstname, ' ', u.lastname) FROM main_users u WHERE DAY(u.dob) = DAY(:currentDate) AND MONTH(u.dob) = MONTH(:currentDate) AND u.isactive = true",nativeQuery = true)
//    List<String> findActiveEmployeesNamesWithBirthdayToday(@Param("currentDate") Date currentDate);

    @Query(value = "SELECT CONCAT(u.firstname, ' ', u.lastname) AS FullName " +
            "FROM sentrifugo_sagarsoft_live.main_users u " +
            "WHERE DAY(u.dob) = DAY(:currentDate) " +
            "AND MONTH(u.dob) = MONTH(:currentDate) " +
            "AND u.isactive = 1", nativeQuery = true)
    List<String> findActiveEmployeesNamesWithBirthdayToday(@Param("currentDate") Date currentDate);

    @Query(value = "SELECT u.firstname AS firstname, u.lastname AS lastname, u.emailaddress AS emailaddress, u.dob AS dob " +
            "FROM sentrifugo_sagarsoft_live.main_users u " +
            "WHERE DAY(u.dob) = DAY(:currentDate) " +
            "AND MONTH(u.dob) = MONTH(:currentDate) " +
            "AND u.isactive = 1", nativeQuery = true)
    List<UserDTO> findActiveEmployeesWithBirthdayToday(@Param("currentDate") Date currentDate);

    @Query(value = "SELECT u.firstname, u.lastname, YEAR(u.createddate) - YEAR(:givenDate) AS anniversaryYear " +
            "FROM sentrifugo_sagarsoft_live.main_users u" +
            "WHERE DAY(createddate) = DAY(:givenDate) " +
            "AND MONTH(createddate) = MONTH(:givenDate) " +
            "AND isactive = 1", nativeQuery = true)
    List<UseraDTO> findActiveUsersByWorkAnniversary(@Param("givenDate") Date currentDate);
}
