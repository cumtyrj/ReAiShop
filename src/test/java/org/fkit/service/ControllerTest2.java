package org.fkit.service;

import org.junit.Before;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.transaction.TransactionConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.context.WebApplicationContext;
import static org.springframework.test.web.servlet.setup.MockMvcBuilders.webAppContextSetup;

import org.fkit.domain.User;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
@TransactionConfiguration(defaultRollback = true)  
@Transactional 
public class ControllerTest2 extends BaseJunitTest {
	 @Autowired  
	    private WebApplicationContext wac;  
	   private MockMvc mockMvc; 
	    
	    @Before  
	    public void setup() {   
	        this.mockMvc = webAppContextSetup(this.wac).build();  
	    } 
	    
	    @Test
	    public void testLogin() throws Exception{
	    	mockMvc.perform((post("/login").param("loginname","111").param("password","222"))).andExpect(status().isOk())
	    	.andDo(print());
	    }
}
