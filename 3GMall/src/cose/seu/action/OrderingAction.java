package cose.seu.action;


import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.servlet.ServletRequest;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import jsx3.net.Request;

import org.apache.struts2.ServletActionContext;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.sun.org.apache.bcel.internal.generic.NEW;

import cose.seu.dao.BookDao;
import cose.seu.dao.OrderDao;
import cose.seu.dao.ShoppingCartDao;
import cose.seu.dao.UserManagerDao;
import cose.seu.dao.impl.BookDaoImpl;
import cose.seu.dao.impl.OrderDaoImpl;
import cose.seu.dao.impl.ShoppingCartDaoimpl;
import cose.seu.dao.impl.UserManagerDaoImpl;
import cose.seu.entity.Book;
import cose.seu.entity.City;
import cose.seu.entity.Order;
import cose.seu.entity.OrderItem;
import cose.seu.entity.RecAddr;
import cose.seu.entity.ShoppingList;
import cose.seu.entity.UserInfo;

public class OrderingAction{
    private List<Book> bookList=new ArrayList<Book>();
    private List<Long> bNumber=new ArrayList<Long>();
    private List<ShoppingList> shoppingLists=new ArrayList<ShoppingList>();
    private float tolPrice=new Float(0.00);
    private RecAddr addr;
    private Order order;
    private UserInfo user;
    private UserInfo user1;
    private String nameTxt;
    private String phoneTxt;
    private String invoiceTxt;
    private String detaliedAddr;
    private String paymentWay;
    private Set<RecAddr> recAddrs;
    private String receiver;
    private List<ShoppingList> ssl;
	private Set<OrderItem> orderItems;
    //private List<String> paymentList;
    private static long No=1;
    
    private long bid;
    private long bookNumber=0;

public String load() {	
		
        HttpSession s = ServletActionContext.getRequest().getSession(true);
        UserInfo user = (UserInfo) s.getAttribute("user");
        if(user==null)
        	return "tologin";
		recAddrs=new HashSet<RecAddr>();
		recAddrs=user.getRecAddress();
		
		BookDao bookDao=new BookDaoImpl();
		Book book=bookDao.findBookById(bid);
		if(bookNumber>book.getStoNumber())
			return "error";
		bookList.add(book);
		bNumber.add(bookNumber);
		ShoppingList lists=new ShoppingList();
	    lists.setBook(bookList.get(0));
	    lists.setBnumber(bNumber.get(0));
	    //System.out.println(bNumber.get(0));
	    shoppingLists.add(lists);
	    tolPrice=book.getPrice()*bookNumber;
	    HttpSession ss = ServletActionContext.getRequest().getSession(true);
	    ss.setAttribute("sh", shoppingLists);
		return "success";
	}
	
	public String settleAccount(){
		//ShoppingCartDao dao = new ShoppingCartDaoimpl();
		HttpSession s = ServletActionContext.getRequest().getSession(true);
		UserManagerDao udao = new UserManagerDaoImpl();
		user1 = (UserInfo) s.getAttribute("user");
		UserInfo ui=udao.findById(user1.getUID());
		s.setAttribute("user", ui);
		user1 = (UserInfo) s.getAttribute("user");
		if(user1==null)
			return "tologin";
		
		recAddrs=new HashSet<RecAddr>();
		recAddrs=user1.getRecAddress();
		BookDao bdao = new BookDaoImpl();
		ShoppingCartDao scd=new ShoppingCartDaoimpl();
		List<ShoppingList> sdl =scd.getShoppingListSetbySCID(scd.getShoppingCartbyUser(user1).getSCID());
		HttpServletRequest request = ServletActionContext.getRequest();
		String[] checkbox = request.getParameterValues("checkbox"); 
		if(checkbox!=null){
		    for(int i=0;i<checkbox.length;i++){
		    	System.out.println(user1.getShoppingCart().getSCID());
		    	Book tempBook=bdao.findBookByName(checkbox[i]);
		    	bookList.add(tempBook);
		    	long tempBNumber=Long.parseLong(request.getParameter(bookList.get(i).getbName()));
		    	if(tempBNumber>tempBook.getStoNumber())
		    		return "error";
			    bNumber.add(tempBNumber);
			    ShoppingList lists=new ShoppingList();
			    lists.setBook(bookList.get(i));
			    lists.setBnumber(bNumber.get(i));
			   // System.out.println(bNumber.get(i));
			    shoppingLists.add(lists);
			    tolPrice+=tempBook.getPrice()*tempBNumber;
			    
			    
			    Iterator<ShoppingList> scIterator=sdl.iterator();
			    
			    System.out.println(tempBook.getBID().intValue());
				while(scIterator.hasNext()){
					ShoppingList ls = scIterator.next();
					if(ls.getBook().getBID().intValue()==tempBook.getBID().intValue()){
						
						System.out.println("tempBook.getBID().intValue()");
						scd.deleteShoppingListbySLID(ls.getSLID());
						user1.getShoppingCart().getShoppinglist().clear();
					}
				}
			   
		    }
		}
		HttpSession ss = ServletActionContext.getRequest().getSession(true);
		ss.setAttribute("sh", shoppingLists);
		return "success";
	}
	
	
	public String submit(){

		setAddr();
		setOrder();
		return "success";
	}

	public String giveUp(){
		return "success";
	}
	
	public List<Book> getBookList() {
		return bookList;
	}

	public void setBookList(List<Book> bookList) {
		this.bookList=bookList;
	}

	public float getTolPrice() {
		return tolPrice;
	}

	public void setTolPrice(float tol) {
		tolPrice=tol;
	}

