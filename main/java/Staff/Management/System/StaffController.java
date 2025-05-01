package Staff.Management.System;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/staffs")
public class StaffController {

    @Autowired
    private StaffService staffService;

    @GetMapping
    public List<Staff> getAllStaffs() {
        return staffService.getAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getStaffById(@PathVariable Long id) {
        Staff staff = staffService.getById(id);
        return staff != null ? ResponseEntity.ok(staff)
                : ResponseEntity.status(HttpStatus.NOT_FOUND).body("Staff not found");
    }

    @PostMapping
    public ResponseEntity<Staff> createStaff(@RequestBody Staff staff) {
        Staff created = staffService.create(staff);
        return ResponseEntity.status(HttpStatus.CREATED).body(created);
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> updateStaff(@PathVariable Long id, @RequestBody Staff staff) {
        Staff updated = staffService.update(id, staff);
        return updated != null ? ResponseEntity.ok(updated)
                : ResponseEntity.status(HttpStatus.NOT_FOUND).body("Staff not found");
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteStaff(@PathVariable Long id) {
        return staffService.delete(id)
                ? ResponseEntity.ok("Deleted successfully")
                : ResponseEntity.status(HttpStatus.NOT_FOUND).body("Staff not found");
    }
}
