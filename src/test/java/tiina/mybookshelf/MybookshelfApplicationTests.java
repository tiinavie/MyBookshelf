package tiina.mybookshelf;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import tiina.mybookshelf.controller.CollectionController;

@ExtendWith(SpringExtension.class)
@SpringBootTest
public class MybookshelfApplicationTests {
	@Autowired
	private CollectionController controller;

	@Test
	public void contextLoads() throws Exception {
		assertThat(controller).isNotNull();

	}
}