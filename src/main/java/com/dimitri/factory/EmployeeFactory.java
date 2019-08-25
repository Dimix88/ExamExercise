package com.dimitri.factory;

import com.dimitri.domain.Employee;
import com.dimitri.util.Misc;

public class EmployeeFactory {
    public static Employee buildEmployee(String fName, String lName){
        return new Employee.Builder()
                .employeeId(Misc.generateId())
                .employeeFirstName(fName)
                .employeeLastName(lName)
                .build();
    }
}

