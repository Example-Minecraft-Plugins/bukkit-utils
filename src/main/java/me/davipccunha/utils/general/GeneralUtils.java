package me.davipccunha.utils.general;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class GeneralUtils {
    public static <T> Map<Integer, List<T>> divideList(List<T> fullList, int subListSize) {
        final Map<Integer, List<T>> subLists = new HashMap<>();

        for (int i = 0; i < fullList.size(); i += subListSize) {
            final List<T> subList = List.copyOf(fullList).subList(i, Math.min(i + subListSize, fullList.size()));
            subLists.put(i / subListSize, subList);
        }

        return subLists;
    }
}
