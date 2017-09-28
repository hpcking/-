package com.txl.action;

import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.annotation.Resource;

import org.apache.struts2.interceptor.SessionAware;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;


import com.txl.entity.Evaluate;
import com.txl.entity.School;
import com.txl.entity.User;
import com.txl.entity.Verify;
import com.txl.entity.ViceMonitor;
import com.txl.server.EvaluateService;
import com.txl.server.SchoolService;
import com.txl.server.UserService;
import com.txl.server.VerifyService;
import com.txl.server.ViceMonitorService;

@Controller
@Scope("prototype")
public class SchoolAction extends BaseAction<School> implements SessionAware {

	private static final long serialVersionUID = 1L;

	@Resource
	private SchoolService schoolService;
	@Resource
	private UserService userService;
	@Resource
	private ViceMonitorService viceMonitorService;
	@Resource
	private EvaluateService evaluateService;
	@Resource
	private VerifyService verifyService;
	
	private Map<String, Object> session;
    private School school;
    private List<ViceMonitor> viceMonitor;
    private List<Evaluate> evaluate;
    private User finduserid;
    private String schoolid_str;
    private List<School> schools;
    private int schoolid_int;
    private String schoolname_str;
    private int flagrole;
    private List<Verify> verifies;
	public List<Verify> getVerifies() {
		return verifies;
	}
	public int getFlagrole() {
		return flagrole;
	}
	public int getSchoolid_int() {
		return schoolid_int;
	}
	public String getSchoolname_str() {
		return schoolname_str;
	}
	public List<School> getSchools() {
		return schools;
	}
	public String getSchoolid_str() {
		return schoolid_str;
	}
	public School getSchool() {
		return school;
	}
	public List<ViceMonitor> getViceMonitor() {
		return viceMonitor;
	}

	public List<Evaluate> getEvaluate() {
		return evaluate;
	}

