package com.example.civilwar;

import static org.hamcrest.CoreMatchers.instanceOf;
//import static org.hamcrest.CoreMatchers.any;
import static org.hamcrest.CoreMatchers.containsString;
import static org.hamcrest.CoreMatchers.is;
//import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThat;
import static org.mockito.Mockito.doReturn;
//import static org.mockito.Mockito.mock;
//import static org.mockito.Mockito.when;
//
//import java.util.Collections;
//import java.text.SimpleDateFormat;
//import java.util.Date;
import static org.mockito.Mockito.doThrow;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.view;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
//import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
//import org.springframework.test.annotation.Rollback;
//import org.springframework.test.context.jdbc.Sql;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.transaction.annotation.Transactional;

import com.example.civilwar.Lordsort;

@RunWith(SpringRunner.class)
@SpringBootTest
@Transactional
public class CivilwarApplicationTests {

	@Mock
	private Lordsort lordsort = new Lordsort();
	@Mock
	private WarlordController wc = new WarlordController();

	private MockMvc mockMvc;
	@Autowired
	WarlordController target;

	@Before
	public void setup() {
		MockitoAnnotations.initMocks(this);
	}

	@Before
	public void setup1() {
		mockMvc = MockMvcBuilders.standaloneSetup(target).build();
	}

	@Test
	public void controllerTest() throws Exception {
		mockMvc.perform(get("/html")).andExpect(status().isOk()).andExpect(view().name("html/index"));
	}

	@Test
	public void contextLoads() {
		LordCommentary lc = new LordCommentary();
		lc.sanada();
		String text = lc.name();
		String mockStr = "aaaa";
		doReturn(mockStr).when(lordsort).lord();
		doReturn(text).when(lordsort).lt();
		// ↑と同じ
//		when(lordsort.lord()).thenReturn("真田幸村");
//		when(lordsort.lt()).thenReturn(text);

		assertThat(lordsort.lord(), is(mockStr));
		assertThat(lordsort.lt(), is(text));
	}

	@Test
	public void test() {
		wc = Mockito.mock(WarlordController.class);
		String mockName = "aaaa";
		String mockText = "test";
		doReturn(mockText).when(wc).test(mockName);

		assertThat(wc.test(mockName), containsString(mockText));
	}

	@Test
	public void test2() {
		// モックオブジェクトの作成
		lordsort = Mockito.mock(Lordsort.class);
		// void型のメソッドに対する挙動の操作
		// #clear()が呼ばれた際にRuntimeExceptionをスローする
		doThrow(new RuntimeException()).when(lordsort).lord();
		try {
			lordsort.lord();
		} catch (Exception e) {
			assertThat(e, is(instanceOf(RuntimeException.class)));
		}
	}
}
