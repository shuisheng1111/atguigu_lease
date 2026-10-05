package com.atguigu.lease.web.admin.custom.converter;


import com.atguigu.lease.model.enums.ItemType;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

/**
 * 字符串转换为ItemType枚举类型的转换器
 * Converter接口是Spring提供的一个类型转换接口，用于在不同类型之间进行转换。
 * <原类型，目标类型>
 */
@Component
public class StringToItemTypeConverter implements Converter<String, ItemType> {
    @Override
    public ItemType convert(String code) {
        // 遍历ItemType枚举类型的所有值，查找与输入字符串匹配的枚举值
        ItemType[] values = ItemType.values();
        for (ItemType value : values) {
            if(value.getCode().equals(Integer.valueOf(code))){
                return value;
            }
        }
        throw new RuntimeException("无法将字符串转换为ItemType枚举类型: " + code);
    }
}
