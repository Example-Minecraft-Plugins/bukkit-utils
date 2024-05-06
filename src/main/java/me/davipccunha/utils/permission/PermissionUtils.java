package me.davipccunha.utils.permission;

import org.apache.commons.lang.math.NumberUtils;

public class PermissionUtils {
    public static int extractNumberSuffix(String permission) {
        String[] parts = permission.split("\\.");
        String lastPart = parts[parts.length - 1];

        return NumberUtils.toInt(lastPart, -1);
    }
}
