    /*
    * To change this license header, choose License Headers in Project Properties.
    * To change this template file, choose Tools | Templates
    * and open the template in the editor.
    */
    package model;

    import java.io.Serializable;
    import java.util.Timer;

    /**
    *
    * @author zakaria
    */
    public class Shop implements Serializable{
    private String name;//shop name
    private String logo;//shop logo
    private boolean liked;//does the shop is liked or no
    private boolean disliked;//does the shop is diliked or no
    private Double distance;//distance betwin user and shop
    private int id;//shop id 


    public Shop() {
    }

    public Shop(int id,String name, String logo, boolean liked, boolean disliked, Double distance) {
    this.id = id;
    this.name = name;
    this.logo = logo;
    this.liked = liked;
    this.disliked = disliked;
    this.distance = distance;
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

    public String getLogo() {
    return logo;
    }

    public void setLogo(String logo) {
    this.logo = logo;
    }



    public boolean isLiked() {
    return liked;
    }

    public void setLiked(boolean liked) {
    this.liked = liked;
    }

    public boolean isDisliked() {
    return disliked;
    }

    public void setDisliked(boolean disliked) {
    this.disliked = disliked;
    }

    public Double getDistance() {
    return distance;
    }

    public void setDistance(Double distance) {
    this.distance = distance;
    }





    }
