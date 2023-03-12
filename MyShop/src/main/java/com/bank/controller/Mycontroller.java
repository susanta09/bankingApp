package com.bank.controller;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Random;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.bank.ADto.LoginDto;
import com.bank.ADto.LoginResult;
import com.bank.ADto.TransactionDto;
import com.bank.modal.Account;
import com.bank.modal.Address2;
import com.bank.modal.Address3;
import com.bank.modal.PaymentDetails;
import com.bank.modal.Registration2;
import com.bank.modal.TransactionDetails;
import com.bank.modal.UserLogin;
import com.bank.service.AccountServiceImpl;
import com.bank.service.RegistrationServiceImp;
import com.bank.service.UserLoginServiceImp;

@Controller
public class Mycontroller {

	UserLoginServiceImp ser = new UserLoginServiceImp();

	public static int randomNumber() {
		Random r = new Random();
		int min = 100000;
		int max = 999999;
		int rn = (int) Math.floor(Math.random() * (max - min + 1) + min);
		return rn;
	}
	 LoginResult lr ;
	 @RequestMapping("/")
	 public ModelAndView logOut()
	 {
		 lr.setRid(00000);
		 System.out.println("LogOut"+lr.getRid());
		 ModelAndView m=new ModelAndView();
		 m.addObject("message","Logout is successfull");
		 m.setViewName("home");
		 return m;
	 }
	@RequestMapping("/log")
	public String loginForm() {
		return "login";
	}

	@RequestMapping("/regform")
	public String regisForm(Model model) {
		model.addAttribute("reg", new LoginDto());
		return "registration";
	}

	@RequestMapping("/collesp")
	public String collesp() {
		return "collesp";
	}

	@RequestMapping("/ok")
	public ModelAndView register(@ModelAttribute("reg") LoginDto user, Model model) {
		user.setRegNo(randomNumber());
		System.out.println(user);
		ModelAndView m=new ModelAndView();
		if(ser.saveData(user)>0)
		{
			m.addObject("result","Welcome to Yes Bank" );
		}
		else {
			m.addObject("result","Plese Register for Login" );

		}
		m.setViewName("successR");
		return m;
	}
  
   
	@RequestMapping("/login")
	public String createAccount(@RequestParam("userName") String name, @RequestParam("password") int pass ,@RequestParam("userType")String userType) {
		LoginDto ul=new LoginDto();
		ul.setUserType(userType);
		ul.setPassword(pass);
		ul.setUserName(name);
		System.out.println(ul);
		 lr = ser.createAccountState(ul);
		int rid=lr.getRid();
		if(lr.getUserType().equals("admin"))
		{
			return"admin";
		}
		else {
			if (lr.getState().equals("success")) {
				return "nab";
			} else if (lr.getState().equals("fail")) {
				return "createAccount";
			} else {
				return "home";
			}
		}
	}

	// ===========registration=========================
	RegistrationServiceImp rser = new RegistrationServiceImp();

	@RequestMapping("/form")
	public ModelAndView showReg() {
		ModelAndView m = new ModelAndView();
	    Registration2 reg=new Registration2();
	    m.addObject("rid", lr.getRid());
		m.addObject("reg",reg );
		m.addObject("add", new Address2());
		m.setViewName("registration2");
		return m;
	}

	@RequestMapping("/rr")
	public ModelAndView registerData(@ModelAttribute("reg") Registration2 reg2, @ModelAttribute("add") Address2 address2,
			Model model) {
		System.out.println(reg2);
		System.out.println(address2);
      
        ModelAndView m= new ModelAndView();
        if(rser.saveRegData(reg2, address2)>0)
		{
			m.addObject("result","Registratin is successfull" );
		}
		else {
			m.addObject("result","Registratin is fail" );

		}
		m.setViewName("successR");
		return m;
	}

