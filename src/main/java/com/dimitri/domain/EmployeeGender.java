package com.dimitri.domain;

import java.util.Objects;

public class EmployeeGender implements Comparable<EmployeeGender> {
    private String employeeId;
    private String genderId;

    private EmployeeGender(){}
    public EmployeeGender(Builder builder){
        this.employeeId = builder.employeeId;
        this.genderId = builder.genderId;
    }

    public String getEmployeeId() {
        return employeeId;
    }

    public String getGenderId() {
        return genderId;
    }
    public static class Builder{
        String employeeId;
        String genderId;

        public Builder employeeId(String employeeId){
            this.employeeId = employeeId;
            return this;
        }
        public Builder genderId(String genderId){
            this.genderId = genderId;
            return this;
        }
        public Builder copy(EmployeeGender employeeGender){
            this.genderId = employeeGender.genderId;
            this.employeeId = employeeGender.employeeId;
            return this;
        }
        public EmployeeGender build(){
            return new EmployeeGender(this);
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof EmployeeGender)) return false;
        EmployeeGender that = (EmployeeGender) o;
        return employeeId.equals(that.employeeId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(employeeId);
    }

    @Override
    public int compareTo(EmployeeGender o) {
        return this.employeeId.compareTo(o.employeeId);
    }

    @Override
    public String toString() {
        return "EmployeeGender{" +
                "employeeId='" + employeeId + '\'' +
                ", genderId='" + genderId + '\'' +
                '}';
    }
}
