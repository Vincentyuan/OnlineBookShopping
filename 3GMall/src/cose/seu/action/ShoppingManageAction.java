package cose.seu.action;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

//import net.sf.json.JSONArray;
//import net.sf.json.JSONObject;

import org.apache.struts.action.Action;
import org.apache.struts2.ServletActionContext;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.opensymphony.xwork2.ActionContext;

import cose.seu.dao.BookDao;
import cose.seu.dao.FavoriteDao;
import cose.seu.dao.ShoppingCartDao;
import cose.seu.dao.UserManagerDao;
import cose.seu.dao.impl.BookDaoImpl;
import cose.seu.dao.impl.FavoriteDaoImpl;
import cose.seu.dao.impl.ShoppingCartDaoimpl;
import cose.seu.dao.impl.UserManagerDaoImpl;
import cose.seu.entity.Book;
import cose.seu.entity.Favorite;
import cose.seu.entity.ShoppingCart;
import cose.seu.entity.ShoppingList;
import cose.seu.entity.UserInfo;

public class ShoppingManageAction{

	
	private List<ShoppingList> sll=new ArrayList<ShoppingList>();
	private List<Long> bidl = new ArrayList<Long>();
	
	public Long getSLB() {
		return SLB;
	}

	public void setSLB(Long sLB) {
		SLB = sLB;
	}

	public static String[] bookid = {"book0","book1","book2","book3","book4","book5","book6","book7","book8","book9","book10"};
	
	private List<Book> SCBook=new ArrayList<Book>();
	private List<Long> Bnumber=new ArrayList<Long>();
	
	private Book SLBook = new Book();
	private UserInfo SLUser = new UserInfo();
	private Book SLBook1 = new Book();
	private Book SLBook2 = new Book();
	private float sumprice=0;
	private Long SLB;
	private Long bid;
	private boolean ok=false;
	private String totalP;
	private String tp;
	private Long slid;
	private Long fid;
	public Long getSlid() {
		return slid;
	}

	public void setSlid(Long slid) {
		this.slid = slid;
	}

	private Long Num=0l;
	public Long getNum() {
		return Num;
	}

	public String sldelete(){
		System.out.println("½øÁË£¡£¡£¡");
		HttpSession se = ServletActionContext.getRequest().getSession(true);
		UserManagerDao udao = new UserManagerDaoImpl();
		SLUser = (UserInfo) se.getAttribute("user");
		UserInfo ui=udao.findById(SLUser.getUID());
		se.setAttribute("user", ui);
		
		SLUser = (UserInfo) se.getAttribute("user");
		System.out.println(slid+"iiidddd");
		ShoppingCartDao dao = new ShoppingCartDaoimpl();
		ShoppingList ls = new ShoppingList();
		
		
		List<ShoppingList> shl=dao.getShoppingListSetbySCID(dao.getShoppingCartbyUser(SLUser).getSCID());
		System.out.println(shl.get(0).getBook().getbName());
		for (ShoppingList shopList : shl) {
			System.out.println(shopList.getBook().getBID());
			System.out.println(slid);
			if(shopList.getBook().getBID().intValue()==slid.intValue()){
				System.out.println("9999");
				dao.deleteShoppingListbySLID(shopList.getSLID());
				return "ShoppingCart";
			}
			
		}
		
	
		
		return "error";
	}
	
	public void setNum(Long num) {
		Num = num;
	}

	//private  SLBk = new ArrayList<ShoppingList>();
	private Float a=(float) 0.0;
	
	public boolean isOk() {
		return ok;
	}

	public void setOk(boolean ok) {
		this.ok = ok;
	}

