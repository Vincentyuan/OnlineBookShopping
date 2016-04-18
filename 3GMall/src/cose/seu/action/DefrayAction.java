package cose.seu.action;

import javax.servlet.http.HttpSession;

import org.apache.struts2.ServletActionContext;

import cose.seu.dao.OrderDao;
import cose.seu.dao.impl.OrderDaoImpl;
import cose.seu.entity.Order;
import cose.seu.entity.UserInfo;

public class DefrayAction {

	private Order ord;
	private long ooid;
	private float tol;
	
	public String defray(){
		OrderDao orderDao=new OrderDaoImpl();
		ord=orderDao.findOrderByOrdID(ooid);
		Float a = ord.getTolPrice()+ord.getPostage();
		tol=(float)(Math.round(a*100))/100;
		//System.out.println(ooid);
		return "success";
	}

	public Order getOrd() {
		return ord;
	}

	public void setOrd(Order ord) {
		this.ord = ord;
	}

	public long getOoid() {
		return ooid;
	}

	public void setOoid(long ooid) {
		this.ooid = ooid;
	}

	public float getTol() {
		return tol;
	}

	public void setTol(float tol) {
		this.tol = tol;
	}
	
}
