package org.example.infrastructure;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.bean.override.mockito.MockitoBean;
import se.iths.ports.api.OrderingTopWear;

@SpringBootTest
class InfrastructureApplicationTests {

    @MockitoBean
    OrderingTopWear orderingTopWear;

    @Test
    void contextLoads() {
    }

}