	public RecAddr getAddr() {
		return addr;
	}

public void setAddr() {
		
		HttpSession s = ServletActionContext.getRequest().getSession(true);
	    UserInfo user = (UserInfo) s.getAttribute("user");
	    SessionFactory sessionFactory=new Configuration().configure().buildSessionFactory();
		Session session=sessionFactory.openSession();
		Transaction transaction=session.beginTransaction();
		
        
		if(receiver==null||"add".equals(receiver)){
			System.out.println(receiver+"111");
			addr=new RecAddr();
			addr.setRecName(nameTxt.isEmpty()?nameTxt="ÄäÃû":nameTxt);
			addr.setRecPhone(Long.parseLong(phoneTxt.isEmpty()?phoneTxt="0":phoneTxt));
			addr.setPostcode(222001l);
			addr.setStreet(detaliedAddr);
			session.save(addr);
			user.getRecAddress().add(addr);
		}else if("change".equals(receiver)){System.out.println(receiver+"222");
			addr=(RecAddr) session.createQuery("from RecAddr ra where ra.RecName=?").setString(0, nameTxt).list().get(0);
			//addr.setRecName(nameTxt);
			addr.setRecPhone(Long.parseLong(phoneTxt.isEmpty()?phoneTxt="0":phoneTxt));
			addr.setPostcode(222001l);
			addr.setStreet(detaliedAddr);
			addr.setUser(user);
			session.update(addr);
		}else{System.out.println(receiver+"333");
			addr=(RecAddr) session.createQuery("from RecAddr ra where ra.RecName=?").setString(0, receiver).list().get(0);
		}
		transaction.commit();
		session.close();
		sessionFactory.close();	
		user.getRecAddress().add(addr);
	}

	public Order getOrder() {
		return order;
	}

	public void setOrder() {
		HttpSession s = ServletActionContext.getRequest().getSession(true);
		UserInfo user = (UserInfo) s.getAttribute("user");
		order=new Order();
		orderItems=new HashSet<OrderItem>();
		HttpSession ss = ServletActionContext.getRequest().getSession(true);
	    ssl = (List<ShoppingList>) ss.getAttribute("sh");
	    BookDao bookDao=new BookDaoImpl();
		for (ShoppingList l : ssl) {
			OrderItem tempOrderItem=new OrderItem();
			Book tempBook=l.getBook();
			long tempBnumber=l.getBnumber();
			tolPrice+=tempBook.getPrice()*tempBnumber;
			tempBook.setSalNumber(tempBnumber);
			tempBook.setStoNumber(tempBook.getStoNumber()-tempBnumber);
			bookDao.update(tempBook);
			tempOrderItem.setBook(tempBook);
			tempOrderItem.setIsbn(tempBnumber);
			tempOrderItem.setOrder(order);
			orderItems.add(tempOrderItem);	
		}
		order.setOrderItem(orderItems);
		SimpleDateFormat sdf=new SimpleDateFormat("yyyyMMddHHmmss");
		String orderDate=sdf.format(new Date());
		long orderNum=Long.parseLong(orderDate)*10000+No++;
		order.setPostage(10l);
		order.setTolPrice(tolPrice);
		order.setInvContent(invoiceTxt);
		order.setOrdDate(new Date());
		order.setOrdid(orderNum);
		order.setState("waiting");
		order.setAddr(addr);
		order.setUser(user);
		OrderDao dao=new OrderDaoImpl();
		dao.saveOrder(order);
		dao.closeSession();
		user.getOrders().add(order);
	}

	public String getNameTxt() {
		return nameTxt;
	}

	public void setNameTxt(String nameTxt) {
		this.nameTxt = nameTxt;
	}

	public String getPhoneTxt() {
		return phoneTxt;
	}

	public void setPhoneTxt(String phoneTxt) {
		    this.phoneTxt = phoneTxt;
	}

	public String getInvoiceTxt() {
		return invoiceTxt;
	}

	public void setInvoiceTxt(String invoiceTxt) {
		this.invoiceTxt = invoiceTxt;
	}

	public String getDetaliedAddr() {
		return detaliedAddr;
	}

	public void setDetaliedAddr(String detaliedAddr) {
		this.detaliedAddr = detaliedAddr;
	}


	public String getPaymentWay() {
		return paymentWay;
	}

	public void setPaymentWay(String paymentWay) {
		this.paymentWay = paymentWay;
	}
    

	public List<ShoppingList> getShoppingLists() {
		return shoppingLists;
	}

	public void setShoppingLists(List<ShoppingList> shoppingLists) {
		this.shoppingLists = shoppingLists;
	}

	public List<Long> getbNumber() {
		return bNumber;
	}

	public void setbNumber(List<Long> bNumber) {
		this.bNumber = bNumber;
	}

	public long getBid() {
		return bid;
	}

	public void setBid(long bid) {
		this.bid = bid;
	}

	public long getBookNumber() {
		return bookNumber;
	}

	public void setBookNumber(long bookNumber) {
		this.bookNumber = bookNumber;
	}

	public UserInfo getUser() {
		return user;
	}

	public void setUser(UserInfo user) {
		this.user = user;
	}

	public Set<RecAddr> getRecAddrs() {
		return recAddrs;
	}

	public void setRecAddrs(Set<RecAddr> recAddrs) {
		this.recAddrs = recAddrs;
	}

	public String getReceiver() {
		return receiver;
	}

	public void setReceiver(String receiver) {
		this.receiver = receiver;
	}

	public List<ShoppingList> getSsl() {
		return ssl;
	}

	public void setSsl(List<ShoppingList> ssl) {
		this.ssl = ssl;
	}

    
}