	@RequestMapping("getdata")
	public ModelAndView showData() {
		Registration2 reg=null;
		ModelAndView m = new ModelAndView();
		if(lr.getRid()!=0)
		{
			reg = rser.showData(lr.getRid());
		}
		else {
			m.addObject("message", "Plese login the page");
			m.setViewName("home");
			return m;
		}
		Address3 add3 = (Address3) reg.getAddress3();

		Address2 add2 = new Address2();
		add2.setPincode(add3.getId().getPincode());
		add2.setCity(add3.getId().getCity());
		add2.setDist(add3.getDist());
		add2.setState(add3.getState());
		add2.setCountry(add3.getCountry());

		//ModelAndView m = new ModelAndView();
		m.addObject("reg", reg);
		m.addObject("add", add2);
		m.setViewName("display");
		return m;
	}
	
	//=========Transaction=============
	AccountServiceImpl acser=new AccountServiceImpl();
	@RequestMapping("depo")
	public ModelAndView showDepo()
	{
		TransactionDto tdto=new TransactionDto();
		ModelAndView m=new ModelAndView();
		if(lr.getRid()!=0)
		{
			m.addObject("tr", tdto);
			m.setViewName("deposit");
			return m;
		}
		else {
			m.addObject("message", "Plese login the page");
			m.setViewName("home");
			return m;
		}
		
	}
	@RequestMapping("with")
	public ModelAndView showWithdraw()
	{
		TransactionDto tdto=new TransactionDto();
		ModelAndView m=new ModelAndView();
		if(lr.getRid()!=0)
		{
			m.addObject("tr", tdto);
			m.setViewName("withdraw");
			return m;
		}
		else {
			m.addObject("message", "Plese login the page");
			m.setViewName("home");
			return m;
		}
		
	}
	@RequestMapping("trans")
	public ModelAndView showTran()
	{
		TransactionDto tdto=new TransactionDto();
		ModelAndView m=new ModelAndView();
		if(lr.getRid()!=0)
		{
			m.addObject("tr", tdto);
			m.setViewName("transactionAmount");
			return m;
		}
		else {
			m.addObject("message", "Plese login the page");
			m.setViewName("home");
			return m;
		}
	}
	@RequestMapping("/dep")
	public ModelAndView addAmount(@ModelAttribute("tr") TransactionDto tdto,Model model)
	{
		tdto.setRid(lr.getRid());
		tdto.setDate(LocalDateTime.now());
		int k=acser.depositAccount(tdto);
		System.out.println("Controll-->"+k);
		ModelAndView m=new ModelAndView();
		if(k==1){
			m.addObject("result", "Deposit Transaction is Successfull");
			m.setViewName("success");
			return m;
		}
		else
		{
			m.addObject("result", "Deposit Transaction is Fail");
			m.setViewName("success");
			return m;
		}
	}
	@RequestMapping("/sub")
	public ModelAndView substrucAmount(@ModelAttribute("tr") TransactionDto tdto,Model model)
	{
		tdto.setRid(lr.getRid());
		tdto.setDate(LocalDateTime.now());
		int k=acser.withdrawAccount(tdto);
		System.out.println("Controll-->"+k);
		ModelAndView m=new ModelAndView();
		if(k==1){
			m.addObject("result", "Withdraw Transaction is Successfull");
			m.setViewName("success");
			return m;
		}
		else
		{
			m.addObject("result", "Withdraw Transaction is Fail");
			m.setViewName("success");
			return m;
		}
	}
	@RequestMapping("/row")
    public int totalRow(int rid)
    {
    	int n=acser.firstData(rid);
    	return n;
    	
    }
	  @RequestMapping("thistory")
	    public ModelAndView transactionHis()
	    {
	    	ModelAndView m=new ModelAndView();
	    	if(lr.getRid()!=0)
			{
	    		m.setViewName("thistory");
	    		return m;
			}
			else {
				m.addObject("message", "Plese login the page");
				m.setViewName("home");
				return m;
			}
	    }
    @RequestMapping("/pagtran")
    public ModelAndView showPagi(Model m) { 
	return pagination(1, m);
	}
	 	 
