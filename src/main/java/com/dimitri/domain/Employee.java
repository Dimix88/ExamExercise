package com.dimitri.domain;

import java.util.Objects;

public class Employee implements Comparable<Employee>{
    private String employeeId;
    private String employeeFirstName;
    private String employeeLastName;

    private Employee(){}

    public Employee(Builder builder){
        this.employeeId = builder.employeeId;
        this.employeeFirstName = builder.employeeFirstName;
        this.employeeLastName = builder.employeeLastName;
    }

    public String getEmployeeId() {
        return employeeId;
    }

    public String getEmployeeFirstName() {
           return employeeFirstName;
    }

    public String getEmployeeLastName() {
        return employeeLastName;
    }

    @Override
    public int compareTo(Employee o) {
        return this.employeeId.compareTo(o.employeeId);
    }

    public static class Builder{
        String employeeId;
        String employeeFirstName;
        String employeeLastName;

        public Builder employeeId(String employeeId){
            this.employeeId = employeeId;
            return this;
        }
        public Builder employeeFirstName(String employeeFirstName){
            this.employeeFirstName = employeeFirstName;
            return this;
        }
        public Builder employeeLastName(String employeeLastName){
            this.employeeLastName = employeeLastName;
            return this;
        }
        public Builder copy(Employee employee){
            this.employeeId = employee.employeeId;
            this.employeeFirstName  = employee.employeeFirstName;
            this.employeeLastName = employee.employeeLastName;
            return this;
        }
        public Employee build(){
            return new Employee(this);
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Employee)) return false;
        Employee employee = (Employee) o;
        return employeeId.equals(employee.employeeId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(employeeId);
    }

    @Override
    public String toString() {
        return "Employee{" +
                "employeeId='" + employeeId + '\'' +
                ", employeeFirstName='" + employeeFirstName + '\'' +
                ", employeeLastName='" + employeeLastName + '\'' +
                '}';
    }
}
