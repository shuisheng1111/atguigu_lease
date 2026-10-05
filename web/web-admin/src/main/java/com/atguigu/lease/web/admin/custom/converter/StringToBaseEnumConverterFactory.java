package com.atguigu.lease.web.admin.custom.converter;

import com.atguigu.lease.model.enums.BaseEnum;
import org.springframework.core.convert.converter.Converter;
import org.springframework.core.convert.converter.ConverterFactory;
import org.springframework.stereotype.Component;

/**
 * 实现ConverterFactory接口，提供将String类型转换为BaseEnum类型的功能
 * 批量转换器工厂类
 */
@Component
public class StringToBaseEnumConverterFactory implements ConverterFactory<String, BaseEnum> {
    @Override
    public <T extends BaseEnum> Converter<String, T> getConverter(Class<T> targetType) {
        //TODO 弃用单个枚举类型的转换器，使用批量转换器工厂类
        return new Converter<String, T>() {
            @Override
            public T convert(String source) {
                T[] enumConstants = targetType.getEnumConstants();
                for (T enumConstant : enumConstants) {
                    if(enumConstant.getCode().equals(Integer.valueOf(source))){
                        return enumConstant;
                    }
                }
                throw new IllegalArgumentException("无法将字符串转换为" + targetType.getSimpleName() + "枚举类型: " + source);
            }
        };
    }
}
