package cose.seu.entity;

import java.io.Serializable;
import java.util.*;

public class UserInfo implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 9L;
	
	private Long UID;
	private String UserName;
	private String NickName;
	private String Password;
	private String Phone;
	private String Mail;
	private String Question;
	private String Answer;
	private String Head;
	private String Level;
	private String Score;
	private Date Birth;
	private String Gender;
	private Long Age;
	private String HomAddr;
	//private Set<Type> Hobby;
	private Set<Credit> CreditNumber;
	
	private ShoppingCart ShoppingCart;
	private Set<History> His;
	private Set<Comments> ComUser;
	private Set<Favorite> Fav;
	private Set<RecAddr> RecAddress;
	private Set<Order> orders;
	public UserInfo(Long uID, String userName, String nickName,
			String password, String phone, String mail, String question,
			String answer, String head, String level, String score, Date birth,
			String gender, Long age, String homAddr, Set<Type> hobby,
			Set<Credit> creditNumber,
			cose.seu.entity.ShoppingCart shoppingCart, Set<History> his,
			Set<Comments> comUser, Set<Favorite> fav, Set<RecAddr> recAddress,
			Set<Order> orders) {
		super();
		UID = uID;
		UserName = userName;
		NickName = nickName;
		Password = password;
		Phone = phone;
		Mail = mail;
		Question = question;
		Answer = answer;
		Head = head;
		Level = level;
		Score = score;
		Birth = birth;
		Gender = gender;
		Age = age;
		HomAddr = homAddr;
		//Hobby = hobby;
		CreditNumber = creditNumber;
		ShoppingCart = shoppingCart;
		His = his;
		ComUser = comUser;
		Fav = fav;
		RecAddress = recAddress;
		this.orders = orders;
	}
	public UserInfo() {
		// TODO Auto-generated constructor stub
	}
	public Long getUID() {
		return UID;
	}
	public void setUID(Long uID) {
		UID = uID;
	}
	public String getUserName() {
		return UserName;
	}
	public void setUserName(String userName) {
		UserName = userName;
	}
	public String getNickName() {
		return NickName;
	}
	public void setNickName(String nickName) {
		NickName = nickName;
	}
	public String getPassword() {
		return Password;
	}
	public void setPassword(String password) {
		Password = password;
	}
	public String getPhone() {
		return Phone;
	}
	public void setPhone(String phone) {
		Phone = phone;
	}
	public String getMail() {
		return Mail;
	}
	public void setMail(String mail) {
		Mail = mail;
	}
	public String getQuestion() {
		return Question;
	}
	public void setQuestion(String question) {
		Question = question;
	}
	public String getAnswer() {
		return Answer;
	}
	public void setAnswer(String answer) {
		Answer = answer;
	}
	public String getHead() {
		return Head;
	}
	public void setHead(String head) {
		Head = head;
	}
	public String getLevel() {
		return Level;
	}
	public void setLevel(String level) {
		Level = level;
	}
	public String getScore() {
		return Score;
	}
	public void setScore(String score) {
		Score = score;
	}
	public Date getBirth() {
		return Birth;
	}
	public void setBirth(Date birth) {
		Birth = birth;
	}
	public String getGender() {
		return Gender;
	}
	public void setGender(String gender) {
		Gender = gender;
	}
	public Long getAge() {
		return Age;
	}
	public void setAge(Long age) {
		Age = age;
	}
	public String getHomAddr() {
		return HomAddr;
	}
	public void setHomAddr(String homAddr) {
		HomAddr = homAddr;
	}
	/*public Set<Type> getHobby() {
		return Hobby;
	}
	public void setHobby(Set<Type> hobby) {
		Hobby = hobby;
	}*/
	public Set<Credit> getCreditNumber() {
		return CreditNumber;
	}
	public void setCreditNumber(Set<Credit> creditNumber) {
		CreditNumber = creditNumber;
	}
	public ShoppingCart getShoppingCart() {
		return ShoppingCart;
	}
	public void setShoppingCart(ShoppingCart shoppingCart) {
		ShoppingCart = shoppingCart;
	}
	public Set<History> getHis() {
		return His;
	}
	public void setHis(Set<History> his) {
		His = his;
	}
	public Set<Comments> getComUser() {
		return ComUser;
	}
	public void setComUser(Set<Comments> comUser) {
		ComUser = comUser;
	}
	public Set<Favorite> getFav() {
		return Fav;
	}
	public void setFav(Set<Favorite> fav) {
		Fav = fav;
	}
	public Set<RecAddr> getRecAddress() {
		return RecAddress;
	}
	public void setRecAddress(Set<RecAddr> recAddress) {
		RecAddress = recAddress;
	}
	public Set<Order> getOrders() {
		return orders;
	}
	public void setOrders(Set<Order> orders) {
		this.orders = orders;
	}

	
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		UserInfo other = (UserInfo) obj;
		if (Age == null) {
			if (other.Age != null)
				return false;
		} else if (!Age.equals(other.Age))
			return false;
		if (Answer == null) {
			if (other.Answer != null)
				return false;
		} else if (!Answer.equals(other.Answer))
			return false;
		if (Birth == null) {
			if (other.Birth != null)
				return false;
		} else if (!Birth.equals(other.Birth))
			return false;
		if (ComUser == null) {
			if (other.ComUser != null)
				return false;
		} else if (!ComUser.equals(other.ComUser))
			return false;
		if (CreditNumber == null) {
			if (other.CreditNumber != null)
				return false;
		} else if (!CreditNumber.equals(other.CreditNumber))
			return false;
		if (Fav == null) {
			if (other.Fav != null)
				return false;
		} else if (!Fav.equals(other.Fav))
			return false;
		if (Gender == null) {
			if (other.Gender != null)
				return false;
		} else if (!Gender.equals(other.Gender))
			return false;
		if (Head == null) {
			if (other.Head != null)
				return false;
		} else if (!Head.equals(other.Head))
			return false;
		if (His == null) {
			if (other.His != null)
				return false;
		} else if (!His.equals(other.His))
			return false;
		if (HomAddr == null) {
			if (other.HomAddr != null)
				return false;
		} else if (!HomAddr.equals(other.HomAddr))
			return false;
		if (Level == null) {
			if (other.Level != null)
				return false;
		} else if (!Level.equals(other.Level))
			return false;
		if (Mail == null) {
			if (other.Mail != null)
				return false;
		} else if (!Mail.equals(other.Mail))
			return false;
		if (NickName == null) {
			if (other.NickName != null)
				return false;
		} else if (!NickName.equals(other.NickName))
			return false;
		if (Password == null) {
			if (other.Password != null)
				return false;
		} else if (!Password.equals(other.Password))
			return false;
		if (Phone == null) {
			if (other.Phone != null)
				return false;
		} else if (!Phone.equals(other.Phone))
			return false;
		if (Question == null) {
			if (other.Question != null)
				return false;
		} else if (!Question.equals(other.Question))
			return false;
		if (RecAddress == null) {
			if (other.RecAddress != null)
				return false;
		} else if (!RecAddress.equals(other.RecAddress))
			return false;
		if (Score == null) {
			if (other.Score != null)
				return false;
		} else if (!Score.equals(other.Score))
			return false;
		if (ShoppingCart == null) {
			if (other.ShoppingCart != null)
				return false;
		} else if (!ShoppingCart.equals(other.ShoppingCart))
			return false;
		if (UID == null) {
			if (other.UID != null)
				return false;
		} else if (!UID.equals(other.UID))
			return false;
		if (UserName == null) {
			if (other.UserName != null)
				return false;
		} else if (!UserName.equals(other.UserName))
			return false;
		if (orders == null) {
			if (other.orders != null)
				return false;
		} else if (!orders.equals(other.orders))
			return false;
		return true;
	}

	
	
}
