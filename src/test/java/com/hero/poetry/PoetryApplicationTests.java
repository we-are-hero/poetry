package com.hero.poetry;

import com.hero.poetry.common.utils.WebCache;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class PoetryApplicationTests {

	@Test
	void contextLoads() throws InterruptedException {
		WebCache.remove("1");
		WebCache<String> hello = new WebCache<String>().data("hello").timeLimit(6);
		WebCache.putCache("1",hello);
		Thread.sleep(5000);
		WebCache<String> s = WebCache.getCache("1");
		assert s != null;
		System.out.println(s.getData());
	}

}