	//***********************************************************

	
	public String  add(){
		
		
		
		HttpSession se = ServletActionContext.getRequest().getSession(true);
		HttpServletRequest request = ServletActionContext.getRequest();
		HttpServletResponse response = ServletActionContext.getResponse();
		SLUser = (UserInfo) se.getAttribute("user");
		ShoppingCartDao dao= new ShoppingCartDaoimpl();
		
		Cookie cookie = null;
		
		Cookie cookies[] = request.getCookies();
		for(int j=0;j<cookies.length;++j){
			System.out.println("add");
			for(int i=0;i<5;++i){
				System.out.println("add");
				if(cookies[j].getName().equals(bookid[i])){
					System.out.println("add222");
					cookies[j].setMaxAge(0);
					response.addCookie(cookies[j]);
				}
			}
			}
		System.out.println("add");
		BookDao bd = new BookDaoImpl();
		SLBook = bd.findBookById(SLB);
				

		ShoppingCart usc = dao.getShoppingCartbyUser(SLUser);
		if(usc == null){
			dao.addShoppingCart(SLUser);
			SLUser.setShoppingCart(usc);
			se.setAttribute("user", SLUser);
		}

		List<ShoppingList> slll = dao.getShoppingListSetbySCID(dao.getShoppingCartbyUser(SLUser).getSCID());
		for(int i=0;i<slll.size();++i){
			if(slll.get(i).getBook().getBID().intValue()==SLBook.getBID().intValue()){
				System.out.println("this book has added.");
				return "SCsuccess";
			}
		}
		java.util.Date date = new Date();
		dao.addShoppingList(1l, dao.getShoppingCartbyUser(SLUser), date, SLBook);
		ok= true;
		return "SCsuccess";
	}
	
//***************************************************************************************
	public String show(){
		HttpSession se = ServletActionContext.getRequest().getSession(true);
		HttpServletRequest request = ServletActionContext.getRequest();
		SLUser = (UserInfo) se.getAttribute("user");
		
		List<Book> bookl=new ArrayList<Book>();
		
		BookDao bdao = new BookDaoImpl();
		
		
		request.setAttribute("SC",123);
		
		if(SLUser.getShoppingCart()!=null){
			ShoppingCartDao dao= new ShoppingCartDaoimpl();
			sll = dao.getShoppingListSetbySCID(dao.getShoppingCartbyUser(SLUser).getSCID());
			Iterator<ShoppingList> i = sll.iterator();
			//System.out.println("11111");
			while(i.hasNext()){
				Book b =i.next().getBook();
				sumprice+=b.getPrice();
				System.out.println(sumprice);
				bookl.add(b);
			}
			SCBook = bookl;
		}
		else{
			return"emptycart";
		}
		
		
		return "ShoppingCart";
	}

	private Set<Favorite> fav=new HashSet<Favorite>();
	private Book favbook;
	public String clear(){
		ShoppingCartDao dao= new ShoppingCartDaoimpl();
		dao.deleteShoppingCartbyUser(SLUser);
		return "ShoppingCart";
	}
	
	public String favclear(){
		FavoriteDao fdao = new FavoriteDaoImpl();
		HttpSession se = ServletActionContext.getRequest().getSession(true);
		//HttpServletRequest request = ServletActionContext.getRequest();
		SLUser = (UserInfo) se.getAttribute("user");
		fdao.delete(SLUser.getUID());
		
		return "fav.jsp";
	}
	public String favshow(){
		HttpSession se = ServletActionContext.getRequest().getSession(true);
		HttpServletRequest request = ServletActionContext.getRequest();
		UserManagerDao udao = new UserManagerDaoImpl();
		SLUser = (UserInfo) se.getAttribute("user");
		UserInfo ui=udao.findById(SLUser.getUID());
		se.setAttribute("user", ui);
		SLUser = (UserInfo) se.getAttribute("user");
		
		Set<Favorite> favl=new HashSet<Favorite>();
		
		FavoriteDao fdao = new FavoriteDaoImpl();
		
		
		//request.setAttribute("S",123);
		
		if(SLUser == null){
			return "error";
		}
		favl = fdao.getSetFavorite(SLUser.getUID());
		
		System.out.println(favl.size());
		Iterator<Favorite> i = favl.iterator();
		//System.out.println("11111");
		while(i.hasNext()){
			Favorite b =i.next();
			fav.add(b);
		}
		
		return "favsuccess";
	}
//*************************************************************************************
	public String favdelete(){
		FavoriteDao fdao = new FavoriteDaoImpl();
		fdao.delete(fid);
		return "favdel";
	}
	public Long getFid() {
		return fid;
	}

