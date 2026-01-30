package com.laundrytracker.backend;

public class MachineStatus {

    private String machine;
    private boolean inUse;
    private String usedBy;

    public MachineStatus(String machine) {
        this.machine = machine;
        this.inUse = false;
        this.usedBy = null;
    }

    public String getMachine() {
        return machine;
    }

    public boolean isInUse() {
        return inUse;
    }

    public void setInUse(boolean inUse) {
        this.inUse = inUse;
    }

    public String getUsedBy() {
        return usedBy;
    }

    public void setUsedBy(String usedBy) {
        this.usedBy = usedBy;
    }
}
