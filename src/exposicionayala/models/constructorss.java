/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package exposicionayala.models;

/**
 *
 * @author ROCIO
 */
public class constructorss {
     private final int constructorId;
        private final String constructorRef;
        private final String name;
        private final String nationality;
        private final String url;

    public constructorss(int constructorId, String constructorRef, String name, String nationality, String url) {
        this.constructorId = constructorId;
        this.constructorRef = constructorRef;
        this.name = name;
        this.nationality = nationality;
        this.url = url;
    }

    public int getConstructorId() {
        return constructorId;
    }

    public String getConstructorRef() {
        return constructorRef;
    }

    public String getName() {
        return name;
    }

    public String getNationality() {
        return nationality;
    }

    public String getUrl() {
        return url;
    }
        
    
        
}