	public User getFinduserid() {
		return finduserid;
	}
	public String create() {
		return "create";
	}
	public String docreate()
	{
		return "redirectAction";
	}
	public void validateDocreate() {
		School school = schoolService.validateSchoolInfo(model);
		if (school != null) {
			addActionError("已有该班级可以直接加入！");		
		} else {
			User user=new User();
			user.setUserid(model.getUserid());
			Set<User> users= new HashSet<User>();
			users.add(user);
			model.setUser(users);
			schoolService.saveEntity(model);
		     User userid=userService.reseeion(model.getUserid());
		     session.remove("user");
		     session.put("user", userid);
		}
	}
	public String student() {
		User userid=new User();
		School schoolid=new School();
		schoolid.setSchoolid(Integer.parseInt(requset.getParameter("schoolid_str")));
		userid.setUserid(Integer.parseInt(requset.getParameter("userid_str")));
		this.school=schoolService.selectSchoolById(schoolid.getSchoolid());
		this.viceMonitor=viceMonitorService.selectViceMonitor(schoolid.getSchoolid());
		this.evaluate=evaluateService.seleteEvaluate(schoolid.getSchoolid(),userid.getUserid());
		return "student";
	}
	public String specificstudent()
	{
		User userid=new User();
		userid.setUserid(Integer.parseInt(requset.getParameter("userid_str")));
		this.schoolid_str=requset.getParameter("schoolid_str");
		this.finduserid=userService.findusername(userid.getUserid());
		return "specificstudent";
	}
    public String seekschool()
    {
    	this.schools=schoolService.selectSchoolByName(model.getSchoolname());
    	model.getSchoolname();
    	return "seekschool";
    }
    public String verify()
    {
        this.schoolid_int=Integer.parseInt(requset.getParameter("schoolid_str"));
        this.schoolname_str=requset.getParameter("schoolname_str");
    	return "verify";
    }
    public String role()
    {
    	School schoolid=new School();
		schoolid.setSchoolid(Integer.parseInt(requset.getParameter("schoolid_str")));
		this.school=schoolService.selectSchoolById(schoolid.getSchoolid());
    	this.flagrole=Integer.parseInt(requset.getParameter("role_str"));    	
		this.verifies=verifyService.selectVerifie(schoolid.getSchoolid());
		this.viceMonitor=viceMonitorService.selectViceMonitor(schoolid.getSchoolid());
    	return "role";
    }
    public String roleadd()
    {
    	//删除验证表中值
    	Verify verify=new Verify();
    	verify.setUserid(Integer.parseInt(requset.getParameter("userid_str")));
    	verify.setClassid(Integer.parseInt(requset.getParameter("schoolid_str")));
    	List<Verify> verifies=verifyService.selectVerifiePerson(verify.getClassid(), verify.getUserid());
    	for(Verify verifyid:verifies){
    	verifyService.delteEntity(verifyid);
    	}
    	//添加用户到班级
    	this.schoolid_str=requset.getParameter("schoolid_str");
    	School schoolid=new School();
    	schoolid.setSchoolid(Integer.parseInt(schoolid_str));
        School selectschool=schoolService.selectSchoolById(schoolid.getSchoolid());
    	Set<User> users=selectschool.getUser();
    	User user=new User();
    	user.setUserid(Integer.parseInt(requset.getParameter("userid_str")));
    	users.add(user);
    	selectschool.setUser(users);
        schoolService.saveOrUpdate(selectschool);
    	return "rerole";
    }
    public String roledelete()
    {
    	//删除验证表中值
    	this.schoolid_str=requset.getParameter("schoolid_str");
    	Verify verify=new Verify();
    	verify.setUserid(Integer.parseInt(requset.getParameter("userid_str")));
    	verify.setClassid(Integer.parseInt(schoolid_str));
    	List<Verify> verifies=verifyService.selectVerifiePerson(verify.getClassid(), verify.getUserid());
    	for(Verify verifyid:verifies){
    	verifyService.delteEntity(verifyid);
    	}
    	this.schoolid_str=requset.getParameter("schoolid_str");
    	School schoolid=new School();
    	schoolid.setSchoolid(Integer.parseInt(schoolid_str));
    	return "rerole";
    }
    public String viceMonitordelete()
    {
    	int schoolid_int=Integer.parseInt(requset.getParameter("schoolid_str"));
    	int userid_int=Integer.parseInt(requset.getParameter("userid_str"));
    	ViceMonitor vicemonitor=new ViceMonitor();
    	vicemonitor.setClassid(schoolid_int);
    	vicemonitor.setUserid(userid_int);
        ViceMonitor viceMonitorid=viceMonitorService.selectViceMonitorPerson(vicemonitor.getClassid(), vicemonitor.getUserid());
    	viceMonitorService.delteEntity(viceMonitorid);
    	return "rerole";
    }
    public String viceMonitoradd()
    {
    	int schoolid_int=Integer.parseInt(requset.getParameter("schoolid_str"));
    	int userid_int=Integer.parseInt(requset.getParameter("userid_str"));
    	ViceMonitor vicemonitor=new ViceMonitor();
    	vicemonitor.setClassid(schoolid_int);
    	vicemonitor.setUserid(userid_int);
    	viceMonitorService.saveEntity(vicemonitor);
    	return "rerole";
    }
    public String userdelete()
    {
    	int schoolid_int=Integer.parseInt(requset.getParameter("schoolid_str"));
    	int userid_int=Integer.parseInt(requset.getParameter("userid_str"));
    	School schoolid=new School();
    	schoolid.setSchoolid(schoolid_int);
    	School selectschool=schoolService.selectSchoolById(schoolid.getSchoolid());
    	User userid=new User();
    	userid.setUserid(userid_int);
    	Set<User> users=selectschool.getUser();
    	Set<User> usersRemove=new HashSet<User>();
    	for(User user:users)
    	{
    		if(user.getUserid()==userid.getUserid()){}
    		else
    		{
    		   usersRemove.add(user);	
    		}
    	}
    	selectschool.setUser(usersRemove);
    	schoolService.saveOrUpdate(selectschool);
    	return "rerole";
    }
    public String motto()
    {
    	int schoolid_int=Integer.parseInt(requset.getParameter("schoolid_str"));
    	School schoolid=new School();
    	schoolid.setSchoolid(schoolid_int);
    	this.school=schoolService.selectSchoolById(schoolid.getSchoolid());
    	return "motto";   	
    }
    public String mottoupdate()
    {
    	School selectschool=schoolService.selectSchoolById(model.getSchoolid());
    	selectschool.setMotto(model.getMotto());
    	schoolService.updateEntity(selectschool);
    	return "motto";
    }
	@Override
	public void setSession(Map<String, Object> session) {
		this.session = session;
	}

}
