package Staff.Management.System;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;

@RestController
@RequestMapping("/api")
public class ResponseDemoController<SampleObject> {

    @GetMapping("/success")
    public ResponseEntity<String> success() {
        return ResponseEntity.ok()
                .header("Custom-Header", "SuccessHeader")
                .body("Success with custom header");
    }

    @GetMapping("/not-found")
    public ResponseEntity<String> notFound() {
        return ResponseEntity.status(HttpStatus.NOT_FOUND)
                .body("Resource not found");
    }

    @PostMapping("/create")
    public ResponseEntity<String> create(@RequestBody SampleObject obj) {
        URI location = URI.create("/api/resource/" + obj.getClass());
        return ResponseEntity.created(location)
                .body("Resource created");
    }
}
