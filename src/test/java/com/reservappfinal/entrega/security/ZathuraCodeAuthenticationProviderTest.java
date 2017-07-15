package com.reservappfinal.entrega.security;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class ZathuraCodeAuthenticationProviderTest {
		
		
	@Before
	public void datos(){
		
	}
	
	@Test
	public void testAuthenticate() {
		ZathuraCodeAuthenticationProvider zathura = new ZathuraCodeAuthenticationProvider();
		assertNotNull(zathura);
	}
		
}
