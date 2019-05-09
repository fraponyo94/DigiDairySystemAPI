package com.dairy.project.dairysystem.component;

import com.dairy.project.dairysystem.Service.EmployeeService;
import com.dairy.project.dairysystem.entity.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
public class DairyUser {

    private EmployeeService employeeService;

    @Autowired
    public DairyUser(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    public User user(String username){



        try{
            Employee employee = employeeService.findById(username);
            if (employee != null) {
                List<GrantedAuthority> grantedAuthorities = AuthorityUtils
                        .commaSeparatedStringToAuthorityList(employee.getRole().toString());
                return new User(employee.getEmployeeId(),employee.getPassword(),employee.isEnabled(),true,true,true,grantedAuthorities);
            }else {
                throw new UsernameNotFoundException("Employee with username="+employee.getEmployeeId()+" does not exist");
            }

        }catch (final Exception e){
            throw new RuntimeException(e);
        }

    }
}