	public void setFid(Long fid) {
		this.fid = fid;
	}

	public String addtofav(){
		HttpSession se = ServletActionContext.getRequest().getSession(true);
		UserManagerDao udao = new UserManagerDaoImpl();
		
		SLUser = (UserInfo) se.getAttribute("user");
		UserInfo ui=udao.findById(SLUser.getUID());
		se.setAttribute("user", ui);
		
		SLUser = (UserInfo) se.getAttribute("user");
		
		System.out.println(SLUser.getShoppingCart().getSCID());
		if(SLUser==null) return "error";
		fav = SLUser.getFav();
		
		System.out.println(fav.size());
		Iterator<Favorite> i = fav.iterator();
		while(i.hasNext()){
			if(i.next().getBook().getBID().intValue()==SLB.intValue()){
				System.out.println("this book had been added.");
				return "fs";
			}
		}
		
		
		Favorite fa = new Favorite();
		BookDao bd = new BookDaoImpl();
		SLBook = bd.findBookById(SLB);
		Date d = new Date();
		System.out.println("1");
		fa.setBook(SLBook);
		System.out.println("1");
		fa.setFavDate(d);
		fa.setUser(SLUser);
		System.out.println("1");
//		if(fav==null){
//			fav = new HashSet<Favorite>();
//			
//		}
//		fav.add(fa);
		//SLUser.setFav(fav);
		FavoriteDao fdao = new FavoriteDaoImpl();
		fdao.save(fa);
		//udao.update(SLUser);
		ok=true;
		return "fs";	
	}
//*************************************************************************************************
	
	
	public List<ShoppingList> getSll() {
		return sll;
	}

	public void setSll(List<ShoppingList> sll) {
		this.sll = sll;
	}

	public List<Book> getSCBook() {
		return SCBook;
	}

	public void setSCBook(List<Book> sCBook) {
		SCBook = sCBook;
	}

	public Book getSLBook1() {
		return SLBook1;
	}

	public void setSLBook1(Book sLBook1) {
		SLBook1 = sLBook1;
	}

	public Book getSLBook2() {
		return SLBook2;
	}

	public void setSLBook2(Book sLBook2) {
		SLBook2 = sLBook2;
	}


	public Book getSLBook() {
		return SLBook;
	}


	public void setSLBook(Book sLBook) {
		SLBook = sLBook;
	}


	public UserInfo getSLUser() {
		return SLUser;
	}


	public void setSLUser(UserInfo sLUser) {
		SLUser = sLUser;
	}


	public float getSumprice() {
		return sumprice;
	}


	public void setSumprice(float sumprice) {
		this.sumprice = sumprice;
	}


	public List<Long> getBnumber() {
		return Bnumber;
	}


	public void setBnumber(List<Long> bnumber) {
		Bnumber = bnumber;
	}


	public List<Long> getBidl() {
		return bidl;
	}


	public void setBidl(List<Long> bidl) {
		this.bidl = bidl;
	}


	public static String[] getBookid() {
		return bookid;
	}


	public static void setBookid(String[] bookid) {
		ShoppingManageAction.bookid = bookid;
	}


	public Long getBid() {
		return bid;
	}


	public void setBid(Long bid) {
		this.bid = bid;
	}


	public Set<Favorite> getFav() {
		return fav;
	}


	public void setFav(Set<Favorite> fav) {
		this.fav = fav;
	}


	public Book getFavbook() {
		return favbook;
	}


	public void setFavbook(Book favbook) {
		this.favbook = favbook;
	}





}
