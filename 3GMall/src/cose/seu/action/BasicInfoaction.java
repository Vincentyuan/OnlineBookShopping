package cose.seu.action;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.servlet.http.HttpSession;

import org.apache.commons.io.FileUtils;
import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.Action;
import com.opensymphony.xwork2.ActionSupport;

//import cose.seu.dao.RecAddrDao;
import cose.seu.dao.UserManagerDao;
//import cose.seu.dao.impl.RecAddrDaoImpl;
import cose.seu.dao.impl.UserManagerDaoImpl;
import cose.seu.entity.Order;
import cose.seu.entity.RecAddr;
import cose.seu.entity.UserInfo;

public class BasicInfoaction extends ActionSupport implements Action{
	/**
	 * 
	 */
	
	private static final long serialVersionUID = 1L;
	
	//Userinfo 成员变量
	private Long uid;
	private String opwd;
	private String pwd;
	private String pwdagain;
	private String nname;
	private String phone;
	private String mail;
	private String question;
	private String answer;
	private Date birth;
	private String gender;
	private String head;
	private String homadd;
	private UserInfo u;
	private UserManagerDao userdao=new UserManagerDaoImpl();
	//图片属性 用于接收头像图片
	private File image;
	private String imageFileName;
	private String imageCotentType;
	private String savePath;
	
	
	//主页处理action，从session中抓取user，并返回UserInfo u
	public String list_upage(){
		HttpSession s=ServletActionContext.getRequest().getSession(true);
		u=(UserInfo) s.getAttribute("user");
		System.out.println(u.getGender());
		System.out.println(u.getNickName());
		nname=u.getNickName();
		head=u.getHead();
		return "toupage";
		
	}
	
	
	//基本信息显示处理action，从session中抓取user，并利用user为页面赋值
	public String list_binfo(){
		HttpSession s=ServletActionContext.getRequest().getSession(true);
//		UserInfo ui=userdao.findById(240l);
//		s.setAttribute("user", ui);

		u=(UserInfo) s.getAttribute("user");

		uid=u.getUID();
//		opwd=u.getPassword();
		nname=u.getNickName();
		phone=u.getPhone();
		mail=u.getMail();
//		question=u.getQuestion();
//		answer=u.getAnswer();
		birth=u.getBirth();
		gender=u.getGender();
//		head=u.getHead();
		homadd=u.getHomAddr();
		s.setAttribute("user", u);
		return "tolist";		
	}
	
	
	//修改页面action，修改user相应属性
	public String edit_binfo(){
		HttpSession s=ServletActionContext.getRequest().getSession(true);
		u=(UserInfo) s.getAttribute("user");
		uid=u.getUID();
		opwd=u.getPassword();
		nname=u.getNickName();
		phone=u.getPhone();
		mail=u.getMail();
		question=u.getQuestion();
		answer=u.getAnswer();
		birth=u.getBirth();
		gender=u.getGender();
		head=u.getHead();
		homadd=u.getHomAddr();
		s.setAttribute("user", u);
		return "toedit";		
	}
	/**
	 * 	public String uploadimage(){
		System.out.println("a");
		String realpath=ServletActionContext.getServletContext().getRealPath("/ima");
		HttpSession s=ServletActionContext.getRequest().getSession(true);
		u=(UserInfo) s.getAttribute("user");
		System.out.println("Real Path: "+realpath);
		if(image!=null){
			File savedir = new File(realpath);
			if(!savedir.exists()){
				savedir.mkdirs();
			}
			File savefile = new File(realpath,this.imageFileName);
			head=this.imageFileName.concat(".").concat(imageCotentType);
			u.setHead(head);
			userdao.save(u);
			s.setAttribute("user", u);
		}
		return null;
		
	}
	 * @return
	 * @throws IOException 
	 */
	//基本信息更改action，完成页面数据同数据库交互
	public String update_binfo() throws IOException{
		HttpSession s=ServletActionContext.getRequest().getSession(true);
		String realpath=s.getServletContext().getRealPath("/ima");
		u=(UserInfo) s.getAttribute("user");
//		try {
//			nname=new String(nname.getBytes("ISO8859_1"), "UTF8");
//			gender=new String(gender.getBytes("ISO8859_1"), "UTF8");
//			question=new String(question.getBytes("ISO8859_1"), "UTF8");
//			answer=new String(answer.getBytes("ISO8859_1"), "UTF8");
//		} catch (UnsupportedEncodingException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//		
		System.out.println(u.getUID());
		System.out.println("Real Path: "+realpath);
		//密码判断逻辑
		if(pwd.length()<6||pwdagain.length()<6){
			u.setPassword(opwd);
		}else u.setPassword(pwd);
		
		System.out.println(u.getPassword());
		//手机判断逻辑
		if(phone.length()==11){
			u.setPhone(phone);
		}
		System.out.println(u.getPhone());
		//邮箱判断逻辑
		if(mail.contains("@")){
			u.setMail(mail);
		}else{
			return INPUT;
		}
		
		u.setNickName(nname);
		u.setBirth(birth);		
		u.setGender(gender);
		u.setQuestion(question);
		u.setAnswer(answer);
		if(image!=null){
			File savedir = new File(realpath);
			if(!savedir.exists()){
				savedir.mkdirs();
			}
			File savefile = new File(realpath,this.imageFileName);
			
			FileUtils.copyFile(image, savefile);
			System.out.println(imageFileName);
			head=this.imageFileName;
			u.setHead(head);
		}
		System.out.println(u.getGender());
		System.out.println(u.getNickName());
		userdao.save(u);
		s.setAttribute("user", u);
		return "backlist";		
	}
//	public String uploadimage(){
//		System.out.println("a");
//		String realpath=ServletActionContext.getServletContext().getRealPath("/ima");
//		HttpSession s=ServletActionContext.getRequest().getSession(true);
//		u=(UserInfo) s.getAttribute("user");
//		System.out.println("Real Path: "+realpath);
//		if(image!=null){
//			File savedir = new File(realpath);
//			if(!savedir.exists()){
//				savedir.mkdirs();
//			}
//			File savefile = new File(realpath,this.imageFileName);
//			head=this.imageFileName.concat(".").concat(imageCotentType);
//			u.setHead(head);
//			userdao.save(u);
//			s.setAttribute("user", u);
//		}
//		return null;
//		
//	}
	  public String getSavePath() throws Exception{
	        return ServletActionContext.getServletContext().getRealPath(savePath); 
	    }

