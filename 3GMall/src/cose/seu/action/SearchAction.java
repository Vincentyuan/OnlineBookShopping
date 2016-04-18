package cose.seu.action;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.commons.collections.IteratorUtils;
import org.apache.struts.taglib.tiles.GetAttributeTag;
import org.apache.struts2.ServletActionContext;
import org.aspectj.weaver.patterns.ITokenSource;
import org.hibernate.Session;

import com.opensymphony.xwork2.ActionSupport;

import cose.seu.dao.BookDao;
import cose.seu.dao.CommentsDao;
import cose.seu.dao.LoginDao;
import cose.seu.dao.ShoppingCartDao;
import cose.seu.dao.UserManagerDao;
import cose.seu.dao.impl.BookDaoImpl;
import cose.seu.dao.impl.CommentsDaoImpl;
import cose.seu.dao.impl.LoginDaoImpl;
import cose.seu.dao.impl.ShoppingCartDaoimpl;
import cose.seu.dao.impl.UserManagerDaoImpl;
import cose.seu.entity.Book;
import cose.seu.entity.Comments;
import cose.seu.entity.ShoppingList;
import cose.seu.entity.Type;
import cose.seu.entity.UserInfo;
import cose.seu.util.HibernateSessionFactory;

public class SearchAction {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String keyword;
	private List<Book> books;
	private UserInfo user;
	private List<Type> types;
	List<HashMap<String,Object>> dataList=new ArrayList<HashMap<String,Object>>();
	private Long bk;
	private Book bok;
	private String username;
	private String pwd;
	private Long SLB;
	private Book SLBook = new Book();
	private UserInfo SLUser = new UserInfo();
//	private boolean ok=false;
	private String flag="-1";
	HttpServletResponse response;
	HttpServletRequest request;
	private String comm;
	private boolean okay;
	private String re="评论失败";
	
	public String getComm() {
		return comm;
	}

	public void setComm(String comm) {
		this.comm = comm;
	}

	public boolean isOkay() {
		return okay;
	}

	public void setOkay(boolean okay) {
		this.okay = okay;
	}

	public HttpServletResponse getResponse() {
		return response;
	}

	public void setResponse(HttpServletResponse response) {
		this.response = response;
	}

	public HttpServletRequest getRequest() {
		return request;
	}

	public void setRequest(HttpServletRequest request) {
		this.request = request;
	}

//	public boolean isOk() {
//		return ok;
//	}
//
//	public void setOk(boolean ok) {
//		this.ok = ok;
//	}

	public Long getBk() {
		return bk;
	}
	public void setflag(String flag)
	{
		this.flag=flag;
	}
	public String getflag(String flag)
	{
		return flag;
	}
	public void setBk(Long bk) {
		this.bk = bk;
	}

	public String getKeyword() {
		return keyword;
	}

	public void setKeyword(String keyword) {
		this.keyword = keyword;
	}

	public List<Book> getBooks() {
		return books;
	}

	public UserInfo getUser() {
		return user;
	}

	public void setUser(UserInfo user) {
		this.user = user;
	}

	public List<Type> getTypes() {
		return types;
	}

	public Book getBok() {
		return bok;
	}

	public void setBok(Book bok) {
		this.bok = bok;
	}

	public void setTypes(List<Type> types) {
		this.types = types;
	}

	public List<HashMap<String, Object>> getDataList() {
		return dataList;
	}

