package cose.seu.entity;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
import java.util.Set;

public class Order implements Serializable {
	/**
	 * @author Jossion
	 * 
	 */
	private static final long serialVersionUID = 5L;
	
	private Long oid;
	private Long ordid;
	private UserInfo user;
	private RecAddr addr;
	private String invContent;
	private float tolPrice;
	private float postage;
	private Date ordDate;
	private String state;
	private Set<OrderItem> orderItem;

	//enum State {
		//UNPAID, PAID, WAITING_SSEND, OUT_STOTAGE, SENDING, WAITING_RECIVE, FINISH, CANCLED
	//}

	public Order(Long oid, Long ordid, UserInfo user, RecAddr addr,
			String invContent, float tolPrice, float postage, Date ordDate,
			String state, Set<OrderItem> orderItem) {
		super();
		this.oid = oid;
		this.ordid = ordid;
		this.user = user;
		this.addr = addr;
		this.invContent = invContent;
		this.tolPrice = tolPrice;
		this.postage = postage;
		this.ordDate = ordDate;
		this.state = state;
		this.orderItem = orderItem;
	}

	public Order() {
		// TODO Auto-generated constructor stub
	}

	public Long getOid() {
		return oid;
	}

	public void setOid(Long oid) {
		this.oid = oid;
	}

	public Long getOrdid() {
		return ordid;
	}

	public void setOrdid(Long ordid) {
		this.ordid = ordid;
	}

	public UserInfo getUser() {
		return user;
	}

	public void setUser(UserInfo user) {
		this.user = user;
	}

	public RecAddr getAddr() {
		return addr;
	}

	public void setAddr(RecAddr addr) {
		this.addr = addr;
	}


	public String getInvContent() {
		return invContent;
	}

	public void setInvContent(String invContent) {
		this.invContent = invContent;
	}


	public float getTolPrice() {
		return tolPrice;
	}

	public void setTolPrice(float tolPrice) {
		this.tolPrice = tolPrice;
	}

	public float getPostage() {
		return postage;
	}

	public void setPostage(float postage) {
		this.postage = postage;
	}

	public Date getOrdDate() {
		return ordDate;
	}

	public void setOrdDate(Date ordDate) {
		this.ordDate = ordDate;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public Set<OrderItem> getOrderItem() {
		return orderItem;
	}

	public void setOrderItem(Set<OrderItem> orderItem) {
		this.orderItem = orderItem;
	}



	
}