	    public void setSavePath(String savePath) {
	        this.savePath = savePath;
	    }
//	    private void close(FileOutputStream fos, FileInputStream fis) {
//	        if (fis != null) {
//	            try {
//	                fis.close();
//	            } catch (IOException e) {
//	                System.out.println("FileInputStream关闭失败");
//	                e.printStackTrace();
//	            }
//	        }
//	        if (fos != null) {
//	            try {
//	                fos.close();
//	            } catch (IOException e) {
//	                System.out.println("FileOutputStream关闭失败");
//	                e.printStackTrace();
//	            }
//	        }
//	    }
//
//	
//	public String update_binfo() throws IOException{
//		HttpSession s=ServletActionContext.getRequest().getSession(true);
//		u=(UserInfo) s.getAttribute("user");
//		try {
//			nname=new String(nname.getBytes("ISO8859_1"), "UTF8");
//			gender=new String(gender.getBytes("ISO8859_1"), "UTF8");
//			question=new String(question.getBytes("ISO8859_1"), "UTF8");
//			answer=new String(answer.getBytes("ISO8859_1"), "UTF8");
//		} catch (UnsupportedEncodingException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//		
//		System.out.println(u.getUID());
//
//		u.setPhone(phone);
//		u.setNickName(nname);
//		u.setBirth(birth);		
//		u.setGender(gender);
//		u.setQuestion(question);
//		u.setAnswer(answer);
//		   FileOutputStream fos = null;
//	        FileInputStream fis = null;
//	        try {
//	            // 建立文件输出流
//	            System.out.println(getSavePath());
//	            fos = new FileOutputStream(getSavePath() + "\\" + getImageFileName());
//	            // 建立文件上传流
//	            fis = new FileInputStream(getImage());
//	            byte[] buffer = new byte[1024];
//	            int len = 0;
//	            while ((len = fis.read(buffer)) > 0) {
//	                fos.write(buffer, 0, len);
//	            }
//	        } catch (Exception e) {
//	            System.out.println("文件上传失败");
//	            e.printStackTrace();
//	        } finally {
//	            close(fos, fis);
//	        }
//		System.out.println(u.getGender());
//		System.out.println(u.getNickName());
//		userdao.save(u);
//		s.setAttribute("user", u);
//		return "backlist";		
//	}

	public Long getUid() {
		return uid;
	}

	public void setUid(Long uid) {
		this.uid = uid;
	}

	public String getOpwd() {
		return opwd;
	}

	public void setOpwd(String opwd) {
		this.opwd = opwd;
	}

	public String getPwd() {
		return pwd;
	}

	public void setPwd(String pwd) {
		this.pwd = pwd;
	}

	public String getPwdagain() {
		return pwdagain;
	}

	public void setPwdagain(String pwdagain) {
		this.pwdagain = pwdagain;
	}

	public String getNname() {
		return nname;
	}

