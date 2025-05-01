package Staff.Management.System;

import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class StaffService {
    private final Map<Long, Staff> staffRepo = new HashMap<>();
    private long idCounter = 1;

    public List<Staff> getAll() {
        return new ArrayList<>(staffRepo.values());
    }

    public Staff getById(Long id) {
        return staffRepo.get(id);
    }

    public Staff create(Staff staff) {
        staff.setId(idCounter++);
        staffRepo.put(staff.getId(), staff);
        return staff;
    }

    public Staff update(Long id, Staff staff) {
        if (!staffRepo.containsKey(id)) return null;
        staff.setId(id);
        staffRepo.put(id, staff);
        return staff;
    }

    public boolean delete(Long id) {
        return staffRepo.remove(id) != null;
    }
}

