package com.bank.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.transaction.annotation.Transactional;

import com.bank.ADto.TransactionDto;
import com.bank.modal.Account;
import com.bank.modal.PaymentDetails;
import com.bank.modal.TransactionDetails;
import com.bank.modal.UserLogin;



public class AccountDaoImpl implements AccountDaoInfo {
	private JdbcTemplate template2;
	
	private HibernateTemplate template;
	

	public void setTemplate2(JdbcTemplate template2) {
		this.template2 = template2;
	}

	public void setTemplate(HibernateTemplate template) {
		this.template = template;
	}

	@Transactional
	public int creditAccount(TransactionDto dto) {
		Account account = new Account();
		account.setAccountNo(dto.getAccountNoFrom());
		account.setAccountType(dto.getAccountType());
		account.setRid(dto.getRid());
		account.setTotalAmount(dto.gettAmount());
		account.setDate(dto.getDate());
		account.setAccess("unblock");
		System.out.println(account);
		int n=0;
		try {
//		   n=template2.update("update account set totalAmount=totalAmount+"+account.getTotalAmount()+", date='"+account.getDate()+"' where (accountNo="+account.getAccountNo()+" and accountType='"+account.getAccountType()+"') and (accessible='"+account.getAccessible()+"')");
			   n=template2.update("update account set totalAmount=totalAmount+"+account.getTotalAmount()+", date='"+account.getDate()+"' where accountNo="+account.getAccountNo()+" and accountType='"+account.getAccountType()+"' and  access='"+account.getAccess()+"'");
		   if(n==1)
		   {
			   dto.setStates("success");
			   transferAccount(dto );
		   }
		   else
		   {
			   dto.setStates("fail");
			   transferAccount(dto );
		   }
		 
		} catch (Exception e) {
			e.printStackTrace();
		}
		System.out.println("cdao---"+n);
		return n;
	}

	@Transactional
	public int debitAccount(TransactionDto dto) {
		int n=0;
		Account account = new Account();
		account.setAccountNo(dto.getAccountNoFrom());
		account.setAccountType(dto.getAccountType());
		account.setRid(dto.getRid());
		account.setTotalAmount(dto.gettAmount());
		account.setDate(dto.getDate());
		account.setAccess("unblock");
		System.out.println(account);
		try {
			
			   n=template2.update("update account set totalAmount=totalAmount-"+account.getTotalAmount()+",date='"+account.getDate()+"' where accountNo="+account.getAccountNo()+" and totalAmount>"+500+" and access='"+account.getAccess()+"'");
			   if(n==1)
			   { dto.setStates("success");}
			   else
			   {dto.setStates("fail");}
			   transferAccount(dto );
			} catch (Exception e) {
				e.printStackTrace();
			}
			System.out.println("ddao---"+n);
			return n;
		
	}

	@Transactional
	public void transferAccount(TransactionDto dto ) {
		
		TransactionDetails td=new TransactionDetails();
		td.setPaymentType(dto.getPaymentType());
		td.setRid(dto.getRid());
		td.setSources(dto.getSources());
		td.settAmount(dto.gettAmount());
		td.setStates(dto.getStates());
		td.setDate(dto.getDate());
		
		System.out.println(dto);
		 int  p=(Integer)template.save(td);
		 System.out.println("tran-->"+p);

	}
	public int first(int rid)
	{
		int n=template2.update("update transaction set tAmount=tAmount+'"+0+"'where rid="+rid+"");
		System.out.println(n);
		return n;
	}
	public List<TransactionDetails> getTDetails(int rid,int currentP,int item)
	{
		//SELECT * FROM TRANSACTION LIMIT 1,4;
		 currentP= (currentP-1)*item+item;
		String sql="select * from transaction where rid="+rid+" limit "+(currentP)+","+item;    
	   List<TransactionDetails>trd= template2.query(sql,new RowMapper<TransactionDetails>(){    
	        public TransactionDetails mapRow(ResultSet rs, int row) throws SQLException {    
	        	TransactionDetails t=new TransactionDetails();    
	              t.setRid(rs.getInt("rid"));  
	              t.setTransactionId(rs.getInt("transactionId"));
	              t.setPaymentType(rs.getString("paymentType"));
	              t.setSources(rs.getString("sources"));
	              t.setStates(rs.getString("states"));
	              t.settAmount(rs.getInt("tAmount"));
	              t.setDate(rs.getTimestamp("date").toLocalDateTime());
	            return t;    
	        }    
	    });  
	System.out.println(trd);
	return trd;

	}
	

