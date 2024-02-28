package Entities;

import java.util.ArrayList;
import java.util.List;

public class Client {
    private int id;
    private String nomComplet; 
    private String email; 
    private String telephone;

    //Attributs de Navigation 
    //OneToMany 
    ArrayList<Adresse> adresseList=new ArrayList<>();
    
    public ArrayList<Adresse> getAdresseList() {
        return adresseList;
    }
    public void setAdresseList(ArrayList<Adresse> adresseList) {
        this.adresseList = adresseList;
    }
    public Client() {
    }
    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    public String getNomComplet() {
        return nomComplet;
    }
    public void setNomComplet(String nomComplet) {
        this.nomComplet = nomComplet;
    }
    public String getEmail() {
        return email;
    }
    public void setEmail(String email) {
        this.email = email;
    }
    public String getTelephone() {
        return telephone;
    }
    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }
}
