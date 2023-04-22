package com.spread.libserver;

import com.spread.libserver.doer.dofactory.Msg;
import com.spread.libserver.mapper.BorrowMapper;
import com.spread.libserver.mapper.PersonMapper;
import com.spread.libserver.model.dao.Borrow;
import com.spread.libserver.model.dao.Person;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@SpringBootTest
class LibserverApplicationTests {

	@Autowired
	private PersonMapper personMapper;
	@Autowired
	private BorrowMapper borrowMapper;
//	@Test
//	void contextLoads() {
//		List<Person> pl = new ArrayList<>();
//		pl = personMapper.selectList(null);
//		for(Person p : pl){
//			System.out.println("name: " + p.getName() + " id: " + p.getId());
//		}
//	}
//
//	@Test
//	void testMsg(){
////		System.out.println(Msg.Register.Success().getCode());
////		System.out.println(Msg.Register.Success().getContent());
//	}
//
//	@Test
//	void testBorrow(){
//		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
//		String strNow = sdf.format(new Date());
//		//borrowMapper.insert(new Borrow(strNow, 3, 20, false, 12.12F));
//		List<Borrow> bs = borrowMapper.selectList(null);
//		bs.forEach(System.out::println);
//	}

}
