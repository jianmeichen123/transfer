package com.galaxy.transfer.common.exception;

import org.slf4j.Logger;

public class RedisException extends RuntimeException{
	private static final long serialVersionUID = 1L;
	private Throwable cause;   		//记录起因异常
	
	public RedisException (String msg){   
		super(msg);   
	}   
	
	public RedisException(Throwable ex,Logger log){   
		super(ex);   
		log.error("自定义：", ex);
		this.cause = ex;
	}   
	
	public RedisException(Throwable ex){   
		super(ex);   
		this.cause = ex;
	}  
	    
	public RedisException(String msg, Throwable ex){   
		super(msg);   
		this.cause = ex;   
	}   
	    
	public Throwable getCause(){   
		return (this.cause == null ? this :this.cause);   
	}   
	    
//	public String getMessage(){   
//		String message = super.getMessage();   
//		Throwable cause = getCause();   
//		if(cause != null){   
//			message = message + ";nested Exception is " + cause;   
//		}   
//		return message;   
//	}  
//	
//	public void printStackTrace(PrintStream ps){   
//		if(this.getCause() == null){   
//			super.printStackTrace(ps); 
//		}else{   
//			ps.println(this);   
//			getCause().printStackTrace(ps);   
//		}   
//	}
//	
//	public void printStackTrace(PrintWriter pw){   
//		if(getCause() == null){   
//			super.printStackTrace(pw);   
//		}else{   
//			pw.println(this);   
//			getCause().printStackTrace(pw);   
//		}   
//	} 
//	
//	public void printStackTrace(){   
//		printStackTrace(System.err);   
//	}   

}
