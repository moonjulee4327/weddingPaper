package com.gaebalgoebal.weddingPaper;

import com.gaebalgoebal.weddingPaper.domain.test.controller.ApiTestController;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class WeddingPaperApplicationTests {

	@Autowired
	private ApiTestController apiTestController;

	@Test
	void contextLoads() {
	}

	@DisplayName("API 테스트")
	@Test
	void 컨텍스트_로딩_테스트(){
		assert apiTestController != null;
	}

}
