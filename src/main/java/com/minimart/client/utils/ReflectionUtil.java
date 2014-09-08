package com.minimart.client.utils;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ReflectionUtil {

	public ReflectionUtil() {
		// TODO Auto-generated constructor stub
	}

	public static List<Field> getAllFields(Class<?> type) {
		List<Field> fields = new ArrayList<Field>();
		for (Class<?> c = type; c != null; c = c.getSuperclass()) {
			fields.addAll(Arrays.asList(c.getDeclaredFields()));
		}
		return fields;
	}

	public static List<Method> getAllMethods(Class<?> type) {
		List<Method> methods = new ArrayList<Method>();
		for (Class<?> c = type; c != null; c = c.getSuperclass()) {
			methods.addAll(Arrays.asList(c.getDeclaredMethods()));
		}
		return methods;
	}

	public static List<Method> getAllGetters(Class<?> type) {

		List<Method> getters = new ArrayList<Method>();

		List<Method> methods = getAllMethods(type);
		for (Method method : methods) {
			if (isGetter(method)) {
				getters.add(method);
			}
		}
		return getters;
	}

	public static List<Method> getDeclaredGetters(Class<?> type) {

		List<Method> getters = new ArrayList<Method>();

		List<Method> methods = Arrays.asList(type.getDeclaredMethods());
		for (Method method : methods) {
			if (isGetter(method)) {
				getters.add(method);
			}
		}
		return getters;
	}
	
	public static List<Method> getDeclaredSetters(Class<?> type) {

		List<Method> setters = new ArrayList<Method>();

		List<Method> methods = Arrays.asList(type.getDeclaredMethods());
		for (Method method : methods) {
			if (isSetter(method)) {
				setters.add(method);
			}
		}
		return setters;
	}

	public static List<Method> getAllSetters(Class<?> type) {

		List<Method> setters = new ArrayList<Method>();

		List<Method> methods = getAllMethods(type);
		for (Method method : methods) {
			if (isSetter(method)) {
				setters.add(method);
			}
		}
		return setters;
	}

	public static boolean isGetter(Method method) {
		if (!method.getName().startsWith("get"))
			return false;
		if (method.getParameterTypes().length != 0)
			return false;
		if (void.class.equals(method.getReturnType()))
			return false;
		return true;
	}

	public static boolean isSetter(Method method) {
		if (!method.getName().startsWith("set"))
			return false;
		if (method.getParameterTypes().length != 1)
			return false;
		return true;
	}
}
