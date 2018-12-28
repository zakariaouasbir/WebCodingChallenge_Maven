
/*
* To change this license header, choose License Headers in Project Properties.
* To change this template file, choose Tools | Templates
* and open the template in the editor.
*/
package controller;

import Util.JsfUtil;
import Util.Session;
import java.io.IOException;
import java.io.Serializable;
import java.util.ArrayList;
import javax.enterprise.context.SessionScoped;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.inject.Named;
import model.User;

/**
*
* @author zakaria
*/
@Named("userController")
@SessionScoped
public class UserController implements Serializable{
private User user;//user for sign in proces
private User added;//user for sign up proces 
private ArrayList<User> users=new ArrayList<>();
private JsfUtil jsf=new JsfUtil();
private Session session=new Session();
//store shops & liked shops before logout 
@Inject
private ShopController shop;


public User getAdded() {
if(added==null)
added= prepareCreate();
return added;
}

public void setAdded(User added) {
this.added = added;
}

 public User getUser() {
if(user==null)
user= prepareCreate();
return user;
}

public void setUser(User user) {
this.user = user;
}

public ArrayList<User> getUsers() {
return users;
}

public void setUsers(ArrayList<User> users) {
this.users = users;
}

public Session getSession() {
return session;
}

public void setSession(Session session) {
this.session = session;
}

 //sign up process using email and password 
public void signup() throws IOException
{  if(getUsers().size()==0)
{getUsers().add(getAdded());
setAdded(null);
redirect("signin");
}else{
for(User a_user:getUsers())
if(!(a_user.getEmail()).equals(getAdded().getEmail()))
{ getUsers().add(getAdded());
setAdded(null);
redirect("signin");
}
}
jsf.addErrorMessage("Sign up failed ,Email already exist ");

}
//PREPARE TO CRATE TO OPTIMISE CREATED OBJECTS
public User prepareCreate() {
user = new User();
return user;
}
//LOGIN USING EMAL AND PASSWORD
public void login() throws IOException {
for(User a_user:users)
if (a_user.getEmail().equalsIgnoreCase(getUser().getEmail()) && a_user.getPassword().equalsIgnoreCase(getUser().getPassword())) 
{   session.setAttribut(getUser(),getUser().getEmail());
user = (User) session.getAttribut(getUser().getEmail());
shop.initshops();
redirect("main");
break;
}  
jsf.addErrorMessage("Sign in failed , please check your login & password ");

}
public void logout() throws IOException{
session.setAttribut(shop.getPreferdshops(), "prefered"+getUser().getEmail());
session.setAttribut(shop.getShops(), "shops"+getUser().getEmail());
shop.destroydata();
user=null;
redirect("signin");

}
//REDIRECT O GIVING PATH AFTER SIGN UP OR SIGN IN 
public static void redirect(String pagePath) throws IOException {
if (!pagePath.endsWith(".xhtml")) {
pagePath += ".xhtml";
}
FacesContext.getCurrentInstance().getExternalContext().redirect(pagePath);

}
}