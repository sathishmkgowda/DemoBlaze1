package com.Testscripts.DemoBlaze1;

import static org.testng.Assert.assertTrue;

import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.genericLib.DemoBlaze1.Base;
import com.genericLib.DemoBlaze1.EventList;
@Listeners(EventList.class)
public class ContactDemoblaze extends Base
{
	@Test
	public void contactDemoblazeTest()
	{
		test=extent.createTest("ContactDemoblaze");
		Assert.assertTrue(false);
		
	}
 
}
