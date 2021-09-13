package org.example;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.TimeUnit;

@RestController
public class SampleController {
    @GetMapping("/")
    String timeout() throws InterruptedException {
        for (int i=0; i<3; i++) {
            System.out.println("Wasted " + i + " seconds");
            TimeUnit.SECONDS.sleep(1);
        }
        return "Unexpected Response";
    }
}
