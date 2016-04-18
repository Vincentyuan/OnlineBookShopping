package cose.seu.dao;


import java.sql.Date;
import java.util.List;
import java.util.Set;

import cose.seu.entity.Book;
import cose.seu.entity.ShoppingCart;
import cose.seu.entity.ShoppingList;
import cose.seu.entity.UserInfo;

public interface ShoppingCartDao {
	
	public void addShoppingCart(UserInfo user);
	public void addShoppingList(Long bnumber, ShoppingCart shoppingcart, java.util.Date date,Book book);
	
	public void deleteShoppingCartbyUser(UserInfo user);
	public void deleteShoppingCartbySC(ShoppingCart shoppingcart);
	public List<ShoppingList> getShoppingListSetbySCID(Long sCID);
	public void deleteShoppingListbySLID(Long sLID);
	
	public ShoppingCart getShoppingCartbyUser(UserInfo user);
	public ShoppingList getShoppingListbySLID(Long sLID);
	public ShoppingCart getShoppingCartbySCID(Long sCID);

	
	public void updateBNumber(ShoppingList shoppinglist,Long bnumber);
	
}

