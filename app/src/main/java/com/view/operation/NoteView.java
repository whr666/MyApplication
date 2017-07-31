package com.view.operation;

import android.app.Activity;
import android.content.Context;
import android.support.v4.app.Fragment;
import android.view.View;

import java.lang.reflect.Field;
import java.lang.reflect.Method;

/**
 * Created by XIAOXIN on 2017/7/7.
 */

public class NoteView {
    /**
     * 传入Activity
     * @param activity
     * @param
     */
    public static void inject(final Activity activity){
        //反射属性
        Field[] declaredFields = activity.getClass().getDeclaredFields();
        for (int i = 0; i < declaredFields.length; i++) {
            Field field = declaredFields[i];
            field.setAccessible(true);
            BindView annotation = field.getAnnotation(BindView.class);
            if (annotation!=null) {
                int id = annotation.value();
                View view = activity.findViewById(id);
                try {
                    field.set(activity, view);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }
        /**
         * 反射方法
         */
        Method[] declaredMethods = activity.getClass().getDeclaredMethods();
        for (int i = 0; i < declaredMethods.length; i++) {
            final Method method = declaredMethods[i];
            method.setAccessible(true);
            BindOnclik annotation = method.getAnnotation(BindOnclik.class);
            if (annotation!=null) {
                int[] value = annotation.value();
                for (int j : value) {
                    int id = j;
                    final View btn = activity.findViewById(id);
                    btn.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            try {
                                method.invoke(activity, btn);
                            } catch (Exception e) {
                                e.printStackTrace();
                            }
                        }
                    });
                }
            }
        }

    }
    /**
     * 传入Fragment
     * @param activity
     * @param view1
     */
    public static void inject(final Fragment activity,View view1){
        //反射属性
        Field[] declaredFields = activity.getClass().getDeclaredFields();
        for (int i = 0; i < declaredFields.length; i++) {
            Field field = declaredFields[i];
            field.setAccessible(true);
            BindView annotation = field.getAnnotation(BindView.class);
            if (annotation!=null) {
                int id = annotation.value();
                View view = view1.findViewById(id);
                try {
                    field.set(activity, view);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }
        /**
         * 反射方法
         */
        Method[] declaredMethods = activity.getClass().getDeclaredMethods();
        for (int i = 0; i < declaredMethods.length; i++) {
            final Method method = declaredMethods[i];
            method.setAccessible(true);
            BindOnclik annotation = method.getAnnotation(BindOnclik.class);
            if (annotation!=null) {
                int[] value = annotation.value();
                for (int j : value) {
                    int id = j;
                    final View btn = view1.findViewById(id);
                    btn.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            try {
                                method.invoke(activity, btn);
                            } catch (Exception e) {
                                e.printStackTrace();
                            }
                        }
                    });
                }
            }
        }

    }


    /**
     * 传入Content
     * @param activity
     * @param view1
     */
    public static void inject(final Context activity, View view1){
        //反射属性
        Field[] declaredFields = activity.getClass().getDeclaredFields();
        for (int i = 0; i < declaredFields.length; i++) {
            Field field = declaredFields[i];
            field.setAccessible(true);
            BindView annotation = field.getAnnotation(BindView.class);
            if (annotation!=null) {
                int id = annotation.value();
                View view = view1.findViewById(id);
                try {
                    field.set(activity, view);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }
        /**
         * 反射方法
         */
        Method[] declaredMethods = activity.getClass().getDeclaredMethods();
        for (int i = 0; i < declaredMethods.length; i++) {
            final Method method = declaredMethods[i];
            method.setAccessible(true);
            BindOnclik annotation = method.getAnnotation(BindOnclik.class);
            if (annotation!=null) {
                int[] value = annotation.value();
                for (int j : value) {
                    int id = j;
                    final View btn = view1.findViewById(id);
                    btn.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            try {
                                method.invoke(activity, btn);
                            } catch (Exception e) {
                                e.printStackTrace();
                            }
                        }
                    });
                }
            }
        }

    }


    /**
     * 传入View
     * @param activity
     * @param
     */
    public static void inject(final View activity){
        //反射属性
        Field[] declaredFields = activity.getClass().getDeclaredFields();
        for (int i = 0; i < declaredFields.length; i++) {
            Field field = declaredFields[i];
            field.setAccessible(true);
            BindView annotation = field.getAnnotation(BindView.class);
            if (annotation!=null) {
                int id = annotation.value();
                View view = activity.findViewById(id);
                try {
                    field.set(activity, view);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }
        /**
         * 反射方法
         */
        Method[] declaredMethods = activity.getClass().getDeclaredMethods();
        for (int i = 0; i < declaredMethods.length; i++) {
            final Method method = declaredMethods[i];
            method.setAccessible(true);
            BindOnclik annotation = method.getAnnotation(BindOnclik.class);
            if (annotation!=null) {
                int[] value = annotation.value();
                for (int j : value) {
                    int id = j;
                    final View btn = activity.findViewById(id);
                    btn.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            try {
                                method.invoke(activity, btn);
                            } catch (Exception e) {
                                e.printStackTrace();
                            }
                        }
                    });
                }
            }
        }

    }









}
