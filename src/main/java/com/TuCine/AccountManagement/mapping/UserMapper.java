package com.TuCine.AccountManagement.mapping;

import com.TuCine.AccountManagement.domain.model.Gender;
import com.TuCine.AccountManagement.domain.model.TypeUser;
import com.TuCine.AccountManagement.domain.model.User;
import com.TuCine.AccountManagement.resource.UserDto;
import com.TuCine.AccountManagement.shared.mapping.EnhancedModelMapper;
import org.modelmapper.AbstractConverter;
import org.modelmapper.Converter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Component;

import java.io.Serializable;
import java.util.List;

@Component
public class UserMapper implements Serializable {
    @Autowired
    EnhancedModelMapper mapper;

    //Object Mapping
    public UserDto toResource(User model){
        return mapper.map(model,UserDto.class);
    }

    public User toModel(UserDto resource){
        return mapper.map(resource,User.class);
    }

    public List<UserDto> modelListToResource(List<User> modelList){return mapper.mapList(modelList, UserDto.class); }

    public Page<UserDto> modelListToPage(List<User> modelList, Pageable pageable) {
        mapper.addConverter(typeUserToString);
        return new PageImpl<>(mapper.mapList(modelList, UserDto.class), pageable, modelList.size());
    }

    Converter<TypeUser, String> typeUserToString = new AbstractConverter<>() {
        @Override
        protected String convert(TypeUser typeUser) {
            return typeUser == null ? null : typeUser.getName().name();
        }
    };

    Converter<Gender, String> genderToString = new AbstractConverter<>() {
        @Override
        protected String convert(Gender gender) {

            return gender == null ? null : gender.getName().name();
        }
    };
}
