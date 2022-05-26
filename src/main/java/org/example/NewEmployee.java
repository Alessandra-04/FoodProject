package org.example;

public class NewEmployee {

    public long employeeId;
    public String employeeName;
    public String shift;
    public String ordersAssigned;
    public int startContract;
    public int finishContract;

    public NewEmployee (long employeeId, String employeeName, String shift, String ordersAssigned, int startContract, int finishContract) {
        this.employeeId = employeeId;
        this.employeeName = employeeName;
        this.shift = shift;
        this.ordersAssigned = ordersAssigned;
        this.startContract = startContract;
        this.finishContract = finishContract;

    }

    public long getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(long employeeId) {
        this.employeeId = employeeId;
    }

    public String getEmployeeName() {
        return employeeName;
    }

    public void setEmployeeName(String employeeName) {
        this.employeeName = employeeName;
    }

    public String getShift() {
        return shift;
    }

    public void setShift(String shift) {
        this.shift = shift;
    }

    public String getOrdersAssigned() {
        return ordersAssigned;
    }

    public void setOrdersAssigned(String ordersAssigned) {
        this.ordersAssigned = ordersAssigned;
    }

    public int getStartContract() {
        return startContract;
    }

    public void setStartContract(int startContract) {
        this.startContract = startContract;
    }

    public int getFinishContract() {
        return finishContract;
    }

    public void setFinishContract(int finishContract) {
        this.finishContract = finishContract;
    }

}
