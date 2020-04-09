package premiereapplication.automation.test.notreapp;

import java.io.Serializable;

/**
 * Created by Sarah on 14/06/2017.
 */


public class Product implements Serializable {
    private int id;
    private String name;
    private String price;
    private String date;
    private String nom_vendeur;
    private String desc;
    private byte[] image;


    public Product(String name, String price, String date,String nom_vendeur,String desc,byte[] image, int id) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.date = date;
        this.nom_vendeur = nom_vendeur;
        this.desc = desc;
        this.image = image;

    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public byte[] getImage() {
        return image;
    }

    public void setImage(byte[] image) {
        this.image = image;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getNom_vendeur() {
        return nom_vendeur;
    }

    public void setNom_vendeur(String nom_vendeur) {
        this.nom_vendeur = nom_vendeur;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }
}