	public void setNname(String nname) {
		this.nname = nname;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getMail() {
		return mail;
	}

	public void setMail(String mail) {
		this.mail = mail;
	}

	public String getQuestion() {
		return question;
	}

	public void setQuestion(String question) {
		this.question = question;
	}

	public String getAnswer() {
		return answer;
	}

	public void setAnswer(String answer) {
		this.answer = answer;
	}

	public Date getBirth() {
		return birth;
	}

	public void setBirth(Date birth) {
		this.birth = birth;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getHead() {
		return head;
	}

	public void setHead(String head) {
		this.head = head;
	}

	public String getHomadd() {
		return homadd;
	}

	public void setHomadd(String homadd) {
		this.homadd = homadd;
	}

	public UserInfo getU() {
		return u;
	}

	public void setU(UserInfo u) {
		this.u = u;
	}

	public UserManagerDao getUserdao() {
		return userdao;
	}

	public void setUserdao(UserManagerDao userdao) {
		this.userdao = userdao;
	}

	public File getImage() {
		return image;
	}

	public void setImage(File image) {
		this.image = image;
	}

	public String getImageFileName() {
		return imageFileName;
	}

	public void setImageFileName(String imageFileName) {
		this.imageFileName = imageFileName;
	}

	public String getImageCotentType() {
		return imageCotentType;
	}

	public void setImageCotentType(String imageCotentType) {
		this.imageCotentType = imageCotentType;
	}
	
//	private UserManagerDao userdao=new UserManagerDaoImpl();
//	private UserInfo user;
//	private Order order;
//	private RecAddr recaddr;
//	private Set<Order> orderset;
//	private List<Order>orderlist;
//	private Set<RecAddr> addset;
//	private List<RecAddr>addlist;
//	private RecAddrDao recaddrdao=new RecAddrDaoImpl();
//	private Long ID;

//
//	public Long getID() {
//		return ID;
//	}
//	public void setID(Long iD) {
//		ID = iD;
//	}
//	public Long getUID() {
//		return UID;
//	}
//	public void setUID(Long uID) {
//		UID = uID;
//	}
//	public UserManagerDao getUserdao() {
//		return userdao;
//	}
//	public void setUserdao(UserManagerDao userdao) {
//		this.userdao = userdao;
//	}
//	
//	public UserInfo getUser() {
//		return user;
//	}
//	public void setUser(UserInfo user) {
//		this.user = user;
//	}
//	
//	public String list_basicinfoedit(){
//		
//		HttpSession s=ServletActionContext.getRequest().getSession(true);
//		s.getAttribute("user");
//		user=userdao.findById(UID);
//		System.out.println(user.getUID());
//		System.out.println(user.getNickName());
//		System.out.println(user.getNickName());
//		
//		return "list_basic";	
//	}
//	public String save_basicinfoedit(){
//		
//		System.out.println(UID);
//		System.out.println(user.getNickName());
//		System.out.println(user.getPhone());
//		user = userdao.findById(ID);
//		System.out.println(user.getUID());
//		
//		userdao.save(user);
//		System.out.println(user.getUID());
//		
//		return "save_basic";
//		
//	}
//	
//	
//	public String list_order(){
//		orderlist=new ArrayList<Order>(user.getOrders());
//		return "list_order";
//		
//	}
//	/*public String delete_order(){
//		oders=creditdao.findById(CCID);
//		orderlist.remove(order);
//		orderset=new HashSet<Order>();
//		orderset.addAll(orderlist);
//		user.setOrders(orderset);
//		userdao.save(user);
//		orderdao.delete(CCID);
//		return "delete_order";
//		
//	}*/
//	public String list_recaddr(){
//		addlist=new ArrayList<RecAddr>(user.getRecAddress());
//		return "list_recaddr";
//	}
//	/*public String delete_recaddr(){
//		recaddr=recaddrdao.findById(ID);
//		addlist.remove(recaddr);
//		addset=new HashSet<RecAddr>();
//		addset.addAll(addlist);
//		user.setRecAddress(addset);
//		userdao.save(user);
//		recaddrdao.delete(ID);
//		return "delete_order";
//		
//	}*/
//	public String add_recaddr(){
//		recaddr.setUser(user);
//		addlist.add(recaddr);
//		addset=new HashSet<RecAddr>();
//		addset.addAll(addlist);
//		user.setRecAddress(addset);
//		userdao.save(user);
//		return "add_recaddr";
//	}
//	public String save_recaddr(){
//		addset=new HashSet<RecAddr>();
//		addset.addAll(addlist);
//		user.setRecAddress(addset);
//		userdao.save(user);
//		return "save_recaddr";
//	}
}