    @RequestMapping(value ="emp/{pageno}" )
	public ModelAndView pagination(@PathVariable("pageno") int pageNo,Model k)
	{
    	System.out.println("pagination=="+lr.getRid());
		int tRow=totalRow(lr.getRid());
		int item=4;
		int nop=0;
		if(tRow/item==0)
		{
			nop=tRow/item;
		}
		else
		{
			nop=(tRow/item)+1;
		}
		int currentP=pageNo-1;
		List<TransactionDetails> trdh;
		trdh=acser.tranHisDet(lr.getRid(), currentP,item);
		ModelAndView m=new ModelAndView();
		m.addObject("noP",nop );
		m.addObject("trdh", trdh);
		m.addObject("currentP", currentP);
		m.setViewName("transactionHistroy");
		String emp="emp";
		m.addObject("emp", emp);
		return m;
  
	}
	@RequestMapping("/tran")
	public ModelAndView transAmount(@ModelAttribute("tr") TransactionDto tdto,Model model)
	{
		tdto.setRid(lr.getRid());
		tdto.setDate(LocalDateTime.now());
		int n=acser.transactionPay(tdto);
//		System.out.println("Controll-->"+k);
		ModelAndView m=new ModelAndView();
		if(n==1){
			m.addObject("result", "Payment Process is Successfull");
			m.setViewName("success");
			return m;
		}
		else
		{
			m.addObject("result", "Payment Process is Fail");
			m.setViewName("success");
			return m;
		}
				
	}
	
	  @RequestMapping("payhistory")
	    public ModelAndView paymentHis()
	    {
	    	
			ModelAndView m=new ModelAndView();
	    	if(lr.getRid()!=0)
			{
	    		m.setViewName("payhistory");
	    		return m;
			}
			else {
				m.addObject("message", "Plese login the page");
				m.setViewName("home");
				return m;
			}
	    }
	  @RequestMapping("/payrow")
	    public int totalPaymentRow(int rid)
	    {
	    	int n=acser.firstPaymentData(rid);
	    	return n;	
	    }
	  @RequestMapping("/pag")
		public ModelAndView showPay( Model m)
		{
			return paginationPayment(1,m);
		}
	
	@RequestMapping("pay/{pno}")
	public ModelAndView paginationPayment(@PathVariable("pno") int pageNo, Model k) {
		int tRow = totalPaymentRow(lr.getRid());
		int item = 4;
		int nop = 0;
		if (tRow / item == 0) {
			nop = tRow / item;
		} else {
			nop = (tRow / item) + 1;
		}
		int currentP = pageNo - 1;
		List<PaymentDetails> trdh;
		trdh = acser.paymenDetails(lr.getRid(),currentP, item);
		ModelAndView m = new ModelAndView();
		m.addObject("noP", nop);
		m.addObject("trdh", trdh);
		m.addObject("currentP", currentP);
		m.setViewName("payment_details");
		return m;
	}
//==========================Admin section===================
	@RequestMapping("admin")
	public String admin()
	{
		return "accountDetails";
	}
	
