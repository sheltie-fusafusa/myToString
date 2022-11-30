package org.example;

import java.lang.reflect.Field;
import java.util.Optional;

public class Util {

    public static String myToString(Object obj) {

        StringBuilder sb = new StringBuilder();
        try {
            StringBuilder innerSb = new StringBuilder();
            for(Field a : obj.getClass().getDeclaredFields()){
                Field field = obj.getClass().getDeclaredField(a.getName());
                field.setAccessible(true);

                innerSb.append(a.getName()).append(" = ").append(field.get(obj)).append(",");
            }

            String str = Optional.ofNullable(innerSb.toString())
                    .filter(s -> s.length() != 0)
                    .map(s -> s.substring(0, s.length() - 1))
                    .orElse("");

            sb.append(obj.getClass().getName()).append("(");
            sb.append(str);
            sb.append(")");
        } catch(Exception e) {
            System.out.println(e.getMessage());
        }

        return sb.toString();
    }
}
