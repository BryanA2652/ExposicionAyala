/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package exposicionayala.models;

import java.sql.Date;

/**
 *
 * @author ROCIO
 */
public class driverss {
    
    private int driverId;
    private String driverRef;
    private int number;
    private String code;
    private String forename;
    private String surname;
    private Date dob;
    private String nationality;
    private String url;

    public driverss(int driverId, String driverRef, int number, String code, String forename, String surname, Date dob, String nationality, String url) {
        this.driverId = driverId;
        this.driverRef = driverRef;
        this.number = number;
        this.code = code;
        this.forename = forename;
        this.surname = surname;
        this.dob = dob;
        this.nationality = nationality;
        this.url = url;
    }

    public int getDriverId() {
        return driverId;
    }

    public String getDriverRef() {
        return driverRef;
    }

    public int getNumber() {
        return number;
    }

    public String getCode() {
        return code;
    }

    public String getForename() {
        return forename;
    }

    public String getSurname() {
        return surname;
    }

    public Date getDob() {
        return dob;
    }

    public String getNationality() {
        return nationality;
    }

    public String getUrl() {
        return url;
    }
    
    
    
}
