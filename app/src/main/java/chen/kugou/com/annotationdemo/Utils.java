package chen.kugou.com.annotationdemo;

import android.app.Activity;

import java.lang.reflect.Field;

/**
 * Created by david on 16/4/28.
 */
public class Utils {
    public static void init(Activity activity){
        Field[] fields = activity.getClass().getDeclaredFields();
        if (fields!=null && fields.length>0){
            for (Field field :fields){
                if (field.isAnnotationPresent(BindView.class)) {
                    BindView bindView = field.getAnnotation(BindView.class);
                    try {
                        field.setAccessible(true);
                        field.set(activity, activity.findViewById(bindView.value()));
                    } catch (IllegalAccessException e) {
                        e.printStackTrace();
                    }
                }
            }
        }
    }
}
