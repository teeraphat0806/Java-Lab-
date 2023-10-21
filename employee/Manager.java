public class Manager extends Employee{
    protected String parkingNo;
    public String getParkingNo(){
        return  parkingNo;
    }

    public void setParkingNo(String parkingNo) {
        this.parkingNo = parkingNo;
    }
    public String getDetails(){
        return super.getDetails()+"ParkingNO:"+parkingNo;
    }
}
