package role;

import action.impl.access.UserMapAccess;

import java.util.concurrent.ConcurrentHashMap;

public enum  Role {
    GUEST(UserMapAccess.accessGuestMap),
    CLIENT(UserMapAccess.accessClientMap),
    ADMIN(UserMapAccess.accessAdminMap);

    private ConcurrentHashMap<String, Boolean> accessMap;

    Role(ConcurrentHashMap<String, Boolean> accessMap) {
        this.accessMap = accessMap;
    }

    public ConcurrentHashMap<String, Boolean> getAccessMap() {
        return accessMap;
    }
}