	@Transactional
	public int payAccount(TransactionDto dto) {
		Account accountF = new Account();
		accountF.setAccountNo(dto.getAccountNoFrom());
		accountF.setAccountType(dto.getAccountType());
		accountF.setRid(dto.getRid());
		accountF.setTotalAmount(dto.gettAmount());
		accountF.setDate(dto.getDate());
		accountF.setAccess("unblock");
		
		Account accountT = new Account();
		accountT.setAccountNo(dto.getAccountNoTo());
		accountT.setRid(000000);
		accountT.setTotalAmount(dto.gettAmount());
		accountT.setDate(dto.getDate());
		accountT.setAccess("unblock");
		System.out.println(dto.getRid()+"==========tran");
		System.out.println(accountF);
		System.out.println(accountT);
		String sql1="select access from account where accountNo='"+accountF.getAccountNo()+"'";
		String sql2="select access from account where accountNo='"+accountT.getAccountNo()+"'";
		
		String s1=template2.queryForObject(sql1, String.class);
		String s2=template2.queryForObject(sql2, String.class);
		System.out.println("s1="+s1+" s2="+s2);
		
		int n=0;
		int p=0;
		  int r=0;
		try {
			if(s1.equals(s2))
			{
				 n=template2.update("update account set totalAmount=totalAmount-"+accountF.getTotalAmount()+", date='"+accountF.getDate()+"' where accountNo="+accountF.getAccountNo()+" and accountType='"+accountF.getAccountType()+"' and totalAmount>"+500+"");
			}
		   if(n==1)
		   { 
			   dto.setStates("success");
			   dto.setPaymentType("withdraw");
			   transferAccount(dto );
		   }
		   else
		   {
			   dto.setStates("fail");
			   dto.setPaymentType("withdraw");
			   transferAccount(dto );
		   }
		   if(s1.equals(s2))
		   {
			   p=template2.update("update account set totalAmount=totalAmount+"+accountT.getTotalAmount()+", date='"+accountT.getDate()+"' where accountNo="+accountT.getAccountNo()+"");
		   }
		   if(p==1)
		   { 
			   dto.setStates("success");
			   dto.setPaymentType("deposit");
			   dto.setRid(000000);
			   transferAccount(dto );
			 }
		   else
		   {
			   dto.setStates("fail");
			   dto.setPaymentType("deposit");
			   dto.setRid(000000);
			   transferAccount(dto );
			   
			}
		 
		   if(n==1&&p==1)
		   {
			   dto.setStates("success");
			   dto.setPaymentType("transaction");
			   dto.setRid(accountF.getRid());
			   insertPaymentDetails(dto);
			   r=1;
		   }
		   else
		   {
			   dto.setStates("fail");
			   dto.setPaymentType("transaction");
			   dto.setRid(accountF.getRid());
			   insertPaymentDetails(dto);
			   r=0;
		   }
		  
		} catch (Exception e) {
			e.printStackTrace();
		}
		System.out.println("cdao---"+n);
		return r;
	}
    public void insertPaymentDetails(TransactionDto tdo)
    {
    	PaymentDetails pd=new PaymentDetails();
    	pd.setAccountNoFrom(tdo.getAccountNoFrom());
    	pd.setAccountNoTo(tdo.getAccountNoTo());
    	pd.settAmount(tdo.gettAmount());
    	pd.setRid(tdo.getRid());
    	pd.setPaymentType(tdo.getPaymentType());
    	pd.setStates(tdo.getStates());
    	pd.setSources(tdo.getSources());
    	pd.setDate(tdo.getDate());
    	System.out.println(pd);
    	int  p=(Integer)template.save(pd);
		 System.out.println("pay-->"+p);
    	
    }
    public int firstPayment(int rid)
	{
		int n=template2.update("update paymentdetails set tAmount=tAmount+'"+0+"'where rid="+rid+"");
		System.out.println(n);
		return n;
	}
    public List<PaymentDetails> getPayDetails(int rid,int currentP,int item)
	{
		//SELECT * FROM TRANSACTION LIMIT 1,4;
    	System.out.println("Payment="+rid);
    	int id=rid;
		 currentP= (currentP-1)*item+item;
		String sql="select * from paymentdetails where rid="+id+" limit "+(currentP)+","+item;    
	   List<PaymentDetails>pay= template2.query(sql,new RowMapper<PaymentDetails>(){    
	        public PaymentDetails mapRow(ResultSet rs, int row) throws SQLException {    
	        	PaymentDetails p=new PaymentDetails();    
	              p.setPaymentId(rs.getInt("paymentId"));
	              p.setAccountNoFrom(rs.getInt("accountNoFrom"));
	              p.setAccountNoTo(rs.getInt("accountNoTo"));
	              p.settAmount(rs.getInt("tAmount"));
	              p.setRid(rs.getInt("rid"));
	              p.setPaymentType(rs.getString("paymentType"));
	              p.setStates(rs.getString("states"));
	              p.setSources(rs.getString("sources"));
	              p.setDate(rs.getTimestamp("date").toLocalDateTime());
	              System.out.println(rs.getTimestamp("date").toLocalDateTime());
	            return p;    
	        }    
	    });  
	System.out.println(pay);
	return pay;

	}
//==========admin section================
    @Transactional
   	public Account getAccDetails(int rid) {
   		Account ac=(Account)template.get(Account.class, rid);
//   		System.out.println(ac);
   		return ac;
   	}
   	@Transactional
   	public Account updateAcc(Account account)
   	{
   		template.update(account);
   		return getAccDetails(account.getRid());
   	}
   	@Transactional
   	public int createAccount(Account ac)
   	{
   		int i=0;
   		System.out.println("kk"+ac.getRid());
   		int id=ac.getRid();
   		System.out.println("+++++++++++++");
   		Account a=getAccDetails(ac.getRid());
   		if(a==null)
   		{
   			template.save(ac);
   			int n=(Integer)template2.update("update userlogin set state='"+"success"+"' where regNo="+ac.getRid()+"");
   			System.out.println("Update state of userlogin");
   			i=1;
   		}
   		return i;
   		
   	}

}
