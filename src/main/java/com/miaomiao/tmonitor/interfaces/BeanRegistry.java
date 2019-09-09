package com.miaomiao.tmonitor.interfaces;


/**
 * Created by sidawei on 16/8/28.
 *
 */
public interface BeanRegistry<T> {


    Integer regist(ClassLoader classLoader, T bean, String beanName);

    /**
     * 查找Bean
     * @param id 注册时返回的
     * @return
     */
    <T> T getBeanById(int id);

    <T> T getBeanByName(String name);

    Integer getIdByName(String name);

//    void rejestInjectMetaData(InjectMetaData injectMetaData);
//
//    void rejestValueMetaData(ValueMetaData valueMetaData);
//
//    void rejestDynamicValueMetaData(DynamicValueMetaData dynamicValueMetaData);

    void injectBean() throws IllegalAccessException;

    void injectBean(int beanId) throws IllegalAccessException;

    void injectValue() throws IllegalAccessException;

    void injectValue(int beanId) throws IllegalAccessException;

    <T> T getValue(String key, Class<T> c);

    public <T1> T1 getDynamicValue(String key, Class<T1> c, T1 defaultValue);

    void injectDynamicValue() throws IllegalAccessException;

    void injectDynamicValue(int beanId) throws IllegalAccessException;

    <T> T getDynamicValue(String key, Class<T> c);

    void refreshDynamicValue(String key, String value) throws IllegalAccessException;

    void refresh();

    void refresh(int beanId);

    void append(int beanId) throws IllegalAccessException;

//    void triggerEvent(BeanEvent event);
}