	@RequestMapping(value ="acc/")
	public ModelAndView getAccount(@RequestParam("acno") int rid)
	{
		System.out.println(rid);
		Account ac=acser.searchAccount(rid);
		System.out.println(ac);
		ModelAndView m=new ModelAndView();
		
		m.addObject("acc", ac);
		m.setViewName("accountDetails");
		return m; 
	}
	@RequestMapping(value ="acBlockUnblock/{b}/{acNo}")
	public ModelAndView acBlockUnblock(@PathVariable("b") String access,@PathVariable("acNo") int accountNo)
	{
		System.out.println("access--"+access);
   		System.out.println("accountNo--"+accountNo);
		Account ac=acser.searchAccount(accountNo);
		System.out.println("before-->"+ac);
		ac.setAccess(access);
		System.out.println(ac);
		Account acc=acser.updateAccount(ac);
		System.out.println(acc);
		ModelAndView m=new ModelAndView();
		m.addObject("acc", acc);
		m.setViewName("accountDetails");
		return m;
	}
	@RequestMapping("/pay")
	public String pay()
	{
		return "searchPay";
	}
	@RequestMapping(value ="payment/")
	public ModelAndView getPay(@RequestParam("rid") int rid)
	{
		return paymentDetailsByRid(1,rid); 
	}
	@GetMapping("/payD/{pageno}/{rid}")
	public ModelAndView paymentDetailsByRid(@PathVariable("pageno") int pageNo,@PathVariable("rid")int rid)
	{
		int tRow=totalPaymentRow(rid);
		int item=4;
		int nop=0;
		if(tRow/item==0)
		{
			nop=tRow/item;
		}
		else
		{
			nop=(tRow/item)+1;
		}
		int currentP=pageNo-1;
		List<PaymentDetails> trdh;
		trdh=acser.paymenDetails(rid,currentP, item);
		ModelAndView m=new ModelAndView();
		m.addObject("noP",nop );
		m.addObject("trdh", trdh);
		m.addObject("currentP", currentP);
		m.addObject("rid",rid);
		m.setViewName("searchPay");
		return m;
	}
	@RequestMapping("/searchT")
	public String searchTran()
	{
		return "searchTransaction";
	}
	@RequestMapping(value ="searchtran/")
	public ModelAndView getTran(@RequestParam("rid") int rid)
	{
		return searchTransaction(1,rid); 
	}
	@GetMapping("/tran/{pageno}/{rid}")
	public ModelAndView searchTransaction(@PathVariable("pageno") int pageNo,@PathVariable("rid") int rid)
	{
		int tRow=totalRow(rid);
		int item=4;
		int nop=0;
		if(tRow/item==0)
		{
			nop=tRow/item;
		}
		else
		{
			nop=(tRow/item)+1;
		}
		int currentP=pageNo-1;
		List<TransactionDetails> trdh;
		trdh=acser.tranHisDet(rid,currentP,item);
		ModelAndView m=new ModelAndView();
		m.addObject("noP",nop );
		m.addObject("trdh", trdh);
		m.addObject("rid",rid);
		m.addObject("currentP", currentP);
		m.setViewName("searchTransaction");
		return m;
	}
	@RequestMapping("userD")
	public String adminGetDetails()
	{
		return"adminDisplayOfUser";
	}
	@RequestMapping(value ="searchUserD/")
	public ModelAndView getUserDetails(@RequestParam("rid") int rid)
	{
		Registration2 reg=null;
		ModelAndView m = new ModelAndView();
		if(rid!=0)
		{
			reg = rser.showData(rid);
		}
		else {
			m.addObject("message", "Plese login the page");
			m.setViewName("home");
			return m;
		}
		Address3 add3 = (Address3) reg.getAddress3();

		Address2 add2 = new Address2();
		add2.setPincode(add3.getId().getPincode());
		add2.setCity(add3.getId().getCity());
		add2.setDist(add3.getDist());
		add2.setState(add3.getState());
		add2.setCountry(add3.getCountry());

		//ModelAndView m = new ModelAndView();
		m.addObject("reg", reg);
		m.addObject("add", add2);
		m.setViewName("adminDisplayOfUser");
		return m;
	}
    @RequestMapping("createAccount/{rid}")
	public ModelAndView createAccount(@PathVariable("rid") int rid)
	{
		String a=92+""+randomNumber();
		int acc=Integer.parseInt(a);
		Account ac=new Account();
		ac.setAccountNo(acc);
		ac.setAccess("unblock");
		ac.setAccountType("saving");
		ac.setDate(LocalDateTime.now());
		ac.setRid(rid);
		ac.setTotalAmount(0);
		System.out.println("==================================");
		System.out.println(ac);
		int r=acser.saveAccount(ac);
		ModelAndView m=new ModelAndView();
		if(r!=0)
		{
			m.addObject("message", "Account is created successfully");
		}
		else {
			m.addObject("message", "Account is already Exist");
		}
		System.out.println("r"+r);
		m.setViewName("adminNab");
		return m;
	}

}
