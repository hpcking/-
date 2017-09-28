package com.txl.action;

import java.io.File;
import java.util.Map;

import javax.annotation.Resource;

import org.apache.struts2.ServletActionContext;
import org.apache.struts2.interceptor.SessionAware;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.util.DigestUtils;

import com.txl.entity.User;
import com.txl.server.UserService;
import com.opensymphony.xwork2.ActionContext;

@Controller
@Scope("prototype")
public class UserAction extends BaseAction<User> implements SessionAware{

	private static final long serialVersionUID = 1L;
	private Map<String, Object> session;
	@Resource
	private UserService userService;
	private String uploadFileContentType;//接受文件的类型(去掉)
	private String uploadFileFileName;//接受上传文件的名称
	private File uploadFile;//接受上传的文件
	public String getUploadFileContentType() {
		return uploadFileContentType;
	}
	public void setUploadFileContentType(String uploadFileContentType) {
		this.uploadFileContentType = uploadFileContentType;
	}
	public String getUploadFileFileName() {
		return uploadFileFileName;
	}
	public void setUploadFileFileName(String uploadFileFileName) {
		this.uploadFileFileName = uploadFileFileName;
	}
	public File getUploadFile() {
		return uploadFile;
	}
	public void setUploadFile(File uploadFile) {
		this.uploadFile = uploadFile;
	}
	public String index()
	{
		return "index";
	}
	public String add()
	{
		return "add";
	}
	public String doadd()
	{
		String path=ServletActionContext.getRequest().getRealPath("/img");
		File dir=new File(path);
		if(!dir.exists())
		{
			dir.mkdirs();
		}
		String sub=this.uploadFileFileName.substring(this.uploadFileFileName.lastIndexOf(".")+1);
		String filename=System.currentTimeMillis()+"."+sub;
		File dest=new File(dir,filename);
		this.uploadFile.renameTo(dest);
		String imagename="/img/"+filename;
		model.setImage(imagename);
		String pass=model.getPassword();
		String password=DigestUtils.md5DigestAsHex(pass.getBytes());
		model.setPassword(password);
		userService.saveEntity(model);
		return "login";
	}
	public String edit()
	{
		return "edit";
	}
    public String doedit()
    {
    	String flag=requset.getParameter("flag");
	     if(!flag.equals("")){
	    	 String password=model.getPassword();
	    	 password=DigestUtils.md5DigestAsHex(password.getBytes());
	    	 model.setPassword(password);
	     }
	     String img=requset.getParameter("image");
	     if(!img.equals("")){
	    	 String path=ServletActionContext.getRequest().getRealPath("/img");
				String sub=this.uploadFileFileName.substring(this.uploadFileFileName.lastIndexOf(".")+1);
				String filename=System.currentTimeMillis()+"."+sub;
				File dir=new File(path);
				File dest=new File(dir,filename);
				this.uploadFile.renameTo(dest);
				File dirdel=new File(ServletActionContext.getRequest().getRealPath("/")+(String) requset.getAttribute("img"));
				dirdel.delete();
				String imagename="/img/"+filename;
				model.setImage(imagename);
	     }
	     if(img.equals("")){
	     String imageurl=requset.getParameter("imageurl");
	     model.setImage(imageurl);
	     }
	     User userid=userService.findusername(model.getUserid());
	     model.setSchool(userid.getSchool());
	     userService.updateEntity(model);
	     User user=userService.reseeion(requset.getAttribute("userid"));
	     session.remove("user");
	     session.put("user", user);
    	return "redirectAction";
    }
    public String logout()
    {
    	ActionContext context = ActionContext.getContext();
    	context.getSession().clear();    
    	return "logout";
    }
    @Override
	public void setSession(Map<String, Object> session) {
		this.session = session;
	}
}
