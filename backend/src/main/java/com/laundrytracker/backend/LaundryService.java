package com.laundrytracker.backend;

import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.List;

@Service
public class LaundryService {

    private final List<MachineStatus> machines = new ArrayList<>();

    public LaundryService() {
        machines.add(new MachineStatus("WASHER"));
        machines.add(new MachineStatus("DRYER"));
    }

    public List<MachineStatus> getStatus() {
        return machines;
    }

    public String useMachine(String machine, String name) {
        for (MachineStatus m : machines) {
            if (m.getMachine().equalsIgnoreCase(machine)) {
                if (m.isInUse()) {
                    return machine + " is already in use by " + m.getUsedBy();
                }
                m.setInUse(true);
                m.setUsedBy(name);
                return machine + " is now in use by " + name;
            }
        }
        return "Machine not found";
    }

    public String releaseMachine(String machine) {
        for (MachineStatus m : machines) {
            if (m.getMachine().equalsIgnoreCase(machine)) {
                m.setInUse(false);
                m.setUsedBy(null);
                return machine + " has been released";
            }
        }
        return "Machine not found";
    }
}
