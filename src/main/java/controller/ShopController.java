    /*
    * To change this license header, choose License Headers in Project Properties.
    * To change this template file, choose Tools | Templates
    * and open the template in the editor.
    */
    package controller;

    import java.io.Serializable;
    import java.util.ArrayList;
    import javax.annotation.PostConstruct;
    import javax.enterprise.context.SessionScoped;
    import javax.inject.Named;
    import model.Shop;

    /**
    *
    * @author zakaria
    */
    @Named("shopController")
    @SessionScoped
    public class ShopController implements Serializable{
    private  ArrayList<Shop>  shops;
    private  ArrayList<Shop> preferdshops;//prefered shop by current user



    @PostConstruct
    public void init(){
    initshops();
    }
    //create shops to show in cards
    public void initshops(){
    preferdshops=new ArrayList<>();
    shops=new ArrayList<Shop>();
      for (int i = 0; i < 10; i++) {
    shops.add(new Shop(i,"shop"+i,"/images/"+i+".png" ,false,false, new Double(10*i)));
    }
    }
    //like a shop
    public void like(Shop selected){
    if(!selected.isLiked())
    {selected.setLiked(true);
    selected.setDisliked(false);
    if(!preferdshops.contains(selected))
    preferdshops.add(selected);
    //update liked shop in shops list
    shops.set(selected.getId(), selected);}
    else 
    {selected.setLiked(false);
    selected.setDisliked(false);
    preferdshops.remove(selected);
    //update liked shop in shops list
    shops.set(selected.getId(), selected);}
    }
    //deslike a shop
    public void dislike(Shop selected){

    selected.setLiked(false);
    selected.setDisliked(true);
    if(preferdshops.contains(selected))
    preferdshops.remove(selected);
    //update liked shop in shops list
     shops.set(selected.getId(), selected);

    }
    //remove a shop 
    public void remove(Shop selected){
    selected.setLiked(false);
    preferdshops.remove(selected);
    //update liked shop in shops list
    shops.set(selected.getId(), selected);
    }
    //when user logedout we should destroy shops and prefered shops
    public void destroydata(){
    shops.clear();
    preferdshops.clear();

    }


    public ArrayList<Shop> getShops() {
    return shops;
    }

    public void setShops(ArrayList<Shop> shops) {
    this.shops = shops;
    }

    public ArrayList<Shop> getPreferdshops() {
    return preferdshops;
    }

    public void setPreferdshops(ArrayList<Shop> preferdshops) {
    this.preferdshops = preferdshops;
    }

    }
