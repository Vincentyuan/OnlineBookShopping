package cose.seu.action;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.servlet.http.HttpSession;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.Action;
import com.opensymphony.xwork2.ActionSupport;

import cose.seu.dao.CreditDao;
import cose.seu.dao.OrderDao;
import cose.seu.dao.UserManagerDao;
import cose.seu.dao.impl.CreditDaoImpl;
import cose.seu.dao.impl.OrderDaoImpl;
import cose.seu.dao.impl.UserManagerDaoImpl;
import cose.seu.entity.Credit;
import cose.seu.entity.Order;
import cose.seu.entity.UserInfo;
import cose.seu.util.HibernateSessionFactory;

@SuppressWarnings("serial")
public class CreditEditAction extends ActionSupport implements Action{
	/**
	 * 
	 */
	private long CCID;
	public long getCCID() {
		return CCID;
	}
	public void setCCID(long cCID) {
		CCID = cCID;
	}
	public Credit getCredit() {
		return credit;
	}
	public void setCredit(Credit credit) {
		this.credit = credit;
	}
	public Long getCreNum() {
		return creNum;
	}
	public void setCreNum(Long creNum) {
		this.creNum = creNum;
	}
	public UserInfo getUserinfo() {
		return userinfo;
	}
	public void setUserinfo(UserInfo userinfo) {
		this.userinfo = userinfo;
	}
	public List<Credit> getCreditlist() {
		return creditlist;
	}
	public void setCreditlist(List<Credit> creditlist) {
		this.creditlist = creditlist;
	}
	public CreditDao getCreditdao() {
		return creditdao;
	}
	public void setCreditdao(CreditDao creditdao) {
		this.creditdao = creditdao;
	}
	public UserManagerDao getUserdao() {
		return userdao;
	}
	public void setUserdao(UserManagerDao userdao) {
		this.userdao = userdao;
	}

	public List<Order> getOrderlist() {
		return orderlist;
	}
	public void setOrderlist(List<Order> orderlist) {
		this.orderlist = orderlist;
	}
	public Order getOrder() {
		return order;
	}
	public void setOrder(Order order) {
		this.order = order;
	}
	public Long getOid() {
		return Oid;
	}
	public void setOid(Long oid) {
		Oid = oid;
	}

	private Credit credit;	
	private Long creNum;
	private UserInfo userinfo;
	private List<Credit> creditlist;
	private CreditDao creditdao=new CreditDaoImpl();
	private UserManagerDao userdao=new UserManagerDaoImpl();
	private OrderDao orderdao=new OrderDaoImpl();
	private List<Order> orderlist;
	private Order order;
	private Long Oid;
	//到列表及修改页面
	public String list(){
		System.out.println("a");
		HttpSession s =ServletActionContext.getRequest().getSession(true);
		System.out.println("b");

		userinfo = (UserInfo) s.getAttribute("user");
		UserInfo ui=userdao.findById(userinfo.getUID());
		s.setAttribute("user", ui);
		userinfo = (UserInfo) s.getAttribute("user");
		
		creditlist=new ArrayList<Credit>(userinfo.getCreditNumber());
		System.out.println("daf");
		s.setAttribute("cr",creditdao.findById(CCID));
		return "Credit";	
	}

	//到添加页面
	public String toedit(){
		HttpSession s=ServletActionContext.getRequest().getSession(true);
		s.setAttribute("cr",creditdao.findById(CCID));
		credit=(Credit) s.getAttribute("cr");
		creNum=credit.getCreNumber();
		return "toedit";
		
	}
	public String toadd(){
		System.out.println("aa");
		return "toadd";
		
	}
	
	//添加方法
	public String add(){
		HttpSession s=ServletActionContext.getRequest().getSession(true);
		userinfo=(UserInfo) s.getAttribute("user");
		
		credit=new Credit();
		credit.setUser(userinfo);
		credit.setCreNumber(creNum);
		creditdao.create(credit);
		System.out.println(creNum+"aaaaaaaaaaaaaa");
		System.out.println(credit.getCCID());
		
		userinfo.getCreditNumber().add(credit);
		s.setAttribute("user", userinfo);
		return "toCredit";
	}
	//到更新页面

	//更新方法
	public String update(){
		HttpSession s=ServletActionContext.getRequest().getSession(true);
		userinfo = (UserInfo) s.getAttribute("user");
		UserInfo ui=userdao.findById(userinfo.getUID());
		s.setAttribute("user", ui);
		userinfo=(UserInfo) s.getAttribute("user");
		credit=(Credit) s.getAttribute("cr");
				
		
		credit.setCreNumber(creNum);
		creditdao.save(credit);
		userinfo.getCreditNumber().add(credit);
		s.setAttribute("user", userinfo);
		s.setAttribute("cr", credit);
		
		System.out.println(credit);
		//ServletActionContext.getRequest().getSession().setAttribute("credit", credit);
	
		return "toCredit";
	}
	
	//删除方法
	public String delete(){
		HttpSession s=ServletActionContext.getRequest().getSession(true);
		userinfo=(UserInfo) s.getAttribute("user");
		credit=creditdao.findById(CCID);
		userinfo.getCreditNumber().remove(credit);
		creditdao.delete(CCID);

		s.setAttribute("user", userinfo);
		s.setAttribute("cr", credit);
		System.out.println("hello");

		return "toCredit";
	}

	public String list_order(){
		System.out.println("a");
		HttpSession s=ServletActionContext.getRequest().getSession(true);
		userinfo = (UserInfo) s.getAttribute("user");
		UserInfo ui=userdao.findById(userinfo.getUID());
		s.setAttribute("user", ui);
//		UserInfo ui=userdao.findById(240l);
//		s.setAttribute("user", ui);
		userinfo=(UserInfo) s.getAttribute("user");
		System.out.println(order);
		orderlist=new ArrayList<Order>(userinfo.getOrders());
		System.out.println(orderlist);

		return "list_order";	
	}
	public String delete_order(){
		HttpSession s=ServletActionContext.getRequest().getSession(true);
		
		userinfo=(UserInfo) s.getAttribute("user");
		System.out.println(Oid);
		order=orderdao.findOrderByOrdID(Oid);
		Long orderdelete=order.getOid();
		
		
//		HibernateSessionFactory.getSessionFactory().openSession().clear();
		userinfo.getOrders().clear();
		orderdao.delete(orderdelete);

		
		System.out.println(userinfo.getOrders());
//		HibernateSessionFactory.getSession().close();
		s.setAttribute("user", userinfo);
		System.out.println("hello");

		return "delete_order";
	}
}