	public void setDataList(List<HashMap<String, Object>> dataList) {
		this.dataList = dataList;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPwd() {
		return pwd;
	}

	public void setPwd(String pwd) {
		this.pwd = pwd;
	}

	public void setBooks(List<Book> books) {
		this.books = books;
	}
	public String log() throws Exception{
		
	    LoginDao login=new LoginDaoImpl(); 
		HttpSession s=ServletActionContext.getRequest().getSession(true);
		System.out.println(username+pwd);
		if(!login.checkUsernameExist(username))
		{
			System.out.println("usernameNotExist");
			return "homepage";
		
		}
		if (!login.checkPwd(username, pwd)) {
			System.out.println("Password Wrong!");
			return"homepage";
		}
		Session c = HibernateSessionFactory.getSession();
		List<UserInfo> uList = c.createQuery("from UserInfo u where u.UserName ='"+username+"'").list();
		user = uList.get(0);
		System.out.println(user);
		s.setAttribute("user", user);
		return "homepagelog";
	
		
}

		
	public String logout(){
		HttpSession s=ServletActionContext.getRequest().getSession(true);

		 if (s.getAttribute("user")!= null)
		 {
			     s.removeAttribute("user");
			     return "homepage";
		 }
		 else return "homepagelog";
}
	
	public String com(){
		
		if(comm.equals("写下您的评价:") )return "comme";
		
		Date dd=new Date();
		Comments c= new Comments();	
		HttpSession s=ServletActionContext.getRequest().getSession(true);
		UserInfo u = (UserInfo) s.getAttribute("user");
		BookDao bDao = new BookDaoImpl();
		Book book = bDao.findBookById(bk);
		System.out.println(bk);
		System.out.println(book);
		System.out.println(u);
		System.out.println(comm);
		
		c.setComBook(book);
		c.setComments(comm);
		c.setUser(u);
		c.setComDate(dd);
		c.setComLevel("5");
		CommentsDao cd = new CommentsDaoImpl();
		
		
		//Set<Comments> sc = u.getComUser();
		//sc.add(c);
		//u.setComUser(sc);
		//s.setAttribute("user", u);
		cd.insertCom(c);
		
		
 		okay=true;
 		re="评论成功";
		
		return "comme";
		
		
	}
	
	public String getRe() {
		return re;
	}

	public void setRe(String re) {
		this.re = re;
	}

	public String showInfo() throws Exception {
		BookDao bd = new BookDaoImpl();
		Set<Comments> c = new HashSet<Comments>();
		
		//bk=bd.findBookByName("Java编程思想（第4版）");
		bok = bd.findBookById(bk);
		c=bok.getComments();
		System.out.println(bok.getComments().size());
		Iterator<Comments> i = c.iterator();
		while(i.hasNext()){
			System.out.println(i.next().getComments());
		}
		System.out.println(bk);
		return "bookinfo";
	}
	
	public String showItem() throws Exception{
		
		BookDao bd = new BookDaoImpl();
		
		types = bd.showType();
		for(Type type:types){
			HashMap<String, Object> map=new HashMap<String,Object>();
			List<Book> books = bd.homeshow(type.getTypeName());
			map.put("type", type);
			map.put("books", books);
			dataList.add(map);
			
		}
		ServletActionContext.getRequest().setAttribute("dataList", dataList);
	
		return "home";
	}
	public String home() throws Exception{
		System.out.println("home");
		HttpSession s = ServletActionContext.getRequest().getSession(true);
		user=(UserInfo) s.getAttribute("user");
		System.out.println(user);
		if(user==null)return "homepage";
		else
		return "homepagelog";
	}

	public String type() throws Exception {
		
		
		if (keyword == null)
			return "error";
		else {
			System.out.println(keyword);
			BookDao bDao = new BookDaoImpl();
			books = bDao.findBookByType(keyword);
			
			for(Book book:books){
				System.out.println(book.getbName());
			}
			// ctx.put("searchBook", bDao.searchByUser(keyword));
			return "success";
		}
	}
	public String search() throws Exception {
		// TODO Auto-generated method stub

		System.out.println(keyword);
		if (keyword == null)
			return "error";
		else {
			BookDao bDao = new BookDaoImpl();
			books = bDao.searchByUser(keyword);
			for(Book book:books){
				System.out.println(book.getbName());
			}
			// ctx.put("searchBook", bDao.searchByUser(keyword));
			return "success";
		}
		// System.out.println("日！！！！！");

	}
	/*public String add(){
		HttpSession s = ServletActionContext.getRequest().getSession(true);
		HttpServletResponse response=ServletActionContext.getResponse();
		SLUser = (UserInfo) s.getAttribute("user");
		ShoppingCartDao dao= new ShoppingCartDaoimpl();
		if(dao.getShoppingCartbyUser(SLUser) == null){
			dao.addShoppingCart(SLUser);
		}
		BookDao bd = new BookDaoImpl();
		SLBook = bd.findBookById(SLB);
		List<ShoppingList> slll = dao.getShoppingListSetbySCID(dao.getShoppingCartbyUser(SLUser).getSCID());
		for(int i=0;i<slll.size();i++){
			if(slll.get(i).getBook().getBID()==SLB){
				System.out.println("this book has been added.");
				try {
					response.getWriter().print("该商品已存在");
				} catch (IOException e) {
					e.printStackTrace();
				}
				return "SCsuccess";
			}
		}
		java.util.Date date = new Date();
		dao.addShoppingList(1l, dao.getShoppingCartbyUser(SLUser), date, SLBook);
		try {
			response.getWriter().print("已加入购物车");
		} catch (IOException e) {
			e.printStackTrace();
		}
		System.out.println("11111111111");
		return "SCsuccess";
	}*/
	
	public String test(){
		System.out.println(SLB);
		System.out.println("收到请求");
		return "SCsuccess";
		
	}
	public Long getSLB() {
		return SLB;
	}

	public void setSLB(Long sLB) {
		SLB = sLB;
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

}
