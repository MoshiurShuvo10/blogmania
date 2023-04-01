package com.rmslab.blogmania.utils;

import java.lang.reflect.InvocationTargetException;

public class ModelMapperUtil {
    public static <T, U> U modelToDtoConverter(T model, Class<U> dtoClass) throws NoSuchMethodException,
                IllegalAccessException, InvocationTargetException, InstantiationException, NoSuchFieldException {
            U dto = dtoClass.getDeclaredConstructor().newInstance();
            for (java.lang.reflect.Field dtoField : dtoClass.getDeclaredFields()) {
                dtoField.setAccessible(true);
                java.lang.reflect.Field modelField = model.getClass().getDeclaredField(dtoField.getName());
                modelField.setAccessible(true);
                dtoField.set(dto, modelField.get(model));
            }
            return dto;
        }

        public static <T, U> T dtoToModelConverter(U dto, Class<T> modelClass) throws NoSuchMethodException,
                IllegalAccessException, InvocationTargetException, InstantiationException, NoSuchFieldException {
            T model = modelClass.getDeclaredConstructor().newInstance();
            for (java.lang.reflect.Field modelField : modelClass.getDeclaredFields()) {
                modelField.setAccessible(true);
                java.lang.reflect.Field dtoField = dto.getClass().getDeclaredField(modelField.getName());
                dtoField.setAccessible(true);
                modelField.set(model, dtoField.get(dto));
            }
            return model;
        }
    }
