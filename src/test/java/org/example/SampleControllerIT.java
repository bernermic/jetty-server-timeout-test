package org.example;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT, properties = {
    "server.jetty.connection-idle-timeout=1s",
    "logging.level.org.eclipse.jetty.io=DEBUG"
})
class SampleControllerIT {
    @Autowired
    private TestRestTemplate testRestTemplate;

    @Test
    void timeout() {
        Assertions.assertTrue(testRestTemplate.getForEntity("/", String.class).getStatusCode()
            .is5xxServerError(), "Expected 5xxServerError Status");
    }
}