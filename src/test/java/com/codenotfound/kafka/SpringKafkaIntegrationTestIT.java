package com.codenotfound.kafka;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.concurrent.TimeUnit;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.codenotfound.kafka.consumer.Receiver;
import com.codenotfound.kafka.producer.Sender;

@RunWith(SpringRunner.class)
@SpringBootTest
public class SpringKafkaIntegrationTestIT {

	private static String BOOT_TOPIC = "boot.t";

	  @Autowired
	  private Sender sender;
	  
	  @Autowired
	  private Receiver receiver;

	  @Test
	  public void testReceive() throws Exception {
	    sender.send(BOOT_TOPIC, "Hello Booting Integration2");

	   receiver.getLatch().await(10000, TimeUnit.MILLISECONDS);
	   
	   assertThat(receiver.getLatch().getCount()).isEqualTo(0);
	    
	  

	  }
}
