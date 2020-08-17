package com.acmday.transaction.server;

import com.acmday.transaction.server.other.MainTest;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * @author wushaofeng.
 * @date 2020/8/17.
 * 不依赖DataSource的BaseClass.
 */
@SpringBootTest(classes = MainTest.class)
@RunWith(value = SpringRunner.class)
public class BaseNoDbClass {
}
