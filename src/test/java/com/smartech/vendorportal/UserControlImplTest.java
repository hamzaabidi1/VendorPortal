package com.smartech.vendorportal;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.smartech.vendorportal.services.UserControl;

@SpringBootTest
class UserControlImplTest {
	
	@Autowired
	UserControl userControl;
	
	@Test
	 void testretriveAllVendor() {
		assertEquals(1, userControl.retriveAllVendor().size());
	}

}
