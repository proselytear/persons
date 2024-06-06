package net.proselyte.apigateway.rest;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/gateway")
public class ApiGatewayRestControllerV1 {

    @PostMapping("/exit")
    public ResponseEntity<?> exit() {
        System.exit(1);
        return ResponseEntity.ok().build();
    }
}
