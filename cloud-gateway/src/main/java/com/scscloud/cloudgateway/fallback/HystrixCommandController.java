package com.scscloud.cloudgateway.fallback;

//import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HystrixCommandController {
    protected final Logger log = LoggerFactory.getLogger(this.getClass());

    @RequestMapping("/hystrixTimeout")
    public String hystrixTimeout() {
        log.error("service-gateway触发了断路由");
        return "service-gateway触发了断路由";
    }

   // @HystrixCommand(commandKey = "authHystrixCommand")
    public String authHystrixCommand() {
        log.error("service-gateway触发了断路由");
        return "";
    }

}